package uy.com.sofka.biblioteca.categoria;

import java.util.Objects;
import java.util.Set;

import co.com.sofka.domain.generic.Entity;
import uy.com.sofka.biblioteca.categoria.value.GeneroLibro;
import uy.com.sofka.biblioteca.categoria.value.LibroId;
import uy.com.sofka.biblioteca.categoria.value.TemaLibro;
import uy.com.sofka.biblioteca.categoria.value.AcotacionLibro;
import uy.com.sofka.biblioteca.categoria.value.AutorId;
import uy.com.sofka.biblioteca.categoria.value.CopiasLibro;
import uy.com.sofka.biblioteca.categoria.value.EditorialId;
import uy.com.sofka.biblioteca.categoria.value.EstadoLibro;
import uy.com.sofka.biblioteca.categoria.value.TituloLibro;

public class Libro extends Entity<LibroId> {
  protected EditorialId editorialId;
  protected AutorId autorId;
  protected TituloLibro titulo;
  protected AcotacionLibro acotacion;
  protected Set<GeneroLibro> generos;
  protected TemaLibro tema;
  protected EstadoLibro estado;
  protected CopiasLibro copias;

  public Libro(LibroId libroId, EditorialId editorialId, AutorId autorId, TituloLibro titulo, AcotacionLibro acotacion, Set<GeneroLibro> generos, TemaLibro tema, EstadoLibro estado, CopiasLibro copias) {
    super(libroId);
    this.editorialId = editorialId;
    this.autorId = autorId;
    this.titulo = titulo;
    this.acotacion = acotacion;
    this.generos = generos;
    this.tema = tema;
    this.estado = estado;
    this.copias = copias;
  }

  // metodos (setters)
  public void modificarTitulo(TituloLibro titulo) {
    this.titulo = Objects.requireNonNull(titulo);
  }
  
  public void modificarAcotacion(AcotacionLibro acotacion) {
    this.acotacion = Objects.requireNonNull(acotacion);
  }
  
  public void AgregarGenero(GeneroLibro genero) {
    this.generos.add(Objects.requireNonNull(genero));
  }
  
  public void QuitarGenero(GeneroLibro genero) {
    this.generos.remove(Objects.requireNonNull(genero));
  }
  
  public void modificarTema(TemaLibro tema) {
    this.tema = Objects.requireNonNull(tema);
  }
  
  public void modificarEstado(EstadoLibro estado) {
    this.estado = Objects.requireNonNull(estado);
  }

  public void GenerarCopias(CopiasLibro copias) {
    // this.copias = 
  }
  
  public void RemoverCopias(CopiasLibro copias) {
    // this.copias = 
  }
  
  //Getters
  public EditorialId editorialId() {
    return editorialId;
  }

  public AutorId autorId() {
    return autorId;
  }

  public TituloLibro titulo() {
    return titulo;
  }
  
  public AcotacionLibro acotacion() {
    return acotacion;
  }

  public Set<GeneroLibro> generos() {
    return generos;
  }

  public TemaLibro tema() {
    return tema;
  }

  public EstadoLibro estado() {
    return estado;
  }

  public CopiasLibro copias() {
    return copias;
  }
  
}