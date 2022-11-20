package ihm;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class FicheFilm extends JPanel {
    FicheFilm(int id,JFrame f) {
    JFrame Fenetre = f;
    JPanel Sud = new JPanel();
    JPanel Centre = new JPanel();
    JButton LouerQR = new JButton("LouerQR");
    JButton LouerDVD = new JButton("LouerDVD");
    JButton Retour = new JButton("Retour");
    JTextField resume = new JTextField("kiki la sorciere");
    Retour.setPreferredSize(new Dimension(110,50));
    Retour.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Films(Fenetre));
            Fenetre.revalidate();
            }
    });
    setLayout(new BorderLayout());
    Sud.setLayout(new FlowLayout());
    Centre.setLayout(new BorderLayout());
    Centre.add(resume,BorderLayout.CENTER);
    Sud.add(Retour);
    Sud.add(LouerDVD);
    Sud.add(LouerQR);
    
    add(Centre,BorderLayout.CENTER);
    add(Sud,BorderLayout.SOUTH);


}
}