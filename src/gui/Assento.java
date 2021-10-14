package gui;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Pack;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Assento{
    List<JButton> bancos = new ArrayList<>();
    char[][] fileiras = new char[6][6];
//    JFrame frame = new JFrame();
    boolean teste = false;
    int linhaSelecionada;
    int colunaSelecionada;
    public Assento(){}

    public JPanel criaJPanelAssento(){
        JPanel painel = new JPanel();

//        GridLayout gl = new GridLayout(9,2);
//        painel.setLayout(gl);


        JLabel frase = new JLabel("Selecione o assento de sua preferencia: ");
        frase.setBorder(BorderFactory.createEmptyBorder(10,20,15,10));
        painel.add(frase);


//        painel.setSize(350,350);
        painel.setBackground(Color.pink);
        JPanel painel1 = new JPanel();

        painel1.setBackground(Color.green);
        GridLayout gl = new GridLayout(7,2);
        gl.setVgap(3);
        gl.setHgap(3);
        painel1.setLayout(gl);
//        painel1.setSize(60,350);

        for (int i =0; i<14;i++){
            JButton botao = new JButton(""+(i+1));
            botao.setBorder(BorderFactory.createEmptyBorder(6,20,6,20));
            painel1.add(botao);
        }

        painel.add(painel1, BorderLayout.EAST);

//        painel.add(Box.createRigidArea(new Dimension(50,0)));
//        painel.add(Box.createHorizontalGlue());

        painel.add(new Box.Filler(new Dimension(40,5),new Dimension(40,5),new Dimension(40,5)));

        JPanel painel2 = new JPanel();
        GridLayout gl2 = new GridLayout(7,2);
        gl2.setVgap(3);
        gl2.setHgap(3);
        painel2.setLayout(gl2);

        for (int i =14; i<28;i++){
            JButton botao = new JButton(""+(i+1)+"");
            botao.setBorder(BorderFactory.createEmptyBorder(6,20,6,20));
            painel2.add(botao);
        }

        painel.add(painel2, BorderLayout.WEST);

        JButton salvar = new JButton("Salvar");
        salvar.setBorder(BorderFactory.createEmptyBorder(10,45,10,45));
        painel.add(salvar, BorderLayout.SOUTH);


        return painel;
    }

//        painel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//        painel.setLayout(new BoxLayout(painel,));
//        painel.add(Box.createRigidArea(new Dimension(5,0)));

//        painel2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//        painel2.setLayout(new BoxLayout(painel2, BoxLayout.PAGE_AXIS));
//        painel2.add(Box.createRigidArea(new Dimension(5,0)));

//        JPanel total = new JPanel();
//
//        JPanel pnl = new JPanel();
//        JLabel lbl = new JLabel("Por favor marque sua decisão final \n");
//        pnl.add(lbl);
//
////        frame.getContentPane().add(pnl, BorderLayout.NORTH);
//
//        JPanel pnl2 = new JPanel();
//        GridLayout l = new GridLayout(5,2);
//        l.setHgap(10); //espaçamento entre as colunas
//        l.setVgap(10); //espaçamento entre as linhas
//
//        pnl2.setLayout(l);
//
//        ActionListener clique = (e)->{
//            int i = bancos.indexOf(e.getSource());
//            int linha = i/5;
//            int coluna = i%4;
//
//            fileiras[linha][coluna] = 'X';
//
//            if (teste == false) {
//                fileiras[linha][coluna] = 'X';
//                teste = true;
//                linhaSelecionada = linha;
//                colunaSelecionada = coluna;
//                System.out.println(i + " " + linha + " " + coluna);
//                System.out.println("Teste -> "+teste);
//                ((JButton) e.getSource()).setText("x");
//            }else{
////                fileiras[linhaSelecionada][colunaSelecionada] = 'O';
////                ((JButton) e.getSource()).getText();
////                fileiras[linha][coluna] = 'X';
//            }
//        };
//
//        for (int i=0; i< 20;i++){
//            JButton b =(new JButton());
//            b.addActionListener(clique);
////            frame.add(b);
//            bancos.add(b);
//            pnl2.add(b);
//        }
//
//
//        total.add(pnl,BorderLayout.NORTH);
//        total.add(pnl2,BorderLayout.CENTER);
//
////        frame.getContentPane().add(pnl2, BorderLayout.CENTER);
//
//        JButton prox = new JButton("Próximo");
////        frame.getContentPane().add(prox, BorderLayout.SOUTH);
//
//        JPanel pnl3 = new JPanel();
//
//        pnl3.add(prox);
//
//        pnl3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//        pnl3.setLayout(new BoxLayout(pnl3, BoxLayout.LINE_AXIS));
//        pnl3.add(Box.createRigidArea(new Dimension(15,30)));
//
//        total.add(pnl3,BorderLayout.SOUTH);
//
//        ////////////////////////////////////////////////////////////////
//
//
////        frameSettings();
//
//        return total;
//    }

//    public void frameSettings(){ //Método que seta tamanho, posição, fechamento do frame
////        frame.addComponentListener(new ComponentAdapter() {
////            public void componentMoved(ComponentEvent e) {
////                frame.setEnabled(false);
////                frame.setEnabled(true);
////            }
////        });
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
