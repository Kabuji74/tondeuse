package com.mowitnow.tondeuse.service;

import com.mowitnow.tondeuse.model.Position;
import com.mowitnow.tondeuse.model.Surface;
import com.mowitnow.tondeuse.model.Tondeuse;

public interface TondeusePiloteService {
    Position moveTondeuse(Surface surface, Tondeuse tondeuse, String moves);
}
