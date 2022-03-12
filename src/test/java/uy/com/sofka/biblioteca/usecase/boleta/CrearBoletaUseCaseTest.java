package uy.com.sofka.biblioteca.usecase.boleta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import uy.com.sofka.biblioteca.boleta.commands.CrearBoleta;
import uy.com.sofka.biblioteca.boleta.events.BoletaCreada;
import uy.com.sofka.biblioteca.boleta.value.BoletaId;
import uy.com.sofka.biblioteca.boleta.value.Fecha;
import uy.com.sofka.biblioteca.boleta.value.FechaDevolucion;
import uy.com.sofka.biblioteca.boleta.value.Necesidad;

public class CrearBoletaUseCaseTest {
  
  @Test
  void crearUnaBoleta() {
    var command = new CrearBoleta(
            new BoletaId(),
            new Necesidad("Para estudiar una materia"),
            new Fecha(),
            new FechaDevolucion(14, 3, 2022)
      );
    var useCase = new CrearBoletaUseCase();

    var events = UseCaseHandler.getInstance()
            .syncExecutor(useCase, new RequestCommand<>(command))
            .orElseThrow()
            .getDomainEvents();

    var boletaCreado = (BoletaCreada) events.get(0);

    Assertions.assertEquals("Para estudiar una materia", boletaCreado.getNecesidad().value());
    Assertions.assertEquals("12-03-2022", boletaCreado.getFecha().value());
    Assertions.assertEquals("14-03-2022", boletaCreado.getFechaDevolucion().value());
  }

  @Test
  void errorFechaDevolucionViejaBoleta() {
    var useCase = new CrearBoletaUseCase();

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      UseCaseHandler.getInstance()
          .syncExecutor(useCase, new RequestCommand<>(
              new CrearBoleta(
                  new BoletaId(),
                  new Necesidad("Para estudiar una materia"),
                  new Fecha(),
                  new FechaDevolucion(10, 3, 2022) //fecha vieja
              )
          ))
          .orElseThrow();
    }, "La fecha de devolucion ingresada no puede ser más vieja que la fecha actual");
  }  

  @Test
  void errorFechaDevolucionInvalidaBoleta() {
    var useCase = new CrearBoletaUseCase();

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      UseCaseHandler.getInstance()
          .syncExecutor(useCase, new RequestCommand<>(
              new CrearBoleta(
                  new BoletaId(),
                  new Necesidad("Para estudiar una materia"),
                  new Fecha(),
                  new FechaDevolucion(2022, 3, 12) // formato de fecha incorrecta
              )
          ))
         .orElseThrow();
    }, "El formato de fecha de devolucion ingresada es invalida. Formato Valido: (dd/MM/yyyy)");
  }  
}
