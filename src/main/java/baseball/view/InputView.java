package baseball.view;

import baseball.model.BaseballInputNumber;
import nextstep.utils.Console;

public class InputView {

    public static BaseballInputNumber userInput(){
        System.out.println("숫자를 입력해주세요:");
        try {
            String numbers = Console.readLine();
            return BaseballInputNumber.input(numbers);
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            return userInput();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return userInput();
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
            return userInput();
        }
    }

    public static boolean continuePlay(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try{
            String num = Console.readLine();
            ContinueSwitch continueSwitch = new ContinueSwitch();
            return continueSwitch.isRestart(num);
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return continuePlay();
        }
    }


}
