package uy.com.sofka.biblioteca.boleta.value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class Fecha implements ValueObject<String> {
  private final LocalDate value;
  private final String valueFormateado;

  public Fecha() {
    this.value = LocalDate.now();
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
    if (!(o instanceof Fecha)) {
      return false;
    }
    Fecha fecha = (Fecha) o;
    return Objects.equals(value, fecha.value) && Objects.equals(valueFormateado, fecha.valueFormateado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, valueFormateado);
  }
  

}
