package com.mowitnow.tondeuse.service;

import com.mowitnow.tondeuse.model.Move;
import com.mowitnow.tondeuse.model.Position;
import com.mowitnow.tondeuse.model.Surface;
import com.mowitnow.tondeuse.model.Tondeuse;

public interface TondeuseService {
    Position moveTondeuse(Surface surface, Tondeuse tondeuse, String moves);
    void changerOrientationTondeuse(Surface surface, Tondeuse tondeuse, Move move);
    void avancerTondeuse(Surface surface, Tondeuse tondeuse);

}
