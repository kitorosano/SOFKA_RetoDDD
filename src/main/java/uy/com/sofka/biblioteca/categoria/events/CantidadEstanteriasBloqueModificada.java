package uy.com.sofka.biblioteca.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.value.CantidadEstanteriasBloque;
import uy.com.sofka.biblioteca.categoria.value.BloqueId;

public class CantidadEstanteriasBloqueModificada extends DomainEvent{
  private final BloqueId bloqueId;
  private final CantidadEstanteriasBloque cantidadEstanterias;

  public CantidadEstanteriasBloqueModificada(BloqueId bloqueId, CantidadEstanteriasBloque cantidadEstanterias) {
    super("sofka.categoria.modificarcantidadestanteriasbloque");
    this.bloqueId = bloqueId;
    this.cantidadEstanterias = cantidadEstanterias;
  } 

  public BloqueId getBloqueId() {
    return bloqueId;
  }

  public CantidadEstanteriasBloque getCantidadEstanterias() {
    return cantidadEstanterias;
  }
}