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
        do{
            BaseballService baseballService = new BaseballService();
            BaseballRandomNumber baseballRandomNumber = new BaseballRandomNumber(baseballService.getRandomNumber());
            baseballService.play(baseballRandomNumber);
        }while(InputView.continuePlay());
    }
}
