package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Louer_abo extends JPanel{
    JFrame Fenetre;
    boolean connecter;
    Louer_abo(JFrame j,boolean c){
        connecter =c;
        Fenetre = j;
        setLayout(new BorderLayout());
        JPanel sud = new JPanel();
        sud.setLayout(new BorderLayout());
        JPanel centre = new JPanel();
        centre.setLayout(new GridLayout(1,2));
        JPanel gauche = new JPanel();
        JPanel droite = new JPanel();
        JPanel espace = new JPanel();
        espace.setPreferredSize(new Dimension(5,40));
        JPanel espace2 = new JPanel();
        espace2.setPreferredSize(new Dimension(5,40));
        JLabel prix = new JLabel("Louer le film choisi pour 4 euros par jour");
        JLabel solde = new JLabel("Soldes : 15 €");
        JButton recharger = new JButton("Recharger");
        JButton valider = new JButton("Valider");
        JButton retour = new JButton("Retour");
        retour.setPreferredSize(new Dimension(110,50));
        retour.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new FicheFilm(0,Fenetre,connecter));
            Fenetre.revalidate();
            }
        });
        recharger.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Recharger(Fenetre,1));
            Fenetre.revalidate();
            }
        });
        sud.add(retour,BorderLayout.WEST);

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

        add(centre,BorderLayout.CENTER);
        add(sud,BorderLayout.SOUTH);
    }
    
}
