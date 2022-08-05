package baseball.model;

public class BaseballResult {

    private int Strike;
    private int Ball;

    public BaseballResult(int Strike, int Ball){
        this.Strike = Strike;
        this.Ball = Ball;
    }

    public int getStrike() {
        return Strike;
    }

    public int getBall() {
        return Ball;
    }


}
