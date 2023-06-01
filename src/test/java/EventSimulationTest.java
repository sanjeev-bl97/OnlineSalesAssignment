package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class EventSimulationTest {

    @Test
    public void testDistribution_diceSimulation() {
        // Arrange
        Map<Object, Integer> dice = new HashMap<>();
        dice.put(1, 10);
        dice.put(2, 30);
        dice.put(3, 15);
        dice.put(4, 15);
        dice.put(5, 30);
        dice.put(6, 0);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        EventSimulation.distribution(dice);
        String output = outputStream.toString().trim();

        // Assert
        String[] lines = output.split(System.lineSeparator());
        Assertions.assertEquals(6, lines.length);
    }

    @Test
    public void testDistribution_coinSimulation() {
        // Arrange
        Map<Object, Integer> coin = new HashMap<>();
        coin.put("HEAD", 35);
        coin.put("TAIL", 65);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        EventSimulation.distribution(coin);
        String output = outputStream.toString().trim();

        // Assert
        String[] lines = output.split(System.lineSeparator());
        Assertions.assertEquals(2, lines.length);
    }

    @Test
    public void testDistribution_emptyInput() {
        // Arrange
        Map<Object, Integer> empty = new HashMap<>();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        EventSimulation.distribution(empty);
        String output = outputStream.toString().trim();

        // Assert
        Assertions.assertEquals("", output);
    }

    @Test
    public void testDistribution_singleOutcome() {
        // Arrange
        Map<Object, Integer> singleOutcome = new HashMap<>();
        singleOutcome.put("A", 100);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        EventSimulation.distribution(singleOutcome);
        String output = outputStream.toString().trim();

        // Assert
        String[] lines = output.split(System.lineSeparator());
        Assertions.assertEquals(1, lines.length);
        Assertions.assertTrue(lines[0].contains("A: 1000 times"));
    }

    @Test
    public void testDistribution_zeroOccurrences() {
        // Arrange
        Map<Object, Integer> outcomes = new HashMap<>();
        outcomes.put("A", 0);
        outcomes.put("B", 0);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        EventSimulation.distribution(outcomes);
        String output = outputStream.toString().trim();

        // Assert
        String[] lines = output.split(System.lineSeparator());
        Assertions.assertEquals(2, lines.length);
        Assertions.assertTrue(lines[0].contains("A: 0 times"));
        Assertions.assertTrue(lines[1].contains("B: 0 times"));
    }
}

