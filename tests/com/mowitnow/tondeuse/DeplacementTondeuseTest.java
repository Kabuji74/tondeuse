package com.mowitnow.tondeuse;

import com.mowitnow.tondeuse.model.Position;
import com.mowitnow.tondeuse.model.Surface;
import com.mowitnow.tondeuse.model.Tondeuse;
import com.mowitnow.tondeuse.service.TondeusePilotePiloteServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import static com.mowitnow.tondeuse.model.Direction.EST;
import static com.mowitnow.tondeuse.model.Direction.NORD;

public class DeplacementTondeuseTest {
    @Test
    public void theTwoTondeusesShouldGoToParameterizedDestination() {
        //Given
        TondeusePilotePiloteServiceImpl pilote = new TondeusePilotePiloteServiceImpl();
        Surface surface = new Surface(5, 5);
        Tondeuse tondeuse1 = new Tondeuse(new Position(1, 2, NORD));
        Tondeuse tondeuse2 = new Tondeuse(new Position(3, 3, EST));

        String deplacementTondeuse1 = "GAGAGAGAA";
        String deplacementTondeuse2 = "AADAADADDA";

        //When
        String finalPosition1 = pilote.moveTondeuse(surface, tondeuse1, deplacementTondeuse1).toString();
        String finalPosition2 = pilote.moveTondeuse(surface, tondeuse2, deplacementTondeuse2).toString();

        //Then
        Assert.assertEquals(2, tondeuse1.getPosition().getPositionX());
        Assert.assertEquals(3, tondeuse1.getPosition().getPositionY());
        Assert.assertEquals(NORD, tondeuse1.getPosition().getOrientation());
        Assert.assertEquals("23N", finalPosition1);

        Assert.assertEquals(5, tondeuse2.getPosition().getPositionX());
        Assert.assertEquals(1, tondeuse2.getPosition().getPositionY());
        Assert.assertEquals(EST, tondeuse2.getPosition().getOrientation());
        Assert.assertEquals("51E", finalPosition2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tondeuseParamMustNotBeNull() {
        //Given
        TondeusePilotePiloteServiceImpl pilote = new TondeusePilotePiloteServiceImpl();
        Surface surface = new Surface(5, 5);

        String deplacementTondeuse1 = "GAGAGAGAA";

        //When
        pilote.moveTondeuse(surface, null, deplacementTondeuse1);

        //Then
        //Exception should be thrown

    }

    @Test(expected = IllegalArgumentException.class)
    public void surfaceParamMustNotBeNull() {
        //Given
        TondeusePilotePiloteServiceImpl pilote = new TondeusePilotePiloteServiceImpl();
        Tondeuse tondeuse1 = new Tondeuse(new Position(1, 2, NORD));

        String deplacementTondeuse1 = "GAGAGAGAA";

        //When
        pilote.moveTondeuse(null, tondeuse1, deplacementTondeuse1);

        //Then
        //Exception should be thrown

    }

    @Test(expected = IllegalArgumentException.class)
    public void movesParamMustNotBeNull() {
        //Given
        TondeusePilotePiloteServiceImpl pilote = new TondeusePilotePiloteServiceImpl();
        Surface surface = new Surface(5, 5);
        Tondeuse tondeuse1 = new Tondeuse(new Position(1, 2, NORD));

        //When
        pilote.moveTondeuse(surface, tondeuse1, null);

        //Then
        //Exception should be thrown

    }
}