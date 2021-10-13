package dados;

import entidades.Bilhete;
import entidades.Passageiro;

import java.sql.Connection;

public class ConexaoEditaPassageiro {
    private static Connection conexao;

    public ConexaoEditaPassageiro(Connection conexao){
        this.conexao = conexao;
    }



//    public Passageiro getInfoPassageiro(Bilhete bilhete){
//
//        return passageiro;
//    }
}
