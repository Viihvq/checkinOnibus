package dados;

import entidades.Bilhete;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ConexaoAssento {

    Connection conexao;
    Bilhete bilhete;
//    PreparedStatement comandoAssento;

    public ConexaoAssento(Bilhete bilhete, Connection conexao) throws SQLException {
        this.conexao = conexao;
        this.bilhete = bilhete;
    }

    public void cadastroAssento(Integer selecionado, String codigo) throws SQLException {
        PreparedStatement attAssento = conexao.prepareStatement("UPDATE \"public\".\"bilhete\" SET " +
                " \"assento\" = ?, \"assento_marcado_em\" = ? WHERE \"codigo\" = ?;");
        attAssento.setInt(1, selecionado);

        Timestamp hrMarcacao = new Timestamp(System.currentTimeMillis());
        bilhete.setAssento_marcado_em(hrMarcacao);
        System.out.println(selecionado + "  "+hrMarcacao); //DEBUG

        attAssento.setTimestamp(2, bilhete.getAssento_marcado_em()); //passei a retornar em Bilhete como time.sql pq o codigo sugeriu isso
        attAssento.setString(3,codigo);

        attAssento.execute();

        System.out.println("teste cadastroassento"+selecionado+codigo);
    }

    public Integer[] isOccupied() throws SQLException { //Verifica se o assento do onibus está ocupado ou nao
        PreparedStatement comandoAssento = conexao.prepareStatement("SELECT \"bilhete\".\"assento\", " +
                "\"bilhete\".\"codigo\" FROM \"public\".\"bilhete\";");
        comandoAssento.execute();
        ResultSet rs = comandoAssento.getResultSet();

        Integer[] ocupado = new Integer[29]; //MUDANÇA AQUI
        int count =0;

        for (int i=0; i<29;i++){ //Pra não dar problema com nulo MUDANÇA AQUI
            ocupado[i] = -1;
        }

        int valor = 0;

        while (rs.next()){
            if(rs.getString(1) != null) {
                if(rs.getInt(1)>0 && rs.getInt(1)<28){
                    valor = rs.getInt(1);
                    System.out.println(rs.getString(2)+" "+rs.getInt(1)+"valor: "+valor);
                    ocupado[valor] = rs.getInt(1);
                    count++;
                };
            }else{
                ocupado[count] = -1;
                count++;
            }
        }

        return  ocupado;
    }
}
