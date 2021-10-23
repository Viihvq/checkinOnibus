package dados;

import entidades.Bilhete;

import java.sql.*;

public class ConexaoAssento {

    Connection conexao;
    Bilhete bilhete;

    public ConexaoAssento(Bilhete bilhete, Connection conexao){
        this.conexao = conexao;
        this.bilhete = bilhete;
    }

    public void cadastroAssento(Integer selecionado, String codigo) throws SQLException {
        PreparedStatement attAssento = conexao.prepareStatement("UPDATE \"public\".\"bilhete\" SET " +
                " \"assento\" = ?, \"assento_marcado_em\" = ? WHERE \"codigo\" = ?;");
        attAssento.setInt(1, selecionado);

        Timestamp hrMarcacao = new Timestamp(System.currentTimeMillis());
        bilhete.setAssento_marcado_em(hrMarcacao);

        attAssento.setTimestamp(2, bilhete.getAssento_marcado_em());
        attAssento.setString(3,codigo);

        attAssento.execute();

        System.out.println("Cadastro assento: "+selecionado+", código: "+codigo+", hora: "+hrMarcacao); //Debug
    }

    public Integer[] isOccupied() throws SQLException { //Verifica se o assento do onibus está ocupado ou nao
        PreparedStatement comandoAssento = conexao.prepareStatement("SELECT \"bilhete\".\"assento\", " +
                "\"bilhete\".\"codigo\"  FROM \"public\".\"bilhete\" WHERE \"bilhete\".\"id_linha\" = "+bilhete.getLinha().getId()+";");
//        comandoAssento.setInt(1,bilhete.getLinha().getId());
        comandoAssento.execute();
        ResultSet rs = comandoAssento.getResultSet();

        Integer[] ocupado = new Integer[29];
        int count =0;

        for (int i=0; i<29;i++){ //Pra não dar problema com nulo
            ocupado[i] = -1;
        }

        int valor = 0;
//        int valLinha = bilhete.getLinha().getId();
//        System.out.println("VALOR DA LINHA "+valLinha);

        while (rs.next()){
            if(rs.getString(1) != null) {
                if(rs.getInt(1)>0 && rs.getInt(1)<29){
                    valor = rs.getInt(1);
                    System.out.println(rs.getString(2)+" "+rs.getInt(1)+" valor: "+valor); //Debug assentos que estão no banco
                    ocupado[valor] = rs.getInt(1);
                    count++;
                }
            }else{
//                ocupado[count] = -1; // <<<<<<<<<<<<< ERA ISSO AQUI
                count++;
            }
        }

//        for (int i=0; i<29;i++){
//            System.out.println("DENTRO DO CONEXAO ASSENTO"+ocupado[i]);
//        }

        return  ocupado;
    }
}
