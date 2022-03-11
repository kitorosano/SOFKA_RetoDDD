package uy.com.sofka.biblioteca.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.value.Nombre;

public class NombreModificado extends DomainEvent {
  private final Nombre nombre;

  public NombreModificado(Nombre nombre) {
    super("sofka.categoria.modificarnombre");
    this.nombre = nombre;
  }

  public Nombre getNombre() {
    return nombre;
  }
  
}
