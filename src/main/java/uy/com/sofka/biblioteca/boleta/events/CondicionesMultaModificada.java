package uy.com.sofka.biblioteca.boleta.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.boleta.value.CondicionesMulta;
import uy.com.sofka.biblioteca.boleta.value.MultaId;

public class CondicionesMultaModificada extends DomainEvent{
  private final MultaId multaId;
  private final CondicionesMulta condiciones;

  public CondicionesMultaModificada(MultaId multaId, CondicionesMulta condiciones) {
    super("sofka.boleta.modificarcondicionesmulta");
    this.multaId = multaId;
    this.condiciones = condiciones;
  } 

  public MultaId getMultaId() {
    return multaId;
  }

  public CondicionesMulta getCondiciones() {
    return condiciones;
  }
}