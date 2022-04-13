package implementation;

public class TimeIncludesThree {

    /**
     * 정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성
     * 예를 들어 1을 입력했을 때 다음은 3이 하나라도 포함되어 있으므로 세어야 하는 시각이다.
     * - 00시 00분 03초
     * - 00시 13분 30초
     * 반면에 다음은 3이 하나도 포함되어 있지 않으므로 세면 안 되는 시각이다.
     * - 00시 02분 55초
     * - 01시 27분 45초
     * @param n 첫째 줄에 정수 N이 입력( 0 <= N <= 23)
     * @return answer 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 출력
     */
    public int solution(int n) {
        int answer = 0 ;

        // 완전 탐색, 비효율적
        for(int h = 0; h <= n; h++) {
            for(int m = 0; m <= 59 ; m++){
                for(int s = 0; s <= 59 ; s++) {
                    if(
                        String.valueOf(h).indexOf("3") >= 0 ||
                        String.valueOf(m).indexOf("3") >= 0 ||
                        String.valueOf(s).indexOf("3") >= 0
                    )
                        answer++;
                }
            }
        }

        return answer;
    }
}
