package gui;

import entidades.Bilhete;
import javax.swing.*;
import java.awt.*;

public class EditaInfos {
    JButton salvar = new JButton("Salvar");
    JButton voltar = new JButton("Voltar");
    JTextField editaCpf;
    JTextField editaNome;

    public EditaInfos(){}
    public JPanel criaJPanelEditaInfos(Bilhete bilhete){
        JPanel geral = new JPanel();

        JLabel titulo = new JLabel("EDIÇÃO DOS DADOS");
        titulo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        titulo.setBackground(new Color(94, 232, 230));
        titulo.setBorder(BorderFactory.createEmptyBorder(20,10,0,10));
        geral.add(titulo);

        JPanel panelEdicao1 = new JPanel();
        panelEdicao1.setBorder(BorderFactory.createEmptyBorder(35,25,25,50));
        BoxLayout l2 = new BoxLayout(panelEdicao1, BoxLayout.X_AXIS);
        panelEdicao1.setLayout(l2);

        JLabel lblNome = new JLabel("      Nome: ");
        panelEdicao1.add(lblNome);

        String nomePassageiroBanco = bilhete.getPassageiro().getNome();
        editaNome = new JTextField(nomePassageiroBanco); //Aparece o nome no texto
        editaNome.setColumns(20);
        panelEdicao1.add(editaNome);

        JPanel panelEdicao2 = new JPanel();

        panelEdicao2.setBorder(BorderFactory.createEmptyBorder(0,20,20,50));
        BoxLayout l = new BoxLayout(panelEdicao2, BoxLayout.LINE_AXIS);
        panelEdicao2.setLayout(l);

        JLabel lblCpf = new JLabel("         CPF: ");

        panelEdicao2.add(lblCpf);

        String cpfPassageiroBanco = bilhete.getPassageiro().getCpf();
        editaCpf = new JTextField(cpfPassageiroBanco); //Faz aparecer o cpf no texto
        editaCpf.setColumns(20);
        panelEdicao2.add(editaCpf);

        JPanel opcoes = new JPanel();
        opcoes.setBorder(BorderFactory.createEmptyBorder(10,20,78,20));

        salvar.setBorder(BorderFactory.createEmptyBorder(15,40,15,40));
        salvar.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        salvar.setBackground(new Color(238, 247, 246));
        opcoes.add(salvar);

        voltar.setBorder(BorderFactory.createEmptyBorder(15,40,15,40));
        voltar.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        voltar.setBackground(new Color(238, 247, 246));
        opcoes.add(voltar);

        geral.setBackground(new Color(184, 249, 244));
        panelEdicao1.setBackground(new Color(184, 249, 244));
        panelEdicao2.setBackground(new Color(184, 249, 244));
        opcoes.setBackground(new Color(184, 249, 244));
        geral.add(panelEdicao1);
        geral.add(panelEdicao2);
        geral.add(opcoes);

        return geral;
    }

    public JButton getBtSalvar(){
        return salvar;
    }

    public JButton getBtVoltar(){
        return voltar;
    }
}
