package uy.com.sofka.biblioteca.usecase.categoria;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import uy.com.sofka.biblioteca.categoria.Categoria;
import uy.com.sofka.biblioteca.categoria.commands.AsignarBloque;

public class AsignarBloqueUseCase extends UseCase<RequestCommand<AsignarBloque>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<AsignarBloque> input) {
    var command = input.getCommand();

    // Verificacion si existe la categoria
    try {
      Categoria.from(command.getCategoriaId(), retrieveEvents());
    } catch (BusinessException e) {
      throw new BusinessException(command.getCategoriaId().value(), "La categoria no existe", e);
    }
    
    // Verificaciones de argumentos
    try {
      var categoria = Categoria.from(command.getCategoriaId(), retrieveEvents());
      
      categoria.asignarBloque(
        command.getBloqueId(),
        command.getDescripcion(),
        command.getPasillos(),
        command.getCantidadEstanteriasBloque()
      );

      emit().onResponse(new ResponseEvents(categoria.getUncommittedChanges()));
      
    } catch (IllegalArgumentException e) {
      throw new BusinessException(command.getCategoriaId().value(), e.getMessage(), e);
    }
  }
  
}