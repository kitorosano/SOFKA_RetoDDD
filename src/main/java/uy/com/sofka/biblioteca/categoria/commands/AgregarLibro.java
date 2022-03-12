package uy.com.sofka.biblioteca.categoria.commands;

import java.util.Set;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.categoria.value.LibroId;
import uy.com.sofka.biblioteca.categoria.value.TemaLibro;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.CopiasLibro;
import uy.com.sofka.biblioteca.categoria.value.EstadoLibro;
import uy.com.sofka.biblioteca.categoria.value.GeneroLibro;
import uy.com.sofka.biblioteca.categoria.value.TituloLibro;
import uy.com.sofka.biblioteca.value.AutorId;
import uy.com.sofka.biblioteca.value.EditorialId;
import uy.com.sofka.biblioteca.categoria.value.AcotacionLibro;

public class AgregarLibro extends Command {
  private final CategoriaId categoriaId;
  private final LibroId libroId;
  private final EditorialId editorialId;
  private final AutorId autorId;
  private final TituloLibro titulo;
  private final AcotacionLibro acotacion; 
  private final Set<GeneroLibro> generos; 
  private final TemaLibro tema;
  private final EstadoLibro estado; 
  private final CopiasLibro copias;

  public AgregarLibro(CategoriaId categoriaId, LibroId libroId, EditorialId editorialId, AutorId autorId, TituloLibro titulo, AcotacionLibro acotacion, Set<GeneroLibro> generos, TemaLibro tema, EstadoLibro estado, CopiasLibro copias) {
    this.categoriaId = categoriaId;
    this.libroId = libroId;
    this.editorialId = editorialId;
    this.autorId = autorId;
    this.titulo = titulo;
    this.acotacion = acotacion;
    this.generos = generos;
    this.tema = tema;
    this.estado = estado;
    this.copias = copias;
  }

  public CategoriaId getCategoriaId() {
    return this.categoriaId;
  }

  public LibroId getLibroId() {
    return this.libroId;
  }

  public EditorialId getEditorialId() {
    return this.editorialId;
  }

  public AutorId getAutorId() {
    return this.autorId;
  }

  public TituloLibro getTitulo() {
    return this.titulo;
  }

  public AcotacionLibro getAcotacion() {
    return this.acotacion;
  }

  public Set<GeneroLibro> getGeneros() {
    return this.generos;
  }

  public TemaLibro getTema() {
    return this.tema;
  }

  public EstadoLibro getEstado() {
    return this.estado;
  }

  public CopiasLibro getCopias() {
    return this.copias;
  }

}
