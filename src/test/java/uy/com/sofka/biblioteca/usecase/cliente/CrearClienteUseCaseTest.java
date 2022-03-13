package uy.com.sofka.biblioteca.usecase.cliente;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import uy.com.sofka.biblioteca.cliente.commands.CrearCliente;
import uy.com.sofka.biblioteca.cliente.events.ClienteCreado;
import uy.com.sofka.biblioteca.value.CedulaCliente;
import uy.com.sofka.biblioteca.value.ClienteId;
import uy.com.sofka.biblioteca.value.DireccionCliente;
import uy.com.sofka.biblioteca.value.NombreCliente;
import uy.com.sofka.biblioteca.value.TelefonoCliente;

public class CrearClienteUseCaseTest {

  
  @Test
  void crearUnCliente() {
      var command = new CrearCliente(
              new ClienteId(),
              new NombreCliente("Esteban"), 
              new DireccionCliente("Roger Balet 2186"), 
              new TelefonoCliente("092728300"), 
              new CedulaCliente("53017189")
        );
      var useCase = new CrearClienteUseCase();

      var events = UseCaseHandler.getInstance()
              .syncExecutor(useCase, new RequestCommand<>(command))
              .orElseThrow()
              .getDomainEvents();

      var clienteCreado = (ClienteCreado) events.get(0);
  
      Assertions.assertEquals("Esteban", clienteCreado.getNombre().value());
      Assertions.assertEquals("Roger Balet 2186", clienteCreado.getDireccion().value());
      Assertions.assertEquals("092728300", clienteCreado.getTelefono().value());
      Assertions.assertEquals("53017189", clienteCreado.getCedula().value());
  }

}
