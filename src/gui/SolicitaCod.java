package gui;

import javax.swing.*;
import java.awt.*;

public class SolicitaCod {
    JPanel cod = new JPanel();
    JTextField txtSolicita = new JTextField();
    JButton btSolicita;

    public SolicitaCod() { }

    public JPanel criaJPanelSolicita() {

        cod.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cod.setLayout(null);

        JLabel lblSolicita = new JLabel("Insira o código do bilhete");
        lblSolicita.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        lblSolicita.setBounds(95, 60, 300, 39);
        cod.add(lblSolicita);

        txtSolicita.setColumns(12); //A caixa para escrever tem tamanho de 12 m
        txtSolicita.setBounds(88, 100, 172, 39);
        cod.add(txtSolicita);

        btSolicita = new JButton("Próximo");
        btSolicita.setBounds(88, 150, 172, 39);
        btSolicita.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        btSolicita.setBackground(new Color(238, 247, 246));
        cod.add(btSolicita);
        cod.setBackground(new Color(184, 249, 244));

        return cod;
    }

    public JButton getbtSolicita() {
        return btSolicita;
    }

}