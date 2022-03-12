package uy.com.sofka.biblioteca.categoria.events;

import java.util.Set;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.value.AcotacionLibro;
import uy.com.sofka.biblioteca.categoria.value.CopiasLibro;
import uy.com.sofka.biblioteca.categoria.value.EstadoLibro;
import uy.com.sofka.biblioteca.categoria.value.GeneroLibro;
import uy.com.sofka.biblioteca.categoria.value.LibroId;
import uy.com.sofka.biblioteca.categoria.value.TemaLibro;
import uy.com.sofka.biblioteca.categoria.value.TituloLibro;
import uy.com.sofka.biblioteca.value.AutorId;
import uy.com.sofka.biblioteca.value.EditorialId;

public class LibroAgregado extends DomainEvent{
  private final LibroId libroId;
  private final EditorialId editorialId;
  private final AutorId autorId;
  private final TituloLibro titulo;
  private final AcotacionLibro acotacion;
  private final Set<GeneroLibro> generos;
  private final TemaLibro tema;
  private final EstadoLibro estado;
  private final CopiasLibro copias;

  public LibroAgregado(LibroId libroId, EditorialId editorialId, AutorId autorId, TituloLibro titulo, AcotacionLibro acotacion, Set<GeneroLibro> generos, TemaLibro tema, EstadoLibro estado, CopiasLibro copias) {
    super("sofka.categoria.agregarlibro");
    this.libroId = libroId;
    this.editorialId = editorialId;
    this.autorId = autorId;
    this.titulo = titulo;
    this.acotacion = acotacion;
    this.tema = tema;
    this.generos = generos;
    this.estado = estado;
    this.copias = copias;
  }

  public LibroId getLibroId() {
    return libroId;
  }

  public EditorialId getEditorialId() {
    return editorialId;
  }

  public AutorId getAutorId() {
    return autorId;
  }

  public TituloLibro getTitulo() {
    return titulo;
  }

  public AcotacionLibro getAcotacion() {
    return acotacion;
  }

  public TemaLibro getTema() {
    return tema;
  }

  public Set<GeneroLibro> getGeneros() {
    return generos;
  }

  public EstadoLibro getEstado() {
    return estado;
  }

  public CopiasLibro getCopias() {
    return copias;
  }
}
