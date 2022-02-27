package implementation;

public class UpDownLeftRight {
    /**
     * 여행가는 N x N 크기의 정사각형 공간 위에 서 있다
     * 이 공간은 1 x 1 크기의 정사각형으로 나누어져 있다
     * 가장 왼쪽 위 좌표는 (1,1)이며, 가장 오른쪽 아래 좌표는 (N,N)에 해당한다.
     * 여행가 A는 상, 하, 좌, 우 방향으로 이동할 수 있으며, 시작 좌표는 항상 (1,1)이다
     * 우리 앞에는 여행가 A가 이동할 계획이 적힌 계획서가 놓여있다
     * 계획서에는 하나의 줄에 띄어쓰기를 기준으로 하여 L,R,U,D 중 하나의 문자가 반복적으로 적혀있다. 각 문자의 의미는 다음과 같다
     * L : 왼쪽으로 한 칸 이동
     * R : 오른쪽으로 한 칸 이동
     * U : 위로 한 칸 이동
     * D : 아래로 한 칸 이동
     * 이때 여행가 A가 N x N 크기의 정사각형 공간을 벗어나는 움직임은 무시된다. 예를 들어 (1,1)의 위치에서 L 혹은 U를 만나면 무시된다.
     * 이 경우 6개의 명령에 따라서 여행가가 움직이게 되는 위치는 순서대로 (1,2), (1,3), (1,4), (1,4), (2,4), (3,4)이므로, 최종적으로 여행가 A가 도착하게 되는 곳의 좌표는 (3,4)이다
     * 다시 말해 3행의 4열의 위치에 해당하므로 (3,4)라고 적는다.
     * 계획서가 주어졌을 때 여행가 A가 최종적으로 도착할 지점의 좌표를 출력하는 프로그램을 작성하시오
     * [입력조건]
     * 첫째 줄에 공간의 크기를 나타내는 N이 주어진다 ( 1<=N<=100 )
     * 둘째 줄에 여행가 A가 이동할 계획서 내용이 주어진다 ( !<=이동횟수<=100 )
     * [출력조건]
     * 첫째 줄에 여행가 A가 최종적으로 도착할 지점의 좌표(X,Y)를 공백으로 구분하여 출력한다
     */
    public int[] solution(int n, String[] plans) {
        int[] answer = new int[2];
        int cnt = 0;
        answer[0]=1;
        answer[1]=1;

        for(String plan : plans) {
            if(plan.equals("L")) {
                int y = answer[1];
                if(y == 1) continue;
                answer[1] = y-1;
            }
            if(plan.equals("R")) {
                int y = answer[1];
                if(y == n) continue;
                answer[1] = y+1;

            }
            if(plan.equals("D")) {
                int x = answer[0];
                if(x == n) continue; // n이면 더 못내려감
                answer[0] = x+1;
            }
            if(plan.equals("U")) {
                int x = answer[0];
                if(x == 1) continue; // 1이면 더 못올라감
                answer[0] = x-1;
            }
            cnt++;
            if(cnt == 5) {
                break;
            }
        }

        return answer;
    }

    public int[] solutionInBook(int n, String[] plans) {
        int[] answer = new int[]{1,1};

        // L,R,U,D에 따른 이동 방향
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        String[] moveTypes = {"L","R","U","D"};

        int moveX = answer[0];
        int moveY = answer[1];
        // 이동 계획을 하나씩 확인
        for(String plan : plans) {
            for(int i=0; i<moveTypes.length; i++) {
                if(plan.equals(moveTypes[i])) {
                    moveX = answer[0] + dx[i];
                    moveY = answer[1] + dy[i];
                }
            }
            // 공간을 벗어나는 경우 무시
            if(moveX < 1 || moveY < 1 || moveX > n || moveY > n) {
                continue;
            }
            answer[0] = moveX;
            answer[1] = moveY;
        }

        return answer;
    }
}
