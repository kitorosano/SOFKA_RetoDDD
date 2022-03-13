package uy.com.sofka.biblioteca.usecase.cliente;

import java.util.ArrayList;
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
import uy.com.sofka.biblioteca.cliente.commands.VincularCuenta;
import uy.com.sofka.biblioteca.cliente.events.ClienteCreado;
import uy.com.sofka.biblioteca.cliente.events.CuentaVinculada;
import uy.com.sofka.biblioteca.cliente.value.CorreoCuenta;
import uy.com.sofka.biblioteca.cliente.value.CuentaId;
import uy.com.sofka.biblioteca.cliente.value.NombreUsuarioCuenta;
import uy.com.sofka.biblioteca.cliente.value.ProveedorCuenta;
import uy.com.sofka.biblioteca.value.CedulaCliente;
import uy.com.sofka.biblioteca.value.ClienteId;
import uy.com.sofka.biblioteca.value.DireccionCliente;
import uy.com.sofka.biblioteca.value.NombreCliente;
import uy.com.sofka.biblioteca.value.TelefonoCliente;

@ExtendWith(MockitoExtension.class)
public class VincularCuentaUseCaseTest {

  @Mock
  private DomainEventRepository repository;
  
  @Test
  void vincularCuenta() {
      ClienteId clienteId = ClienteId.of("ccc");
      CuentaId cuentaId = CuentaId.of("ddd");
      NombreUsuarioCuenta nombreUsuario = new NombreUsuarioCuenta("UsuarioTest");
      CorreoCuenta correo = new CorreoCuenta("correo@test.com");
      ProveedorCuenta proveedor = new ProveedorCuenta("Facebook");

      var command = new VincularCuenta(clienteId, cuentaId, nombreUsuario, correo, proveedor);

      var useCase = new VincularCuentaUseCase();
      Mockito.when(repository.getEventsBy("ccc")).thenReturn(history());
      useCase.addRepository(repository);

      var events = UseCaseHandler.getInstance()
              .setIdentifyExecutor(clienteId.value())
              .syncExecutor(useCase, new RequestCommand<>(command))
              .orElseThrow()
              .getDomainEvents();

      var cuentaVinculada = (CuentaVinculada) events.get(0);
  
      Assertions.assertEquals("UsuarioTest", cuentaVinculada.getNombreUsuarioCuenta().value());
      Assertions.assertEquals("correo@test.com", cuentaVinculada.getCorreoCuenta().value());
      Assertions.assertEquals("Facebook", cuentaVinculada.getProveedorCuenta().value());
  }

  private List<DomainEvent> history() {
    return List.of(
      new ClienteCreado(
        new NombreCliente("Esteban"), 
        new DireccionCliente("Roger Balet 2186"), 
        new TelefonoCliente("092728300"), 
        new CedulaCliente("53017189")
      )
    );
  }

  
  @Test
  void errorClienteNoExiste() {
      ClienteId clienteId = ClienteId.of("ccc");
      CuentaId cuentaId = CuentaId.of("ddd");
      NombreUsuarioCuenta nombreUsuario = new NombreUsuarioCuenta("UsuarioTest");
      CorreoCuenta correo = new CorreoCuenta("correo@test.com");
      ProveedorCuenta proveedor = new ProveedorCuenta("Facebook");

      var command = new VincularCuenta(clienteId, cuentaId, nombreUsuario, correo, proveedor);

      var useCase = new VincularCuentaUseCase();

      Assertions.assertThrows(UnexpectedException.class, () -> {
        UseCaseHandler.getInstance()
              .setIdentifyExecutor(clienteId.value())
              .syncExecutor(useCase, new RequestCommand<>(command))
              .orElseThrow();
    }, "El cliente al cual se quiere vincular una cuenta no existe.");

  }
}
