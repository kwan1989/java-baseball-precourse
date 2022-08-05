package baseball.view;

import baseball.model.BaseballInputNumber;
import baseball.model.BaseballRandomNumber;
import baseball.model.BaseballResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class OutputViewTest {

    BaseballResult baseballResult;
    OutputView outputView;
    BaseballRandomNumber baseballRandomNumber;
    BaseballInputNumber baseballInputNumber;

    @BeforeEach
    void init(){
        outputView = new OutputView();
    }

    @Test
    void TC01_결과확인() {

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
        baseballResult = new BaseballResult(3,0);
        assertThat(outputView.userOutput(baseballResult)).isTrue();

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
        baseballResult = new BaseballResult(1,1);

        assertThat(outputView.userOutput(baseballResult)).isFalse();
    }
}
