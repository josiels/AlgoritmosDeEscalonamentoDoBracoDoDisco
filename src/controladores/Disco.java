package controladores;

import java.util.ArrayList;

public class Disco {

    private int tamanho;
    private int posicaoInicial;
    private int posicaoProxima;
    private int contadorPercurso;
    private ArrayList<Integer> listTrajeto;

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getPosicaoInicial() {
        return posicaoInicial;
    }

    public void setPosicaoInicial(int posicaoInicial) {
        this.posicaoInicial = posicaoInicial;
    }

    public int getPosicaoProxima() {
        return posicaoProxima;
    }

    public void setPosicaoProxima(int posicaoProxima) {
        this.posicaoProxima = posicaoProxima;
    }

    public int getContadorPercurso() {
        return contadorPercurso;
    }

    public void setContadorPercurso(int contadorPercurso) {
        this.contadorPercurso = contadorPercurso;
    }

    public ArrayList<Integer> getListTrajeto() {
        return listTrajeto;
    }

    public void setListTrajeto(ArrayList<Integer> listTrajeto) {
        this.listTrajeto = listTrajeto;
    }

    
    
}
