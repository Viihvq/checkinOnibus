package gui;

import dados.ConexaoAssento;
import entidades.Bilhete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Assento{
    private ArrayList<JButton> listaBotoes = new ArrayList<>();
    private JButton salvar = new JButton("Salvar");
    private Integer assentoSelecionado = null;
    private ConexaoAssento conexaoAssentos;
    private Bilhete bilhete;
    private Integer[] ocupados;

    public Assento(){}

    public JPanel criaJPanelAssento(Bilhete bilhete, Connection conexao) throws SQLException {

        JPanel painel = new JPanel();

        JLabel frase = new JLabel("Selecione o assento de sua preferência");
        frase.setFont(new Font("Lucida Grande", Font.TRUETYPE_FONT, 15));
        frase.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        painel.add(frase);
        painel.setBackground(new Color(184, 249, 244));

        JPanel painelEsquerda = new JPanel();
        painelEsquerda.setBackground(new Color(94, 232, 230));

        GridLayout gl = new GridLayout(7,2);
        gl.setVgap(3);
        gl.setHgap(3);
        painelEsquerda.setLayout(gl);

        this.bilhete = bilhete;

        conexaoAssentos = new ConexaoAssento(bilhete,conexao);
        ocupados = conexaoAssentos.isOccupied();

        listaBotoes.add(new JButton("Numero 0")); //Evita problema nos botões: aperta um e vai o anterior.

//        for(int i = 1; i<=14; i++){
//            JButton botao = new JButton(""+i);
//            botao.addActionListener(cliqueAssentoSelecionado);
//            botao.setBorder(BorderFactory.createEmptyBorder(6,20,6,20));
//
//            //Verificação dos assentos, se está livre ou não
//            if (ocupados[i]==i){
//                botao.setBackground(Color.RED);
//                botao.setEnabled(false);
//                listaBotoes.add(botao);
//                setAssento(i,"ocupado");
//            }else{
//                botao.setBackground(Color.green);
//                listaBotoes.add(botao);
//                setAssento(i,"livre");
//            }
//            painelEsquerda.add(botao);
//        }
//
//        painel.add(painelEsquerda, BorderLayout.EAST);
//
//        //Adiciona um espaço entre as fileiras
//        painel.add(new Box.Filler(new Dimension(40,5),new Dimension(40,5),new Dimension(40,5)));
//
//        JPanel painelDireita = new JPanel();
//        painelDireita.setBackground(new Color(94, 232, 230));
//
//        GridLayout gl2 = new GridLayout(7,2);
//        gl2.setVgap(3);
//        gl2.setHgap(3);
//        painelDireita.setLayout(gl2);
//
//        for(int i = 15; i<=28; i++){
//            JButton botao = new JButton(""+i);
//            botao.addActionListener(cliqueAssentoSelecionado);
//            botao.setBorder(BorderFactory.createEmptyBorder(6,20,6,20));
//
//            //Verificação dos assentos, se está livre ou não
//            if (ocupados[i]==i){
//                botao.setBackground(Color.RED);
//                botao.setEnabled(false);
//                listaBotoes.add(botao);
//                setAssento(i,"ocupado");
//            }else{
//                botao.setBackground(Color.green);
//                listaBotoes.add(botao);
//                setAssento(i,"livre");
//            }
//            painelDireita.add(botao);
//        }


        for(int i = 1; i<29; i++){
            JButton botao = new JButton(""+i);
            botao.addActionListener(cliqueAssentoSelecionado);
            botao.setBorder(BorderFactory.createEmptyBorder(6,20,6,20));

            //Verificação dos assentos, se está livre ou não

            System.out.println("OCUPADOS[i] "+ocupados[i]);

            if (ocupados[i]==i){
                botao.setBackground(Color.RED);
                botao.setEnabled(false);
                listaBotoes.add(botao);
                System.out.println("BOTAO DESABILITADO"+i);
                setAssento(i,"ocupado");
            }else{
                botao.setBackground(Color.green);
                listaBotoes.add(botao);
                setAssento(i,"livre");
            }
            painelEsquerda.add(botao);
        }

        painel.add(painelEsquerda);

//        painel.add(painelDireita, BorderLayout.WEST);

        salvar.setBorder(BorderFactory.createEmptyBorder(10,45,10,45));
        salvar.setBackground(new Color(238, 247, 246));
        salvar.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        painel.add(salvar, BorderLayout.SOUTH);

//        for (int i=0; i<listaBotoes.toArray().length; i++){
//            System.out.println("LISTA DE BOTOES:"+(listaBotoes.get(i)));
//        }


        return painel;
    }

    public JButton getSalvarAssento(){
        return salvar;
    }

    private ActionListener cliqueAssentoSelecionado = (e) ->{
        if(assentoSelecionado != null){ //se tem um assento já marcado, ele volta para livre
            setAssento(assentoSelecionado,"livre");
        }
        assentoSelecionado = listaBotoes.indexOf(e.getSource());
        System.out.println("O ASSENTO SELECIONADO É: "+assentoSelecionado+"  ");
        setAssento(assentoSelecionado, "selecionado");
    };

    public void setAssento(int assento, String situacao){
        JButton b = listaBotoes.get(assento);
        if(situacao.equals("selecionado")){
            b.setBackground(Color.CYAN);
        }else if(situacao.equals("livre")){
            b.setBackground(Color.green);
        }else if(situacao.equals("ocupado")){
            b.setEnabled(false);
        }
    }

    public Integer getAssentoSelecionado() {
        return assentoSelecionado;
    }

    public void setAssentoSelecionado(Integer assentoSelecionado) {
        this.assentoSelecionado = assentoSelecionado;
    }

    public ConexaoAssento getConexaoAssentos() {
        return conexaoAssentos;
    }

    public void setConexaoAssentos(ConexaoAssento conexaoAssentos) {
        this.conexaoAssentos = conexaoAssentos;
    }

    public ArrayList<JButton> getListaBotoes() {
        return listaBotoes;
    }

    public void setListaBotoes(ArrayList<JButton> listaBotoes) {
        this.listaBotoes = listaBotoes;
    }
}
