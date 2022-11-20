package ihm;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Histo extends JPanel {
    JFrame Fenetre;
    Histo(JFrame j){
        Fenetre = j;
        setLayout(new BorderLayout());
        JPanel principal = new JPanel();
        principal.setLayout(new StackLayout());
        JScrollPane scroll = new JScrollPane(principal);
        JPanel sud = new JPanel();
        JButton Retour = new JButton("Retour");
        sud.setLayout(new BorderLayout());
        sud.add(Retour,BorderLayout.WEST);

        for (int i=0;i<40;i++){
            FicheHisto h = new FicheHisto(i+1);
            principal.add(h);
        }
        Retour.setPreferredSize(new Dimension(110,50));
        Retour.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new GestionCompte(Fenetre));
            Fenetre.revalidate();
            }
        });
        add(scroll,BorderLayout.CENTER);
        add(sud,BorderLayout.SOUTH);
    }
    
}
