package game;

public class Level2_5 implements LevelState {

    private int multiply = 2;
    private int threshold = 14;
    private int bonus = 1;

    @Override
    public void addPoints(Game game, int newPoints) {
        int points = game.getTotalPoints() + multiply * newPoints;
        if (points > threshold) {
            game.setLevelState(new Level3());
            game.setTotalPoints(points + bonus);
        } else {
            game.setTotalPoints(points);
        }
    }

    @Override
    public String toString() {
        return "Level2_5";
    }
}
