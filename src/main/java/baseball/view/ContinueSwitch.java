package baseball.view;

public class ContinueSwitch {

    /**
     * 시작 | 종료 스위치
     * @param inputNum
     * @return
     */
    public boolean isRestart(String inputNum){
        if (inputNum.equals("1")){
            return true;
        }

        if (inputNum.equals("2")){
            return false;
        }

        if (!inputNum.equals("1")
                || !inputNum.equals("2") ){
            throw new IllegalArgumentException("[ERROR] 올바른 선택값이 아닙니다.");
        }
        return false;
    }
}
