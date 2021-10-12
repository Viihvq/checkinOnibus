package dados;

import java.sql.*;

public class ConexaoCodigos {
    private static Connection conexao;
    static final String LISTAR_CODIGOS = "SELECT * FROM \"public\".\"bilhete\";";

    public ConexaoCodigos(Connection conexao){ //Recebe da Main
        this.conexao = conexao;
    }


    public boolean codLocalizado(String cod) throws SQLException {
        PreparedStatement comandoListarCodigos = conexao.prepareStatement(LISTAR_CODIGOS);
        comandoListarCodigos.execute();
        ResultSet comandoResultadoCodigos = comandoListarCodigos.getResultSet();

        while (comandoResultadoCodigos.next()){

            if(comandoResultadoCodigos.getString(1).equals(cod)){
                System.out.println("alo achou");
                return true;
            }
        }

        return false;
    }

//    public static void main(String[] args) throws SQLException {
//        new ConexaoCodigos(DriverManager.getConnection("jdbc:postgresql://134.209.243.185:5432/vavatur",
//                "vavatur", "gGgLqu")).codLocalizado("BEBBIX");
//    }
}
