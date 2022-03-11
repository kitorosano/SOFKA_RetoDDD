package uy.com.sofka.biblioteca.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.cliente.value.Nombre;

public class NombreModificado extends DomainEvent {
  private final Nombre nombre;

  public NombreModificado(Nombre nombre) {
    super("sofka.cliente.modificarnombre");
    this.nombre = nombre;
  }

  public Nombre getNombre() {
    return nombre;
  }
  
}
