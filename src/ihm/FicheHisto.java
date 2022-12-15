package ihm;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import fc.*;

public class FicheHisto extends JPanel {
    Interface inter;
    FicheHisto(Historique histo){
        JPanel centre = new JPanel();
        JLabel titre = new JLabel(histo.get_film().get_titre());
        JLabel date_deb = new JLabel(histo.date_debut.toString());
        String s = "Non rendu";
        if(histo.date_fin != null){
            s = histo.date_fin.toString();
        }
        JLabel date_fin = new JLabel(s);
        titre.setFont(new Font("Arial",Font.PLAIN,15));
        date_deb.setFont(new Font("Arial",Font.PLAIN,15));
        date_fin.setFont(new Font("Arial",Font.PLAIN,15));
        setLayout(new BorderLayout());
        centre.setLayout(new GridLayout(1,3));
        centre.add(titre);
        centre.add(date_deb);
        centre.add(date_fin);
        
        add(centre,BorderLayout.NORTH);
    }   
}
