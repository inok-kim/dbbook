package greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ChangeTest {

    Change change = new Change();

    @Test
    void solution() {
        int n = 1260;
        int answer = change.solution(n);
        Assertions.assertThat(answer).isEqualTo(6);
    }
}