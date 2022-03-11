package uy.com.sofka.biblioteca.categoria.events;

import java.util.Set;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.value.DescripcionBloque;
import uy.com.sofka.biblioteca.categoria.value.PasilloBloque;
import uy.com.sofka.biblioteca.categoria.value.BloqueId;
import uy.com.sofka.biblioteca.categoria.value.CantidadEstanteriasBloque;

public class BloqueAsignado extends DomainEvent{
  private final BloqueId bloqueId;
  private final DescripcionBloque descripcion;
  private final Set<PasilloBloque> pasillos;
  private final CantidadEstanteriasBloque cantidadEstanterias;

  public BloqueAsignado(BloqueId bloqueId, DescripcionBloque descripcion, Set<PasilloBloque> pasillos, CantidadEstanteriasBloque cantidadEstanterias) {
    super("sofka.categoria.asignarbloque");
    this.bloqueId = bloqueId;
    this.descripcion = descripcion;
    this.pasillos = pasillos;
    this.cantidadEstanterias = cantidadEstanterias;
  } 

  public BloqueId getBloqueId() {
    return bloqueId;
  }

  public DescripcionBloque getDescripcion() {
    return descripcion;
  }

  public Set<PasilloBloque> getPasillos() {
    return pasillos;
  }

  public CantidadEstanteriasBloque getCantidadEstanterias() {
    return cantidadEstanterias;
  }
}
