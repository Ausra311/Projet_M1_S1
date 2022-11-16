package fc;
import java.util.Vector;

public class Film {
    private int id_film;
    private String titre;
    private String realisateur;
    private Vector<String> acteurs;
    private String resume;
    private Vector<String> genre;
    private int restriction;
    private int nb_location;

    Film(int id,
        String _titre,
        String _realisateur, 
        Vector<String> _acteurs, 
        String _resume,
        Vector<String> _genre,
        int _restriction,
        int _nb){

        id_film=id;
        titre = _titre;
        realisateur = _realisateur;
        acteurs = _acteurs;
        resume = _resume;
        genre = _genre;
        restriction = _restriction;
        nb_location = _nb;

    }

    public int get_id(){
        return id_film;
    }

    public String get_titre(){
        return titre;
    }

    public String get_realisateur(){
        return realisateur;
    }

    public Vector<String> get_acteurs(){
        return acteurs;
    } 

    public String get_resume(){
        return resume;
    }

    public Vector<String> get_genre(){
        return genre;
    }

    public int get_restriction(){
        return restriction;
    }

    public int get_nb_location(){
        return nb_location;
    }

    public void add_genre(String g){
        genre.add(g);
    }

    public void suppr_genre(String g){
        genre.remove(g);
    }

    public void change_restriction(int i){
        restriction = i;
    }

    public void nouvelle_location(){
        nb_location++;
    }



}