package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import fc.*;


public class Accueil extends JPanel{

    boolean connecter;
    Interface inter;
    Accueil(JFrame f, boolean c,Interface i) {
        inter=i;
        connecter = c;
        JFrame Fenetre = f;
        setLayout(new StackLayout());
        //setBackground(new Color(0, 0, 0,50));
        JPanel Location = new JPanel();
        JPanel Boutons = new JPanel();
        JButton Louer = new JButton("Louer");
        JButton Connexion = new JButton("Connexion");
        JButton Rendre = new JButton("Rendre  ");
        JButton Deconnexion = new JButton ("Deconnexion");
        
        // Placement
        JPanel Haut = new JPanel();
        Haut.setPreferredSize(new Dimension(600,400));


        // Boutons
        Louer.setPreferredSize(new Dimension(400,80));
        Louer.setFont(new Font("Arial",Font.BOLD,25));
        Louer.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Films(Fenetre,connecter,inter));
            Fenetre.revalidate();
            }
        });
        
        Connexion.setPreferredSize(new Dimension(200,40));
        Connexion.setFont(new Font("Arial",Font.BOLD,15));
        Connexion.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Connexion(Fenetre,connecter,0,inter,new Film(0,"","",null,"",null,0,0)));
            Fenetre.revalidate();
            }
        });
        Deconnexion.setPreferredSize(new Dimension(200,40));
        Deconnexion.setFont(new Font("Arial",Font.BOLD,15));
        Deconnexion.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
            inter.deconnexion();
            connecter = false;
            Fenetre.setContentPane(new Accueil(Fenetre,connecter,inter));
            Fenetre.revalidate();
            }
        });
        Rendre.setPreferredSize(new Dimension(200,40));
        Rendre.setFont(new Font("Arial",Font.BOLD,15));
        Rendre.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Rendre(Fenetre,connecter,inter));
            Fenetre.revalidate();
            }
        });
        // Panel principal
        if(connecter){
            Connexion.setVisible(false);
            Deconnexion.setVisible(true);
        }else{
            Connexion.setVisible(true);
            Deconnexion.setVisible(false);            
        }
        Location.add(Louer,BorderLayout.CENTER);
        Boutons.add(Rendre);
        Boutons.add(Connexion);
        Boutons.add(Deconnexion);
        add(Haut);
        add(Location);
        add(Boutons);       
        
    }
}


