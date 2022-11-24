package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class Accueil extends JPanel{

    boolean connecter;
    Accueil(JFrame f, boolean c) {

        connecter = c;
        JFrame Fenetre = f;
        setLayout(new StackLayout());
        
        JPanel Location = new JPanel();
        JPanel Boutons = new JPanel();
        JButton Louer = new JButton("Louer");
        JButton Connexion = new JButton("Connexion");
        JButton Rendre = new JButton("Rendre  ");
   
        
        // Placement
        JPanel Haut = new JPanel();
        Haut.setPreferredSize(new Dimension(600,400));


        // Boutons
        Louer.setPreferredSize(new Dimension(400,80));
        Louer.setFont(new Font("Arial",Font.BOLD,25));
        Louer.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Films(Fenetre,connecter));
            Fenetre.revalidate();
            }
        });
        
        Connexion.setPreferredSize(new Dimension(200,40));
        Connexion.setFont(new Font("Arial",Font.BOLD,15));
        Connexion.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Connexion(Fenetre,connecter,0));
            Fenetre.revalidate();
            }
        });
        Rendre.setPreferredSize(new Dimension(200,40));
        Rendre.setFont(new Font("Arial",Font.BOLD,15));
        Rendre.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Rendre(Fenetre,connecter));
            Fenetre.revalidate();
            }
        });


        // Panel principal
        Location.add(Louer,BorderLayout.CENTER);
        Boutons.add(Rendre);
        Boutons.add(Connexion);
        add(Haut);
        add(Location);
        add(Boutons);

    }
}


