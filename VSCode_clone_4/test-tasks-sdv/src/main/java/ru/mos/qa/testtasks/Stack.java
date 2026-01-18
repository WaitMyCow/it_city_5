package ru.mos.qa.testtasks;

public class Stack { //Добавлен модификатор public
  private int mSize;
  private int[] stackArray;
  private int top;

  public Stack(int m) {
    this.mSize = m;
    stackArray = new int[mSize];
    top = -1;
  }

  public void addElement(int element) { //Добавлена проверка в случае если Стак будет полон
    if (isFull()) {
      throw new IllegalStateException("Full stack");
    }
    stackArray[++top] = element;
  }

  public int deleteElement() {//Добавлена проверка в случае если Стак будет пуст
    if (isEmpty()) {
      throw new IllegalStateException("Empty stack");
    }
    return stackArray[--top+1];
  }

  public int readTop() {//Добавлена проверка в случае если Стак будет пуст
    if (isEmpty()) {
      throw new IllegalStateException("Empty stack");
    }
    return stackArray[top];

  }

  public boolean isEmpty() {
    return (top == -1);
  }

  public boolean isFull() {
    return (top == mSize - 1);
  }
}
