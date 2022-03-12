package uy.com.sofka.biblioteca.boleta;

import java.util.Objects;

import co.com.sofka.domain.generic.Entity;
import uy.com.sofka.biblioteca.value.*;

public class Cliente extends Entity<ClienteId> {
  protected NombreCliente nombre;
  protected DireccionCliente direccion;
  protected TelefonoCliente telefono;
  protected CedulaCliente cedula;

  public Cliente(ClienteId multaId, NombreCliente nombre, DireccionCliente direccion, TelefonoCliente telefono, CedulaCliente cedula) {
    super(multaId);
    this.nombre = nombre;
    this.direccion = direccion;
    this.telefono = telefono;
    this.cedula = cedula;
  }

  // metodos (setters)
  public void modificarNombre(NombreCliente nombre) {
    this.nombre = Objects.requireNonNull(nombre);
  }

  public void modificarDireccion(DireccionCliente direccion) {
    this.direccion = Objects.requireNonNull(direccion);
  }
  
  public void modificarTelefono(TelefonoCliente telefono) {
    this.telefono = Objects.requireNonNull(telefono);
  }
  
  //Getters
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
  
}
