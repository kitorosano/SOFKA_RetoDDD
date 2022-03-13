package uy.com.sofka.biblioteca.usecase.cliente;

import java.util.List;

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
import uy.com.sofka.biblioteca.boleta.events.BoletaCreada;
import uy.com.sofka.biblioteca.boleta.events.MultaEstablecida;
import uy.com.sofka.biblioteca.boleta.value.CondicionesMulta;
import uy.com.sofka.biblioteca.boleta.value.Fecha;
import uy.com.sofka.biblioteca.boleta.value.FechaDevolucion;
import uy.com.sofka.biblioteca.boleta.value.MontoMulta;
import uy.com.sofka.biblioteca.boleta.value.MultaId;
import uy.com.sofka.biblioteca.boleta.value.Necesidad;
import uy.com.sofka.biblioteca.cliente.commands.AplicarSancion;
import uy.com.sofka.biblioteca.cliente.events.ClienteCreado;
import uy.com.sofka.biblioteca.cliente.events.SancionAplicada;
import uy.com.sofka.biblioteca.cliente.value.SancionId;
import uy.com.sofka.biblioteca.cliente.value.ObservacionSancion;
import uy.com.sofka.biblioteca.value.CedulaCliente;
import uy.com.sofka.biblioteca.value.ClienteId;
import uy.com.sofka.biblioteca.value.DireccionCliente;
import uy.com.sofka.biblioteca.value.NombreCliente;
import uy.com.sofka.biblioteca.value.TelefonoCliente;

@ExtendWith(MockitoExtension.class)
public class AplicarSancionUseCaseTest {

  @Mock
  private DomainEventRepository repository;
  
  @Test
  void aplicarSancion() {
      ClienteId clienteId = ClienteId.of("ccc");
      SancionId sancionId = SancionId.of("sss");
      ObservacionSancion observacion = new ObservacionSancion("Esta sancion fue realizada porque se realizo una entrega tarde del material.");
      MultaId multaId = MultaId.of("mmm");

      var command = new AplicarSancion(clienteId, sancionId, observacion, multaId);

      var useCase = new AplicarSancionUseCase();
      Mockito.when(repository.getEventsBy("ccc")).thenReturn(history());
      useCase.addRepository(repository);

      var events = UseCaseHandler.getInstance()
              .setIdentifyExecutor(clienteId.value())
              .syncExecutor(useCase, new RequestCommand<>(command))
              .orElseThrow()
              .getDomainEvents();

      var sancionAplicada = (SancionAplicada) events.get(0);
  
      Assertions.assertEquals("Esta sancion fue realizada porque se realizo una entrega tarde del material.", sancionAplicada.getObservacion().value());
      Assertions.assertEquals("mmm", sancionAplicada.getMultaId().value());
  }

  private List<DomainEvent> history() {
    return List.of(
      new ClienteCreado(
        new NombreCliente("Esteban"), 
        new DireccionCliente("Roger Balet 2186"), 
        new TelefonoCliente("092728300"), 
        new CedulaCliente("53017189")
      ),
      new BoletaCreada(
        new Necesidad("Para estudiar una materia"),
        new Fecha(),
        new FechaDevolucion(14, 3, 2024)
      ),
      new MultaEstablecida(
        MultaId.of("mmm"), 
        new CondicionesMulta("Estas son las condiciones de la multa: ..."), 
        new MontoMulta(2000.00)  
      )
    );
  }

  //TODO: Revisar
  @Test
  void errorMultaNoExiste() {
    ClienteId clienteId = ClienteId.of("ccc");
    SancionId sancionId = SancionId.of("sss");
    ObservacionSancion observacion = new ObservacionSancion("Esta sancion fue realizada porque se realizo una entrega tarde del material.");
    MultaId multaId = MultaId.of("mmm");

    var command = new AplicarSancion(clienteId, sancionId, observacion, multaId);

    var useCase = new AplicarSancionUseCase();

    Assertions.assertThrows(UnexpectedException.class, () -> {
      UseCaseHandler.getInstance()
            .setIdentifyExecutor(clienteId.value())
            .syncExecutor(useCase, new RequestCommand<>(command))
            .orElseThrow();
    }, "La multa al cual se quiere aplicar la sancion no existe.");
  }

  @Test
  void errorClienteNoExiste() {
    ClienteId clienteId = ClienteId.of("ccc");
    SancionId sancionId = SancionId.of("sss");
    ObservacionSancion observacion = new ObservacionSancion("Esta sancion fue realizada porque se realizo una entrega tarde del material.");
    MultaId multaId = MultaId.of("mmm");

    var command = new AplicarSancion(clienteId, sancionId, observacion, multaId);

    var useCase = new AplicarSancionUseCase();

    Assertions.assertThrows(UnexpectedException.class, () -> {
      UseCaseHandler.getInstance()
            .setIdentifyExecutor(clienteId.value())
            .syncExecutor(useCase, new RequestCommand<>(command))
            .orElseThrow();
    }, "El cliente al cual se quiere aplicar la sancion no existe.");
  }
}
