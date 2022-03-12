package uy.com.sofka.biblioteca.usecase.boleta;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import uy.com.sofka.biblioteca.boleta.Boleta;
import uy.com.sofka.biblioteca.boleta.commands.CrearBoleta;

public class CrearBoletaUseCase extends UseCase<RequestCommand<CrearBoleta>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<CrearBoleta> input) {
    var command = input.getCommand();

    try {
      var boleta = new Boleta(
        command.getBoletaId(),
        command.getNecesidad(),
        command.getFecha(),
        command.getFechaDevolucion()
      );

      emit().onResponse(new ResponseEvents(boleta.getUncommittedChanges()));
      
    } catch (IllegalArgumentException e) {
      throw new BusinessException(command.getFechaDevolucion().value(), e.getMessage());
    }

  }
  
}
