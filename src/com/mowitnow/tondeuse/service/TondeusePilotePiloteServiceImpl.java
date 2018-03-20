package com.mowitnow.tondeuse.service;

import com.mowitnow.tondeuse.model.Move;
import com.mowitnow.tondeuse.model.Position;
import com.mowitnow.tondeuse.model.Surface;
import com.mowitnow.tondeuse.model.Tondeuse;

import static com.mowitnow.tondeuse.model.Move.*;

public class TondeusePilotePiloteServiceImpl implements TondeusePiloteService {

    public Position moveTondeuse(Surface surface, Tondeuse tondeuse, String moves) {
        //TODO:Test null
        //TODO:Gestion Exception (logs ?)
        //TODO: Postulat, les déplacements sont parsés précédemment et donc vérifiés
        for (Character move : moves.toCharArray()) {
            Move currentMove = Move.fromShortName(move);
            if (currentMove != null) {
                if (currentMove.equals(AVANCE)) {
                    avancerTondeuse(surface, tondeuse);
                } else {
                    changerOrientationTondeuse(surface, tondeuse, currentMove);
                }

            }

        }

        return tondeuse.getPosition();
    }

    public void changerOrientationTondeuse(Surface surface, Tondeuse tondeuse, Move move) {
        if (tondeuse != null && tondeuse.getPosition() != null && tondeuse.getPosition().getOrientation() != null) {
            if (move.equals(DROITE)) {
//            Direction direction = Direction.fromShortName(tondeuse.getOrientation());
                tondeuse.getPosition().setOrientation(tondeuse.getPosition().getOrientation().rotated90RightDirection());

            } else if (move.equals(GAUCHE)) {
//            Direction direction = Direction.fromShortName(tondeuse.getOrientation());
                tondeuse.getPosition().setOrientation(tondeuse.getPosition().getOrientation().rotated90LeftDirection());
            }
        }
    }

    public void avancerTondeuse(Surface surface, Tondeuse tondeuse) {

        if (tondeuse != null) {
            if (tondeuse.getPosition() != null && tondeuse.getPosition().getOrientation() != null) {
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
    }
}
