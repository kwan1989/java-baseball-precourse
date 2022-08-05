package baseball.service;

import baseball.model.BaseballInputNumber;
import baseball.model.BaseballRandomNumber;
import baseball.model.BaseballResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class BaseballServiceTest {

    BaseballService baseballService;
    BaseballRandomNumber baseballRandomNumber;
    BaseballInputNumber baseballInputNumber;


    @BeforeEach
    void init() {
        baseballService = new BaseballService();
    }

    @Test
    void TC01_중복숫자() {
        baseballRandomNumber = new BaseballRandomNumber(baseballService.getRandomNumber());
        String[] result = baseballRandomNumber.getRandomNumber().toArray(new String[0]);
        assertThat(result).doesNotHaveDuplicates();
    }

    @Test
    void TC02_결과확인() {

        // TC-1
        List<String> randomNum = new ArrayList<>();
        List<String> inputNum = new ArrayList<>();
        randomNum.add("1");
        randomNum.add("2");
        randomNum.add("3");
        inputNum.add("1");
        inputNum.add("2");
        inputNum.add("3");
        baseballRandomNumber = new BaseballRandomNumber(randomNum);
        baseballInputNumber = new BaseballInputNumber(inputNum);
        BaseballResult result =  baseballService.checkBallResult(baseballRandomNumber, baseballInputNumber);
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);

        // TC-2
        randomNum = new ArrayList<>();
        inputNum = new ArrayList<>();
        randomNum.add("1");
        randomNum.add("2");
        randomNum.add("3");
        inputNum.add("1");
        inputNum.add("3");
        inputNum.add("5");
        baseballRandomNumber = new BaseballRandomNumber(randomNum);
        baseballInputNumber = new BaseballInputNumber(inputNum);
        result =  baseballService.checkBallResult(baseballRandomNumber, baseballInputNumber);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }
}
