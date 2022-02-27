package greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UntilOneTest {

    UntilOne untilOne = new UntilOne();

    @Test
    void solution1() {
        int n = 25;
        int k = 5;

        int answer = untilOne.solution(n, k);

        Assertions.assertThat(answer).isEqualTo(2);
    }

    @Test
    void solution2() {
        int n = 25;
        int k = 5;

        int answer = untilOne.betterSolution(n, k);

        Assertions.assertThat(answer).isEqualTo(2);
    }
}