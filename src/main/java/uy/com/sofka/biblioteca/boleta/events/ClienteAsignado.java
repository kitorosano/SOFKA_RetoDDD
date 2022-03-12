package uy.com.sofka.biblioteca.boleta.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.value.*;

public class ClienteAsignado extends DomainEvent{
  private final ClienteId clienteId;
  private final NombreCliente nombre;
  private final DireccionCliente direccion;
  private final TelefonoCliente telefono;
  private final CedulaCliente cedula;

  public ClienteAsignado(ClienteId clienteId, NombreCliente nombre, DireccionCliente direccion, TelefonoCliente telefono, CedulaCliente cedula) {
    super("sofka.boleta.asignarcliente");
    this.clienteId = clienteId;
    this.nombre = nombre;
    this.direccion = direccion;
    this.telefono = telefono;
    this.cedula = cedula;
  } 

  public ClienteId getClienteId() {
    return clienteId;
  }

  public NombreCliente getNombre() {
    return nombre;
  }

  public DireccionCliente getDireccion() {
    return direccion;
  }

  public TelefonoCliente getTelefono() {
    return telefono;
  }

  public CedulaCliente getCedula() {
    return cedula;
  }
}
