package com.mowitnow.tondeuse.service;

import com.mowitnow.tondeuse.model.Position;
import com.mowitnow.tondeuse.model.Surface;
import com.mowitnow.tondeuse.model.Tondeuse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.mowitnow.tondeuse.model.Direction.*;
import static com.mowitnow.tondeuse.model.Move.DROITE;
import static com.mowitnow.tondeuse.model.Move.GAUCHE;

public class TondeusePiloteServiceImplTest {

    private Tondeuse tondeuse = givenTondeuse();
    private TondeusePilotePiloteServiceImpl pilote = givenTondeusePilote();
    private Surface pelouse = givenPelouseSurface();

    @Before
    public void initTests() {
        tondeuse.getPosition().setOrientation(NORD);
        tondeuse.getPosition().setPositionX(1);
        tondeuse.getPosition().setPositionY(1);
    }

    @Test
    public void moveForwardTondeuseShouldSetTondeuseToItsNewLocation() {
        //Given


        //When
        pilote.moveForwardTondeuse(pelouse, tondeuse);

        //Then
        Assert.assertEquals(NORD, tondeuse.getPosition().getOrientation());
        Assert.assertEquals(1, tondeuse.getPosition().getPositionX());
        Assert.assertEquals(2, tondeuse.getPosition().getPositionY());

    }

    @Test
    public void moveForwardShouldDoNothingIfNextMoveGoTooFarNorth() {
        //Given
        tondeuse.getPosition().setPositionX(1);
        tondeuse.getPosition().setPositionY(5);

        //When
        pilote.moveForwardTondeuse(pelouse, tondeuse);

        //Then
        Assert.assertEquals(NORD, tondeuse.getPosition().getOrientation());
        Assert.assertEquals(1, tondeuse.getPosition().getPositionX());
        Assert.assertEquals(5, tondeuse.getPosition().getPositionY());

    }


    @Test
    public void moveForwardTondeuseShouldDoNothingIfNextMoveGoTooFarSouth() {
        //Given
        tondeuse.getPosition().setPositionX(2);
        tondeuse.getPosition().setPositionY(1);
        tondeuse.getPosition().setOrientation(SUD);

        //When
        pilote.moveForwardTondeuse(pelouse, tondeuse);

        //Then
        Assert.assertEquals(SUD, tondeuse.getPosition().getOrientation());
        Assert.assertEquals(2, tondeuse.getPosition().getPositionX());
        Assert.assertEquals(1, tondeuse.getPosition().getPositionY());

    }

    @Test
    public void moveForwardTondeuseShouldDoNothingIfNextMoveGoTooFarEast() {
        //Given
        tondeuse.getPosition().setPositionX(5);
        tondeuse.getPosition().setPositionY(3);
        tondeuse.getPosition().setOrientation(EST);

        //When
        pilote.moveForwardTondeuse(pelouse, tondeuse);

        //Then
        Assert.assertEquals(EST, tondeuse.getPosition().getOrientation());
        Assert.assertEquals(5, tondeuse.getPosition().getPositionX());
        Assert.assertEquals(3, tondeuse.getPosition().getPositionY());

    }

    @Test
    public void moveForwardTondeuseShouldDoNothingIfNextMoveGoTooFarWest() {
        //Given
        tondeuse.getPosition().setPositionX(1);
        tondeuse.getPosition().setPositionY(3);
        tondeuse.getPosition().setOrientation(OUEST);

        //When
        pilote.moveForwardTondeuse(pelouse, tondeuse);

        //Then
        Assert.assertEquals(OUEST, tondeuse.getPosition().getOrientation());
        Assert.assertEquals(1, tondeuse.getPosition().getPositionX());
        Assert.assertEquals(3, tondeuse.getPosition().getPositionY());

    }

    @Test
    public void rotateTondeuseShouldRotateTondeuseToTheRightDirection() {
        //Given

        //When
        pilote.rotateTondeuse(pelouse, tondeuse, DROITE);
        pilote.rotateTondeuse(pelouse, tondeuse, DROITE);

        //Then
        Assert.assertEquals(SUD, tondeuse.getPosition().getOrientation());
        Assert.assertEquals(1, tondeuse.getPosition().getPositionX());
        Assert.assertEquals(1, tondeuse.getPosition().getPositionY());

    }

    @Test
    public void rotateTondeuseShouldMakeAFullRoll() {
        //Given

        //When
        pilote.rotateTondeuse(pelouse, tondeuse, DROITE);
        pilote.rotateTondeuse(pelouse, tondeuse, DROITE);
        pilote.rotateTondeuse(pelouse, tondeuse, DROITE);
        pilote.rotateTondeuse(pelouse, tondeuse, DROITE);

        //Then
        Assert.assertEquals(NORD, tondeuse.getPosition().getOrientation());
        Assert.assertEquals(1, tondeuse.getPosition().getPositionX());
        Assert.assertEquals(1, tondeuse.getPosition().getPositionY());

    }

    @Test
    public void rotateTondeuseShouldRotateTondeuseAntiClockWise() {
        //Given

        //When
        pilote.rotateTondeuse(pelouse, tondeuse, GAUCHE);

        //Then
        Assert.assertEquals(OUEST, tondeuse.getPosition().getOrientation());
        Assert.assertEquals(1, tondeuse.getPosition().getPositionX());
        Assert.assertEquals(1, tondeuse.getPosition().getPositionY());

    }

    private Surface givenPelouseSurface() {
        return new Surface(5, 5);
    }

    private TondeusePilotePiloteServiceImpl givenTondeusePilote() {
        return new TondeusePilotePiloteServiceImpl();
    }

    private Tondeuse givenTondeuse() {
        return new Tondeuse(new Position(1, 1, NORD));
    }
}