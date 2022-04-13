package implementation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameDevelopmentTest {

    GameDevelopment gameDevelopment = new GameDevelopment();

    @Test
    void solution() {
        int[] size = {4, 4};
        int[] position = {1, 1, 0};
        int[][] mapStatus = {{1, 1, 1, 1,}, {1, 0, 0, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}};
        int result = gameDevelopment.solution(size, position, mapStatus);
        Assertions.assertThat(result).isEqualTo(3);
    }
}