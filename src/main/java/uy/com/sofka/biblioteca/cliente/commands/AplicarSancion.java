package uy.com.sofka.biblioteca.cliente.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.cliente.value.ClienteId;
import uy.com.sofka.biblioteca.cliente.value.MultaId;
import uy.com.sofka.biblioteca.cliente.value.SancionId;
import uy.com.sofka.biblioteca.cliente.value.ObservacionSancion;

public class AplicarSancion extends Command {
  private final ClienteId clienteId;
  private final SancionId sancionId;
  private final ObservacionSancion observacion;
  private final MultaId multaId;

  public AplicarSancion(ClienteId clienteId, SancionId sancionId, ObservacionSancion observacion, MultaId multaId) {
    this.clienteId = clienteId;
    this.sancionId = sancionId;
    this.observacion = observacion;
    this.multaId = multaId;
  }

  public ClienteId getClienteId() {
    return this.clienteId;
  }

  public SancionId getSancionId() {
    return this.sancionId;
  }

  public ObservacionSancion getObservacion() {
    return this.observacion;
  }

  public MultaId getMultaId() {
    return this.multaId;
  }

}
