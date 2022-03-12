package uy.com.sofka.biblioteca.boleta.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.value.ClienteId;
import uy.com.sofka.biblioteca.value.TelefonoCliente;

public class TelefonoClienteModificado extends DomainEvent {
  private final ClienteId clienteId; 
  private final TelefonoCliente telefono;

  public TelefonoClienteModificado(ClienteId clienteId, TelefonoCliente telefono) {
    super("sofka.cliente.modificartelefonocliente");
    this.clienteId = clienteId;
    this.telefono = telefono;
  }

  public ClienteId getClienteId() {
    return clienteId;
  }

  public TelefonoCliente getTelefono() {
    return telefono;
  }
  
}
