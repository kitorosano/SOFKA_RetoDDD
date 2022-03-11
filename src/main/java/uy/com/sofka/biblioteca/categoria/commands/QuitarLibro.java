package uy.com.sofka.biblioteca.categoria.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.LibroId;

public class QuitarLibro extends Command {
  private final CategoriaId categoriaId;
  private final LibroId libroId;

  public QuitarLibro(CategoriaId categoriaId, LibroId libroId) {
    this.categoriaId = categoriaId;
    this.libroId = libroId;
  }

  public CategoriaId getCategoriaId() {
    return this.categoriaId;
  }

  public LibroId getLibroId() {
    return this.libroId;
  }
}
