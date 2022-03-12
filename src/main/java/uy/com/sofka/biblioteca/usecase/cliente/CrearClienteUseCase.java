package uy.com.sofka.biblioteca.usecase.cliente;

import java.util.Objects;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UnexpectedException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import uy.com.sofka.biblioteca.cliente.Cliente;
import uy.com.sofka.biblioteca.cliente.commands.CrearCliente;

public class CrearClienteUseCase extends UseCase<RequestCommand<CrearCliente>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<CrearCliente> input) {
    var command = input.getCommand();
    
    // TODO: validar cedula repetida en clientes

    var cliente = new Cliente(
      command.getClienteId(), 
      command.getNombre(), 
      command.getDireccion(), 
      command.getTelefono(), 
      command.getCedula()
      );

    emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
  }
  
}
