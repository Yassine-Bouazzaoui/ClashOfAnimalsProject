package com.example.tests.animalstests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hle.clashofanimals.api.effects.attack.AttackEffect;
import com.hle.clashofanimals.api.types.Herbivore;
import com.hle.clashofanimals.impl.animals.Gazelle;
import com.hle.clashofanimals.impl.animals.Tiger;
import com.hle.clashofanimals.impl.effect.AttackEffect2D;
import com.hle.clashofanimals.impl.effect.AttackEffect3D;

class TigerTest {

    private Tiger tiger;
    private Gazelle gazelle;
    private AttackEffect attackEffect;

    @BeforeEach
    void setUp() {
        tiger = Tiger.builder()
                .name("Simba San")
                .numberOfCanines(4)
                .typeRayure("Orange and Black")
                .build();

        gazelle = Gazelle.builder()
                .name("Bambi")
                .ruminatingDuration(10)
                .build();

        attackEffect = new AttackEffect3D("Claws");
    }

    @Test
    void testMakeNoise() {
        String noise = tiger.makeNoise();
        assertEquals("Tiger  <Simba San> is growling : GRRRR ...", noise);
    }

    @Test
    void testAttachAttackStrategy() {
        tiger.attachAttackStrategy(attackEffect);
        assertNotNull(tiger.getAttackEffect());
        assertEquals(attackEffect, tiger.getAttackEffect());
    }

    @Test
    void testAttack() {
        String result = tiger.attack(gazelle);
        assertEquals("Tiger <Simba San> is mauling with its claws and fangs <Bambi>  : <Tiger  <Simba San> is growling : GRRRR ...> ....", result);
    }

    @Test
    void testTryToDevour() {
        tiger.attachAttackStrategy(attackEffect);
        String result = tiger.tryToDevour(gazelle);
        assertTrue(result.contains("was devoured by Tiger <Simba San>"));
        assertNotNull(gazelle.getDeathDate());
    }

    @Test
    void testTryToDevourLuckyHerbivore() {
        Herbivore luckyHerbivore = Gazelle.builder()
                .name("Lucky")
                .ruminatingDuration(0)
                .build();

        AttackEffect2D attackEffect = AttackEffect2D.builder()
                .weapon("Roar and Claws")
                .build();
        tiger.attachAttackStrategy(attackEffect);

        String result = tiger.tryToDevour(luckyHerbivore);

        System.out.println(result);
        assertTrue(result.contains("was devoured by Tiger"));

    }
}
