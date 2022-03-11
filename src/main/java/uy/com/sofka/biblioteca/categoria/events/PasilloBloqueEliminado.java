package uy.com.sofka.biblioteca.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.value.PasilloBloque;
import uy.com.sofka.biblioteca.categoria.value.BloqueId;

public class PasilloBloqueEliminado extends DomainEvent{
  private final BloqueId bloqueId;
  private final PasilloBloque pasillo;

  public PasilloBloqueEliminado(BloqueId bloqueId, PasilloBloque pasillo) {
    super("sofka.categoria.eliminarpasillobloque");
    this.bloqueId = bloqueId;
    this.pasillo = pasillo;
  } 

  public BloqueId getBloqueId() {
    return bloqueId;
  }
  public PasilloBloque getPasillo() {
    return pasillo;
  }
}
