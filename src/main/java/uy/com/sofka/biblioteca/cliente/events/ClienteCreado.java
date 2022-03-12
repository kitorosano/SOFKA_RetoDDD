package uy.com.sofka.biblioteca.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.value.*;

public class ClienteCreado extends DomainEvent {
  private final NombreCliente nombre;
  private final DireccionCliente direccion;
  private final TelefonoCliente telefono;
  private final CedulaCliente cedula;

  public ClienteCreado(NombreCliente nombre, DireccionCliente direccion, TelefonoCliente telefono, CedulaCliente cedula) {
    super("sofka.cliente.clientecreado");
    this.nombre = nombre;
    this.telefono = telefono;
    this.direccion = direccion;
    this.cedula = cedula;
  }
  
  public NombreCliente getNombre() {
    return nombre;
  }

  public TelefonoCliente getTelefono() {
    return telefono;
  }

  public DireccionCliente getDireccion() {
    return direccion;
  }

  public CedulaCliente getCedula() {
    return cedula;
  }
}
