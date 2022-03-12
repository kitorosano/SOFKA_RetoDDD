package uy.com.sofka.biblioteca.boleta.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.boleta.value.Necesidad;

public class NecesidadModificada extends DomainEvent {
  private final Necesidad necesidad;

  public NecesidadModificada(Necesidad necesidad) {
    super("sofka.boleta.modificarnecesidad");
    this.necesidad = necesidad;
  }

  public Necesidad getNecesidad() {
    return necesidad;
  }
  
}
