package uy.com.sofka.biblioteca.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.cliente.value.*;

public class ClienteCreado extends DomainEvent {
  private final Nombre nombre;
  private final Telefono telefono;
  private final Direccion direccion;
  private final Cedula cedula;

  public ClienteCreado(Nombre nombre, Telefono telefono, Direccion direccion, Cedula cedula) {
    super("sofka.cliente.clientecreado");
    this.nombre = nombre;
    this.telefono = telefono;
    this.direccion = direccion;
    this.cedula = cedula;
  }
  
  public Nombre getNombre() {
    return nombre;
  }

  public Telefono getTelefono() {
    return telefono;
  }

  public Direccion getDireccion() {
    return direccion;
  }

  public Cedula getCedula() {
    return cedula;
  }
}
