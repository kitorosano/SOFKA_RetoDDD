package uy.com.sofka.biblioteca.categoria.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.categoria.value.LibroId;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.AcotacionLibro;

public class ModificarAcotacionLibro extends Command {
  
  private final CategoriaId categoriaId;
  private final LibroId libroId;
  private final AcotacionLibro titulo;

  public ModificarAcotacionLibro(CategoriaId categoriaId, LibroId libroId, AcotacionLibro titulo) {
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

  public AcotacionLibro getAcotacion() {
    return this.titulo;
  }
}
