package uy.com.sofka.biblioteca.usecase.boleta;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import uy.com.sofka.biblioteca.boleta.Boleta;
import uy.com.sofka.biblioteca.boleta.commands.AgregarItem;

public class AgregarItemUseCase extends UseCase<RequestCommand<AgregarItem>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<AgregarItem> input) {
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
      boleta.agregarItem(
        command.getItemId(),
        command.getLibroId(),
        command.getCategoriaId(),
        command.getCantidad()
      );

      emit().onResponse(new ResponseEvents(boleta.getUncommittedChanges()));
    } catch (IllegalArgumentException e) {
      throw new BusinessException(command.getBoletaId().value(), e.getMessage(), e);
    }
      

  }
  
}