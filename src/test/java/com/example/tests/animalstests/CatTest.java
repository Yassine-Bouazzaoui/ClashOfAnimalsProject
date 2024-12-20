package com.example.tests.animalstests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.hle.clashofanimals.impl.animals.Cat;
import com.hle.clashofanimals.impl.animals.Gazelle;
import com.hle.clashofanimals.impl.effect.AttackEffect3D;

class CatTest {

    @Test
    void testMakeNoise() {
        Cat cat = Cat.builder().name("Fluffy").build();

        String noise = cat.makeNoise();
        assertEquals("the cat <Fluffy> is meowing : MEEYAW...", noise);
    }

    @Test
    void testAttack() {
        Cat cat = Cat.builder().name("Fluffy").build();
        Gazelle gazelle = Gazelle.builder().name("Grace").build();

        AttackEffect3D attackEffect = AttackEffect3D.builder().weapon("Claws").build();

        cat.attachAttackStrategy(attackEffect);

        String attackMessage = cat.attack(gazelle);
        assertTrue(attackMessage.contains("The cat  <Fluffy> is attacking"));
    }

    @Test
    void testTryToDevour() {
        Cat cat = Cat.builder().name("Fluffy").build();
        Gazelle gazelle = Gazelle.builder().name("Grace").build();

        AttackEffect3D attackEffect = AttackEffect3D.builder().weapon("Claws").build();

        cat.attachAttackStrategy(attackEffect);

        String result = cat.tryToDevour(gazelle);

        assertTrue(result.contains("was devoured by cat <Fluffy>"));
    }
}
