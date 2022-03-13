package uy.com.sofka.biblioteca.usecase.categoria;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import uy.com.sofka.biblioteca.categoria.Categoria;
import uy.com.sofka.biblioteca.categoria.commands.AgregarLibro;

public class AgregarLibroUseCase extends UseCase<RequestCommand<AgregarLibro>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<AgregarLibro> input) {
    var command = input.getCommand();

    try {
      var categoria = Categoria.from(command.getCategoriaId(), retrieveEvents());
      categoria.agregarLibro(
        command.getLibroId(),
        command.getEditorialId(),
        command.getAutorId(),
        command.getTitulo(),  
        command.getAcotacion(),
        command.getGeneros(),
        command.getTema(),
        command.getEstado(),
        command.getCopias()
      );

      emit().onResponse(new ResponseEvents(categoria.getUncommittedChanges()));
      
    } catch (BusinessException e) {
      throw new BusinessException(command.getCategoriaId().value(), "El categoria no existe", e);
    }
  }
  
}