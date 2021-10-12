package gui;

import dados.ConexaoCodigos;
import dados.ConexaoInfos;
import entidades.Bilhete;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class InterfacePrincipal extends  JFrame{
    private JPanel cardPanel = new JPanel();
    private CardLayout cardLayout = new CardLayout();
    private Home telaInicial;
    private SolicitaCod telaSolicitaCod;
    private Infos telaInfos;
    private EditaInfos telaEditaInfos;
    private Assento telaAssento;
    private JButton btcheck;
    private Bilhete bilheteInfosBanco = new Bilhete();

    private Connection conexaoBanco;

    public InterfacePrincipal(Connection conexao) throws SQLException {
        conexaoBanco = conexao; //Recebe os dados do BD

        cardPanel.setLayout(cardLayout);
        setContentPane(cardPanel);

        telaInicial = new Home();
        add(getTelaInicial(), "inicial"); //Adicionona a tela e o nome

        telaSolicitaCod = new SolicitaCod();
        add(getSolicitaCod(), "solicitacao"); //adiciona a tela e o nome


        telaInfos = new Infos();
//        add(getTelaInfos(), "infos"); //talvez de merda aqui, nao sei

        telaEditaInfos = new EditaInfos();
        add(getTelaEditaInfos(), "edita infos");

        telaAssento = new Assento();
        add(getTelaAssento(), "assento");


        /*
        *
        * FALTA:
   -Exibir as informações do bilhete e do passageiro
   -Editar as informações do passageiro
        * */

        botaoInicial(); //ActionListener
        botaoSolicitaCod(); //ActionListener
        botoesInfo(); //ActionListener
        botoesEditaInfo(); //ActionListener

        exibe("inicial"); //quando inicializa pela primeira vez esse que vai aparecer
        setTitle("Checking");

        setSize(350,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Programa para derodar ao clicar no X
        setLocationRelativeTo(null); //Tela centralizada
        setVisible(true);
    }

    private void botoesEditaInfo(){
        telaEditaInfos.getBtSalvar().addActionListener((al) -> {
            exibe("infos");
            setTitle("Informações");
        });
        telaEditaInfos.getBtVoltar().addActionListener((al) -> {
            exibe("infos");
            setTitle("Informações");
        });
    }

    private void botoesInfo(){
        telaInfos.getBtAtt().addActionListener((al) -> {
            exibe("edita infos");
            setTitle("Edição de dados");
        });
        telaInfos.getBtProx().addActionListener((al) -> {
            exibe("assento"); //AINDA NAO FIZ
            setTitle("Assentos");
        });
    }

    private void botaoSolicitaCod(){ //método do botão para quando o usuário enviar o código
        telaSolicitaCod.getbtSolicita().addActionListener((al) -> { //só um teste para ver se vai retornar para inicial
            try {
                if (new ConexaoCodigos(conexaoBanco).codLocalizado(telaSolicitaCod.txtSolicita.getText())){
//                    telaInfos = new Infos();
                    bilheteInfosBanco = new ConexaoInfos(conexaoBanco).getInfosBanco(telaSolicitaCod.txtSolicita.getText());
                    add(getTelaInfos(), "infos"); //talvez de merda aqui, nao sei
                    exibe("infos"); //tem que colocar aqui a chamada do conexaoinfos
                    setTitle("Informações");
                }else{
                    System.out.println("NÃO LOCALIZADO");
                    JOptionPane.showMessageDialog(null,
                            "Bilhete não localizado\nFavor tentar novamente!",
                            "ERRO",JOptionPane.ERROR_MESSAGE);
                    exibe("inicial");
                    setTitle("Checking");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private void botaoInicial(){
        telaInicial.getBotaoHome().addActionListener((al) -> { //Se apertar esse botão, muda pra tela de solicitação
            setTitle("Solicitação do código");
            exibe("solicitacao");
        });
    }

    private void exibe(String nome){
        this.cardLayout.show(this.cardPanel, nome);
    }

    private JPanel getTelaInicial() {
        telaInicial = new Home(); //instancio para conseguir acessar o método hometeste(), se eu fizesse no construtor
        //nao conseguiria retornar pq o retorno seria o nome da classe, nao um jpanel que é o que quero
        return telaInicial.criaJPanelHome();
    }

    private JPanel getSolicitaCod(){
        telaSolicitaCod = new SolicitaCod();
        return telaSolicitaCod.criaJPanelSolicita();
    }

    private JPanel getTelaInfos() throws SQLException {
//        telaInfos = new Infos();
//        ConexaoInfos ci = new ConexaoInfos(conexaoBanco);
        /**
         * COLOCAR ESSE BILHETE NO BOTAOSOLICITACOD

        Bilhete bilheteInfosBanco = new ConexaoInfos(conexaoBanco).getInfosBanco(telaSolicitaCod.txtSolicita.getText());
//                ci.getInfosBanco(telaSolicitaCod.txtSolicita.getText()); //acho que posso criar aqui direto e tirar de lá de cima
        //pega o código da telaSolicita, manda para o metodo do conexaoInfo e ele retorna um array com informações para o telaInfos
        */
        return telaInfos.criaJPanelInfos(bilheteInfosBanco);
    }

    private JPanel getTelaEditaInfos(){
        telaEditaInfos = new EditaInfos();
        return telaEditaInfos.criaJPanelEditaInfos();
    }

    private JPanel getTelaAssento(){
        telaAssento = new Assento();
        return telaAssento.criaJPanelAssento();
    }

//    public static void main(String[] args) throws SQLException {
//        new InterfacePrincipal(DriverManager.getConnection("jdbc:postgresql://134.209.243.185:5432/vavatur",
//                "vavatur", "gGgLqu"));
//    }
}
