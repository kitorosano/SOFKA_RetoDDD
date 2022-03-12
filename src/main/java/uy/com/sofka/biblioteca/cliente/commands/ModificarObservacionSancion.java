package uy.com.sofka.biblioteca.cliente.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.value.ClienteId;
import uy.com.sofka.biblioteca.cliente.value.SancionId;
import uy.com.sofka.biblioteca.cliente.value.ObservacionSancion;

public class ModificarObservacionSancion extends Command {
  private final ClienteId clienteId;
  private final SancionId sancionId; 
  private final ObservacionSancion observacion;

  public ModificarObservacionSancion(ClienteId clienteId, SancionId sancionId, ObservacionSancion observacion) {
    this.clienteId = clienteId;
    this.sancionId = sancionId;
    this.observacion = observacion;
  }
  
  public ClienteId getClienteId() {
    return this.clienteId;
  }

  public SancionId getSancionId() {
    return this.sancionId;
  }

  public ObservacionSancion getObservacionSancion() {
    return this.observacion;
  }
}
