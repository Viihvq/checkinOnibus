package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Home{ //acho que agora posso herdar de interface, pq ai vai ser o mesmo frame no final!
    JButton btcheck;
    JPanel checkingPanel;
//    JFrame frame = new JFrame();
    Connection conexaoBanco;

    public Home(){
        criaJPanelHome();
    }
    public JPanel criaJPanelHome() {
//        this.conexaoBanco = conexaoBanco;

        checkingPanel = new JPanel(); //home
        checkingPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        btcheck = new JButton("Realizar checking");
        btcheck.setBounds(25,25,25,25);
//        btcheck.addActionListener(al); //lê o clique do botão
//        btcheck.addActionListener((al) -> {
//            System.out.println("teste 123");
//        });

        checkingPanel.add(btcheck);
        checkingPanel.setBackground(Color.cyan);

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
