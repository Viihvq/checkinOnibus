package entidades;

import java.sql.Time;
import java.time.LocalDate;

public class Linha {
    private Integer id;
    private String origem;
    private String destino;
    private Time hora_embarque;
    private Time hora_partida;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Time getHora_embarque() {
        return hora_embarque;
    }

    public void setHora_embarque(Time hora_embarque) {
        this.hora_embarque = hora_embarque;
    }

    public Time getHora_partida() {
        return hora_partida;
    }

    public void setHora_partida(Time hora_partida) {
        this.hora_partida = hora_partida;
    }

    @Override
    public String toString() {
        return "Linha{" +
                "id=" + id +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", hora_embarque=" + hora_embarque +
                ", hora_partida=" + hora_partida +
                '}';
    }
}
