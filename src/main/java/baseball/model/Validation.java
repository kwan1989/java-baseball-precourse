package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    private static final String SIZE_EXCEPTION = "[ERROR] 자리수가 올바르지 않습니다.";
    private static final String DUPLICATE_EXCEPTION = "[ERROR] 중복된 숫자가 있습니다.";
    private static final int BASEBALL_SIZE = 3;

    public Validation(List<String> lst) {
        validation(lst);
    }

    private void validation(List<String> number) {
        if (number.size() != BASEBALL_SIZE) {
            throw new IllegalArgumentException(SIZE_EXCEPTION);
        }

        if (validateDeduplicationSize(number) != BASEBALL_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
        }
    }

    private int validateDeduplicationSize(List<String> number) {
        Set<String> checker = new HashSet<>(number);
        return checker.size();
    }

}
