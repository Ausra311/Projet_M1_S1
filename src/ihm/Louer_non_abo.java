package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Louer_non_abo extends JPanel {
    JFrame Fenetre;
    Louer_non_abo(JFrame j){
        Fenetre = j;
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
        JLabel paye = new JLabel("Payement de 5 euros effectué     ");

        espace.setPreferredSize(new Dimension(5,40));
        JPanel espace2 = new JPanel();
        espace2.setPreferredSize(new Dimension(5,40));
        JLabel prix = new JLabel("Louer le film choisi pour 5 euros par jour");
        JButton connecter = new JButton("Se Connecter");
        JButton valider = new JButton("Valider");
        JButton retour = new JButton("Retour");
        JButton terminer = new JButton("Terminer");

        paye.setFont(new Font("Arial",Font.BOLD,20));
        terminer.setFont(new Font("Arial",Font.BOLD,20));
        prix.setFont(new Font("Arial",Font.BOLD,25));
        connecter.setFont(new Font("Arial",Font.BOLD,25));
        valider.setFont(new Font("Arial",Font.BOLD,25));
        retour.setPreferredSize(new Dimension(110,50));
        retour.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new FicheFilm(0,Fenetre,false));
            Fenetre.revalidate();
            }
        });
        connecter.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Connexion(Fenetre,false,1));
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
        terminer.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Accueil(Fenetre,false));
            Fenetre.revalidate();
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

        droite.add(connecter);
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
