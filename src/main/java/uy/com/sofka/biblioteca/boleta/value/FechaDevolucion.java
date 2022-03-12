package uy.com.sofka.biblioteca.boleta.value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class FechaDevolucion implements ValueObject<LocalDateTime> {
  private final LocalDateTime value;

  public FechaDevolucion(String fecha) {
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    try {
      this.value = LocalDateTime.parse(fecha, formateador);
    }catch (DateTimeParseException e){
      throw new IllegalStateException("La fecha de devolucion ingresada es invalida. Asegurese de que el formato sea 'dd/MM/yyyy HH:mm:ss'");
    }
  }

  @Override
  public LocalDateTime value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof FechaDevolucion)) {
      return false;
    }
    FechaDevolucion fechaDevolucion = (FechaDevolucion) o;
    return Objects.equals(value, fechaDevolucion.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

}
