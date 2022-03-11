package uy.com.sofka.biblioteca.categoria.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.BloqueId;
import uy.com.sofka.biblioteca.categoria.value.CantidadEstanteriasBloque;

public class ModificarCantidadEstanteriasBloque extends Command {
  private final CategoriaId categoriaId;
  private final BloqueId bloqueId; 
  private final CantidadEstanteriasBloque cantidadEstanterias;

  public ModificarCantidadEstanteriasBloque(CategoriaId categoriaId, BloqueId bloqueId, CantidadEstanteriasBloque cantidadEstanterias) {
    this.categoriaId = categoriaId;
    this.bloqueId = bloqueId;
    this.cantidadEstanterias = cantidadEstanterias;
  }
  
  public CategoriaId getCategoriaId() {
    return this.categoriaId;
  }

  public BloqueId getBloqueId() {
    return this.bloqueId;
  }

  public CantidadEstanteriasBloque getCantidadEstanteriasBloque() {
    return this.cantidadEstanterias;
  }
}
