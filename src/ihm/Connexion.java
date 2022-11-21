package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Connexion extends JPanel{

    Connexion(JFrame f){
        JFrame Fenetre = f;
        setLayout(new BorderLayout());

        JPanel sud = new JPanel();
        JPanel centre = new JPanel();
        JButton Inserer_carte = new JButton("Inserer carte");
        JButton Retour = new JButton("Retour");

        // Placement
        JPanel haut = new JPanel(); 
        haut.setPreferredSize(new Dimension(600,400));
        
        //Boutons
        Inserer_carte.setPreferredSize(new Dimension(400,80));
        Inserer_carte.setFont(new Font("Arial",Font.BOLD,25));
        Inserer_carte.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Films(Fenetre));
            Fenetre.revalidate();
            }
        });

        Retour.setPreferredSize(new Dimension(110,50));
        Retour.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Accueil(Fenetre));
            Fenetre.revalidate();
            }
        });
        
        centre.add(Inserer_carte);
        sud.setLayout(new BorderLayout());
        sud.add(Retour,BorderLayout.WEST);

        //Panel principal
        add(centre,BorderLayout.CENTER);
        add(sud,BorderLayout.SOUTH);
        add(haut,BorderLayout.NORTH);

    }
}