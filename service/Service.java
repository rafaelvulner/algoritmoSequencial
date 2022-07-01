package service;

import java.util.LinkedList;
import java.util.List;

public class Service {

  private static List<Integer> PRIMEIRO;
  private static List<Integer> SEGUNDO;
  private static List<Integer> PRIMEIRO_SEQUENCIAL;
  private static List<Integer> SEGUNDOS_EQUENCIAL;
  private static List<Integer> ISOLADO;

  public Service(){
    PRIMEIRO = new LinkedList<>();
    SEGUNDO = new LinkedList<>();
    PRIMEIRO_SEQUENCIAL = new LinkedList<>();
    SEGUNDOS_EQUENCIAL = new LinkedList<>();
    SEGUNDOS_EQUENCIAL = new LinkedList<>();
    ISOLADO = new LinkedList<>();
  }

  public static String obterSequenciaFormatada(Integer[] valores) {
    return getsequenciaEdoisValores(valores);
  }

  public static String getsequenciaEdoisValores(Integer[] valores) {

    String retorno = "";
    for (Integer i = 0; i < valores.length; i++) {
      if (valores[i] - i == 1) {

        PRIMEIRO.add(valores[i]);
      } else {
        SEGUNDO.add(valores[i]);
      }
    }

    if (PRIMEIRO.size() > 1) {

      retorno = PRIMEIRO.get(0) + "-" + PRIMEIRO.get(PRIMEIRO.size() - 1);
    }

    if (PRIMEIRO.size() == 1) {

      ISOLADO.add(PRIMEIRO.get(0));

      Integer[] novoSegundo = new Integer[SEGUNDO.size()];

      Integer cont = 0;
      for (Integer i : SEGUNDO) {
        novoSegundo[cont] = i;
        cont++;
      }

      Integer inicio = novoSegundo[0];
      Integer cont1 = 0;
      Integer cont2 = 0;
      for (Integer i = inicio; i < novoSegundo.length - 1; i++) {
        if (novoSegundo[cont1] - i == 1) {
        } else {
          ISOLADO.add(novoSegundo[cont2]);
          Integer finalCont = inicio;
          SEGUNDO.removeIf(r -> r == finalCont);
        }
        cont1++;
      }

      if (ISOLADO.size() > 1) {
        for (Integer i : ISOLADO) {
          retorno = retorno.concat(i + ",");
        }
      }

      if (!SEGUNDO.isEmpty()) {
        Integer[] newSegundo = SEGUNDO.toArray(new Integer[SEGUNDO.size()]);
        int idx = 0;
        for (Integer i : SEGUNDO) {
          newSegundo[idx++] = i;
        }
        idx = novoSegundo[0] + 1;
        for (Integer i = 0; i < newSegundo.length; i++) {
          if (newSegundo[i] - idx == 1) {
            PRIMEIRO_SEQUENCIAL.add(newSegundo[i]);
          } else {
            SEGUNDOS_EQUENCIAL.add(newSegundo[i]);
          }
          idx++;
        }

        if(PRIMEIRO_SEQUENCIAL.size() > 0){
          if(!ISOLADO.isEmpty()){
            String comeco = PRIMEIRO_SEQUENCIAL.stream().findFirst().get().toString();
            String fim = PRIMEIRO_SEQUENCIAL.stream().reduce((one, two) -> two).get().toString();

            retorno = retorno.concat(comeco +"-"+fim);
          }
        }

        if(SEGUNDOS_EQUENCIAL.size() > 0){
          if(!ISOLADO.isEmpty()){
            String comeco = SEGUNDOS_EQUENCIAL.stream().findFirst().get().toString();
            String fim = SEGUNDOS_EQUENCIAL.stream().reduce((one, two) -> two).get().toString();

            retorno = retorno.concat(","+comeco +"-"+fim);
          }
        }
      }
    } else {
      Integer[] segundoValor = new Integer[SEGUNDO.size()];

      if (!SEGUNDO.isEmpty()) {

        Integer cont = 0;
        for (Integer i : SEGUNDO) {
          segundoValor[cont] = i;
          cont++;
        }
        for (Integer i = 0; i < segundoValor.length - 1; i++) {
          if (!contains(segundoValor, segundoValor[i] + 1)) {

            if (!ISOLADO.contains(segundoValor[i] + 1)) {

              ISOLADO.add(segundoValor[i]);
              Integer[] finalSegundoValor = segundoValor;
              Integer finalI1 = i;
              SEGUNDO.removeIf(f -> f == finalSegundoValor[finalI1]);
            }
          }
        }
      }
    }

    if (!ISOLADO.isEmpty() && PRIMEIRO_SEQUENCIAL.isEmpty()) {

      for (Integer i : ISOLADO) {
        retorno = retorno.concat("," + i);
      }
    }

    if (!SEGUNDO.isEmpty() && PRIMEIRO_SEQUENCIAL.isEmpty() && SEGUNDOS_EQUENCIAL.isEmpty()) {
      String inicio = SEGUNDO.stream().findFirst().get().toString();
      String fim = SEGUNDO.stream().reduce((one, two) -> two).get().toString();

      retorno = retorno.concat("," + inicio + "-" + fim);
    }

    return retorno;
  }

  public static boolean contains(Integer[] a, Integer b) {
    for (Integer i : a) {
      if (i == b) {
        return true;
      } else if (i > b) {
        return false;
      }
    }
    return false;
  }

}


