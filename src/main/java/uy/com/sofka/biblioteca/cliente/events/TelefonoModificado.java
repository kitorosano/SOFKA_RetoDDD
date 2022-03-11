package uy.com.sofka.biblioteca.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.cliente.value.Telefono;

public class TelefonoModificado extends DomainEvent {
  private final Telefono telefono;

  public TelefonoModificado(Telefono telefono) {
    super("sofka.cliente.modificartelefono");
    this.telefono = telefono;
  }

  public Telefono getTelefono() {
    return telefono;
  }
  
}
