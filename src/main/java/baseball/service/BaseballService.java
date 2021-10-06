package baseball.service;

import baseball.model.BaseballInputNumber;
import baseball.model.BaseballRandomNumber;
import baseball.model.BaseballResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballService {
    private static final int BASEBALL_SIZE = 3;

    public void play(BaseballRandomNumber baseballRandomNumber) {
        boolean isResult;
        do {
            BaseballInputNumber baseballInputNumber = InputView.userInput();
            BaseballResult baseballResult =  checkBallResult(baseballRandomNumber, baseballInputNumber);
            isResult = OutputView.userOutput(baseballResult);
        } while (!isResult);
    }

    /**
     * 랜덤값 생성-1
     * @return
     */
    public List<String> getRandomNumber() {
        List<String> lst = getRandomNumber(BASEBALL_SIZE);
        System.out.println(Arrays.toString(lst.toArray()));
        return lst;
    }

    /**
     * 랜덤값 생성-2
     * @param size
     * @return
     */
    public List<String> getRandomNumber(int size) {
        List<String> lst = new ArrayList<>();

        do {
            getValidateNumber(lst, Integer.toString(Randoms.pickNumberInRange(1, 9)));
        } while (lst.size() != size);

        BaseballRandomNumber baseballRandomNumber = new BaseballRandomNumber(lst);

        return lst;
    }

    /**
     * 중복되지 않은 값 추가
     * @param listNum
     * @param currNum
     * @return
     */
    private List<String> getValidateNumber(List<String> listNum, String currNum) {
        if (!listNum.contains(currNum)) {
            listNum.add(currNum);
        }
        return listNum;
    }

    /**
     * 스트라이크 & 볼 결과 체크
     * @param randomNumber
     * @param inputNumber
     * @return
     */
    public BaseballResult checkBallResult(BaseballRandomNumber randomNumber, BaseballInputNumber inputNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < BASEBALL_SIZE; i++) {
            strike += checkStrike(randomNumber, inputNumber, i);
            ball += checkBall(randomNumber, inputNumber, i);
        }
        return new BaseballResult(strike, ball);
    }

    /**
     * 스트라이크 체크
     * @param randomNumber
     * @param inputNumber
     * @param index
     * @return
     */
    private int checkStrike(BaseballRandomNumber randomNumber, BaseballInputNumber inputNumber, int index) {
        if (randomNumber.getRandomNumber().get(index).equals(inputNumber.getInputNumber().get(index)) ) {
            return 1;
        }
        return 0;
    }

    /**
     * 볼 체크
     * @param randomNumber
     * @param inputNumber
     * @param index
     * @return
     */
    private int checkBall(BaseballRandomNumber randomNumber, BaseballInputNumber inputNumber, int index) {
        if (!randomNumber.getRandomNumber().get(index).equals(inputNumber.getInputNumber().get(index))
                && randomNumber.getRandomNumber().contains(inputNumber.getInputNumber().get(index))) {
            return 1;
        }
        return 0;
    }


}
