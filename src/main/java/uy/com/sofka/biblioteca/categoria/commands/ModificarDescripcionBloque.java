package uy.com.sofka.biblioteca.categoria.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.BloqueId;
import uy.com.sofka.biblioteca.categoria.value.DescripcionBloque;

public class ModificarDescripcionBloque extends Command {
  private final CategoriaId categoriaId;
  private final BloqueId bloqueId; 
  private final DescripcionBloque descripcion;

  public ModificarDescripcionBloque(CategoriaId categoriaId, BloqueId bloqueId, DescripcionBloque descripcion) {
    this.categoriaId = categoriaId;
    this.bloqueId = bloqueId;
    this.descripcion = descripcion;
  }
  
  public CategoriaId getCategoriaId() {
    return this.categoriaId;
  }

  public BloqueId getBloqueId() {
    return this.bloqueId;
  }

  public DescripcionBloque getDescripcionBloque() {
    return this.descripcion;
  }
}
