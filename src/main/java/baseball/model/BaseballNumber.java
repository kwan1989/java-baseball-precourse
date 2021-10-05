package baseball.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumber {

    private static final String SIZE_EXCEPTION = "자리수가 올바르지 않습니다.";
    private static final String DUPLICATE_EXCEPTION = "중복된 숫자가 있습니다.";
    private static final int BASEBALL_SIZE = 3;

    private List<String> randomNumber;
    private List<String> inputNumber;

    public List<String> getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(List<String> randomNumber) {
        this.randomNumber = randomNumber;
    }

    public List<String> getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(List<String> inputNumber) {
        this.inputNumber = inputNumber;
    }

    private void validation(){
        if (inputNumber.size() != BASEBALL_SIZE){
            throw new IllegalArgumentException(SIZE_EXCEPTION);
        }

        if (validateDeduplicationSize(randomNumber) != validateDeduplicationSize(inputNumber)){
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
        }
    }

    private int validateDeduplicationSize(List<String> number){
        Set<String> checker = new HashSet<>(number);
        return checker.size();
    }

    public static BaseballNumber input(String inputNum){
        char[] chaNums = inputNum.toCharArray();
        List<String> lst = new ArrayList<>();
        for (int i=0; i<inputNum.length(); i++){
            lst.add(Character.toString(chaNums[i]));
        }
        return new BaseballNumber(lst);
    }

    private BaseballNumber(List<String> input){
        validation();
        this.setInputNumber(input);
    }
}
