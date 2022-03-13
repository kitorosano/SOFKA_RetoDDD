package uy.com.sofka.biblioteca.usecase.boleta;

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
import uy.com.sofka.biblioteca.boleta.commands.AgregarItem;
import uy.com.sofka.biblioteca.boleta.events.BoletaCreada;
import uy.com.sofka.biblioteca.boleta.events.ItemAgregado;
import uy.com.sofka.biblioteca.boleta.value.BoletaId;
import uy.com.sofka.biblioteca.boleta.value.CantidadItem;
import uy.com.sofka.biblioteca.boleta.value.Fecha;
import uy.com.sofka.biblioteca.boleta.value.FechaDevolucion;
import uy.com.sofka.biblioteca.boleta.value.ItemId;
import uy.com.sofka.biblioteca.boleta.value.Necesidad;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.LibroId;

@ExtendWith(MockitoExtension.class)
public class AgregarItemUseCaseTest {

  @Mock
  private DomainEventRepository repository;
  
  @Test
  void agregarItem() {
      BoletaId boletaId = BoletaId.of("bbb");
      ItemId itemId = ItemId.of("iii");
      CategoriaId categoriaId = CategoriaId.of("ccc");
      LibroId libroId = LibroId.of("lll");
      CantidadItem cantidad = new CantidadItem(5);

      var command = new AgregarItem(boletaId, itemId, categoriaId, libroId, cantidad);

      var useCase = new AgregarItemUseCase();
      Mockito.when(repository.getEventsBy("bbb")).thenReturn(history());
      useCase.addRepository(repository);

      var events = UseCaseHandler.getInstance()
              .setIdentifyExecutor(boletaId.value())
              .syncExecutor(useCase, new RequestCommand<>(command))
              .orElseThrow()
              .getDomainEvents();

      var itemAgregado = (ItemAgregado) events.get(0);
      
      Assertions.assertEquals("iii", itemAgregado.getItemId().value());
      Assertions.assertEquals("ccc", itemAgregado.getCategoriaId().value());
      Assertions.assertEquals("lll", itemAgregado.getLibroId().value());
      Assertions.assertEquals(5, itemAgregado.getCantidad().value());
  }

  private List<DomainEvent> history() {
    return List.of(
      new BoletaCreada(
        new Necesidad("Para estudiar una materia"),
        new Fecha(),
        new FechaDevolucion(14, 3, 2023)
      )
    );
  }
  
  @Test
  void errorBoletaNoExiste() {
    BoletaId boletaId = BoletaId.of("bbb");
    ItemId itemId = ItemId.of("iii");
    CategoriaId categoriaId = CategoriaId.of("ccc");
    LibroId libroId = LibroId.of("lll");
    CantidadItem cantidad = new CantidadItem(5);

    var command = new AgregarItem(boletaId, itemId, categoriaId, libroId, cantidad);

    var useCase = new AgregarItemUseCase();

      Assertions.assertThrows(UnexpectedException.class, () -> {
        UseCaseHandler.getInstance()
              .setIdentifyExecutor(boletaId.value())
              .syncExecutor(useCase, new RequestCommand<>(command))
              .orElseThrow();
    }, "La boleta al cual se quiere agregar un item no existe.");

  }
}
