package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Home{
    JButton btcheck;
    JPanel checkingPanel;

    public Home(){
        criaJPanelHome();
    }
    public JPanel criaJPanelHome() {


        checkingPanel = new JPanel(); //home
        checkingPanel.setLayout(null);/*BERNARDO*/
        checkingPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        btcheck = new JButton("Realizar checking");
//        btcheck.setBounds(25,25,25,25);
        btcheck.setBounds(67, 112, 200, 60);/*BERNARDO*/
        btcheck.setFont(new Font("Lucida Grande", Font.PLAIN, 14)); /*BERNARDO*/
        btcheck.setBackground(new Color(238, 247, 246));


//        btcheck.addActionListener(al); //lê o clique do botão
//        btcheck.addActionListener((al) -> {
//            System.out.println("teste 123");
//        });

        checkingPanel.add(btcheck);
        checkingPanel.setBackground(new Color(184, 249, 244));

//        frame.getContentPane().add(checkingPanel);
//        frameSettings();

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
