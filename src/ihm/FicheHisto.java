package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class FicheHisto extends JPanel {
    FicheHisto(int i){
        JPanel centre = new JPanel();
        JLabel titre = new JLabel("historique numero" + i);
        JLabel date_deb = new JLabel("01/02/1699");
        JLabel date_fin = new JLabel("03/04/1789");
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
