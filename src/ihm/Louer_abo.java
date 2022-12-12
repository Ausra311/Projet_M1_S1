package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import fc.*;

public class Louer_abo extends JPanel{
    JFrame Fenetre;
    boolean connecter;
    Interface inter;
    Louer_abo(JFrame j,boolean c,Interface i){
        connecter =c;
        Fenetre = j;
        inter = i;
        setLayout(new BorderLayout());
        JPanel sud = new JPanel();
        sud.setLayout(new BorderLayout());
        JPanel centre = new JPanel();
        centre.setLayout(new GridLayout(0,2));
        JPanel gauche = new JPanel();
        JPanel droite = new JPanel();
        JPanel espace = new JPanel();
        JPanel Payement = new JPanel();
        JPanel nord = new JPanel();
        nord.setPreferredSize(new Dimension(600,300));
        JLabel paye = new JLabel("Payement de 4 euros effectué     ");
        espace.setPreferredSize(new Dimension(5,40));
        JPanel espace2 = new JPanel();
        espace2.setPreferredSize(new Dimension(5,40));
        JLabel prix = new JLabel("Louer le film choisi pour 4 euros par jour");
        int sold = 15;
        JLabel solde = new JLabel("Soldes : " + sold + " €");
        JButton recharger = new JButton("Recharger");
        JButton valider = new JButton("Valider");
        JButton retour = new JButton("Retour");
        JButton terminer = new JButton("Terminer");
        
        paye.setFont(new Font("Arial",Font.BOLD,20));
        terminer.setFont(new Font("Arial",Font.BOLD,20));
        solde.setFont(new Font("Arial",Font.BOLD,25));
        prix.setFont(new Font("Arial",Font.BOLD,25));
        recharger.setFont(new Font("Arial",Font.BOLD,25));
        valider.setFont(new Font("Arial",Font.BOLD,25));
        retour.setPreferredSize(new Dimension(110,50));
        retour.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new FicheFilm(0,Fenetre,connecter,inter));
            Fenetre.revalidate();
            }
        });
        terminer.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Accueil(Fenetre,connecter,inter));
            Fenetre.revalidate();
            }
        });
        recharger.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Recharger(Fenetre,1,inter));
            Fenetre.revalidate();
            }
        });
        valider.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
            Payement.setVisible(true);
            valider.setVisible(false);
            }
        });
        sud.add(retour,BorderLayout.WEST);

        Payement.add(paye);
        Payement.add(terminer);
        Payement.setVisible(false);

        gauche.setLayout(new StackLayout());
        droite.setLayout(new StackLayout());
        gauche.add(prix);
        gauche.add(espace);
        gauche.add(solde);

        droite.add(recharger);
        droite.add(espace2);
        droite.add(valider);

        centre.add(gauche);
        centre.add(droite);
        centre.add(Payement);

        add(nord,BorderLayout.NORTH);
        add(centre,BorderLayout.CENTER);
        add(sud,BorderLayout.SOUTH);
    }
    
}
