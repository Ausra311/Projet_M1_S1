package ihm;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Gerergosse extends JPanel {
    JFrame Fenetre;
    Gerergosse(JFrame j){
        Fenetre = j;
        JPanel centre = new JPanel();
        JPanel sud = new JPanel();
        JComboBox enfants = new JComboBox<>();
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
        centre.add(enfants);
        setLayout(new BorderLayout());
        add(centre,BorderLayout.CENTER);
        add(sud,BorderLayout.SOUTH);

    }
}
