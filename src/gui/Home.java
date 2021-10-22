package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Home{
    JButton btcheck;
    JPanel checkingPanel;

    public Home(){}
    public JPanel criaJPanelHome() throws IOException {

        checkingPanel = new JPanel();
        checkingPanel.setLayout(null);
        checkingPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        btcheck = new JButton("Realizar checking");
        btcheck.setBounds(67, 112, 200, 60);
        btcheck.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        btcheck.setBackground(new Color(238, 247, 246));

        checkingPanel.add(btcheck);

        JLabel imagem = new JLabel();
//        status.setBorder(BorderFactory.createLineBorder(Color.BLACK)); //Borda
        imagem.setBounds(0, 0, 350, 310);
        Image img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("imageHome.png")); //Permite abrir a imagem no jar
        imagem.setIcon(new ImageIcon(img));

        checkingPanel.add(imagem,Component.BOTTOM_ALIGNMENT);
        checkingPanel.setBackground(new Color(184, 249, 244));

        getBotaoHome();

        return checkingPanel;
    }

    public JButton getBotaoHome(){
        return btcheck;
    }

}
