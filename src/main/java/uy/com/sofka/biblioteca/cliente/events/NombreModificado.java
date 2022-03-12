package uy.com.sofka.biblioteca.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.value.NombreCliente;

public class NombreModificado extends DomainEvent {
  private final NombreCliente nombre;

  public NombreModificado(NombreCliente nombre) {
    super("sofka.cliente.modificarnombre");
    this.nombre = nombre;
  }

  public NombreCliente getNombre() {
    return nombre;
  }
  
}
