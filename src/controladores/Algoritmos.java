package controladores;

import java.util.ArrayList;
import java.util.Collections;

public class Algoritmos {

    public ArrayList<MovimentoDoBraco> algoritmoFirstComeFirstServed(ArrayList<Integer> listaPercurso, int posicaoAtualBraco) {
        ArrayList<MovimentoDoBraco> listaMovimento = new ArrayList();
        for (Integer proximoPasso : listaPercurso) {
            int contadorDePercurso = 0;
            MovimentoDoBraco movimento = new MovimentoDoBraco();
            movimento.setPosicaoAtual(posicaoAtualBraco);
            movimento.setProximaPosicao(proximoPasso);

            if (posicaoAtualBraco > proximoPasso) {
                contadorDePercurso = contadorDePercurso + (posicaoAtualBraco - proximoPasso);
                movimento.setTotalTrajeto(contadorDePercurso);
            } else {
                contadorDePercurso = contadorDePercurso + (proximoPasso - posicaoAtualBraco);
                movimento.setTotalTrajeto(contadorDePercurso);
            }
            posicaoAtualBraco = proximoPasso;
            listaMovimento.add(movimento);
        }

        return listaMovimento;
    }

    public ArrayList<MovimentoDoBraco> algoritmoShortestSeekFirst(ArrayList<Integer> listaPercurso, int posicaoAtualBraco) {
        Collections.sort(listaPercurso);
        ArrayList<MovimentoDoBraco> listaMovimento = new ArrayList();
        for (Integer proximoPasso : listaPercurso) {
            int contadorDePercurso = 0;
            MovimentoDoBraco movimento = new MovimentoDoBraco();
            movimento.setPosicaoAtual(posicaoAtualBraco);
            movimento.setProximaPosicao(proximoPasso);

            if (posicaoAtualBraco > proximoPasso) {
                contadorDePercurso = contadorDePercurso + (posicaoAtualBraco - proximoPasso);
                movimento.setTotalTrajeto(contadorDePercurso);
            } else {
                contadorDePercurso = contadorDePercurso + (proximoPasso - posicaoAtualBraco);
                movimento.setTotalTrajeto(contadorDePercurso);
            }
            posicaoAtualBraco = proximoPasso;
            listaMovimento.add(movimento);
        }

        return listaMovimento;
    }

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList();
        Algoritmos al = new Algoritmos();
        l.add(4);
        l.add(29);
        l.add(1);
        l.add(5);
        l.add(25);
        System.out.println("Atual: " + 30);
        for (Integer j : al.ordenarListaElevador(l, 30)) {
            System.out.println("Resultado: " + j);
        }
    }

    private static ArrayList<Integer> ordenarListaElevador(ArrayList<Integer> listaPercurso, int atual) {
        ArrayList<Integer> listaTemporaria = new ArrayList();
        ArrayList<Integer> listaReordenada = new ArrayList();
        if (listaPercurso.get(0) < atual) {//descce
            Collections.sort(listaPercurso);
            Collections.reverse(listaPercurso);//se está descendo então a lista será descendente
            for (Integer j : listaPercurso) {
                if (j < atual) {
                    listaReordenada.add(j);
                } else {
                    listaTemporaria.add(j);
                }
            }
            Collections.sort(listaTemporaria);
            for (Integer o : listaTemporaria) {
                listaReordenada.add(o);
            }
        } else {
            Collections.sort(listaPercurso);
            for (Integer j : listaPercurso) {
                if (j > atual) {
                    listaReordenada.add(j);
                } else {
                    listaTemporaria.add(j);
                }
            }
            Collections.sort(listaTemporaria);
            Collections.reverse(listaTemporaria);
            for (Integer o : listaTemporaria) {
                listaReordenada.add(o);
            }
        }
        return listaReordenada;
    }

    public ArrayList<MovimentoDoBraco> algoritmoElevatorAlgorithm(ArrayList<Integer> listaPercurso, int posicaoAtualBraco) {
        ArrayList<MovimentoDoBraco> listaMovimento = new ArrayList();
        ArrayList<Integer> listaElevador = ordenarListaElevador(listaPercurso, posicaoAtualBraco);
        
        for (Integer proximoPasso : listaElevador) {
            int contadorDePercurso = 0;
            MovimentoDoBraco movimento = new MovimentoDoBraco();
            movimento.setPosicaoAtual(posicaoAtualBraco);
            movimento.setProximaPosicao(proximoPasso);

            if (posicaoAtualBraco > proximoPasso) {
                contadorDePercurso = contadorDePercurso + (posicaoAtualBraco - proximoPasso);
                movimento.setTotalTrajeto(contadorDePercurso);
            } else {
                contadorDePercurso = contadorDePercurso + (proximoPasso - posicaoAtualBraco);
                movimento.setTotalTrajeto(contadorDePercurso);
            }
            posicaoAtualBraco = proximoPasso;
            listaMovimento.add(movimento);
        }

        return listaMovimento;
    }

}
