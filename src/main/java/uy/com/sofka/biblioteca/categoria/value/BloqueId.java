package uy.com.sofka.biblioteca.categoria.value;

import co.com.sofka.domain.generic.Identity;

public class BloqueId extends Identity{
  
  public BloqueId(){
    
  }

  private BloqueId(String id){
    super (id);
  }

  public static BloqueId of (String id){
    return new BloqueId(id);
  }
}
