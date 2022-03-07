package utils;

public class Result {

    private int currentScore;
    private int attempts;

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore() {
        this.currentScore++;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts() {
        this.attempts++;
    }

    @Override
    public String toString(){
        return currentScore + "/" + attempts;
    }
}
