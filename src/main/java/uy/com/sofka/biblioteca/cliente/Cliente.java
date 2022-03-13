package uy.com.sofka.biblioteca.cliente;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.boleta.value.MultaId;
import uy.com.sofka.biblioteca.cliente.events.*;
import uy.com.sofka.biblioteca.cliente.value.*;
import uy.com.sofka.biblioteca.value.*;

public class Cliente extends AggregateEvent<ClienteId> {
  protected NombreCliente nombre;
  protected DireccionCliente direccion;
  protected TelefonoCliente telefono;
  protected CedulaCliente cedula;
  protected Set<Cuenta> cuentas;
  protected Set<Sancion> sanciones;

  /** Constructores */
  public Cliente(ClienteId clienteId, NombreCliente nombre, DireccionCliente direccion, TelefonoCliente telefono, CedulaCliente cedula) {
    super(clienteId);
    appendChange(new ClienteCreado(nombre, direccion, telefono, cedula)).apply(); //Crar obj Cliente
  }
  
  private Cliente(ClienteId clienteId){
    super(clienteId);
    subscribe(new ClienteChange(this));
  }

  public static Cliente from(ClienteId clienteId, List<DomainEvent> events){
    var cliente = new Cliente(clienteId);
    events.forEach(cliente::applyEvent); //recrea todos los agregados apartir de eventos guardados
    return cliente;
  }
  
  /** Metodos */  
  public void modificarNombre(NombreCliente nombre){
    Objects.requireNonNull(nombre);
    appendChange(new NombreModificado(nombre)).apply();
  }

  public void modificarDireccion(DireccionCliente direccion){
    Objects.requireNonNull(direccion);
    appendChange(new DireccionModificada(direccion)).apply();
  }
  
  public void modificarTelefono(TelefonoCliente telefono){
    Objects.requireNonNull(telefono);
    appendChange(new TelefonoModificado(telefono)).apply();
  }
  
  public void aplicarSancion(SancionId sancionId, ObservacionSancion observacion, MultaId multaId){
    Objects.requireNonNull(sancionId);
    Objects.requireNonNull(observacion);
    Objects.requireNonNull(multaId);
    appendChange(new SancionAplicada(sancionId, observacion, multaId)).apply();
  }

  public void retirarSancion(SancionId sancionId){
    Objects.requireNonNull(sancionId);
    appendChange(new SancionRetirada(sancionId)).apply();
  }
  
  public void modificarObservacionSancion(SancionId sancionId, ObservacionSancion observacion){
    Objects.requireNonNull(sancionId);
    Objects.requireNonNull(observacion);
    appendChange(new ObservacionSancionModificada(sancionId, observacion)).apply();
  }

  public void vincularCuenta(CuentaId cuentaId, NombreUsuarioCuenta nombreUsuario, CorreoCuenta correo, ProveedorCuenta proveedor){
    Objects.requireNonNull(cuentaId);
    Objects.requireNonNull(nombreUsuario);
    Objects.requireNonNull(correo);
    Objects.requireNonNull(proveedor);
    appendChange(new CuentaVinculada(cuentaId, nombreUsuario, correo, proveedor)).apply();
  }

  public void desvincularCuenta(CuentaId cuentaId){
    Objects.requireNonNull(cuentaId);
    appendChange(new CuentaDesvinculada(cuentaId)).apply();
  }

  public void modificarNombreUsuarioCuenta(CuentaId cuentaId, NombreUsuarioCuenta nombreUsuario){
    Objects.requireNonNull(cuentaId);
    Objects.requireNonNull(nombreUsuario);
    appendChange(new NombreUsuarioCuentaModificado(cuentaId, nombreUsuario)).apply();
  }


  /** Getters */
  public NombreCliente nombre() {
    return nombre;
  }

  public DireccionCliente direccion() {
    return direccion;
  }
  
  public TelefonoCliente telefono() {
    return telefono;
  }

  public CedulaCliente cedula() {
    return cedula;
  }

  public Set<Cuenta> cuentas() {
    return cuentas;
  }

  protected Optional<Cuenta> getCuentaPorId(CuentaId cuentaId){
    return cuentas().stream().filter(cuenta -> cuenta.identity().equals(cuentaId)).findFirst();
  }

  public Set<Sancion> sanciones() {
    return sanciones;
  }

  protected Optional<Sancion> getSancionPorId(SancionId sancionId){
    return sanciones().stream().filter(cuenta -> cuenta.identity().equals(sancionId)).findFirst();
  }
}