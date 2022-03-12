package uy.com.sofka.biblioteca.boleta.value;

import java.time.LocalDateTime;
import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class Fecha implements ValueObject<LocalDateTime> {
  private final LocalDateTime value;

  public Fecha() {
    this.value = LocalDateTime.now();
  }

  @Override
  public LocalDateTime value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Fecha)) {
      return false;
    }
    Fecha fecha = (Fecha) o;
    return Objects.equals(value, fecha.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

}
