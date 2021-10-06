package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void init(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(5);
        numbers.add(5);
    }

    @Test
    void TC01_Set_크기(){
        assertThat(numbers.size()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void TC02_Set_존재여부(int val){
        assertThat(numbers.contains(val)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:true","5:true","6:false","7:false"}, delimiter = ':')
    void TC03_Set_리턴타입변경(int val, boolean result){
        assertThat(numbers.contains(val)).isEqualTo(result);
    }

}
