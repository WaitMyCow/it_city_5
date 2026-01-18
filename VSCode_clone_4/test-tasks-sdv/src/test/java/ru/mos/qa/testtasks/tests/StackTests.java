package ru.mos.qa.testtasks.tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackTests {
    private Stack stack;
    @BeforeEach
    public void stackCapacity() {
        stack = new Stack(4);//Перед началом тестов задаём максимальный размер стака - 4
    }

    @Test
    //Проверка отстутсвия элементов в стаке
    public void StackIsEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    //Проверка чтения элемента в пустом стаке
    public void readTopFromEmptyStack() {
        assertThrows(IllegalStateException.class, () -> {
            stack.readTop();
        });
    }

    @Test
    //Проверка удаления элемента из пустого стака
    public void deleteFromEmptyStack() {
        assertThrows(IllegalStateException.class, () -> {
            stack.deleteElement();
        });
    }

    @Test
    //Проверка стака с нулевым размером
    public void zeroCapacityStack() {
        Stack zeroStack = new Stack(0);
        assertTrue(zeroStack.isEmpty());
        assertTrue(zeroStack.isFull());
        assertThrows(IllegalStateException.class, () -> {
            zeroStack.addElement(1);
        });
    }

    @Test
    //Проверка полного стака
    public void StackIsFull() {
        for (int i = 0; i < 4; i++) {
            stack.addElement(i * 10);
        }
        assertTrue(stack.isFull());
        assertEquals(30, stack.readTop());
    }

    @Test
    //Проверка добавления элемента в стак
    public void addElementToStack() {
        stack.addElement(1);
        assertEquals(1, stack.readTop());
    }

    @Test
    //Проверка удаления элемента из стака
    public void deleteElementFromStack() {
        stack.addElement(1);
        stack.addElement(41);
        stack.addElement(951);

        int deleted = stack.deleteElement();
        assertEquals(951, deleted);
        assertEquals(41, stack.readTop());
    }

    @Test
    //Проверка добавления нескольких элементов в стак
    public void addMultipleElementsToStack() {
        stack.addElement(1);
        stack.addElement(41);
        stack.addElement(951);

        assertEquals(951, stack.readTop());
        assertFalse(stack.isFull());
    }

}