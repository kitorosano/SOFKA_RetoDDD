package uy.com.sofka.biblioteca.categoria.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.categoria.value.Nombre;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;

public class ModificarNombre extends Command {
  private final CategoriaId categoriaId;
  private final Nombre nombre;

  public ModificarNombre(CategoriaId categoriaId, Nombre nombre) {
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
