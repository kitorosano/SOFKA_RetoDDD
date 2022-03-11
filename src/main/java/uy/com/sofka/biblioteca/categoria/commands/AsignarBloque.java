package uy.com.sofka.biblioteca.categoria.commands;

import java.util.Set;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.CantidadEstanteriasBloque;
import uy.com.sofka.biblioteca.categoria.value.BloqueId;
import uy.com.sofka.biblioteca.categoria.value.DescripcionBloque;
import uy.com.sofka.biblioteca.categoria.value.PasilloBloque;

public class AsignarBloque extends Command {
  private final CategoriaId categoriaId;
  private final BloqueId bloqueId;
  private final DescripcionBloque descripcion;
  private final Set<PasilloBloque> pasillos;
  private final CantidadEstanteriasBloque cantidadEstanterias;

  public AsignarBloque(CategoriaId categoriaId, BloqueId bloqueId, DescripcionBloque descripcion, Set<PasilloBloque> pasillos, CantidadEstanteriasBloque cantidadEstanterias) {
    this.categoriaId = categoriaId;
    this.bloqueId = bloqueId;
    this.descripcion = descripcion;
    this.pasillos = pasillos;
    this.cantidadEstanterias = cantidadEstanterias;
  }

  public CategoriaId getCategoriaId() {
    return this.categoriaId;
  }

  public BloqueId getBloqueId() {
    return this.bloqueId;
  }

  public DescripcionBloque getDescripcion() {
    return this.descripcion;
  }

  public CantidadEstanteriasBloque getCantidadEstanteriasBloque() {
    return this.cantidadEstanterias;
  }

  public Set<PasilloBloque> getPasillos() {
    return pasillos;
  }
}
