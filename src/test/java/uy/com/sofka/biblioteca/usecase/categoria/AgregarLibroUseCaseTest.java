package uy.com.sofka.biblioteca.usecase.categoria;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import co.com.sofka.business.generic.UnexpectedException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.commands.AgregarLibro;
import uy.com.sofka.biblioteca.categoria.events.CategoriaCreada;
import uy.com.sofka.biblioteca.categoria.events.LibroAgregado;
import uy.com.sofka.biblioteca.categoria.value.AcotacionLibro;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.EstadoLibro;
import uy.com.sofka.biblioteca.categoria.value.GeneroLibro;
import uy.com.sofka.biblioteca.categoria.value.LibroId;
import uy.com.sofka.biblioteca.categoria.value.Nombre;
import uy.com.sofka.biblioteca.categoria.value.TituloLibro;
import uy.com.sofka.biblioteca.categoria.value.TemaLibro;
import uy.com.sofka.biblioteca.categoria.value.CopiasLibro;
import uy.com.sofka.biblioteca.value.AutorId;
import uy.com.sofka.biblioteca.value.EditorialId;

@ExtendWith(MockitoExtension.class)
public class AgregarLibroUseCaseTest {

  @Mock
  private DomainEventRepository repository;
  
  @Test
  void agregarLibroValoresDefecto() {
      CategoriaId categoriaId = CategoriaId.of("ccc");
      LibroId libroId = LibroId.of("ddd");
      EditorialId editorialId = EditorialId.of("eee");
      AutorId autorId = AutorId.of("aaa");
      TituloLibro titulo = new TituloLibro("TestTitulo");
      AcotacionLibro acotacion = new AcotacionLibro("Esta es una acotacion test");
      Set<GeneroLibro> generos = new HashSet<GeneroLibro>(); //defecto
      TemaLibro tema = new TemaLibro("TemaTest");
      EstadoLibro estado = new EstadoLibro(); //defecto
      CopiasLibro copias = new CopiasLibro(3);

      var command = new AgregarLibro(categoriaId, libroId, editorialId, autorId, titulo, acotacion, generos, tema, estado, copias);

      var useCase = new AgregarLibroUseCase();
      Mockito.when(repository.getEventsBy("ccc")).thenReturn(history());
      useCase.addRepository(repository);

      var events = UseCaseHandler.getInstance()
              .setIdentifyExecutor(categoriaId.value())
              .syncExecutor(useCase, new RequestCommand<>(command))
              .orElseThrow()
              .getDomainEvents();

      var libroAgregado = (LibroAgregado) events.get(0);
  
      Assertions.assertEquals("eee", libroAgregado.getEditorialId().value());
      Assertions.assertEquals("aaa", libroAgregado.getAutorId().value());
      Assertions.assertEquals("TestTitulo", libroAgregado.getTitulo().value());
      Assertions.assertEquals("Esta es una acotacion test", libroAgregado.getAcotacion().value());
      Assertions.assertEquals(new HashSet<GeneroLibro>(), libroAgregado.getGeneros());
      Assertions.assertEquals("TemaTest", libroAgregado.getTema().value());
      Assertions.assertEquals("IMPECABLE", libroAgregado.getEstado().value());
      Assertions.assertEquals(3, libroAgregado.getCopias().value());
  }

  @Test
  void agregarLibro() {
      CategoriaId categoriaId = CategoriaId.of("ccc");
      LibroId libroId = LibroId.of("ddd");
      EditorialId editorialId = EditorialId.of("eee");
      AutorId autorId = AutorId.of("aaa");
      TituloLibro titulo = new TituloLibro("TestTitulo");
      AcotacionLibro acotacion = new AcotacionLibro("Esta es una acotacion test");
      Set<GeneroLibro> generos = Set.of(new GeneroLibro("Miedo"), new GeneroLibro("Suspernso")); //seteados
      TemaLibro tema = new TemaLibro("TemaTest");
      EstadoLibro estado = new EstadoLibro(EstadoLibro.Type.ROTO); //seteados
      CopiasLibro copias = new CopiasLibro(3);

      var command = new AgregarLibro(categoriaId, libroId, editorialId, autorId, titulo, acotacion, generos, tema, estado, copias);

      var useCase = new AgregarLibroUseCase();
      Mockito.when(repository.getEventsBy("ccc")).thenReturn(history());
      useCase.addRepository(repository);

      var events = UseCaseHandler.getInstance()
              .setIdentifyExecutor(categoriaId.value())
              .syncExecutor(useCase, new RequestCommand<>(command))
              .orElseThrow()
              .getDomainEvents();

      var libroAgregado = (LibroAgregado) events.get(0);
  
      Assertions.assertEquals("eee", libroAgregado.getEditorialId().value());
      Assertions.assertEquals("aaa", libroAgregado.getAutorId().value());
      Assertions.assertEquals("TestTitulo", libroAgregado.getTitulo().value());
      Assertions.assertEquals("Esta es una acotacion test", libroAgregado.getAcotacion().value());
      Assertions.assertEquals(Set.of(new GeneroLibro("Miedo"), new GeneroLibro("Suspernso")), libroAgregado.getGeneros());
      Assertions.assertEquals("TemaTest", libroAgregado.getTema().value());
      Assertions.assertEquals("ROTO", libroAgregado.getEstado().value());
      Assertions.assertEquals(3, libroAgregado.getCopias().value());
  }

  private List<DomainEvent> history() {
    return List.of(
      new CategoriaCreada(new Nombre("Novelas"))
    );
  }
  
  @Test
  void errorCategoriaNoExiste() {
      CategoriaId categoriaId = CategoriaId.of("ccc");
      LibroId libroId = LibroId.of("ddd");
      EditorialId editorialId = EditorialId.of("eee");
      AutorId autorId = AutorId.of("aaa");
      TituloLibro titulo = new TituloLibro("TestTitulo");
      AcotacionLibro acotacion = new AcotacionLibro("Esta es una acotacion test");
      Set<GeneroLibro> generos = new HashSet<GeneroLibro>();
      TemaLibro tema = new TemaLibro("TemaTest");
      EstadoLibro estado = new EstadoLibro();
      CopiasLibro copias = new CopiasLibro(3);

      var command = new AgregarLibro(categoriaId, libroId, editorialId, autorId, titulo, acotacion, generos, tema, estado, copias);

      var useCase = new AgregarLibroUseCase();

      Assertions.assertThrows(UnexpectedException.class, () -> {
        UseCaseHandler.getInstance()
              .setIdentifyExecutor(categoriaId.value())
              .syncExecutor(useCase, new RequestCommand<>(command))
              .orElseThrow();
    }, "La categoria al cual se quiere agregar un libro no existe.");

  }
}
