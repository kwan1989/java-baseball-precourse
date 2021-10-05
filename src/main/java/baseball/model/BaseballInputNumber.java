package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class BaseballInputNumber extends Validation {

    private List<String> inputNumber;

    public List<String> getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(List<String> inputNumber) {
        this.inputNumber = inputNumber;
    }

    public static BaseballInputNumber input(String number) {
        char[] chaNums = number.toCharArray();
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            lst.add(Character.toString(chaNums[i]));
        }
        return new BaseballInputNumber(lst);
    }

    public BaseballInputNumber(List<String> number) {
        super(number);
        this.setInputNumber(number);
    }

}
