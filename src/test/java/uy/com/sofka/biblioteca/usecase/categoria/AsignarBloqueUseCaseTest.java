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

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UnexpectedException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.commands.AsignarBloque;
import uy.com.sofka.biblioteca.categoria.events.BloqueAsignado;
import uy.com.sofka.biblioteca.categoria.events.CategoriaCreada;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.DescripcionBloque;
import uy.com.sofka.biblioteca.categoria.value.BloqueId;
import uy.com.sofka.biblioteca.categoria.value.CantidadEstanteriasBloque;
import uy.com.sofka.biblioteca.categoria.value.Nombre;
import uy.com.sofka.biblioteca.categoria.value.PasilloBloque;

@ExtendWith(MockitoExtension.class)
public class AsignarBloqueUseCaseTest {

  @Mock
  private DomainEventRepository repository;
  
  @Test
  void asignarBloque() {
      CategoriaId categoriaId = CategoriaId.of("ccc");
      BloqueId bloqueId = BloqueId.of("bbb");
      DescripcionBloque descripcion = new DescripcionBloque("Esta es una descripcion test");
      Set<PasilloBloque> pasillos = Set.of(new PasilloBloque(4), new PasilloBloque(3)); //seteados
      CantidadEstanteriasBloque cantidadEstanterias = new CantidadEstanteriasBloque(5);

      var command = new AsignarBloque(categoriaId, bloqueId, descripcion, pasillos, cantidadEstanterias);

      var useCase = new AsignarBloqueUseCase();
      Mockito.when(repository.getEventsBy("ccc")).thenReturn(history());
      useCase.addRepository(repository);

      var events = UseCaseHandler.getInstance()
              .setIdentifyExecutor(categoriaId.value())
              .syncExecutor(useCase, new RequestCommand<>(command))
              .orElseThrow()
              .getDomainEvents();

      var bloqueAgregado = (BloqueAsignado) events.get(0);
  
      Assertions.assertEquals("Esta es una descripcion test", bloqueAgregado.getDescripcion().value());
      Assertions.assertEquals(Set.of(new PasilloBloque(4), new PasilloBloque(3)), bloqueAgregado.getPasillos()); //seteados, bloqueAgregado.getPasillos());
      Assertions.assertEquals(5, bloqueAgregado.getCantidadEstanterias().value());
  }

  @Test
  void errorPasillosVacios() {
    CategoriaId categoriaId = CategoriaId.of("ccc");
    BloqueId bloqueId = BloqueId.of("bbb");
    DescripcionBloque descripcion = new DescripcionBloque("Esta es una descripcion test");
    Set<PasilloBloque> pasillos = new HashSet<PasilloBloque>(); //seteados
    CantidadEstanteriasBloque cantidadEstanterias = new CantidadEstanteriasBloque(5);

    var command = new AsignarBloque(categoriaId, bloqueId, descripcion, pasillos, cantidadEstanterias);

    var useCase = new AsignarBloqueUseCase();
    Mockito.when(repository.getEventsBy("ccc")).thenReturn(history());
    useCase.addRepository(repository);
      
    Assertions.assertThrows(BusinessException.class, () -> {
      UseCaseHandler.getInstance()
          .setIdentifyExecutor(categoriaId.value())
          .syncExecutor(useCase, new RequestCommand<>(command))
          .orElseThrow()
          .getDomainEvents();
    }, "El bloque si o si requiere que el campo pasillos no este vacio.");
  }

  private List<DomainEvent> history() {
    return List.of(
      new CategoriaCreada(new Nombre("Novelas"))
    );
  }
  
  @Test
  void errorCategoriaNoExiste() {
    CategoriaId categoriaId = CategoriaId.of("ccc");
    BloqueId bloqueId = BloqueId.of("bbb");
    DescripcionBloque descripcion = new DescripcionBloque("Esta es una descripcion test");
    Set<PasilloBloque> pasillos = Set.of(new PasilloBloque(4), new PasilloBloque(3)); //seteados
    CantidadEstanteriasBloque cantidadEstanterias = new CantidadEstanteriasBloque(5);

    var command = new AsignarBloque(categoriaId, bloqueId, descripcion, pasillos, cantidadEstanterias);

    var useCase = new AsignarBloqueUseCase();

      Assertions.assertThrows(UnexpectedException.class, () -> {
        UseCaseHandler.getInstance()
              .setIdentifyExecutor(categoriaId.value())
              .syncExecutor(useCase, new RequestCommand<>(command))
              .orElseThrow();
    }, "La categoria al cual se quiere asignar un bloque no existe.");

  }
}
