package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class BaseballRandomNumber extends Validation {

    private List<String> randomNumber;

    public List<String> getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(List<String> randomNumber) {
        this.randomNumber = randomNumber;
    }

    public static BaseballRandomNumber input(String number) {
        char[] chaNums = number.toCharArray();
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            lst.add(Character.toString(chaNums[i]));
        }
        return new BaseballRandomNumber(lst);
    }

    public BaseballRandomNumber(List<String> number) {
        super(number);
        this.setRandomNumber(number);
    }
}
