package gui;

import dados.ConexaoCodigos;
import dados.ConexaoInfos;
import entidades.Bilhete;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class InterfacePrincipal extends  JFrame{
    private Connection conexaoBanco;

    private JPanel cardPanel = new JPanel();
    private CardLayout cardLayout = new CardLayout();
    private Home telaInicial;
    private SolicitaCod telaSolicitaCod;
    private Infos telaInfos;
    private EditaInfos telaEditaInfos;
    private Assento telaAssento;
    private JButton btcheck;
    private Bilhete bilheteInfosBanco = new Bilhete();
    private ConexaoInfos conexaoInfos;

    public InterfacePrincipal(Connection conexao) throws SQLException {
        conexaoBanco = conexao; //Recebe os dados do BD

        cardPanel.setLayout(cardLayout);
        setContentPane(cardPanel);

        telaInicial = new Home();
        add(getTelaInicial(), "inicial"); //Adiciona a tela e o nome

        telaSolicitaCod = new SolicitaCod();
        add(getSolicitaCod(), "solicitacao"); //Adiciona a tela e o nome


        telaInfos = new Infos();
//        add(getTelaInfos(), "infos"); //talvez de m aqui, nao sei TEM QUE DEIXAR FORA MSM

        telaEditaInfos = new EditaInfos();
//        add(getTelaEditaInfos(), "edita infos"); TEM QUE DEIXAR FORA MESMO POR CAUSA QUE EU ADICIONO NOS METODOS ABAIXO

        telaAssento = new Assento();
//        add(getTelaAssento(), "assento");


        botaoInicial(); //ActionListener
        botaoSolicitaCod(); //ActionListener
        botoesInfo(); //ActionListener
        botoesEditaInfo(); //ActionListener

        exibe("inicial"); //quando inicializa pela primeira vez esse que vai aparecer
        setTitle("Checking");

        setSize(350,350);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Programa para derodar ao clicar no X
        setLocationRelativeTo(null); //Tela centralizada
        setVisible(true);
    }

    private void botoesEditaInfo(){
        telaEditaInfos.getBtSalvar().addActionListener((al) -> {
            try {
                conexaoInfos.getAttInfosBanco(bilheteInfosBanco.getPassageiro().getId(), //Id, nome e CPF para atualizar
                                              telaEditaInfos.editaNome.getText(),
                                              telaEditaInfos.editaCpf.getText());
                bilheteInfosBanco = conexaoInfos.getInfosBanco(bilheteInfosBanco.getCodigo());
                this.cardLayout.removeLayoutComponent(getTelaInfos()); //Se não remover, não retorna com as informações nova
                add(getTelaInfos(), "infos"); //Adiciona de novo para aparecer as informações atualizadas
                System.out.println("Debug AL salvar");
                exibe("infos");
                setTitle("Informações");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        telaEditaInfos.getBtVoltar().addActionListener((al) -> {
            exibe("infos");
            setTitle("Informações");
        });
    }

    private void botoesInfo(){ //Botoes Atualizar infos e próximo da tela Informações
        telaInfos.getBtAtt().addActionListener((al) -> {

            try { //pediu trycatch dps de colocar o .conexao no getattinfos
                add(getTelaEditaInfos(), "edita infos"); /**/
            } catch (SQLException e) {
                e.printStackTrace();
            }

            exibe("edita infos");/**/
            setTitle("Edição de dados");
        });

        telaInfos.getBtProx().addActionListener((al) -> {
            try {
//   n precisa disso, ja tem as infos no global vvvv
//   bilheteInfosBanco = conexaoInfos.getInfosBanco(telaSolicitaCod.txtSolicita.getText()); //pega as informações do bilhete do banco para a tela de assento
                add(getTelaAssento(), "assento");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            exibe("assento"); //AINDA NAO FIZ
            setTitle("Assentos");
        });
    }

    private void botaoSolicitaCod(){ //método do botão para quando o usuário enviar o código
        telaSolicitaCod.getbtSolicita().addActionListener((al) -> {
            try {
                if (new ConexaoCodigos(conexaoBanco).codLocalizado(telaSolicitaCod.txtSolicita.getText())){

                    conexaoInfos = new ConexaoInfos(conexaoBanco);

//                    bilheteInfosBanco = new ConexaoInfos(conexaoBanco).getInfosBanco(telaSolicitaCod.txtSolicita.getText());
                    bilheteInfosBanco = conexaoInfos.getInfosBanco(telaSolicitaCod.txtSolicita.getText()); //pega as informações do bilhete do banco para a tela de infos
                    add(getTelaInfos(), "infos");
                    exibe("infos");
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

    private JPanel getTelaInfos() /*throws SQLException*/ {
//        telaInfos = new Infos();
//        ConexaoInfos ci = new ConexaoInfos(conexaoBanco);
//        COLOCAR ESSE BILHETE NO BOTAOSOLICITACOD
//        Bilhete bilheteInfosBanco = new ConexaoInfos(conexaoBanco).getInfosBanco(telaSolicitaCod.txtSolicita.getText());
//                ci.getInfosBanco(telaSolicitaCod.txtSolicita.getText()); //acho que posso criar aqui direto e tirar de lá de cima
        //pega o código da telaSolicita, manda para o metodo do conexaoInfo e ele retorna um array com informações para o telaInfos

        return telaInfos.criaJPanelInfos(bilheteInfosBanco); //O bilheteInfosBanco foi preenchido no metodo botaoSolicitaCodigo
    }

    private JPanel getTelaEditaInfos() throws SQLException {
//        telaEditaInfos = new EditaInfos(); //Se eu fizer isso não funciona a volta dos botoes att e voltar
        return telaEditaInfos.criaJPanelEditaInfos(bilheteInfosBanco, conexaoInfos); //Tenho que passar o bilhete com as infos e a classe que tem os metodos de procura
    }

    private JPanel getTelaAssento() throws SQLException {
//        telaAssento = new Assento();
        return telaAssento.criaJPanelAssento(bilheteInfosBanco, conexaoBanco);
    }

//    public static void main(String[] args) throws SQLException {
//        new InterfacePrincipal(DriverManager.getConnection("jdbc:postgresql://134.209.243.185:5432/vavatur",
//                "vavatur", "gGgLqu"));
//    }
}
