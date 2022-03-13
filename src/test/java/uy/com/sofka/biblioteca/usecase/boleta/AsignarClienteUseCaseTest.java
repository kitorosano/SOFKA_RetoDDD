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
import uy.com.sofka.biblioteca.boleta.commands.AsignarCliente;
import uy.com.sofka.biblioteca.boleta.events.BoletaCreada;
import uy.com.sofka.biblioteca.boleta.events.ClienteAsignado;
import uy.com.sofka.biblioteca.boleta.value.BoletaId;
import uy.com.sofka.biblioteca.boleta.value.Fecha;
import uy.com.sofka.biblioteca.boleta.value.FechaDevolucion;
import uy.com.sofka.biblioteca.boleta.value.Necesidad;
import uy.com.sofka.biblioteca.value.CedulaCliente;
import uy.com.sofka.biblioteca.value.ClienteId;
import uy.com.sofka.biblioteca.value.DireccionCliente;
import uy.com.sofka.biblioteca.value.NombreCliente;
import uy.com.sofka.biblioteca.value.TelefonoCliente;

@ExtendWith(MockitoExtension.class)
public class AsignarClienteUseCaseTest {

  @Mock
  private DomainEventRepository repository;
  
  @Test
  void asignarCliente() {
      BoletaId boletaId = BoletaId.of("bbb");
      ClienteId clienteId = ClienteId.of("ccc");
      NombreCliente nombre = new NombreCliente("Esteban");
      DireccionCliente direccion = new DireccionCliente("Roger Balet 2186");
      TelefonoCliente telefono = new TelefonoCliente("092728300");
      CedulaCliente cedula = new CedulaCliente("53017189");

      var command = new AsignarCliente(boletaId, clienteId, nombre, direccion, telefono, cedula);

      var useCase = new AsignarClienteUseCase();
      Mockito.when(repository.getEventsBy("bbb")).thenReturn(history());
      useCase.addRepository(repository);

      var events = UseCaseHandler.getInstance()
              .setIdentifyExecutor(boletaId.value())
              .syncExecutor(useCase, new RequestCommand<>(command))
              .orElseThrow()
              .getDomainEvents();

      var clienteAsignado = (ClienteAsignado) events.get(0);
      
      Assertions.assertEquals("ccc", clienteAsignado.getClienteId().value());
      Assertions.assertEquals("Esteban", clienteAsignado.getNombre().value());
      Assertions.assertEquals("Roger Balet 2186", clienteAsignado.getDireccion().value());
      Assertions.assertEquals("092728300", clienteAsignado.getTelefono().value());
      Assertions.assertEquals("53017189", clienteAsignado.getCedula().value());
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
    ClienteId clienteId = ClienteId.of("ccc");
    NombreCliente nombre = new NombreCliente("Esteban");
    DireccionCliente direccion = new DireccionCliente("Roger Balet 2186");
    TelefonoCliente telefono = new TelefonoCliente("092728300");
    CedulaCliente cedula = new CedulaCliente("53017189");

    var command = new AsignarCliente(boletaId, clienteId, nombre, direccion, telefono, cedula);

    var useCase = new AsignarClienteUseCase();

      Assertions.assertThrows(UnexpectedException.class, () -> {
        UseCaseHandler.getInstance()
              .setIdentifyExecutor(boletaId.value())
              .syncExecutor(useCase, new RequestCommand<>(command))
              .orElseThrow();
    }, "La boleta al cual se quiere asignar un cliente no existe.");

  }
}
