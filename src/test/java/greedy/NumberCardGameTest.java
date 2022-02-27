package greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberCardGameTest {

    NumberCardGame numberCardGame = new NumberCardGame();

    @Test
    void solution1() {
        int[] a = {3,3};
        int[][] b = {{3,1,2},{4,1,4},{2,2,2}};

        int answer = numberCardGame.solution(a, b);

        Assertions.assertThat(answer).isEqualTo(2);
    }

    @Test
    void solution2() {
        int[] a = {2,4};
        int[][] b = {{7,3,1,8},{3,3,3,4}};

        int answer = numberCardGame.solution(a, b);

        Assertions.assertThat(answer).isEqualTo(3);
    }
}