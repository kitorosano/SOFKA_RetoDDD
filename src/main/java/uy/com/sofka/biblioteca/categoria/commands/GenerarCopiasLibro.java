package uy.com.sofka.biblioteca.categoria.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.categoria.value.LibroId;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.CopiasLibro;

public class GenerarCopiasLibro extends Command {
  
  private final CategoriaId categoriaId;
  private final LibroId libroId;
  private final CopiasLibro copias;

  public GenerarCopiasLibro(CategoriaId categoriaId, LibroId libroId, CopiasLibro copias) {
    this.categoriaId = categoriaId;
    this.libroId = libroId;
    this.copias = copias;
  }

  public CategoriaId getCategoriaId() {
    return this.categoriaId;
  }

  public LibroId getLibroId() {
    return this.libroId;
  }

  public CopiasLibro getCopias() {
    return this.copias;
  }
}
