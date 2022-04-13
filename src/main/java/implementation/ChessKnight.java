package implementation;

import java.util.Arrays;

public class ChessKnight {

    /**
     * 행복 왕국의 왕실 정원은 체스판과 같은 8 X 8 좌표 평면이다.
     * 왕실 정원의 특정한 한 칸에 나이트가 서 있다. 나이트는 매우 충성스러운 신하로서 매일 무술을 연마한다.
     * 나이트는 말을 타고 있기 때문에 이동을 할 때는 L자 형태로만 이동할 수 있으며 정원 밖으로는 나갈 수 없다.
     * 나이트는 특정한 위치에서 다음과 같은 2가지 경우로 이동할 수 있다.
     * 1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
     * 2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
     * 수평 a,b,c,d,e,f,g,h
     * 수직 1,2,3,4,5,6,7,8
     * 이처럼 8 X 8 좌표 평면상에서 나이트의 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 작성
     * 이때 왕실의 정원에서 행 위치를 표현할 때는 1부터 8로 표현하며, 열 위치를 표현할 때는 a부터 h로 표현한다
     * 예를 들어 만약 나이트가 a1에 있을 때 이동할 수 있는 경우의 수는 다음 2가지이다.
     * a1의 위치는 좌표 평면에서 구석의 위치에 해당하며 나이트는 정원의 밖으로는 나갈 수 없기 때문이다
     * 1. 오른쪽으로 두 칸 이동 후 아래로 한 칸 이동하기(c2)
     * 2. 아래로 두 칸 이동한 뒤에 오른쪽으로 한 칸 이동하기(b3)
     * 또 다른 예로 나이트가 c2에 위치해 있다면 나이트가 이동할 수 있는 경우의 수는 6가지이다.
     * @param cordinates 첫째 줄에 8 X 8 좌표 평면상에서 현재 나이트가 위치한 곳의 좌표를 나타내는 두 문자로 구성된 문자열(열과 행)
     * @return 첫째 줄에 나이트가 이동할 수 있는 경우의 수
     */
    public int solution(String cordinates) {
        int answer = 0;

        String[] columns = {"a","b","c","d","e","f","g","h"};
        int[] rows = {1,2,3,4,5,6,7,8};

        String column = cordinates.split("")[0];
        int row = Integer.valueOf(cordinates.split("")[1]);

        System.out.println("column = " + column);
        System.out.println("row = " + row);

        // 수평이동
        if(moveColumn(column, 2)) {
            if(moveRow(row, 1)) answer++;
            if(moveRow(row, -1)) answer++;
        }
        if(moveColumn(column, -2)) {
            if(moveRow(row, 1)) answer++;
            if(moveRow(row, -1)) answer++;
        }

        // 수직이동
        if(moveRow(row, 2)) {
            if(moveColumn(column, 1)) answer++;
            if(moveColumn(column, -1)) answer++;
        }
        if(moveRow(row, -2)) {
            if(moveColumn(column, 1)) answer++;
            if(moveColumn(column, -1)) answer++;
        }

        return answer;
    }

    public boolean moveColumn(String column, int move) {
        String[] columns = {"a","b","c","d","e","f","g","h"};
        int columnIndex = Arrays.asList(columns).indexOf(column);
        return columnIndex + move >= 0;
    }
    public boolean moveRow(int row, int move) {
        Integer[] rows = {1,2,3,4,5,6,7,8};
        int rowIndex = Arrays.asList(rows).indexOf(row);
        return rowIndex + move >= 0;
    }

}
