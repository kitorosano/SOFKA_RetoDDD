package uy.com.sofka.biblioteca.cliente.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class ProveedorCuenta implements ValueObject<String> {
  private final String value;

  public ProveedorCuenta(String value) {
    this.value = Objects.requireNonNull(value).trim();

    if(this.value.isBlank())
      throw new IllegalArgumentException("El proveedor de la cuenta no puede estar vacio");

  }

  @Override
  public String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof ProveedorCuenta)) {
      return false;
    }
    ProveedorCuenta proveedorCuenta = (ProveedorCuenta) o;
    return Objects.equals(value, proveedorCuenta.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
  
}