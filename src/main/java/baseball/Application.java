package baseball;

import baseball.model.BaseballInputNumber;
//import baseball.model.BaseballNumber;
import baseball.model.BaseballRandomNumber;
import baseball.model.BaseballResult;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;
import nextstep.utils.Randoms;

import java.util.List;

public class Application {


    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        do{
            BaseballService baseballService = new BaseballService();
            BaseballRandomNumber baseballRandomNumber = new BaseballRandomNumber(baseballService.getRandomNumber());
            play(baseballRandomNumber);
        }while(InputView.continuePlay());
    }

    public static void play(BaseballRandomNumber baseballRandomNumber) {
        boolean isResult;
        do {
            BaseballInputNumber baseballInputNumber = InputView.userInput();
            BaseballService baseballService = new BaseballService();
            BaseballResult baseballResult =  baseballService.checkBallResult(baseballRandomNumber, baseballInputNumber);
            isResult = OutputView.userOutput(baseballResult);

        } while (!isResult);

    }
}
