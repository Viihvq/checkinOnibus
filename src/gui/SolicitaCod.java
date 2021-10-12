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

        JLabel lblSolicita = new JLabel("Digite o código");
        cod.add(lblSolicita);

        txtSolicita.setColumns(12); //A caixa para escrever tem tamanho de 12 m
        cod.add(txtSolicita);

        btSolicita = new JButton("Próximo");
        cod.add(btSolicita);
        cod.setBackground(Color.red);

        return cod;
    }

    public JButton getbtSolicita() {
        return btSolicita;
    }

}