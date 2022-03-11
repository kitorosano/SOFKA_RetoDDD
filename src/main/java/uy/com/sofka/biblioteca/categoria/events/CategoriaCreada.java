package uy.com.sofka.biblioteca.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.value.*;

public class CategoriaCreada extends DomainEvent {
  private final Nombre nombre;

  public CategoriaCreada(Nombre nombre) {
    super("sofka.categoria.categoriacreada");
    this.nombre = nombre;
  }
  
  public Nombre getNombre() {
    return nombre;
  }
}
