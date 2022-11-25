package ihm;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import java.awt.*;


public class Films extends JPanel{
    boolean connecter;
    Films(JFrame f, boolean c) {
    connecter = c;
    JFrame Fenetre = f;
    setLayout(new BorderLayout());
    JPanel centre = new JPanel();
    JPanel films = new JPanel();
    JPanel sud = new JPanel();
    JButton Retour = new JButton("Retour");
    JButton GestionCompte = new JButton("Mon Compte");
    JLabel Solde = new JLabel("Votre solde : 15 € ");
    JTextField Recherche = new JTextField();
    Recherche.setFont(new Font("Arial",Font.PLAIN,20));
    Vector<String> genre = new Vector<String>();
    genre.add("Tous");
    genre.add("Action");
    genre.add("Animation");
    JComboBox Liste_genre = new JComboBox<>(genre);
    JPanel bar_recherche = new JPanel();
    JButton chercher = new JButton("Chercher");
    JLabel cherche = new JLabel(" Chercher :");
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
    Retour.setPreferredSize(new Dimension(110,50));
    Retour.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Accueil(Fenetre,connecter));
            Fenetre.revalidate();
            }
    });
    GestionCompte.setPreferredSize(new Dimension(110,50));
    GestionCompte.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new GestionCompte(Fenetre));
            Fenetre.revalidate();
            }
    });
    chercher.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            String genre_choisi =(String) Liste_genre.getSelectedItem();
            String titre = Recherche.getText();
            System.out.println("Recherche = " + titre);
            System.out.println("genre = " + genre_choisi);
            }
    });
    for (int i = 1; i<= 20; i++){
        Film fi = new Film(i, Fenetre, connecter);
        films.add(fi);
    }

    centre.add(bar,BorderLayout.CENTER);
    add(centre,BorderLayout.CENTER);
    add(sud,BorderLayout.SOUTH);
    add(nord,BorderLayout.NORTH);

    }
}