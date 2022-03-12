package uy.com.sofka.biblioteca.cliente;

import java.util.Objects;

import co.com.sofka.domain.generic.Entity;
import uy.com.sofka.biblioteca.cliente.value.MultaId;
import uy.com.sofka.biblioteca.cliente.value.ObservacionSancion;
import uy.com.sofka.biblioteca.cliente.value.SancionId;

public class Sancion extends Entity<SancionId> {
  protected ObservacionSancion observacion;
  protected MultaId multaId;

  public Sancion(SancionId sancionId, ObservacionSancion observacion, MultaId multaId) {
    super(sancionId);
    this.observacion = observacion;
    this.multaId = multaId;
  }

  // metodos (setters)
  public void modificarObservacion(ObservacionSancion observacion) {
    this.observacion = Objects.requireNonNull(observacion);
  }
  
  //Getters
  public ObservacionSancion observacion() {
    return observacion;
  }
  
  public MultaId multaId() {
    return multaId;
  }
  
}
