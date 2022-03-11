package uy.com.sofka.biblioteca.categoria.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.categoria.value.LibroId;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.TituloLibro;

public class ModificarTituloLibro extends Command {
  
  private final CategoriaId categoriaId;
  private final LibroId libroId;
  private final TituloLibro titulo;

  public ModificarTituloLibro(CategoriaId categoriaId, LibroId libroId, TituloLibro titulo) {
    this.categoriaId = categoriaId;
    this.libroId = libroId;
    this.titulo = titulo;
  }

  public CategoriaId getCategoriaId() {
    return this.categoriaId;
  }

  public LibroId getLibroId() {
    return this.libroId;
  }

  public TituloLibro getTitulo() {
    return this.titulo;
  }
}
