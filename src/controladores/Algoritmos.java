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

    private static ArrayList<Integer> organizarSSF(ArrayList<Integer> listaPercurso, int posicaoAtualBraco) {
        ArrayList<Integer> listaFinal = new ArrayList();
        ArrayList<Integer> listaRestante = new ArrayList();
        ArrayList<Integer> listaRefeita = new ArrayList();

        while (listaPercurso.size() >= 1) {
            listaRefeita.addAll(listaPercurso);
            if (listaPercurso.get(0) > posicaoAtualBraco) {
                Collections.sort(listaRefeita);//3  9  11  15  19  22
                for (Integer i : listaRefeita) {
                    int varAnalize = i;
                    int maior = listaPercurso.get(0);
                    if (i >= posicaoAtualBraco && i <= maior) {
                        if (!listaFinal.contains(i)) {
                            listaFinal.add(i);
                        }
                    } else {
                        listaRestante.add(i);
                    }
                }
            } else {
                Collections.sort(listaRefeita);
                Collections.reverse(listaRefeita);
                for (Integer i : listaRefeita) {
                    if (i <= posicaoAtualBraco && i >= listaPercurso.get(0)) {
                        if (!listaFinal.contains(i)) {
                            listaFinal.add(i);
                        }
                    } else {
                        listaRestante.add(i);
                    }
                }
            }
            posicaoAtualBraco = listaPercurso.get(0);
            listaPercurso.remove(0);
        }
        return listaFinal;
    }
    /*
    public static void main(String[] args) {
        ArrayList<Integer> listaInt = new ArrayList();
        listaInt.add(15);
        listaInt.add(3);
        listaInt.add(22);
        listaInt.add(9);
        listaInt.add(19);
        listaInt.add(11);
        listaInt.add(2);
        for (Integer m : organizarSSF(listaInt, 10)) {
            System.out.println(m.intValue());
        }
    }
    */
    public ArrayList<MovimentoDoBraco> algoritmoShortestSeekFirst(ArrayList<Integer> movimentos, int posicaoAtualBraco) {
        ArrayList<Integer> listaPercurso = organizarSSF(movimentos, posicaoAtualBraco);
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
