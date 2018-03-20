package com.mowitnow.tondeuse.service;

import com.mowitnow.tondeuse.model.Move;
import com.mowitnow.tondeuse.model.Position;
import com.mowitnow.tondeuse.model.Surface;
import com.mowitnow.tondeuse.model.Tondeuse;

import static com.mowitnow.tondeuse.model.Move.*;

public class TondeusePilotePiloteServiceImpl implements TondeusePiloteService {

    public Position moveTondeuse(Surface surface, Tondeuse tondeuse, String moves) {
        //TODO: null should never be passed as arguments
        //TODO: need logs
        if (moves == null) {
            throw new IllegalArgumentException("moves must not be null");
        }
        if (tondeuse == null) {
            throw new IllegalArgumentException("tondeuse must not be null");
        }
        if (surface == null) {
            throw new IllegalArgumentException("surface must not be null");
        }

        for (Character move : moves.toCharArray()) {
            Move currentMove = Move.fromShortName(move);
            if (currentMove != null) {
                if (AVANCE.equals(currentMove)) {
                    moveForwardTondeuse(surface, tondeuse);
                } else {
                    rotateTondeuse(surface, tondeuse, currentMove);
                }
            }
        }
        return tondeuse.getPosition();

    }

    protected void rotateTondeuse(Surface surface, Tondeuse tondeuse, Move move) {
        if (DROITE.equals(move)) {
            tondeuse.getPosition().setOrientation(tondeuse.getPosition().getOrientation().rotated90RightDirection());

        } else if (GAUCHE.equals(move)) {
            tondeuse.getPosition().setOrientation(tondeuse.getPosition().getOrientation().rotated90LeftDirection());
        }
    }

    protected void moveForwardTondeuse(Surface surface, Tondeuse tondeuse) {

        Position position = tondeuse.getPosition();
        switch (position.getOrientation()) {
            case NORD:
                if (position.getPositionY() < surface.getTopRightCornerY())
                    position.setPositionY(position.getPositionY() + 1);
                break;
            case EST:
                if (position.getPositionX() < surface.getTopRightCornerX())
                    position.setPositionX(position.getPositionX() + 1);
                break;
            case SUD:
                if (position.getPositionY() > 1)
                    position.setPositionY(position.getPositionY() - 1);
                break;
            case OUEST:
                if (position.getPositionX() > 1)
                    position.setPositionX(position.getPositionX() - 1);
                break;

        }
    }
}
