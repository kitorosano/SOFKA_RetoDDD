package uy.com.sofka.biblioteca.usecase.categoria;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import uy.com.sofka.biblioteca.categoria.Categoria;
import uy.com.sofka.biblioteca.categoria.commands.CrearCategoria;

public class CrearCategoriaUseCase extends UseCase<RequestCommand<CrearCategoria>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<CrearCategoria> input) {
    var command = input.getCommand();
    
    //TODO: Corroborar que el nombre no se repita entre categorias

    var categoria = new Categoria(
      command.getCategoriaId(), 
      command.getNombre()
      );

    emit().onResponse(new ResponseEvents(categoria.getUncommittedChanges()));
  }
  
}
