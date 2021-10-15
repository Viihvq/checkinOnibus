package dados;

import entidades.Bilhete;

import java.sql.*;

public class ConexaoAssento {
    /*
    * Brainstorm do Assento:
    *  FEITO
    *   -Verificar se o assento está nulo ou não
    *       -não nulo: não deixa marcar novamente
    *       -nulo: deixa marcar.
    *   -Criação dos botões:
    *       -Assento já marcado: fundo vermelho
    *       -Assento livre: fundo verde
    *
    *  AINDA PRA FAZER:
    *   -Marcar um assento e pintar de verde;
    *   -Marcar outra opção e desmarcar a marcada anteriormente
    * */

    Connection conexao;
    Bilhete bilhete;
//    PreparedStatement comandoAssento;

    public ConexaoAssento(Bilhete bilhete, Connection conexao) throws SQLException {
        this.conexao = conexao;
        this.bilhete = bilhete;
    }

    public Integer[] isOccupied() throws SQLException { //Verifica se o assento do onibus está ocupado ou nao
        PreparedStatement comandoAssento = conexao.prepareStatement("SELECT \"bilhete\".\"assento\", " +
                "\"bilhete\".\"codigo\" FROM \"public\".\"bilhete\";");
        comandoAssento.execute();
        ResultSet rs = comandoAssento.getResultSet();

        Integer[] ocupado = new Integer[28];
        int count =0;

        for (int i=0; i<28;i++){ //sagacidade pra não dar problema com nulo
            ocupado[i] = -1;
        }

        while (rs.next()){
            if(rs.getString(1) != null) {
                int valor = rs.getInt(1);
                ocupado[valor] = rs.getInt(1);
                count++;
            }else{
                ocupado[count] = -1;
                count++;
            }
        }

        return  ocupado;
    }
}
