package ru.mos.qa.testtasks.tests;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class FileTests {
    @Test
    public void doYouHavePerseverance() {
        String perseverance = "Упорство"; //Cлово, которое ищем
        boolean gotWord = false; //false, пока совпадение не найдено
        //Получаем путь к файлу TraineeCharacteristics.txt
        try (InputStream traineeChars = getClass().getClassLoader().getResourceAsStream("TraineeCharacteristics.txt")) {
            if (traineeChars == null) {
                fail("File cant be found: ");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(traineeChars));//Читаем строки из InputStream
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(perseverance)) {
                    gotWord = true;//Слово совпало, заменяем gotWord
                    break;//И выходим, так как нужно найти одно совпадение
                }
            }
        } catch (IOException e) {
            fail("Error file reading: " + e.getMessage());
        }

        assertTrue(gotWord);
    }
}
