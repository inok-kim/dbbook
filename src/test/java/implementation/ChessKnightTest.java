package implementation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChessKnightTest {

    ChessKnight chessKnight = new ChessKnight();

    @Test
    void solution() {
        String cordinates = "a1";
        int answer = 2;
        int result = chessKnight.solution(cordinates);
        Assertions.assertThat(result).isEqualTo(answer);
    }

    @Test
    void solution2() {
        String cordinates = "c2";
        int answer = 6;
        int result = chessKnight.solution(cordinates);
        Assertions.assertThat(result).isEqualTo(answer);
    }

}