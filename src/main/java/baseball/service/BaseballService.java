package baseball.service;

import baseball.model.BaseballNumber;
import baseball.model.BaseballResult;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BaseballService {

    private static final int BASEBALL_SIZE = 3;
    private BaseballNumber baseballNumber;

    public List<String> getRandomNumber() {
        List<String> lst = getRandomNumber(BASEBALL_SIZE);
        baseballNumber.setRandomNumber(lst);
        return lst;
    }

    public List<String> getRandomNumber(int size) {
        List<String> lst = new ArrayList<>();

        //TODO : 예외처리 ? 2depth -> 1depth
        do {
            getValidateNumber(lst, Integer.toString(Randoms.pickNumberInRange(1, 9)));
        } while (lst.size() != size);

        //String result = listToString(lst);
        baseballNumber.setRandomNumber(lst);
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
    public BaseballResult checkBallResult() {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < BASEBALL_SIZE; i++) {

        }
        return new BaseballResult(strike, ball);
    }

    private int checkStrike(int index) {
        if (baseballNumber.getRandomNumber().get(index) == baseballNumber.getInputNumber().get(index)) {
            return 1;
        }
        return 0;
    }

    private int checkBall(int index) {
        if (baseballNumber.getRandomNumber().get(index) != baseballNumber.getInputNumber().get(index)
                && baseballNumber.getRandomNumber().contains(baseballNumber.getInputNumber().get(index))) {
            return 1;
        }
        return 0;
    }


}
