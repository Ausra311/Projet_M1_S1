package fc;

import java.util.Vector;

public class Abonne_enfant  extends Abonne{
    private Vector<String> restriction_catégorie;
    private int restriction_age;


    //Get :
    public int get_age(){
        return restriction_age;
    };

    public Vector<String> get_restriction_catégorie(){
        return restriction_catégorie;
    }

    //Set :
    public void add_restriction_enfant(String s){
        restriction_catégorie.add(s);
    }

    @Override 
    public String type_client(){
        return "Abonne_enfant";
    }





}
