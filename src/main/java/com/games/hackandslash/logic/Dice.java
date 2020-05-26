package com.games.hackandslash.logic;

public enum Dice {
    DICE1D4(1, 1, 4),
    DICE1D6(2, 1, 6),
    DICE1D8(3, 1, 8),
    DICE3D6(4, 3, 6);

    private final int id;
    private final int numberOfDiceThrow;
    private final int sideNumber;

    private Dice(int id, int numberOfDiceThrow, int sideNumber) {
        this.id = id;
        this.numberOfDiceThrow = numberOfDiceThrow;
        this.sideNumber = sideNumber;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfDiceThrow() {
        return numberOfDiceThrow;
    }

    public int getSideNumber() {
        return sideNumber;
    }
}
