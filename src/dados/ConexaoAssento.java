package dados;

import entidades.Bilhete;

import java.sql.*;

public class ConexaoAssento {
    /*
    * Brainstorm do Assento:
    *   -Verificar se o assento está nulo ou não
    *       -não nulo: não deixa marcar novamente
    *       -nulo: deixa marcar.
    *   -Criação dos botõe:
    *       -Assento já marcado: fundo vermelho
    *       -Assento livre: fundo verde
    *   -
    * */

    Connection conexao;
    Bilhete bilhete;
//    PreparedStatement comandoAssento;

    public ConexaoAssento(Bilhete bilhete, Connection conexao) throws SQLException {
        this.conexao = conexao;
        this.bilhete = bilhete;
//        this.comandoAssento = conexao.prepareStatement("SELECT \"bilhete\".\"assento\", " +
//                "\"bilhete\".\"codigo\" FROM \"public\".\"bilhete\";");
//        System.out.println("DEBUG CONEXAOASSENTO  --  "+bilhete);
    }

    public Integer[] isOccupied() throws SQLException { //Verifica se o assento do onibus está ocupado ou nao
        PreparedStatement comandoAssento = conexao.prepareStatement("SELECT \"bilhete\".\"assento\", " +
                "\"bilhete\".\"codigo\" FROM \"public\".\"bilhete\";");
        comandoAssento.execute();
        ResultSet rs = comandoAssento.getResultSet();

        Integer[] ocupado = new Integer[28];
        int count =0;

        for (int i=0; i<28;i++){
            ocupado[i] = -1;
        }

        while (rs.next()){
            if(rs.getString(1) != null) {
//                System.out.println(rs.getString(1));
                int valor = rs.getInt(1);
                ocupado[valor] = rs.getInt(1);
                count++;
            }else{
                ocupado[count] = -1;
                count++;
            }
        }


        System.out.println(count);




        return  ocupado;
    }
}
