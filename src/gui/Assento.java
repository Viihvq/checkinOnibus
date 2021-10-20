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
        frase.setBackground(new Color(94, 232, 230));
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

        for (int i =0; i<14;i++){ //Por questões de gabiarra começa do 0, resolvo isso depois
            JButton botao = new JButton(""+i);
            botao.addActionListener(cliqueAssentoSelecionado);
            botao.setBorder(BorderFactory.createEmptyBorder(6,20,6,20));

            /**Verificação dos assentos, se está livre ou não*/
            if (ocupados[i]==i){
                botao.setBackground(Color.RED); //Aparentemente isso não funciona junto com o setEnabled
                botao.setEnabled(false); //
                listaBotoes.add(botao);
                setAssento(i,"ocupado");
            }else{
                botao.setBackground(Color.green); //
                listaBotoes.add(botao);
                setAssento(i,"livre");
                }
            painelEsquerda.add(botao);
        }

        painel.add(painelEsquerda, BorderLayout.EAST);

        //Adiciona um espaço entre as fileiras
        painel.add(new Box.Filler(new Dimension(40,5),new Dimension(40,5),new Dimension(40,5)));

        JPanel painelDireita = new JPanel();
        painelDireita.setBackground(new Color(184, 249, 244));
        GridLayout gl2 = new GridLayout(7,2);
        gl2.setVgap(3);
        gl2.setHgap(3);
        painelDireita.setLayout(gl2);

        for (int i =14; i<28;i++){
            JButton botao = new JButton(""+i);
            botao.addActionListener(cliqueAssentoSelecionado);
            botao.setBorder(BorderFactory.createEmptyBorder(6,20,6,20));

            /**Verificação dos assentos, se está livre ou não*/
            if (ocupados[i]==i){
                botao.setBackground(Color.RED); //Aparentemente isso não funciona junto com o setEnabled
                botao.setEnabled(false);
                /*Essas duas linhas de cima ficam redundantem com o setAssento, mas se eu não
                  deixá-las dá prolema nos assentos quando clico em salvar e faço o processo todo de novo
                 */
                listaBotoes.add(botao);
                setAssento(i,"ocupado");
            }else{
                botao.setBackground(Color.green); //
                listaBotoes.add(botao);
                setAssento(i,"livre");
            }
            painelDireita.add(botao);
        }

        painel.add(painelDireita, BorderLayout.WEST);

        salvar.setBorder(BorderFactory.createEmptyBorder(10,45,10,45));
        salvar.setBackground(new Color(238, 247, 246));
        salvar.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        painel.add(salvar, BorderLayout.SOUTH);





        return painel;
    }

    public JButton getSalvarAssento(){
//        salvar.addActionListener((al)->{
//            if(assentoSelecionado != null){
//                try {
//                    conexaoAssentos.cadastroAssento(assentoSelecionado, bilhete.getCodigo());
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        return salvar;
    }

    private ActionListener cliqueAssentoSelecionado = (e) ->{
        if(assentoSelecionado != null){ //se tem um assento já marcado, ele volta pra livre
            setAssento(assentoSelecionado,"livre");
        }
        assentoSelecionado = listaBotoes.indexOf(e.getSource());
        setAssento(assentoSelecionado, "selecionado");
    };

    public void setAssento(int assento, String situacao){ //aqui da problema se não tiver a redundancia
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
    //        painel.add(Box.createRigidArea(new Dimension(50,0)));
//        painel.add(Box.createHorizontalGlue());

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
