package uy.com.sofka.biblioteca.usecase.boleta;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import uy.com.sofka.biblioteca.boleta.Boleta;
import uy.com.sofka.biblioteca.boleta.commands.EstablecerMulta;

public class EstablecerMultaUseCase extends UseCase<RequestCommand<EstablecerMulta>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<EstablecerMulta> input) {
    var command = input.getCommand();

    // Verificacion si existe la boleta
    try {
      Boleta.from(command.getBoletaId(), retrieveEvents());
    } catch (BusinessException e) {
      throw new BusinessException(command.getBoletaId().value(), "La boleta no existe", e);
    }
    
    // Verificaciones de argumentos
    try {
      var boleta = Boleta.from(command.getBoletaId(), retrieveEvents());
      
      boleta.establecerMulta(
        command.getMultaId(),
        command.getCondiciones(),
        command.getMontoMulta()
      );

      emit().onResponse(new ResponseEvents(boleta.getUncommittedChanges()));
      
    } catch (IllegalArgumentException e) {
      throw new BusinessException(command.getBoletaId().value(), e.getMessage(), e);
    }
  }
  
}