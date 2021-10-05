package baseball;

import baseball.service.BaseballService;
import baseball.view.InputView;
import nextstep.utils.Randoms;

public class Application {


    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        do{
            BaseballService baseballService = new BaseballService();
            System.out.println(baseballService.getRandomNumber());
        }while(InputView.continuePlay());
    }

    public static void play() {
        boolean isAnswer;
        do {

        } while (!isAnswer);

    }
}
