package ihm;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class GestionCompte extends JPanel {
    JFrame Fenetre;
    GestionCompte(JFrame j){
        Fenetre =j;
        setLayout(new BorderLayout());
        JPanel centre = new JPanel();
        JPanel sud = new JPanel();
        centre.setLayout(new FlowLayout());
        sud.setLayout(new BorderLayout());
        JTextField Infos = new JTextField("Nom Prenom adresse ...");
        JPanel boutons = new JPanel();
        boutons.setLayout(new StackLayout());
        JButton Histo = new JButton("Historique");
        JButton Recharger = new JButton("Recharger");
        JButton GererMioche = new JButton("Gérer compte enfant");
        JButton Retour = new JButton("Retour");
        Retour.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Films(Fenetre));
            Fenetre.revalidate();
            }
        });
        Histo.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Histo(Fenetre));
            Fenetre.revalidate();
            }
        });
        Recharger.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Recharger(Fenetre));
            Fenetre.revalidate();
            }
        });
        GererMioche.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Gerergosse(Fenetre));
            Fenetre.revalidate();
            }
        });

        sud.add(Retour,BorderLayout.WEST);
        boutons.add(Histo);
        boutons.add(Recharger);
        boutons.add(GererMioche);
        centre.add(Infos);
        centre.add(boutons);
        add(centre,BorderLayout.CENTER);
        add(sud,BorderLayout.SOUTH);


    }
    
}
