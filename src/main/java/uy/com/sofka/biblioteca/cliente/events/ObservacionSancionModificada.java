package uy.com.sofka.biblioteca.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.cliente.value.ObservacionSancion;
import uy.com.sofka.biblioteca.cliente.value.SancionId;

public class ObservacionSancionModificada extends DomainEvent{
  private final SancionId sancionId;
  private final ObservacionSancion observacion;

  public ObservacionSancionModificada(SancionId sancionId, ObservacionSancion observacion) {
    super("sofka.cliente.modificarobservacionsancion");
    this.sancionId = sancionId;
    this.observacion = observacion;
  } 

  public SancionId getSancionId() {
    return sancionId;
  }

  public ObservacionSancion getObservacion() {
    return observacion;
  }
}