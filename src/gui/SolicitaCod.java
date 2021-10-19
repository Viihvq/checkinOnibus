package gui;

import javax.swing.*;
import java.awt.*;

public class SolicitaCod {
    //    JFrame frame = new JFrame();
    JPanel cod = new JPanel();
    JTextField txtSolicita = new JTextField();
    JButton btSolicita;

    public SolicitaCod() { }

    public JPanel criaJPanelSolicita() {

        cod.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cod.setLayout(null);

        JLabel lblSolicita = new JLabel("Insira o código do bilhete");
        lblSolicita.setFont(new Font("Lucida Grande", Font.PLAIN, 14)); /*Bernardo*/
        lblSolicita.setBounds(95, 60, 300, 39);/*Bernardo*/
        cod.add(lblSolicita);

        txtSolicita.setColumns(12); //A caixa para escrever tem tamanho de 12 m
        txtSolicita.setBounds(88, 100, 172, 39);/*Bernardo*/
        cod.add(txtSolicita);

        btSolicita = new JButton("Próximo");
        btSolicita.setBounds(88, 150, 172, 39);/*Bernardo*/
        btSolicita.setFont(new Font("Lucida Grande", Font.PLAIN, 14));/*Bernardo*/
        cod.add(btSolicita);
        cod.setBackground(new Color(184, 249, 244));

        return cod;
    }

    public JButton getbtSolicita() {
        return btSolicita;
    }

}