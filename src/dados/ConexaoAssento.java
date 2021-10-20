package dados;

import entidades.Bilhete;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    *   -Marcar um assento e pintar de verde;
    *   -Marcar outra opção e desmarcar a marcada anteriormente
    *
    *   -Pegar o botão selecionado e jogar isso para o banco quando o
    *    usuario clicar em 'salvar'.
    *
    *   BUGS:
    *     -Tem um bug muito esquisito acontecendo: se eu tentar cadastrar um assento pela primeira vez rodando
    * e depois tentar recadastrar, avisa bonitinho que já foi feito. Funciona 10! Porém, se
    * eu quiser cadastrar um segundo assento, vai maneiro. Porém se eu entrar de novo nesse segundo (com o programa
    * ainda rodando) ele dá erro aqui nessa classe. É como se o int valor recebesse/somasse/multiplicasse algum valor e aí da erro.
    *
    * */

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
        System.out.println(hrMarcacao); //DEBUG

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

        Integer[] ocupado = new Integer[28];
        int count =0;

        for (int i=0; i<28;i++){ //Pra não dar problema com nulo
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
