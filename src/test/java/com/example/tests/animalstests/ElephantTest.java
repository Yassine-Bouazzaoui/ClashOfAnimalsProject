package com.example.tests.animalstests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.hle.clashofanimals.api.effects.attack.AttackEffect;
import com.hle.clashofanimals.impl.Animal;
import com.hle.clashofanimals.impl.animals.Elephant;
import com.hle.clashofanimals.impl.effect.AttackEffect3D;

public class ElephantTest {

    @Test
    public void testMakeNoise() {
        // Création d'un éléphant avec le builder
        Elephant elephant = Elephant.builder()
                .name("Dumbo")
                .species("African Elephant")
                .longueurDeTrompe(2.5f)
                .ruminatingDuration(6)
                .build();

        // Test du bruit généré
        String noise = elephant.makeNoise();
        assertEquals("Elephant <Dumbo> is rumbling with its trumpet : TROUMP ...", noise);
    }

    @Test
    public void testAttack() {
        Elephant elephant = Elephant.builder()
                .name("Dumbo")
                .species("African Elephant")
                .longueurDeTrompe(2.5f)
                .build();

        Animal target = Elephant.builder()
                .name("TargetElephant")
                .species("Indian Elephant")
                .build();

        // Test de l'attaque
        String attack = elephant.attack(target);
        assertEquals("Elephant <Dumbo> is chaging  with its tusks against <TargetElephant>  : <Elephant <Dumbo> is rumbling with its trumpet : TROUMP ...> ....", attack);
    }

    @Test
    public void testAttachAttackStrategy() {
        Elephant elephant = Elephant.builder()
                .name("Dumbo")
                .build();

        AttackEffect attackEffect = AttackEffect3D.builder()
                .weapon("Tusk")
                .build();

        elephant.attachAttackStrategy(attackEffect);

        // Test de l'effet d'attaque
        assertEquals("3D Viz Effect of <Tusk>", attackEffect.showEffect());
    }
}
