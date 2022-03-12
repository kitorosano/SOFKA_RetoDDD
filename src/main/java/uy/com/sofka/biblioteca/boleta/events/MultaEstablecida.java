package uy.com.sofka.biblioteca.boleta.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.boleta.value.CondicionesMulta;
import uy.com.sofka.biblioteca.boleta.value.MultaId;
import uy.com.sofka.biblioteca.boleta.value.MontoMulta;

public class MultaEstablecida extends DomainEvent{
  private final MultaId multaId;
  private final CondicionesMulta condiciones;
  private final MontoMulta monto;

  public MultaEstablecida(MultaId multaId, CondicionesMulta condiciones, MontoMulta monto) {
    super("sofka.boleta.establecermulta");
    this.multaId = multaId;
    this.condiciones = condiciones;
    this.monto = monto;
  } 

  public MultaId getMultaId() {
    return multaId;
  }

  public CondicionesMulta getCondiciones() {
    return condiciones;
  }

  public MontoMulta getMonto() {
    return monto;
  }
}
