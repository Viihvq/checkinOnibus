package dados;

import entidades.Bilhete;
import entidades.Linha;
import entidades.Passageiro;

import java.sql.*;

public class ConexaoInfos{
    private static Connection conexao;
//    static final String LISTAR_INFOS = "SELECT  \"passageiro\".nome, \"passageiro\".cpf, \"linha\".origem, " +
//            "\"linha\".destino FROM \"public\".\"linha\" JOIN \"public\".\"bilhete\" ON \"linha\".id = \"bilhete\".id_linha " +
//            "JOIN \"public\".\"passageiro\" ON \"bilhete\".id_passageiro = \"passageiro\".id;";
    //nome, cpf, origem e destino
    //Rever isso depois ^^. De onde vou tirar a informação de hr pra embarque e desembarque?

    public ConexaoInfos(Connection conexao){
        this.conexao = conexao;
    }

    public Bilhete getInfosBanco(String codigo) throws SQLException {
//        ArrayList informacoesBanco = new ArrayList(); //NAO PRECISO MAIS DISSO PQ VOU RETORNAR BILHETE

        PreparedStatement comandoListarInfos = conexao.prepareStatement("SELECT \"bilhete\".codigo, \"passageiro\".nome, \"passageiro\".cpf, \"linha\".origem, " +
                "\"linha\".destino, \"linha\".hora_embarque, \"linha\".hora_partida FROM \"public\".\"linha\" JOIN \"public\".\"bilhete\" ON \"linha\".id = \"bilhete\".id_linha " +
                "JOIN \"public\".\"passageiro\" ON \"bilhete\".id_passageiro = \"passageiro\".id AND \"bilhete\".codigo = ?;");
        //cod, nome, cpf, origem, destino, embarque, partida
        comandoListarInfos.setString(1, codigo);
        comandoListarInfos.execute();
        ResultSet rs = comandoListarInfos.getResultSet();

        Bilhete bilhete = new Bilhete();
        Passageiro passageiro = new Passageiro();
        Linha linha = new Linha();

        while (rs.next()){
            System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));
            bilhete.setCodigo(rs.getString(1));
            passageiro.setNome(rs.getString(2));
            passageiro.setCpf(rs.getString(3));
            linha.setOrigem(rs.getString(4));
            linha.setDestino(rs.getString(5));
            linha.setHora_embarque(rs.getTime(6));
            linha.setHora_partida(rs.getTime(7));
            bilhete.setPassageiro(passageiro);
            bilhete.setLinha(linha);
        }

        System.out.println(codigo+"        --      "+bilhete);

        return bilhete;
    }

//    public static void main(String[] args) throws SQLException {
//        new ConexaoInfos(DriverManager.getConnection("jdbc:postgresql://134.209.243.185:5432/vavatur",
//                "vavatur", "gGgLqu")).getInfosBanco("BEBBIX");
//    }
}
