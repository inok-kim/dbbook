package greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxNumberTest {
    MaxNumber maxNumber = new MaxNumber();

    @Test
    void solution() {
        int[] a =  {5,8,3};
        int[] b = {2,4,5,4,6};
        int answer = maxNumber.solution(a, b);
        Assertions.assertThat(answer).isEqualTo(46);
    }

}