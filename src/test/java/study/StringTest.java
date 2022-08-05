package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class StringTest {

    @Test
    void TC01_Split1_1(){
        String input = "1,2";
        String[] spt = input.split(",");

        assertThat(spt.length).isEqualTo(2);
        assertThat(spt).contains("1", "2");
        assertThat(spt).containsExactly("1", "2");
    }

    @Test
    void TC01_Split1_2(){
        String input = "1";
        String[] spt = input.split(",");

        assertThat(spt.length).isEqualTo(1);
        assertThat(spt).contains("1");
        assertThat(spt).containsExactly("1");
    }

    @Test
    void TC02_Substring2(){
        String input = "(1,2)";
        String result = input.substring(1, input.length()-1);

        assertThat(result.length()).isEqualTo(input.length()-2);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("@DisplayName을 활용해 테스트 메소드의 의도를 드러낸다. String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면\n" +
            "StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void TC03_Substring3(){
        String input = "abc";
        char result = input.charAt(0);

        assertThat(result).isEqualTo('a');
        assertThatThrownBy(()-> input.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("out of range");
    }
}
