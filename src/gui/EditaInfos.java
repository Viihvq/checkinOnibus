package gui;

import dados.ConexaoInfos;
import entidades.Bilhete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class EditaInfos {
    JFrame frame = new JFrame();
    JButton salvar = new JButton("Salvar");
    JButton voltar = new JButton("Voltar");
    JTextField editaCpf;// = new JTextField();
    JTextField editaNome;// = new JTextField();
    Connection conexaoBanco;

    public EditaInfos(){}
    //resolver esse segundo argumento<<<<<<<<<<<<<<<<<<<<<
    public JPanel criaJPanelEditaInfos(Bilhete bilhete, ConexaoInfos conexaoInfos) throws SQLException {
//        this.conexaoBanco = conexaoBanco;

        JPanel geral = new JPanel();

/*
* Aqui, quando eu clicar no botão de salvar, vou jogar as informações do que foi escrito
* para a classe ConexaoEditaPassageiro. Mas, antes disso, eu preciso saber o nome e
* o cpf do passageiro, então tenho que chamar 2x o ConexaoEditaPassageiro
* */


        JPanel edicao = new JPanel();
        edicao.setBorder(BorderFactory.createEmptyBorder(50,10,30,10));
        GridLayout l = new GridLayout(5,1);
        l.setHgap(0); //espaçamento entre colunas
        l.setVgap(10); //espaçamento entre linhas
        edicao.setLayout(l);

        JLabel lblCpf = new JLabel("Edita CPF: ");
        lblCpf.setSize(10,10);
        edicao.add(lblCpf);

//        editaCpf.setColumns(12); //tamanho da caixa de texto

        String cpfPassageiroBanco = bilhete.getPassageiro().getCpf();
        editaCpf = new JTextField(cpfPassageiroBanco); //Faz aparecer o cpf no texto
        edicao.add(editaCpf);

        JLabel lblNome = new JLabel("Edita nome: ");
        edicao.add(lblNome);

//        editaNome.setColumns(12);
        String nomePassageiroBanco = bilhete.getPassageiro().getNome();
        editaNome = new JTextField(nomePassageiroBanco); //Aparece o nome no texto
        edicao.add(editaNome);


        JPanel opcoes = new JPanel();

        opcoes.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));


//        salvar.addActionListener(al); SE DER PROBLEMA PODE SER AQUI QUE COMENTEI
        opcoes.add(salvar);

//        voltar.addActionListener(al);
        opcoes.add(voltar);

        geral.add(edicao);
        geral.add(opcoes);

        return geral;
    }

    public JButton getBtSalvar(){
        return salvar;
    }

    public JButton getBtVoltar(){
        return voltar;
    }

//    ActionListener al = new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//        }
//    };

//    public void frameSettings(){ //Método que seta tamanho, posição, fechamento do frame
//        frame.addComponentListener(new ComponentAdapter() {
//            public void componentMoved(ComponentEvent e) {
//                frame.setEnabled(false);
//                frame.setEnabled(true);
//            }
//        });
//
//        frame.setSize(350,350);
//        frame.setTitle("Edição");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        frame.setResizable(false); //Teoricamente impede mudança no tamanho da janela
//        frame.setVisible(true);
//    }

//    public static void main(String[] args) throws SQLException {
//        Connection conexao = DriverManager.getConnection("jdbc:postgresql://134.209.243.185:5432/vavatur",
//                "vavatur", "gGgLqu");
//        new EditaInfos(conexao);
//    }
}
