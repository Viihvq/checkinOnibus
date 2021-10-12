package gui;

import entidades.Bilhete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Infos {
    JFrame frame = new JFrame();
    JButton btAtt = new JButton("Atualizar informações");
    JButton btProx = new JButton("Próximo");
//    Connection conexaoBanco;
    Bilhete bilhete;

    public Infos(){
//        criaJPanelInfos(bilhete);
    }
    public JPanel criaJPanelInfos(Bilhete bilhete){
//        this.conexaoBanco = conexaoBanco;
        this.bilhete = bilhete;

        JPanel informacoes = new JPanel();

        JPanel teste = new JPanel(); //JOGA INFO E BOTOES PRA CA

        GridLayout l = new GridLayout(8,2);
        l.setHgap(10);
        l.setVgap(10);
        informacoes.setLayout(l);

        JLabel lblOrigem = new JLabel("Origem: ");
        informacoes.add(lblOrigem);

        JLabel lblOrigemBanco = new JLabel(bilhete.getLinha().getOrigem());
        System.out.println(bilhete.getCodigo() + "aaaaaaa testando\n");
        informacoes.add(lblOrigemBanco);

        JLabel lblDestino = new JLabel("Destino: ");
        informacoes.add(lblDestino);

        JLabel lblDestinoBanco = new JLabel(bilhete.getLinha().getDestino());
        informacoes.add(lblDestinoBanco);

        JLabel lblEmbarque = new JLabel("Embarque: ");
        informacoes.add(lblEmbarque);

        JLabel lblEmbarqueBanco = new JLabel(String.valueOf(bilhete.getLinha().getHora_embarque()));
        informacoes.add(lblEmbarqueBanco);

        JLabel lblPartida = new JLabel("Partida: ");
        informacoes.add(lblPartida);

        JLabel lblPartidaBanco = new JLabel(String.valueOf(bilhete.getLinha().getHora_partida()));
        informacoes.add(lblPartidaBanco);

        JLabel lblHrAtual = new JLabel("Hora atual");
        informacoes.add(lblHrAtual);

        DateFormat HrPC = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();

        JLabel lblHrAtualPC = new JLabel(HrPC.format(date));
        informacoes.add(lblHrAtualPC);

        JLabel lblNome = new JLabel("Nome: ");
        informacoes.add(lblNome);

        JLabel lblNomeBanco = new JLabel(bilhete.getPassageiro().getNome());
        informacoes.add(lblNomeBanco);

        JLabel lblCpf = new JLabel("CPF: ");
        informacoes.add(lblCpf);

        JLabel lblCpfBanco = new JLabel(bilhete.getPassageiro().getCpf());
        informacoes.add(lblCpfBanco);

//        JPanel botoes = new JPanel();


        btAtt.addActionListener(al); //"Escuta" quando o botão é clicado
        informacoes.add(btAtt);

        btProx.addActionListener(al); //"Escuta" quando o botão é clicado
        informacoes.add(btProx);

        //TIRA ISSO DEPOIS DOS TESTES
//        frame.getContentPane().add(informacoes, BorderLayout.NORTH); //Posicionamento em cima
//        frame.getContentPane().add(botoes, BorderLayout.SOUTH); //Posicionamento embaixo
//        //

        teste.add(informacoes, BorderLayout.NORTH); //DESCOMENTAR DEPOIS
//        teste.add(botoes, BorderLayout.SOUTH);

//        frameSettings();
        return teste;
    }

    public JButton getBtAtt(){
        return btAtt;
    }

    public JButton getBtProx(){
        return btProx;
    }

    final ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btAtt) {
                System.out.println("OPA");
//                frame.dispose();
                new EditaInfos();
            } else if (e.getSource() == btProx) {
                System.out.println("BÃO");

            }

//            frame.dispose(); //Fecha o frame
        }
    };

//    public void frameSettings(){ //Método que seta tamanho, posição, fechamento do frame
////        frame.addComponentListener(new ComponentAdapter() {
////            public void componentMoved(ComponentEvent e) {
////                frame.setEnabled(false);
////                frame.setEnabled(true);
////            }
////        });
//
//        frame.setSize(350,350);
//        frame.setTitle("Informações");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        frame.setResizable(false); //Teoricamente impede mudança no tamanho da janela
//        frame.setVisible(true);
//    }

//    public static void main(String[] args) {
//        Infos i = new Infos();
////        i.criaJPanelInfos();
//    }
}
