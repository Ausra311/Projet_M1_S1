package ihm;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import java.awt.*;

public class Gerergosse extends JPanel {
    JFrame Fenetre;
    Gerergosse(JFrame j){
        Fenetre = j;
        JPanel centre = new JPanel();
        JPanel sud = new JPanel();
        Vector<String> enfants = new Vector<String>();
        enfants.add("enfant 1");
        enfants.add("enfant 2");
        JComboBox Liste_enfants = new JComboBox<>(enfants);
        JButton Retour = new JButton("Retour");
        Retour.setPreferredSize(new Dimension(110,50));
        Retour.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new GestionCompte(Fenetre));
            Fenetre.revalidate();
            }
        });
        sud.setLayout(new BorderLayout());
        sud.add(Retour,BorderLayout.WEST);
        centre.add(Liste_enfants);
        setLayout(new BorderLayout());
        add(centre,BorderLayout.CENTER);
        add(sud,BorderLayout.SOUTH);

    }
}
