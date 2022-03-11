package uy.com.sofka.biblioteca.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.value.DescripcionBloque;
import uy.com.sofka.biblioteca.categoria.value.BloqueId;

public class DescripcionBloqueModificada extends DomainEvent{
  private final BloqueId bloqueId;
  private final DescripcionBloque descripcion;

  public DescripcionBloqueModificada(BloqueId bloqueId, DescripcionBloque descripcion) {
    super("sofka.categoria.modificardescripcionbloque");
    this.bloqueId = bloqueId;
    this.descripcion = descripcion;
  } 

  public BloqueId getBloqueId() {
    return bloqueId;
  }

  public DescripcionBloque getDescripcion() {
    return descripcion;
  }
}