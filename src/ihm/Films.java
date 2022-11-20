package ihm;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Films extends JPanel{
    Films(JFrame f) {
    JFrame Fenetre = f;
    setLayout(new BorderLayout());
    boolean connecte = true;
    JPanel centre = new JPanel();
    JPanel films = new JPanel();
    Film film1 = new Film(1,Fenetre);
    Film film2 = new Film(2,Fenetre);
    JPanel sud = new JPanel();
    JButton Retour = new JButton("Retour");
    JButton GestionCompte = new JButton("Mon Compte");
    JLabel Solde = new JLabel("Votre solde : 15 € ");
    films.setLayout(new StackLayout());
    JScrollPane bar = new JScrollPane(films);
    centre.setLayout(new BorderLayout());

    // Placement
    JPanel nord = new JPanel();
    nord.setLayout(new BorderLayout());
    nord.add(GestionCompte,BorderLayout.WEST);

    sud.setLayout(new BorderLayout());
    sud.add(Retour,BorderLayout.WEST);
    sud.add(Solde,BorderLayout.EAST);

    //Connxion
    if(!connecte){
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
            Fenetre.setContentPane(new Accueil(Fenetre));
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


    films.add(film1);
    films.add(film2);
    centre.add(bar,BorderLayout.CENTER);
    add(centre,BorderLayout.CENTER);
    add(sud,BorderLayout.SOUTH);
    add(nord,BorderLayout.NORTH);
    }
}