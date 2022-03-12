package uy.com.sofka.biblioteca.value;

import java.util.Objects;
import com.fabdelgado.ciuy.*;

import co.com.sofka.domain.generic.ValueObject;

public class CedulaCliente implements ValueObject<String> {
  private final String value;

  public CedulaCliente(String value) {
    this.value = Objects.requireNonNull(value).trim();

    if(!validarCi(this.value))
      throw new IllegalArgumentException("La cedula ingresada es invalida");
  }

  private Boolean validarCi(String ci) {
    Validator validator = new Validator();
    return validator.validateCi(ci);
  }

  @Override
  public String value() {
    return value;
  }


  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof CedulaCliente)) {
      return false;
    }
    CedulaCliente cedulaCliente = (CedulaCliente) o;
    return Objects.equals(value, cedulaCliente.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

}
