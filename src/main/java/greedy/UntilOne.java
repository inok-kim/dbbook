package greedy;

public class UntilOne {
    /**
     * 어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 한다
     * 단, 두 번째 연산은 N이 K로 나누어떨어질 때만 선택할 수 있다
     *
     * 1. N에서 1을 뺀다
     * 2. N을 K로 나눈다
     *
     * 예를 들어 N이 17, K가 4라고 가정하자. 이때 1번의 과정을 한 번 수행하면 N은 16이 된다. 이후에 2번의 과정을 두 번 수행하면 N은 1이 된다.
     * 결과적으로 이 경우 전체 과정을 실행한 횟수는 3이 된다. 이는 N을 1로 만드는 최소 횟수이다.
     * N과 K가 주어질 때 N이 1이 될 때까지 1번 혹은 2번의 과정을 수행해야 하는 최소 횟수를 구하는 프로그램을 작성하시오.
     *
     */
    public int solution(int n, int k) {
       int answer = 0;
       // 나누기를 최대한 많이 하자 , 뺴기보다 나누기가 숫자를 훨씬 많이 줄일 수 있다
        while(n!=1) {
            if(n % k == 0) {
                n /= k;
            }else {
                n -= 1;
            }
            answer++;
        }

       return answer;
    }

    public int betterSolution(int n, int k) {
        int answer = 0;
        // 나누기를 최대한 많이 하자 , 뺴기보다 나누기가 숫자를 훨씬 많이 줄일 수 있다
        // N이 K의 배수가 되도록 효율적으로 한번에 빼는 방식으로 작성하면 빠르게 동작
        while(n!=1) {
            if(n % k == 0) {
                n /= k;
                answer++;
            }else {
                n -= n % k ;
                answer += n % k;
            }
        }
        return answer;
    }

    public int betterSolutionInBook(int n, int k) {
        int answer = 0;
        while(true) {
            int target = (n/k)*k; // k배수
            answer += (n-target); // k배수 나머지로 해도 똑같..
            n = target; // k배수로 집어넣음
            if (n < k) break; // k배수로 나눌 수 없을 만큼 작으면 반복 멈춤
            answer += 1; // 나눌 수 있으니까 나누고 +1
            n /= k; // 나눈 값 n에 대입
        }

        answer += (n-1); // k보다 작은 수일 경우 나머지를 -1의 경우로 치고 더해주기
        return answer;
    }
}
