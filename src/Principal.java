import gui.InterfacePrincipal;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Principal {

    public static Connection conexaoBanco() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://134.209.243.185:5432/vavatur",
                "vavatur", "gGgLqu");
    }

    public static void main(String[] args) throws Exception {
        Connection conexao = conexaoBanco();
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        //USA O CODIGO BEBBIX PARA TESTAR

        new InterfacePrincipal(conexao);//Passa os dados do banco pra classe
    }
}
