package entidades;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Bilhete {
    private String codigo;
    private String assento;
    private Passageiro passageiro;
    private Linha linha;
    private Timestamp assento_marcado_em;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Linha getLinha() {
        return linha;
    }

    public void setLinha(Linha id_linha) {
        this.linha = id_linha;
    }

    public Timestamp getAssento_marcado_em() {
        return assento_marcado_em;
    }

    public void setAssento_marcado_em(Timestamp assento_marcado_em) {
        this.assento_marcado_em = assento_marcado_em;
    }

    @Override
    public String toString() {
        return "Bilhete{" +
                "codigo='" + codigo + '\'' +
                ", assento='" + assento + '\'' +
                ", passageiro=" + passageiro +
                ", linha=" + linha +
                ", assento_marcado_em=" + assento_marcado_em +
                '}';
    }
}
