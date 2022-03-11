package uy.com.sofka.biblioteca.categoria.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.categoria.value.LibroId;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.GeneroLibro;

public class QuitarGeneroLibro extends Command {
  
  private final CategoriaId categoriaId;
  private final LibroId libroId;
  private final GeneroLibro genero;

  public QuitarGeneroLibro(CategoriaId categoriaId, LibroId libroId, GeneroLibro genero) {
    this.categoriaId = categoriaId;
    this.libroId = libroId;
    this.genero = genero;
  }

  public CategoriaId getCategoriaId() {
    return this.categoriaId;
  }

  public LibroId getLibroId() {
    return this.libroId;
  }

  public GeneroLibro getGenero() {
    return this.genero;
  }
}
