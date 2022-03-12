package uy.com.sofka.biblioteca.categoria;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.events.*;
import uy.com.sofka.biblioteca.categoria.value.*;
import uy.com.sofka.biblioteca.value.AutorId;
import uy.com.sofka.biblioteca.value.EditorialId;

public class Categoria extends AggregateEvent<CategoriaId> {
  protected Nombre nombre;
  protected Set<Libro> libros;
  protected Bloque bloque;

  /** Constructores */
  public Categoria(CategoriaId entityId, Nombre nombre) {
    super(entityId);
    appendChange(new CategoriaCreada(nombre)).apply(); //Crar obj Categoria
  }
  
  private Categoria(CategoriaId categoriaId){
    super(categoriaId);
    subscribe(new CategoriaChange(this));
  }

  public static Categoria from(CategoriaId categoriaId, List<DomainEvent> events){
    var categoria = new Categoria(categoriaId);
    events.forEach(categoria::applyEvent); //recrea todos los agregados apartir de eventos guardados
    return categoria;
  }
  
  /** Metodos */  
  public void modificarNombre(Nombre nombre){
    Objects.requireNonNull(nombre);
    appendChange(new NombreModificado(nombre)).apply();
  }

  public void agregarLibro(LibroId libroId, EditorialId editorialId, AutorId autorId, TituloLibro titulo, AcotacionLibro acotacion, Set<GeneroLibro> generos, TemaLibro tema, EstadoLibro estado, CopiasLibro copias){
    Objects.requireNonNull(libroId);
    Objects.requireNonNull(autorId);
    Objects.requireNonNull(editorialId);
    Objects.requireNonNull(titulo);
    Objects.requireNonNull(acotacion);
    Objects.requireNonNull(generos);
    Objects.requireNonNull(tema);
    Objects.requireNonNull(estado);
    Objects.requireNonNull(copias);
    appendChange(new LibroAgregado(libroId, editorialId, autorId, titulo, acotacion, generos, tema, estado, copias)).apply();
  }

  public void quitarLibro(LibroId libroId){
    Objects.requireNonNull(libroId);
    appendChange(new LibroQuitado(libroId)).apply();
  }

  public void modificarTituloLibro(LibroId libroId, TituloLibro titulo){
    Objects.requireNonNull(libroId);
    Objects.requireNonNull(titulo);
    appendChange(new TituloLibroModificado(libroId, titulo)).apply();
  }

  public void modificarAcotacionLibro(LibroId libroId, AcotacionLibro acotacion){
    Objects.requireNonNull(libroId);
    Objects.requireNonNull(acotacion);
    appendChange(new AcotacionLibroModificada(libroId, acotacion)).apply();
  }

  public void agregarGeneroLibro(LibroId libroId, GeneroLibro genero){
    Objects.requireNonNull(libroId);
    Objects.requireNonNull(genero);
    appendChange(new GeneroLibroAgregado(libroId, genero)).apply();
  }

  public void quitarGeneroLibro(LibroId libroId, GeneroLibro genero){
    Objects.requireNonNull(libroId);
    Objects.requireNonNull(genero);
    appendChange(new GeneroLibroQuitado(libroId, genero)).apply();
  }
  
  public void modificarTemaLibro(LibroId libroId, TemaLibro tema){
    Objects.requireNonNull(libroId);
    Objects.requireNonNull(tema);
    appendChange(new TemaLibroModificado(libroId, tema)).apply();
  }

  public void modificarEstadoLibro(LibroId libroId, EstadoLibro estado){
    Objects.requireNonNull(libroId);
    Objects.requireNonNull(estado);
    appendChange(new EstadoLibroModificado(libroId, estado)).apply();
  }

  public void generarCopiasLibro(LibroId libroId, CopiasLibro copias){
    Objects.requireNonNull(libroId);
    Objects.requireNonNull(copias);
    appendChange(new CopiasLibroGeneradas(libroId, copias)).apply();
  }

  public void removerCopiasLibro(LibroId libroId, CopiasLibro copias){
    Objects.requireNonNull(libroId);
    Objects.requireNonNull(copias);
    appendChange(new CopiasLibroRemovidas(libroId, copias)).apply();
  }

  public void asignarBloque(BloqueId bloqueId, DescripcionBloque descripcion, Set<PasilloBloque> pasillos, CantidadEstanteriasBloque cantidadEstanterias){
    Objects.requireNonNull(bloqueId);
    Objects.requireNonNull(descripcion);
    Objects.requireNonNull(pasillos);
    Objects.requireNonNull(cantidadEstanterias);
    appendChange(new BloqueAsignado(bloqueId, descripcion, pasillos, cantidadEstanterias)).apply();
  } 
  
  public void modificarDescripcionBloque(BloqueId bloqueId, DescripcionBloque descripcion){
    Objects.requireNonNull(bloqueId);
    Objects.requireNonNull(descripcion);
    appendChange(new DescripcionBloqueModificada(bloqueId, descripcion)).apply();
  }

  public void agregarPasilloBloque(BloqueId bloqueId, PasilloBloque pasillo){
    Objects.requireNonNull(bloqueId);
    Objects.requireNonNull(pasillo);
    appendChange(new PasilloBloqueAgregado(bloqueId, pasillo)).apply();
  }

  public void eliminarPasilloBloque(BloqueId bloqueId, PasilloBloque pasillo){
    Objects.requireNonNull(bloqueId);
    Objects.requireNonNull(pasillo);
    appendChange(new PasilloBloqueEliminado(bloqueId, pasillo)).apply();
  }

  public void modificarCantidadEstanteriasBloque(BloqueId bloqueId, CantidadEstanteriasBloque cantidadEstanterias){
    Objects.requireNonNull(bloqueId);
    Objects.requireNonNull(cantidadEstanterias);
    appendChange(new CantidadEstanteriasBloqueModificada(bloqueId, cantidadEstanterias)).apply();
  }


  /** Getters */
  public Nombre nombre() {
    return nombre;
  }

  public Set<Libro> libros() {
    return libros;
  }

  protected Optional<Libro> getLibroPorId(LibroId libroId){
    return libros().stream().filter(key -> key.identity().equals(libroId)).findFirst();
  }

  public Bloque bloque() {
    return bloque;
  }
}