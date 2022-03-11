package uy.com.sofka.biblioteca.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.value.PasilloBloque;
import uy.com.sofka.biblioteca.categoria.value.BloqueId;

public class PasilloBloqueAgregado extends DomainEvent{
  private final BloqueId bloqueId;
  private final PasilloBloque pasillo;

  public PasilloBloqueAgregado(BloqueId bloqueId, PasilloBloque pasillo) {
    super("sofka.categoria.agregarpasillobloque");
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
