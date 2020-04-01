package model;

import java.io.Serializable;

public class Pais implements Serializable {

        private int id ;
        private String nome;
        private long populacao;
        private String area;

        public Pais() {
        }
        
    //Aplicando Gets e Sets do model   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "model.Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", populacao=" + populacao +
                ", area=" + area +
                '}';
    }
}