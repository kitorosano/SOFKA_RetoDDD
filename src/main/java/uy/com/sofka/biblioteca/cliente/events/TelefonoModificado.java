package uy.com.sofka.biblioteca.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.value.TelefonoCliente;

public class TelefonoModificado extends DomainEvent {
  private final TelefonoCliente telefono;

  public TelefonoModificado(TelefonoCliente telefono) {
    super("sofka.cliente.modificartelefono");
    this.telefono = telefono;
  }

  public TelefonoCliente getTelefono() {
    return telefono;
  }
  
}
