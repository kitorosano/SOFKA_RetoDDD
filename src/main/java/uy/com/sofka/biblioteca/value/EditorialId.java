package uy.com.sofka.biblioteca.value;

import co.com.sofka.domain.generic.Identity;

public class EditorialId extends Identity {
  
  public EditorialId(){
    
  }

  private EditorialId(String id){
    super (id);
  }

  public static EditorialId of (String id){
    return new EditorialId(id);
  }
}
