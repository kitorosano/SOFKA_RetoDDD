package uy.com.sofka.biblioteca.boleta.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class MontoMulta implements ValueObject<Double> {
  private final Double value;

  public MontoMulta(Double value) {
    this.value = Objects.requireNonNull(value);

    if(this.value < 0)
      throw new IllegalArgumentException("El monto de la multa no puede ser negativo.");
  }

  @Override
  public Double value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof MontoMulta)) {
      return false;
    }
    MontoMulta montoMulta = (MontoMulta) o;
    return Objects.equals(value, montoMulta.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

}
