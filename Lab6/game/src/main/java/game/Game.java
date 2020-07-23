package game;

import java.util.Random;
import java.util.logging.Level;

public class Game {
    private int totalPoints = 0;
    private LevelState levelState;

    public Game() {
        this.levelState = new Level1();
    }

    public void play() {
        Random random = new Random();
        addPoints(random.nextInt(7));
        System.out.println("points=" + totalPoints + " level=" + levelState.toString());
    }

    public void addPoints(int newPoints) {
        this.levelState.addPoints(this, newPoints);
    }

    public void setLevelState(LevelState levelState) {
        this.levelState = levelState;
    }

    private LevelState getLevelState() {
        return this.levelState;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
