package uy.com.sofka.biblioteca.categoria.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.Nombre;

public class CrearCategoria extends Command {
  private final CategoriaId categoriaId;
  private final Nombre nombre;

  public CrearCategoria(CategoriaId categoriaId, Nombre nombre) {
    this.categoriaId = categoriaId;
    this.nombre = nombre;
  }

  public CategoriaId getCategoriaId() {
    return this.categoriaId;
  }

  public Nombre getNombre() {
    return this.nombre;
  }

}
