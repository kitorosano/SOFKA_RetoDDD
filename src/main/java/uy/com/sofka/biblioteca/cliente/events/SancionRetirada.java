package uy.com.sofka.biblioteca.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.cliente.value.SancionId;

public class SancionRetirada extends DomainEvent{
  private final SancionId sancionId;

  public SancionRetirada(SancionId sancionId) {
    super("sofka.cliente.retirarsancion");
    this.sancionId = sancionId;
  } 

  public SancionId getSancionId() {
    return sancionId;
  }

}