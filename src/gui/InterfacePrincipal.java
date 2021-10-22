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
    private Bilhete bilheteInfosBanco = new Bilhete();
    private ConexaoInfos conexaoInfos;

    public InterfacePrincipal(Connection conexao) throws Exception {
        conexaoBanco = conexao; //Recebe os dados do BD

        cardPanel.setLayout(cardLayout);
        setContentPane(cardPanel);

        telaInicial = new Home();
        add(getTelaInicial(), "inicial"); //Adiciona a tela e o nome

        telaSolicitaCod = new SolicitaCod();
        add(getSolicitaCod(), "solicitacao"); //Adiciona a tela e o nome

        telaInfos = new Infos();
//        add(getTelaInfos(), "infos");

        telaEditaInfos = new EditaInfos();
//        add(getTelaEditaInfos(), "edita infos");

        telaAssento = new Assento();
//        add(getTelaAssento(), "assento");

        botaoInicial(); //ActionListener
        botaoSolicitaCod(); //ActionListener
        botoesInfo(); //ActionListener
        botoesEditaInfo(); //ActionListener
        botaoSalvarAssento();

        exibe("inicial"); //quando inicializa pela primeira vez esse que vai aparecer
        setTitle("Checking");

        setSize(350,350);
        setResizable(false); //Impede a mudança do tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Programa para de rodar ao clicar no X
        setLocationRelativeTo(null); //Tela centralizada
        setVisible(true);
    }

    private void botaoSalvarAssento(){

        telaAssento.getSalvarAssento().addActionListener((al)->{
            try {

                if (bilheteInfosBanco.getAssento() != null){
                    JOptionPane.showMessageDialog(null,"VOCE JA ESCOLHEU. \nSEU ASSENTO É O "+bilheteInfosBanco.getAssento());
                    exibe("inicial");
                }else if(telaAssento.getAssentoSelecionado() != null && bilheteInfosBanco.getAssento() == null){
                    telaAssento.getConexaoAssentos().cadastroAssento(telaAssento.getAssentoSelecionado(), bilheteInfosBanco.getCodigo());

                    JOptionPane.showMessageDialog(null,"CHECK IN REALIZADO COM SUCESSO!");
                    exibe("inicial");
                }else{
                    JOptionPane.showMessageDialog(null,"ESCOLHA UMA OPÇÃO");
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"ERRO \nFAVOR TENTAR NOVAMENTE!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            telaAssento.getListaBotoes().clear(); //LIMPA O ARRAY AO FINAL
        });
    }

    private void botoesEditaInfo(){
        telaEditaInfos.getBtSalvar().addActionListener((al) -> {
            try {
                conexaoInfos.getAttInfosBanco(bilheteInfosBanco.getPassageiro().getId(), //Id, nome e CPF para atualizar
                                              telaEditaInfos.editaNome.getText(),
                                              telaEditaInfos.editaCpf.getText());
                bilheteInfosBanco = conexaoInfos.getInfosBanco(bilheteInfosBanco.getCodigo());
                this.cardLayout.removeLayoutComponent(getTelaInfos()); //Se não remover, não retorna com as informações novas
                add(getTelaInfos(), "infos"); //Adiciona de novo para aparecer as informações atualizadas
//                System.out.println("Debug AL salvar");
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

    private void botoesInfo(){ //Botoes Atualizar infos e Próximo da tela Informações
        telaInfos.getBtAtt().addActionListener((al) -> {

            try {
                add(getTelaEditaInfos(), "edita infos");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            exibe("edita infos");
            setTitle("Edição de dados");
        });

        telaInfos.getBtProx().addActionListener((al) -> {
            try {
                add(getTelaAssento(), "assento");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            exibe("assento");
            setTitle("Assentos");
        });
    }

    private void botaoSolicitaCod(){ //método do botão para quando o usuário enviar o código
        telaSolicitaCod.getbtSolicita().addActionListener((al) -> {
            try {
                if (new ConexaoCodigos(conexaoBanco).codLocalizado(telaSolicitaCod.txtSolicita.getText())){
                    conexaoInfos = new ConexaoInfos(conexaoBanco);
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

    private JPanel getTelaInicial() throws Exception {
        return telaInicial.criaJPanelHome();
    }

    private JPanel getSolicitaCod(){
        return telaSolicitaCod.criaJPanelSolicita();
    }

    private JPanel getTelaInfos(){
        return telaInfos.criaJPanelInfos(bilheteInfosBanco); //O bilheteInfosBanco foi preenchido no metodo botaoSolicitaCodigo
    }

    private JPanel getTelaEditaInfos() throws SQLException {
        return telaEditaInfos.criaJPanelEditaInfos(bilheteInfosBanco); //Tenho que passar o bilhete com as infos e a classe que tem os metodos de procura
    }

    private JPanel getTelaAssento() throws SQLException {
        return telaAssento.criaJPanelAssento(bilheteInfosBanco, conexaoBanco);
    }

}
