package ihm;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import java.awt.*;
import fc.*;


public class Films extends JPanel{
    boolean connecter;
    Interface inter;
    Vector<Film> liste_films = new Vector<Film>();
    
    Films(JFrame f, boolean c,Interface in){
    inter = in;
    connecter = c;
    int solde = 0;
    if(connecter){
        Client client = inter.get_client();
        solde = client.get_solde();
        
    }
    JFrame Fenetre = f;
    setLayout(new BorderLayout());
    JPanel centre = new JPanel();
    JPanel films = new JPanel();
    JPanel sud = new JPanel();
    liste_films = inter.get_liste_film();
    
    JButton Retour = new JButton("Retour");
    JButton GestionCompte = new JButton("Compte");
    JTextField Recherche = new JTextField();
    Recherche.setFont(new Font("Arial",Font.PLAIN,20));
    Vector<String> genre = inter.get_liste_genre();
    JComboBox Liste_genre = new JComboBox<>(genre);
    JPanel bar_recherche = new JPanel();
    JButton chercher = new JButton("Chercher");
    JLabel cherche = new JLabel(" Chercher :");
    JLabel Solde = new JLabel("Votre solde : "+ solde + " €");
    cherche.setFont(new Font("Arial",Font.PLAIN,20));

    films.setLayout(new StackLayout());
    JScrollPane bar = new JScrollPane(films);
    centre.setLayout(new BorderLayout());

    // Placement
    JPanel nord = new JPanel();
    nord.setLayout(new BorderLayout());
    bar_recherche.setLayout(new BorderLayout());
    nord.add(GestionCompte,BorderLayout.WEST);
    nord.add(chercher,BorderLayout.EAST);
    bar_recherche.add(cherche,BorderLayout.WEST);
    bar_recherche.add(Recherche,BorderLayout.CENTER);
    bar_recherche.add(Liste_genre,BorderLayout.EAST);
    nord.add(bar_recherche,BorderLayout.CENTER);

    sud.setLayout(new BorderLayout());
    sud.add(Retour,BorderLayout.WEST);
    sud.add(Solde,BorderLayout.EAST);

    //Connxion
    if(!connecter){
            Solde.setVisible(false);
            GestionCompte.setVisible(false);
    }
    
    //Label
    Solde.setFont(new Font("Arial",Font.BOLD,25));
    
    //Boutons
    Retour.setPreferredSize(new Dimension(150,50));
    Retour.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Accueil(Fenetre,connecter,inter));
            Fenetre.revalidate();
            }
    });
    GestionCompte.setPreferredSize(new Dimension(110,40));
    GestionCompte.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new GestionCompte(Fenetre,inter,new Film(0,"","",null,"",null,0,0),false));
            Fenetre.revalidate();
            }
    });
    chercher.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            String genre_choisi = (String) Liste_genre.getSelectedItem();
            String titre = Recherche.getText();
            if(!titre.equals("") && !genre_choisi.equals("Tous")){
                System.out.println("b");
                liste_films = inter.rechercher(titre, genre_choisi);
            }
            else if(titre.equals("") && !genre_choisi.equals("Tous")){
                System.out.println("a");
                liste_films = inter.rechercher_genre(genre_choisi);
            }
            else if (!titre.equals("") && genre_choisi.equals("Tous")){
                liste_films = inter.rechercher_titre(titre);
            }
            else{
                liste_films = inter.get_liste_film();
            }
            centre.removeAll();
            bar.removeAll();
            JPanel new_films = new JPanel();
            new_films.setLayout(new StackLayout());
            centre.remove(bar);
            JScrollPane new_bar = new JScrollPane(new_films);
            for (int i = 0; i< liste_films.size() ; i++){
                PFilm fi = new PFilm(liste_films.get(i).get_id(), Fenetre, connecter,liste_films,inter,false);
                new_films.add(fi);
                
            }
            centre.add(new_bar,BorderLayout.CENTER);
            centre.revalidate();
            centre.repaint();
            }
    });
    for (int i = 0; i< liste_films.size() ; i++){
        PFilm fi = new PFilm(liste_films.get(i).get_id(), Fenetre, connecter,liste_films,inter,false);
        films.add(fi);
    }

    centre.add(bar,BorderLayout.CENTER);
    add(centre,BorderLayout.CENTER);
    add(sud,BorderLayout.SOUTH);
    add(nord,BorderLayout.NORTH);

    }
}