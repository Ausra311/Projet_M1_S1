package ihm;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import fc.*;

public class Histo extends JPanel {
    JFrame Fenetre;
    Interface inter;
    Histo(JFrame j,Interface in,Film film){
        Fenetre = j;
        inter = in;
        JPanel nord = new JPanel();
        nord.setLayout(new GridLayout(1,3));
        JLabel titre = new JLabel("Titre");
        JLabel date_deb = new JLabel("Date emprunt");
        JLabel date_fin = new JLabel("Date rendu");
        titre.setFont(new Font("Arial",Font.BOLD,15));
        date_deb.setFont(new Font("Arial",Font.BOLD,15));
        date_fin.setFont(new Font("Arial",Font.BOLD,15));
        nord.add(titre);
        nord.add(date_deb);
        nord.add(date_fin);
        setLayout(new BorderLayout());
        JPanel principal = new JPanel();
        principal.setLayout(new StackLayout());
        JScrollPane scroll = new JScrollPane(principal);
        JPanel sud = new JPanel();
        JButton Retour = new JButton("Retour");
        sud.setLayout(new BorderLayout());
        sud.add(Retour,BorderLayout.WEST);

        for (int i=0;i<40;i++){
            FicheHisto h = new FicheHisto(i+1,inter);
            principal.add(h);
        }
        Retour.setPreferredSize(new Dimension(110,50));
        Retour.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new GestionCompte(Fenetre,inter,film));
            Fenetre.revalidate();
            }
        });
        add(nord,BorderLayout.NORTH);
        add(scroll,BorderLayout.CENTER);
        add(sud,BorderLayout.SOUTH);
    }
    
}
