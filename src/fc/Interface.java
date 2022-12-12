package fc;

import java.util.Vector;
import fc.banque.Banque_transaction;

public class Interface {

    Client client;
    Vector<Client> liste_client;
    Vector<Location> liste_location;
    Vector<Support> liste_support;
    Vector<Film> liste_film;
    Vector<String> liste_genre;
    
    public Interface(){
        Carte_banquaire cb = new Carte_banquaire("CIC", "Visa", "42", new Banque_transaction());
        Client c1= new Client(0, cb);
        
        Abonne_parent c2= new Abonne_parent(1, "ANDRE", "Paul", "SMH", "3630", 15, cb);
        Abonne_enfant c3= new Abonne_enfant(2, "Romain", "Noe", "Grenoble", "0606060606", 15, cb);
        
        c2.add_enfant(c3);

        liste_client = new Vector<Client>();
        liste_client.add(c1);
        liste_client.add(c2);

        liste_location = new Vector<Location>();

        liste_genre = new Vector<String>();
        liste_genre.add("Tous");
        liste_genre.add("Action");
        liste_genre.add("Animation");

        String resume1 = "Kiki est une jeune sorcière qui vient de fêter ses treize ans. C’est une date importante dans sa famille : traditionnellement à cet âge, les sorcières doivent quitter leurs parents et s’établir pour une année dans une nouvelle ville afin de parfaire leur apprentissage. Kiki, que cette idée met en joie, écoute le bulletin météo à la radio qui annonce beau temps. C’est décidé, elle partira le soir même ! Bien que sa mère soit un peu inquiète, elle n’essaye pas de différer le départ. Elle confie à sa fille la robe noire traditionnelle des sorcières, que Kiki trouve trop terne à son goût, tandis que son père appelle les voisins pour la cérémonie d’adieu. À la nuit tombante, la jeune sorcière est ainsi parée, avec sa petite radio, son paquetage, et son sarcastique chat noir Jiji qui a la faculté de parler avec Kiki. Elle enfourche le vieux balai magique de sa famille et s’envole vers sa nouvelle vie. ";
        Vector<String> act1 = new Vector<String>();
        act1.add("Minami Takayama");
        act1.add("Rei Sakuma");
        Vector<String> genre1 = new Vector<String>();
        genre1.add("Action");
        genre1.add("Animation");
        Film f1 = new Film(0, "Kiki", "Hayao Miyazaki", act1, resume1, genre1, 0, 0);


        String resume2 = "L'univers de Star Wars se déroule dans une galaxie qui est le théâtre d'affrontements entre les Chevaliers Jedi et les Seigneurs noirs des Sith, personnes sensibles à la Force, un champ énergétique mystérieux leur procurant des pouvoirs psychiques. Les Jedi maîtrisent le Côté lumineux de la Force, pouvoir bénéfique et défensif, pour maintenir la paix dans la galaxie. Les Sith utilisent le Côté obscur, pouvoir nuisible et destructeur, pour leurs usages personnels et pour dominer la galaxie. ";
        Vector<String> act2 = new Vector<String>();
        act1.add("Ewan McGregor");
        act1.add("Natalie Portman");
        Vector<String> genre2 = new Vector<String>();
        genre1.add("Action");
        Film f2 = new Film(1, "Star Wars", " 	George Lucas", act2, resume2, genre2, 12, 1);
        

        liste_film = new Vector<Film>();
        liste_film.add(f1);
        liste_film.add(f2);

        DVD d1 = new DVD(f1, 0, false, true, 0);
        DVD d2 = new DVD(f2, 1, false, true, 0);
        liste_support = new Vector<Support>();
        liste_support.add(d1);
        liste_support.add(d2);



    }

    public Client get_client(){
        return client;
    }

    public void set_client(int id){
        for(int i =0; i<liste_client.size();i++){
            if(liste_client.get(i).get_id()==id){
                client = liste_client.get(i);
            }
        }
    }

    public void rendre(int id, Boolean endommage){
        for(int i =0; i<liste_location.size();i++){
            if(liste_location.get(i).get_Support().get_id()==id){
                liste_location.get(i).get_Support().retour();
                liste_location.get(i).get_Support().set_endommage(endommage);
            }
        }
    }

    public Vector<String> get_liste_genre(){
        return liste_genre;
    }

    public Vector<Film> get_liste_film(){
        return liste_film;
    }

    public Vector<Film> rechercher(String titre,String categorie){
        Vector<Film> lf = new Vector<Film>();
        for(int i = 0;i<liste_film.size();i++){
            if(liste_film.get(i).get_titre() == titre){
                Boolean b = false;
                for(int j = 0;j<liste_film.get(i).get_genre().size();j++){
                    if(liste_film.get(i).get_genre().get(j) == categorie){
                        b = true;
                    }
                }
                if(b){
                    lf.add(liste_film.get(i));
                }
            }
        }
        return lf;
    }

    public Vector<Film> rechercher_titre(String titre){
        Vector<Film> lf = new Vector<Film>();
        for(int i = 0;i<liste_film.size();i++){
            if(liste_film.get(i).get_titre() == titre){
                lf.add(liste_film.get(i));
            }
        }
        return lf;
    }

    public Vector<Film> rechercher_genre(String categorie){
        Vector<Film> lf = new Vector<Film>();
        for(int i = 0;i<liste_film.size();i++){
            Boolean b = false;
            for(int j = 0;j<liste_film.get(i).get_genre().size();j++){
                if(liste_film.get(i).get_genre().get(j) == categorie){
                    b = true;
                }
            }
            if(b){
                lf.add(liste_film.get(i));
            }
        }
        return lf;
    }

    public boolean dvd_dispo(Film f){
        Boolean b = false;
        for(int i =0; i < liste_support.size();i++){
            if(liste_support.get(i).get_film().get_id() == f.get_id()){
                b = true;
            }
        }
        return b;
    }
}
