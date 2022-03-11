package uy.com.sofka.biblioteca.cliente;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.cliente.events.*;
import uy.com.sofka.biblioteca.cliente.value.*;

public class Cliente extends AggregateEvent<ClienteId> {
  protected Nombre nombre;
  protected Telefono telefono;
  protected Direccion direccion;
  protected Cedula cedula;
  protected Set<Cuenta> cuentas;
  protected Set<Sancion> sanciones;

  /** Constructores */
  public Cliente(ClienteId entityId, Nombre nombre, Telefono telefono, Direccion direccion, Cedula cedula) {
    super(entityId);
    appendChange(new ClienteCreado(nombre, telefono, direccion, cedula)).apply(); //Crar obj Cliente
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
  public void modificarNombre(Nombre nombre){
    Objects.requireNonNull(nombre);
    appendChange(new NombreModificado(nombre)).apply();
  }

  public void actualizarDireccion(Direccion direccion){
    Objects.requireNonNull(direccion);
    appendChange(new DireccionActualizada(direccion)).apply();
  }
  
  public void modificarTelefono(Telefono telefono){
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
  public Nombre nombre() {
    return nombre;
  }

  public Direccion direccion() {
    return direccion;
  }
  
  public Telefono telefono() {
    return telefono;
  }

  public Cedula cedula() {
    return cedula;
  }

  public Set<Cuenta> cuentas() {
    return cuentas;
  }

  protected Optional<Cuenta> getCuentaPorId(CuentaId cuentaId){
    return cuentas().stream().filter(key -> key.identity().equals(cuentaId)).findFirst();
  }

  public Set<Sancion> sanciones() {
    return sanciones;
  }

  protected Optional<Sancion> getSancionPorId(SancionId sancionId){
    return sanciones().stream().filter(key -> key.identity().equals(sancionId)).findFirst();
  }
}