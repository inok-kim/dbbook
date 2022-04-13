package implementation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TimeIncludesThreeTest {

    TimeIncludesThree timeIncludesThree = new TimeIncludesThree();

    @Test
    void solution() {
        int n = 5;
        int answer = 11475;
        int result = timeIncludesThree.solution(n);
        assertThat(result).isEqualTo(answer);
    }
}