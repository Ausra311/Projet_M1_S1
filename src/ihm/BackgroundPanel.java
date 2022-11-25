package ihm;
 

import java.awt.Graphics;
 
import javax.swing.ImageIcon;
import javax.swing.JPanel;


import java.awt.GridBagLayout;
 
public class BackgroundPanel extends JPanel {
 
    private static final long serialVersionUID = 1L;
    private ImageIcon background;
    int cas;
   
    public BackgroundPanel(String fileName,int c) {
        super();
        cas =c;
        this.setLayout(new GridBagLayout());
        ImageIcon image= new ImageIcon(fileName); 
        switch(cas){
            case 0:
                this.background = new ImageIcon(image.getImage().getScaledInstance(150, 200, 0));
            break;
            default:
                this.background = new ImageIcon(image.getImage().getScaledInstance(500, 700, 0));
            break;
        }        
        

    }
 
    public void setBackground(ImageIcon background) {
        this.background = background;
    }
 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, this);
    }
}
