package uy.com.sofka.biblioteca.usecase.cliente;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import uy.com.sofka.biblioteca.cliente.Cliente;
import uy.com.sofka.biblioteca.cliente.commands.VincularCuenta;

public class VincularCuentaUseCase extends UseCase<RequestCommand<VincularCuenta>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<VincularCuenta> input) {
    var command = input.getCommand();

    try {
    var cliente = Cliente.from(command.getClienteId(), retrieveEvents());
    cliente.vincularCuenta(
      command.getCuentaId(), 
      command.getNombreUsuario(), 
      command.getCorreo(), 
      command.getProveedor()
    );

    emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    } catch (BusinessException e) {
      throw new BusinessException(command.getClienteId().value(), "El cliente no existe", e);
    }
  }
  
}