package ru.mos.qa.testtasks.tests;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ProblemTests {

  private String CONST = "const";   // Убираем final для переменной CONST, чтобы тест assignValueToConstVar прошёл
  private final static String bd = "pui";

  @Test
  public void stringEqualsOneToOne(){ //Изменено название
    assertEquals("1", "1"); //Проверка равности двух переменных String
  }


  @Test
  public void assignValueToConstVar(){
    CONST = "newValue";
    assertEquals("newValue", CONST); //Проверка присвоения переменной CONST нового значения
  }

  @Test
  public void integerEqualsOneToOne(){ //Изменено название, убран модификатор static
    assertEquals(1, 1);//Проверка равности двух переменных Integer
  }



  @Test
  public void stringsMustBeEqual(){
    String res = "a";

    if (bd.equals("pui")) { //Заменён оператор "==" на "equals". Оператор "==" сравнивает ссылки на объекты, а не их содержимое.
      res = "asd";
    }

    assertEquals("asd", res); //Проверка равности содержимого двух переменных String
  }

  @Test
  public void successfullyRemovingFirstElementFromList(){
    List<String> sourceData = new ArrayList<>(List.of("1", "viskas", "chupocabra")); //Метод List.of служит для создания неизменяемых списков. Оборачиваем его в ArrayList
    sourceData.remove(0); //Удаляем первый элемент списка

    assertFalse(sourceData.contains("1")); //Проверка успешного удаления первого элемента списка
  }


}