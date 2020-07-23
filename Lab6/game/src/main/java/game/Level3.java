package game;

public class Level3 implements LevelState {

    private int multiply = 3;
    private int threshold = 30;

    @Override
    public void addPoints(Game game, int newPoints) {
        int points = game.getTotalPoints() + multiply * newPoints;
        game.setTotalPoints(points);
    }

    @Override
    public String toString() {
        return "Level3";
    }
}
