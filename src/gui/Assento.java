package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Assento {
    List<JButton> bancos = new ArrayList<>();
    char[][] fileiras = new char[6][6];
    JFrame frame = new JFrame();
    boolean teste = false;
    int linhaSelecionada;
    int colunaSelecionada;
    public Assento(){}

    public JPanel criaJPanelAssento(){
        JPanel pnl = new JPanel();
        JLabel lbl = new JLabel("Por favor marque sua decisão final");
        pnl.add(lbl);
        frame.getContentPane().add(pnl, BorderLayout.NORTH);

        JPanel pnl2 = new JPanel();
        GridLayout l = new GridLayout(5,2);
        l.setHgap(10); //espaçamento entre as colunas
        l.setVgap(10); //espaçamento entre as linhas

        pnl2.setLayout(l);

        ActionListener clique = (e)->{
            int i = bancos.indexOf(e.getSource());
            int linha = i/5;
            int coluna = i%4;

            fileiras[linha][coluna] = 'X';

            if (teste == false) {
                fileiras[linha][coluna] = 'X';
                teste = true;
                linhaSelecionada = linha;
                colunaSelecionada = coluna;
                System.out.println(i + " " + linha + " " + coluna);
                System.out.println("Teste -> "+teste);
                ((JButton) e.getSource()).setText("x");
            }else{
//                fileiras[linhaSelecionada][colunaSelecionada] = 'O';
//                ((JButton) e.getSource()).getText();
//                fileiras[linha][coluna] = 'X';
            }
        };

        for (int i=0; i< 20;i++){
            JButton b =(new JButton());
            b.addActionListener(clique);
//            frame.add(b);
            bancos.add(b);
            pnl2.add(b);
        }


//        frame.getContentPane().add(pnl2, BorderLayout.CENTER);

        JButton prox = new JButton("Próximo");
//        frame.getContentPane().add(prox, BorderLayout.SOUTH);

        JCheckBox check1 = new JCheckBox();


//        frameSettings();

        return pnl;
    }

//    public void frameSettings(){ //Método que seta tamanho, posição, fechamento do frame
//        frame.addComponentListener(new ComponentAdapter() {
//            public void componentMoved(ComponentEvent e) {
//                frame.setEnabled(false);
//                frame.setEnabled(true);
//            }
//        });
//
//        frame.setSize(350,350);
//        frame.setTitle("Assentos");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        frame.setResizable(false); //impede mudança no tamanho da janela
//        frame.setVisible(true);
//    }

//    public static void main(String[] args) {
//        new Assento();
//    }
}
