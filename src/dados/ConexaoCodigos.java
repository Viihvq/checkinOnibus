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
                System.out.println("Código encontrado");
                return true;
            }
        }

        return false;
    }

}
