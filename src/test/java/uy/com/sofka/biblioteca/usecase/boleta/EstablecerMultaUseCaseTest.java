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

import co.com.sofka.business.generic.UnexpectedException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.boleta.commands.EstablecerMulta;
import uy.com.sofka.biblioteca.boleta.events.MultaEstablecida;
import uy.com.sofka.biblioteca.boleta.events.BoletaCreada;
import uy.com.sofka.biblioteca.boleta.value.BoletaId;
import uy.com.sofka.biblioteca.boleta.value.CondicionesMulta;
import uy.com.sofka.biblioteca.boleta.value.Fecha;
import uy.com.sofka.biblioteca.boleta.value.FechaDevolucion;
import uy.com.sofka.biblioteca.boleta.value.MultaId;
import uy.com.sofka.biblioteca.boleta.value.Necesidad;
import uy.com.sofka.biblioteca.boleta.value.MontoMulta;

@ExtendWith(MockitoExtension.class)
public class EstablecerMultaUseCaseTest {

  @Mock
  private DomainEventRepository repository;
  
  @Test
  void asignarMulta() {
      BoletaId boletaId = BoletaId.of("ccc");
      MultaId multaId = MultaId.of("mmm");
      CondicionesMulta condiciones = new CondicionesMulta("Estas son las condiciones test");
      MontoMulta monto = new MontoMulta(500.00);

      var command = new EstablecerMulta(boletaId, multaId, condiciones, monto);

      var useCase = new EstablecerMultaUseCase();
      Mockito.when(repository.getEventsBy("ccc")).thenReturn(history());
      useCase.addRepository(repository);

      var events = UseCaseHandler.getInstance()
              .setIdentifyExecutor(boletaId.value())
              .syncExecutor(useCase, new RequestCommand<>(command))
              .orElseThrow()
              .getDomainEvents();

      var multaAgregado = (MultaEstablecida) events.get(0);
  
      Assertions.assertEquals("mmm", multaAgregado.getMultaId().value());
      Assertions.assertEquals("Estas son las condiciones test", multaAgregado.getCondiciones().value());
      Assertions.assertEquals(500.00, multaAgregado.getMonto().value());
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
    BoletaId boletaId = BoletaId.of("ccc");
    MultaId multaId = MultaId.of("mmm");
    CondicionesMulta condiciones = new CondicionesMulta("Estas son las condiciones test");
    MontoMulta monto = new MontoMulta(500.00);

    var command = new EstablecerMulta(boletaId, multaId, condiciones, monto);

    var useCase = new EstablecerMultaUseCase();

      Assertions.assertThrows(UnexpectedException.class, () -> {
        UseCaseHandler.getInstance()
              .setIdentifyExecutor(boletaId.value())
              .syncExecutor(useCase, new RequestCommand<>(command))
              .orElseThrow();
    }, "La boleta al cual se quiere establecer una multa no existe.");

  }
}
