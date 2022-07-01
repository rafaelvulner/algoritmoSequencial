package test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.Service;

public class Teste {

  private Service service;

  private Integer[] PRIMEIRO = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

  private Integer[] SEGUNDO = new Integer[]{1, 2, 3, 4, 6, 7, 8, 9};

  private Integer[] TERCEIRO = new Integer[]{1, 2, 3, 4, 5, 8, 10, 11, 12, 13, 14, 15};

  private Integer[] QUARTO = new Integer[]{1, 3, 5, 6, 9, 10, 11, 12};

  private String PRIMEIRO_ESPERADO = "1-10";

  private String SEGUNDO_ESPERADO = "1-4,6-9";

  private String TERCEIRO_ESPERADO = "1-5,8,10-15";

  private String QUARTO_ESPERADO = "1,3,5-6,9-12";

  @BeforeEach
  void init() {

    service = new Service();

  }

  @Test
  void primeiro() {
    String primeiro = Service.obterSequenciaFormatada(PRIMEIRO);
    System.out.println("Esperado: " + PRIMEIRO_ESPERADO + " Resultado: " + primeiro);
    Assertions.assertEquals(PRIMEIRO_ESPERADO, primeiro);
  }

  @Test
  void segundo() {
    String segundo = Service.obterSequenciaFormatada(SEGUNDO);
    System.out.println("Esperado: " + SEGUNDO_ESPERADO + " Resultado: " + segundo);
    Assertions.assertEquals(SEGUNDO_ESPERADO, segundo);
  }

  @Test
  void terceiro() {
    String terceiro = Service.obterSequenciaFormatada(TERCEIRO);
    System.out.println("Esperado: " + TERCEIRO_ESPERADO + " Resultado: " + terceiro);
    Assertions.assertEquals(TERCEIRO_ESPERADO, terceiro);
  }

  @Test
  void quarto() {
    String quarto = Service.obterSequenciaFormatada(QUARTO);
    System.out.println("Esperado: " + QUARTO_ESPERADO + " Resultado: " + quarto);
    Assertions.assertEquals(QUARTO_ESPERADO, quarto);
  }

}
