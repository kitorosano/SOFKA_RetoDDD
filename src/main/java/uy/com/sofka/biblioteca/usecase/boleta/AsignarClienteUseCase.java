package uy.com.sofka.biblioteca.usecase.boleta;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import uy.com.sofka.biblioteca.boleta.Boleta;
import uy.com.sofka.biblioteca.boleta.commands.AsignarCliente;

public class AsignarClienteUseCase extends UseCase<RequestCommand<AsignarCliente>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<AsignarCliente> input) {
    var command = input.getCommand();

    // Validacion de la boleta
    try {
      Boleta.from(command.getBoletaId(), retrieveEvents());
    } catch (BusinessException e) {
      throw new BusinessException(command.getBoletaId().value(), "La boleta no existe", e);
    }

    // Validacion de argumentos
    try {
      var boleta = Boleta.from(command.getBoletaId(), retrieveEvents());
      boleta.asignarCliente(
        command.getClienteId(),
        command.getNombre(),
        command.getDireccion(),
        command.getTelefono(),
        command.getCedula()
      );

      emit().onResponse(new ResponseEvents(boleta.getUncommittedChanges()));
    } catch (IllegalArgumentException e) {
      throw new BusinessException(command.getBoletaId().value(), e.getMessage(), e);
    }
      

  }
  
}