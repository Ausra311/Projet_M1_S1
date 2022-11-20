package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class FicheHisto extends JPanel {
    FicheHisto(int i){
        JTextField infos = new JTextField("historique numero" + i);
        add(infos);
    }   
}
