package controladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {

    private final Disco disco = new Disco();
    private final ArrayList<Integer> listTrajeto = new ArrayList();
    //private final File arquivo = new File("C:\\Users\\pmrn\\Documents\\NetBeansProjects\\AlgoritmosDeEscalonamentoDoBracoDoDisco\\src\\controladores\\disco.txt");

    public Disco carregadorDoDisco(File arquivo) {
        try {
            FileReader leitor = new FileReader(arquivo);
            BufferedReader buffer = new BufferedReader(leitor);
            
            String linha;
            int contador = 0;
            int posicao = 0;

            while ((linha = buffer.readLine()) != null) {
                if (contador > 1) {
                    listTrajeto.add(Integer.parseInt(linha));
                } else if (contador == 1) {
                    disco.setPosicaoInicial(Integer.parseInt(linha));
                } else if (contador == 0) {
                    disco.setTamanho(Integer.parseInt(linha));
                }
                contador++;
            }
            disco.setListTrajeto(listTrajeto);
            buffer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return disco;
    }
}
