package implementation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpDownLeftRightTest {

    UpDownLeftRight upDownLeftRight = new UpDownLeftRight();

    @Test
    void solution() {
        int n = 5;
        String[] plan = {"R","R","R","U","D","D"};
        int[] answer = upDownLeftRight.solution(n,plan);
        Assertions.assertThat(answer).containsExactly(3,4);
    }

    @Test
    void solutionInBook() {
        int n = 5;
        String[] plan = {"R","R","R","U","D","D"};
        int[] answer = upDownLeftRight.solutionInBook(n,plan);
        Assertions.assertThat(answer).containsExactly(3,4);
    }
}