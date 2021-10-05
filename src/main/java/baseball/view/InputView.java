package baseball.view;

import baseball.model.BaseballNumber;

import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static BaseballNumber userInput(){
        System.out.println("숫자를 입력해주세요:");
        try {
            String numbers = sc.next();
            return BaseballNumber.input(numbers);
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
            String num = sc.next();
            ContinueSwitch continueSwitch = new ContinueSwitch();
            return continueSwitch.isRestart(num);
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return continuePlay();
        }
    }


}
