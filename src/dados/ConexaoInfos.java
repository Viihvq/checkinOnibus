package dados;

import entidades.Bilhete;
import entidades.Linha;
import entidades.Passageiro;

import java.sql.*;

public class ConexaoInfos{
    private static Connection conexao;
    Bilhete bilhete = new Bilhete();
    Passageiro passageiro = new Passageiro();
    Linha linha = new Linha();


    public ConexaoInfos(Connection conexao) throws SQLException {
        this.conexao = conexao;
    }

    public void getAttInfosBanco(Integer idPassageiro, String nomePassageiro, String cpfPassageiro) throws SQLException {

        PreparedStatement attInfo = conexao.prepareStatement("UPDATE \"public\".\"passageiro\" SET " +
                " \"cpf\" = ?, \"nome\" = ? WHERE \"id\" = ?;");

        attInfo.setString(1,cpfPassageiro);
        attInfo.setString(2,nomePassageiro);
        attInfo.setLong(3,idPassageiro);

        System.out.println("BEGUD DO GETATTINFOSBANCO");

        attInfo.execute();

    } //essa classe só precisa att as informações, então creio que nao precise de retorno


    public Bilhete getInfosBanco(String codigo) throws SQLException {

        PreparedStatement comandoListarInfos = conexao.prepareStatement("SELECT \"bilhete\".codigo, \"bilhete\".assento ,\"passageiro\".id,\"passageiro\".nome, \"passageiro\".cpf, \"linha\".origem, " +
                "\"linha\".destino, \"linha\".hora_embarque, \"linha\".hora_partida FROM \"public\".\"linha\" JOIN \"public\".\"bilhete\" ON \"linha\".id = \"bilhete\".id_linha " +
                "JOIN \"public\".\"passageiro\" ON \"bilhete\".id_passageiro = \"passageiro\".id AND \"bilhete\".codigo = ?;");
        //cod, assento, nome, cpf, origem, destino, embarque, partida
        comandoListarInfos.setString(1, codigo);
        comandoListarInfos.execute();
        ResultSet rs = comandoListarInfos.getResultSet();


        while (rs.next()){
            System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));
            bilhete.setCodigo(rs.getString(1));
            bilhete.setAssento(rs.getString(2)); //se der merda o problema ta aqui
            passageiro.setId(rs.getInt(3));
            passageiro.setNome(rs.getString(4));
            passageiro.setCpf(rs.getString(5));
            linha.setOrigem(rs.getString(6));
            linha.setDestino(rs.getString(7));
            linha.setHora_embarque(rs.getTime(8));
            linha.setHora_partida(rs.getTime(9));
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
