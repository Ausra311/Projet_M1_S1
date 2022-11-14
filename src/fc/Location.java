package fc;

import java.util.Date;

public class Location {
    private Client client;
    private String type_client;
    private String support;
    private Film film;
    private Date date_emprunt;

    Location(Client c,String t,String s,Film f,Date d){
        client = c;
        type_client = t;
        support = s;
        film = f;
        date_emprunt = d;
    }

    public void retour(){

    }

    public void sortir_film(){

    }

   public void debiter(){
    client.debiter();
   }

    
    // get 
    public Client get_client(){
        return client;
    }
    public String get_type_client(){
        return type_client;
    }
    public String support(){
        return support;
    }
    public Film film(){
        return film;
    }
    public Date date_emprunt(){
        return date_emprunt;
    }
    
}
