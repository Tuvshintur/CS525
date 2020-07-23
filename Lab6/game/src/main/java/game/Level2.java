package game;

public class Level2 implements LevelState {

    private int multiply = 2;
    private int threshold = 20;
    private int bonus = 2;

    @Override
    public void addPoints(Game game, int newPoints) {
        int points = game.getTotalPoints() + multiply * newPoints;
        if (points > threshold) {
            game.setLevelState(new Level2_5());
            game.setTotalPoints(points + bonus);
        } else {
            game.setTotalPoints(points);
        }
    }

    @Override
    public String toString() {
        return "Level2";
    }
}
