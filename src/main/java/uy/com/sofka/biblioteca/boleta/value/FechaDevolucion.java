package uy.com.sofka.biblioteca.boleta.value;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class FechaDevolucion implements ValueObject<String> {
  private final LocalDate value;
  private final String valueFormateado;

  public FechaDevolucion(int day, int month, int year) {
    try {
      this.value = LocalDate.of(year, month, day);
      if(this.value.isBefore(LocalDate.now())) {
        throw new IllegalArgumentException("La fecha de devolucion ingresada no puede ser más vieja que la fecha actual.");
      }
    } catch (DateTimeException e){
      throw new IllegalArgumentException("El formato de fecha de devolucion ingresada es invalida. Formato Valido: (dd/MM/yyyy)");
    }
    this.valueFormateado = formatear();
  }

  private String formatear(){
    return this.value.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
  }

  
  @Override
  public String value() {
    return valueFormateado;
  }
  
  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof FechaDevolucion)) {
      return false;
    }
    FechaDevolucion fechaDevolucion = (FechaDevolucion) o;
    return Objects.equals(value, fechaDevolucion.value) && Objects.equals(valueFormateado, fechaDevolucion.valueFormateado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, valueFormateado);
  }

}
