package uy.com.sofka.biblioteca.usecase.cliente;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import uy.com.sofka.biblioteca.cliente.Cliente;
import uy.com.sofka.biblioteca.cliente.commands.AplicarSancion;

public class AplicarSancionUseCase extends UseCase<RequestCommand<AplicarSancion>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<AplicarSancion> input) {
    var command = input.getCommand();

    try {
    var cliente = Cliente.from(command.getClienteId(), retrieveEvents());
    cliente.aplicarSancion(
      command.getSancionId(), 
      command.getObservacion(), 
      command.getMultaId()
    );

    emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    } catch (BusinessException e) {
      throw new BusinessException(command.getClienteId().value(), "El cliente no existe", e);
    }
  }
  
}