package com.example.tests.animalstests;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import com.hle.clashofanimals.impl.animals.Gazelle;

public class GazelleTest {

    @Test
    public void testMakeNoise() {
        // Arrange
        Gazelle gazelle = Gazelle.builder()
                .name("Grace")
                .species("Thomson's Gazelle")
                .ruminatingDuration(4)
                .build();

        // Act
        String noise = gazelle.makeNoise();

        // Assert
        assertEquals("Gazelle <Grace> is snorting : PFFFT ...", noise);
    }

    @Test
    public void testRuminatingDuration() {
        // Arrange
        Gazelle gazelle = Gazelle.builder()
                .name("Grace")
                .ruminatingDuration(6)
                .build();

        // Act & Assert
        assertEquals(6, gazelle.getRuminatingDuration());
    }

    @Test
    public void testDiesUpdatesDeathDate() {
        // Arrange
        Gazelle gazelle = Gazelle.builder()
                .name("Grace")
                .build();

        // Act
        gazelle.dies();

        // Assert
        assertNotNull(gazelle.getDeathDate());
        assertEquals(LocalDate.now(), gazelle.getDeathDate());
    }

    @Test
    public void testDeathDateInitiallyNull() {
        // Arrange
        Gazelle gazelle = Gazelle.builder()
                .name("Grace")
                .build();

        // Assert
        assertNull(gazelle.getDeathDate(), "Death date should initially be null");
    }
}
