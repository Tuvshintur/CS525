package game;

public class Level1 implements LevelState {

    private int multiply = 1;
    private int threshold = 10;
    private int bonus = 1;

    @Override
    public void addPoints(Game game, int newPoints) {
        int points = game.getTotalPoints() + multiply * newPoints;
        if (points > threshold) {
            game.setLevelState(new Level2());
            game.setTotalPoints(points + bonus);
        } else {
            game.setTotalPoints(points);
        }
    }

    @Override
    public String toString() {
        return "Level1";
    }
}
