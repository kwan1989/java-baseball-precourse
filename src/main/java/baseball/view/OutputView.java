package baseball.view;

import baseball.model.BaseballResult;

public class OutputView {

    public static boolean userOutput(BaseballResult baseballResult) {
        String result = "";
        if (baseballResult.getStrike() > 0) {
            result += Integer.toString(baseballResult.getStrike()).concat(" 스트라이크 ");
        }

        if (baseballResult.getBall() > 0) {
            result += Integer.toString(baseballResult.getBall()).concat(" 볼 ");
        }

        if (result.equals("")){
            result += "낫싱";
        }

        System.out.println(result);

        if ( baseballResult.getStrike() == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
            return true;
        }

        return false;
    }
}
