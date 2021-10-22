package gui;

import entidades.Bilhete;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Infos {
    JButton btAtt = new JButton("Atualizar Dados");
    JButton btProx = new JButton("Próximo");
    Bilhete bilhete;

    public Infos(){}
    public JPanel criaJPanelInfos(Bilhete bilhete){
        this.bilhete = bilhete;

        JPanel informacoes = new JPanel();
        informacoes.setBackground(new Color(184, 249, 244));

        JPanel panelInfo = new JPanel();

        JLabel titulo = new JLabel(" DADOS ATUAIS DO BILHETE ");
        titulo.setFont(new Font("Lucida Grande", Font.BOLD, 12));
        titulo.setBorder(BorderFactory.createEmptyBorder(7,10,3,10));
        panelInfo.add(titulo);

        GridLayout l = new GridLayout(10,2);
        l.setHgap(5);
        l.setVgap(5);
        informacoes.setLayout(l);

        JLabel lblNome = new JLabel("         Nome:");
        informacoes.add(lblNome, Component.CENTER_ALIGNMENT);

        JLabel lblNomeBanco = new JLabel(" "+bilhete.getPassageiro().getNome());
        informacoes.add(lblNomeBanco);

        JLabel lblCpf = new JLabel("         CPF:");
        informacoes.add(lblCpf);

        JLabel lblCpfBanco = new JLabel(" "+bilhete.getPassageiro().getCpf());
        informacoes.add(lblCpfBanco);

        JLabel lblOrigem = new JLabel("         Origem:");
        informacoes.add(lblOrigem);

        JLabel lblOrigemBanco = new JLabel(bilhete.getLinha().getOrigem());
        informacoes.add(lblOrigemBanco);

        JLabel lblDestino = new JLabel("         Destino:");
        informacoes.add(lblDestino);

        JLabel lblDestinoBanco = new JLabel(" "+bilhete.getLinha().getDestino());
        informacoes.add(lblDestinoBanco);

        JLabel lblEmbarque = new JLabel("         Embarque:");
        informacoes.add(lblEmbarque);

        JLabel lblEmbarqueBanco = new JLabel(" "+String.valueOf(bilhete.getLinha().getHora_embarque()));
        informacoes.add(lblEmbarqueBanco);

        JLabel lblPartida = new JLabel("         Partida:");
        informacoes.add(lblPartida);

        JLabel lblPartidaBanco = new JLabel(" "+String.valueOf(bilhete.getLinha().getHora_partida()));
        informacoes.add(lblPartidaBanco);

        JLabel lblHrAtual = new JLabel("         Hora atual:");
        informacoes.add(lblHrAtual);

        DateFormat HrPC = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();

        JLabel lblHrAtualPC = new JLabel(" "+HrPC.format(date));
        informacoes.add(lblHrAtualPC);

        btAtt.setBorder(BorderFactory.createEmptyBorder(6,15,5,15));
        btAtt.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        btAtt.setBackground(new Color(238, 247, 246));
        informacoes.add(btAtt);

        btProx.setBorder(BorderFactory.createEmptyBorder(6,15,5,15));
        btProx.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        btProx.setBackground(new Color(238, 247, 246));
        informacoes.add(btProx);

        panelInfo.add(informacoes, BorderLayout.NORTH);
        panelInfo.setBackground(new Color(184, 249, 244));

        return panelInfo;
    }

    public JButton getBtAtt(){
        return btAtt;
    }

    public JButton getBtProx(){
        return btProx;
    }

}
