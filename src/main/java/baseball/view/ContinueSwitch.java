package baseball.view;

public class ContinueSwitch {

    public boolean isRestart(String inputNum){
        if (inputNum.equals("1")){
            return true;
        }

        if (inputNum.equals("2")){
            return false;
        }

        if (!inputNum.equals("1")
                || !inputNum.equals("2") ){
            throw new IllegalArgumentException("올바른 선택값이 아닙니다.");
        }
        return false;
    }
}
