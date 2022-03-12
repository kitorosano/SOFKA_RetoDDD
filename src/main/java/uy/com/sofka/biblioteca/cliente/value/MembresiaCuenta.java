package uy.com.sofka.biblioteca.cliente.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class MembresiaCuenta implements ValueObject<String> {
  private final String value;

  public MembresiaCuenta(String value) {
    this.value = Objects.requireNonNull(value);

    if(this.value.isBlank())
      throw new IllegalArgumentException("La membresia de la cuenta no puede estar vacia");

    if(this.value.length() <= 3)
      throw new IllegalArgumentException("La membresia de la cuenta debe tener minimo 3 caracteres");
      
    if(this.value.length() >= 30)
      throw new IllegalArgumentException("La membresia de la cuenta debe tener maximo 50 caracteres");
  }

  @Override
  public String value() {
    return value;
  }


  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof MembresiaCuenta)) {
      return false;
    }
    MembresiaCuenta membresiaCuenta = (MembresiaCuenta) o;
    return Objects.equals(value, membresiaCuenta.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

}