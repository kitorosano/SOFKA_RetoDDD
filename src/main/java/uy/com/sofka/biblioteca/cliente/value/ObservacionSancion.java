package uy.com.sofka.biblioteca.cliente.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class ObservacionSancion implements ValueObject<String> {
  private final String value;

  public ObservacionSancion(String value) {
    this.value = Objects.requireNonNull(value).trim();

    if(this.value.isBlank())
      throw new IllegalArgumentException("La observacion de la sancion no puede estar vacia");

    if(this.value.length() <= 10)
      throw new IllegalArgumentException("La observacion de la sancion debe tener minimo 10 caracteres");
      
    if(this.value.length() >= 100)
      throw new IllegalArgumentException("La observacion de la sancion debe tener maximo 100 caracteres");
  }

  @Override
  public String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof ObservacionSancion)) {
      return false;
    }
    ObservacionSancion observacionSancion = (ObservacionSancion) o;
    return Objects.equals(value, observacionSancion.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
  
}