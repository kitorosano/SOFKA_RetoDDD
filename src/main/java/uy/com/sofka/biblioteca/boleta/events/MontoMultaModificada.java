package uy.com.sofka.biblioteca.boleta.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.boleta.value.MontoMulta;
import uy.com.sofka.biblioteca.boleta.value.MultaId;

public class MontoMultaModificada extends DomainEvent{
  private final MultaId multaId;
  private final MontoMulta monto;

  public MontoMultaModificada(MultaId multaId, MontoMulta monto) {
    super("sofka.boleta.modificarmontomulta");
    this.multaId = multaId;
    this.monto = monto;
  } 

  public MultaId getMultaId() {
    return multaId;
  }

  public MontoMulta getMonto() {
    return monto;
  }
}