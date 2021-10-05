package baseball.service;

import baseball.model.BaseballInputNumber;
import baseball.model.BaseballRandomNumber;
import baseball.model.BaseballResult;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballService {

    private static final int BASEBALL_SIZE = 3;
    //private static BaseballNumber baseballNumber;

    public List<String> getRandomNumber() {
        List<String> lst = getRandomNumber(BASEBALL_SIZE);
        System.out.println(Arrays.toString(lst.toArray()));
        return lst;
    }

    public List<String> getRandomNumber(int size) {
        List<String> lst = new ArrayList<>();

        //TODO : 예외처리 ? 2depth -> 1depth
        do {
            getValidateNumber(lst, Integer.toString(Randoms.pickNumberInRange(1, 9)));
        } while (lst.size() != size);

        BaseballRandomNumber baseballRandomNumber = new BaseballRandomNumber(lst);

        return lst;
    }

    private List<String> getValidateNumber(List<String> listNum, String currNum) {
        if (!listNum.contains(currNum)) {
            listNum.add(currNum);
        }
        return listNum;
    }

    //TODO : 메소드 호출시, 콘솔을 통해 입력 입력값이 모델값으로 저장
    //TODO : 스트라이크, 볼, 체크
    public BaseballResult checkBallResult(BaseballRandomNumber randomNumber, BaseballInputNumber inputNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < BASEBALL_SIZE; i++) {
            strike += checkStrike(randomNumber, inputNumber, i);
            ball += checkBall(randomNumber, inputNumber, i);
        }
        return new BaseballResult(strike, ball);
    }

    private int checkStrike(BaseballRandomNumber randomNumber, BaseballInputNumber inputNumber, int index) {
        if (randomNumber.getRandomNumber().get(index).equals(inputNumber.getInputNumber().get(index)) ) {
            return 1;
        }
        return 0;
    }

    private int checkBall(BaseballRandomNumber randomNumber, BaseballInputNumber inputNumber, int index) {
        if (!randomNumber.getRandomNumber().get(index).equals(inputNumber.getInputNumber().get(index))
                && randomNumber.getRandomNumber().contains(inputNumber.getInputNumber().get(index))) {
            return 1;
        }
        return 0;
    }


}
