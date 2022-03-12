package uy.com.sofka.biblioteca.usecase.categoria;

import static org.mockito.Mockito.mock;

import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import uy.com.sofka.biblioteca.categoria.commands.CrearCategoria;
import uy.com.sofka.biblioteca.categoria.events.CategoriaCreada;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.Nombre;

public class CrearCategoriaUseCaseTest {
  
  @Test
  void crearUnaCategoria() {
      var command = new CrearCategoria(
              new CategoriaId(),
              new Nombre("Novelas")
        );
      var useCase = new CrearCategoriaUseCase();

      var events = UseCaseHandler.getInstance()
              .syncExecutor(useCase, new RequestCommand<>(command))
              .orElseThrow()
              .getDomainEvents();

      var categoriaCreado = (CategoriaCreada) events.get(0);

      Assertions.assertTrue(Objects.nonNull(categoriaCreado.getNombre().value()));
  }

}
