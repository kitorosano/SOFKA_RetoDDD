package uy.com.sofka.biblioteca.categoria.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.categoria.value.LibroId;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.EstadoLibro;

public class ModificarEstadoLibro extends Command {
  
  private final CategoriaId categoriaId;
  private final LibroId libroId;
  private final EstadoLibro tema;

  public ModificarEstadoLibro(CategoriaId categoriaId, LibroId libroId, EstadoLibro tema) {
    this.categoriaId = categoriaId;
    this.libroId = libroId;
    this.tema = tema;
  }

  public CategoriaId getCategoriaId() {
    return this.categoriaId;
  }

  public LibroId getLibroId() {
    return this.libroId;
  }

  public EstadoLibro getEstado() {
    return this.tema;
  }
}
