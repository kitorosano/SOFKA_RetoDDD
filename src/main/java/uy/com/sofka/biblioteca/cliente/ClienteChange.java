package uy.com.sofka.biblioteca.cliente;

import co.com.sofka.domain.generic.EventChange;
import uy.com.sofka.biblioteca.cliente.events.*;

public class ClienteChange extends EventChange {
  
  public ClienteChange(Cliente cliente){

    apply((ClienteCreado event) -> {
      cliente.nombre = event.getNombre();
      cliente.direccion = event.getDireccion();
      cliente.telefono = event.getTelefono();
      cliente.cedula = event.getCedula();
    });
    
    apply((NombreModificado event) -> {
      cliente.nombre = event.getNombre();
    });

    apply((DireccionModificada event) -> {
      cliente.direccion = event.getDireccion();
    });

    apply((TelefonoModificado event) -> {
      cliente.telefono = event.getTelefono();
    });

    apply((SancionAplicada event) -> {
      cliente.sanciones.add(new Sancion(
          event.getSancionId(),
          event.getObservacion(),
          event.getMultaId()
      ));
    });

    apply((SancionRetirada event) -> {
      cliente.cuentas.removeIf(sancion -> sancion.identity().equals(event.getSancionId()));
    });
    
    apply((ObservacionSancionModificada event) -> {
      var cuentas = cliente.getSancionPorId(event.getSancionId())
              .orElseThrow(() -> new IllegalArgumentException("No se encuentra la sancion del cliente"));
      cuentas.modificarObservacion(event.getObservacion());
    });

    apply((CuentaVinculada event) -> {
      cliente.cuentas.add(new Cuenta(
          event.getCuentaId(),
          event.getNombreUsuarioCuenta(),
          event.getCorreoCuenta(),
          event.getProveedorCuenta()
      ));
    });

    apply((CuentaDesvinculada event) -> {
      cliente.cuentas.removeIf(cuenta -> cuenta.identity().equals(event.getCuentaId()));
    });

    apply((NombreUsuarioCuentaModificado event) -> {
      var cuenta = cliente.getCuentaPorId(event.getCuentaId())
              .orElseThrow(() -> new IllegalArgumentException("No se encuentra la cuenta del cliente"));
      cuenta.modificarNombreUsuario(event.getNombreUsuario());
    });
  }
}
