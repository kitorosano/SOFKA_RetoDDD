package uy.com.sofka.biblioteca.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.boleta.value.MultaId;
import uy.com.sofka.biblioteca.cliente.value.ObservacionSancion;
import uy.com.sofka.biblioteca.cliente.value.SancionId;

public class SancionAplicada extends DomainEvent{
  private final SancionId sancionId;
  private final ObservacionSancion observacion;
  private final MultaId multaId;

  public SancionAplicada(SancionId sancionId, ObservacionSancion observacion, MultaId multaId) {
    super("sofka.cliente.aplicarsancion");
    this.sancionId = sancionId;
    this.observacion = observacion;
    this.multaId = multaId;
  } 

  public SancionId getSancionId() {
    return sancionId;
  }

  public ObservacionSancion getObservacion() {
    return observacion;
  }

  public MultaId getMultaId() {
    return multaId;
  }
}
