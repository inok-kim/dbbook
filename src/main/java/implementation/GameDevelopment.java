package implementation;

public class GameDevelopment {

    /**
     * 현민이는 게임 캐릭터가 맵 안에서 움직이는 시스템을 개발 중이다.
     * 캐릭터가 있는 장소는 1 X 1 크기의 정사각형으로 이뤄진 N X M 크기의 직사각형으로, 각각의 칸은 육지 또는 바다이다.
     * 캐릭터는 동서남북 중 한 곳을 바라본다.
     * 맵의 각 칸은 (A,B)로 나타낼 수 있고, A는 북쪽으로부터 떨어진 칸의 개수, B는 서쪽으로부터 떨어진 칸의 개수이다.
     * 캐릭터는 상하좌우로 움직일 수 있고, 바다로 되어 있는 공간에는 갈 수 없다.
     * 캐릭터의 움직임을 설정하기 위해 정해 놓은 매뉴얼은 이러하다.
     * 1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향(반시계 방향으로 90도 회전한 방향)부터 차례대로 갈 곳을 정한다.
     * 2. 캐릭터의 바로 왼쪽 방향에 아직 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전한 다음 왼쪽으로 한 칸을 전진한다.
     * 왼쪽 방향에 가보지 않은 칸이 없다면, 왼쪽 방향으로 회전만 수행하고 1단계로 돌아간다.
     * 3. 만약 네 방향 모두 이미 가본 칸이거나 바다로 되어 있는 칸인 경우에는, 바라보는 방향을 유지한 채로 한 칸 뒤로 가고 1단게로 돌아간다.
     * 단, 이때 뒤쪽 방향이 바다인 칸이라 뒤로 갈 수 없는 경우에는 움직임을 멈춘다.
     * 현민이는 위 과정을 반복적으로 수행하면서 캐릭터의 움직임에 이상이 있는지 테스트하려고 한다.
     * 매뉴얼에 따라 캐릭터를 이동시킨 뒤에, 캐릭터가 방문한 칸의 수를 출력하는 프로그램을 만드시오.
     *
     * 입력조건
     * - 첫째 줄에 맵의 세로 크기 N과 가로 크기 M을 공백으로 구분하여 입력한다. ( 3 <= N,M <= 50 )
     * - 둘째 줄에 게임 캐릭터가 있는 칸의 좌표(A,B)와 바라보는 방향 d가 각각 서로 공백으로 구분하여 주어진다.
     * 방향 d의 값으로는 다음과 같이 4가지가 존재한다.
     * 0: 북쪽
     * 1: 동쪽
     * 2: 남쪽
     * 3: 서쪽
     * - 셋째 줄부터 맵이 육지인지 바다인지에 대한 정보가 주어진다. N개의 줄에 맵의 상태가 북쪽부터 남쪽 순서대로, 각 줄의 데이터는 서쪽부터 동쪽 순서대로 주어진다.
     * 맵의 외곽은 항상 바다로 되어 있다.
     * 0: 육지
     * 1: 바다
     * - 처음에 게임 캐릭터가 위치한 칸의 상태는 항상 육지이다.
     * @return 첫째 줄에 이동을 마친 후 캐릭터가 방문한 칸의 수를 출력한다.
     */
    public int solution(int[] size, int[] position, int[][] mapStatus) {

        // 처음 서있는 자리 포함해서 1
        int answer = 1;

        int n = size[0];
        int m = size[1];
        int[][] map = new int[n][m];

        // 현재위치
        int x = position[0];
        int y = position[1];
        int direction = position[2];

        // 서있는 곳 체크
        map[x][y] = 1;

        // 북, 동, 남, 서
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        int turnTime = 0;

        while(true) {
            // 왼쪽으로 회전
            direction = turnLeft(direction);

            // 왼쪽으로 이동해서 한 칸 옮긴 곳 좌표 구하기
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 가본적 없고 육지인 곳
            if(map[nx][ny] == 0 && mapStatus[nx][ny] == 0) {
                map[nx][ny] = 1;
                x = nx;
                y = ny;
                answer++;
                turnTime = 0;
                continue;
            }else {
                turnTime++;
            }

            if(turnTime == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];
                if(mapStatus[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                }else {
                    break;
                }
                turnTime = 0;
            }
        }


        return answer;

    }

    public int turnLeft(int direction) {
        direction -= 1;
        return direction == -1 ? 3 : direction;
    }


}
