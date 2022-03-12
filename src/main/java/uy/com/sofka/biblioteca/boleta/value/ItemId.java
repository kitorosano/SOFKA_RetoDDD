package uy.com.sofka.biblioteca.boleta.value;

import co.com.sofka.domain.generic.Identity;

public class ItemId extends Identity {

  public ItemId(){
    
  }

  private ItemId(String id){
    super (id);
  }

  public static ItemId of (String id){
    return new ItemId(id);
  }
}
