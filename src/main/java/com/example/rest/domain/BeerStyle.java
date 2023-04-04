package com.example.rest.domain;

import java.util.List;
import java.util.Random;

public enum BeerStyle {
    LAGER, PILSNER, STOUT, GOSE, PORTER, ALE, WHEAT, IPA, PALE_ALE, SAISON;

    private static final List<BeerStyle> VALUES = List.of(values());
    private static final Random RANDOM = new Random();
    private static final int SIZE = VALUES.size();

    public static BeerStyle randomStyle() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

}
