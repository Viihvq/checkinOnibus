package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

public class Home{
    JButton btcheck;
    JPanel checkingPanel;


    public Home(){
        //criaJPanelHome();
    }
    public JPanel criaJPanelHome() throws IOException {


        checkingPanel = new JPanel(); //home
//        checkingPanel.setLayout(null);
        checkingPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        btcheck = new JButton("Realizar checking");
        btcheck.setBounds(67, 112, 200, 60);
//        btcheck.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        btcheck.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        btcheck.setBackground(new Color(238, 247, 246));

        checkingPanel.add(btcheck);
        JLabel imagem = new JLabel();
//        status.setBorder(BorderFactory.createLineBorder(Color.BLACK)); //Borda
        imagem.setBounds(0, 0, 350, 310);
        Image img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("img.png")); //Permite abrir a imagem no jar
        imagem.setIcon(new ImageIcon(img));
        checkingPanel.add(imagem,Component.BOTTOM_ALIGNMENT);

        checkingPanel.setBackground(new Color(184, 249, 244));

        getBotaoHome();

        return checkingPanel;
    }

    public JButton getBotaoHome(){
        return btcheck;
    }

    public void frameSettings(){ //Método que seta tamanho, posição, fechamento do frame
//        frame.addComponentListener(new ComponentAdapter() {
//            public void componentMoved(ComponentEvent e) {
//                frame.setEnabled(false);
//                frame.setEnabled(true);
//            }
//        });

//        frame.setSize(350,350);
//        frame.setTitle("Checking");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        frame.setResizable(false); //Teoricamente impede mudança no tamanho da janela
//        frame.setVisible(true);
    }

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Teste 123");
//            SolicitaCod sc = new SolicitaCod(conexaoBanco);
//            frame.dispose(); //Fecha o frame
        }
    };

//    public static void main(String[] args) {
//        Home a = new Home();
//    }
}
