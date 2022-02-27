package greedy;

import java.util.Arrays;

public class MaxNumber {

    /**
     * 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만들기
     * 단, 배열의 특정한 인덱스에 해당하는 수가 연속해서 K번을 연속해서 더해질 수가 없다
     *
     * 배열의 크기 N, 숫자가 더해지는 횟수 M, 연속 가능 횟수 K
     */
    public int solution(int[] a, int[] b) {
        int answer = 0;

        int n = a[0];
        int m = a[1];
        int k = a[2];

        Arrays.sort(b);
        int max = b[n-1];
        int secondMax = b[n-2];

        int cnt = 0;
        for(int i=0; i<m; i++){
            if(cnt!=k) {
                answer+=max;
                cnt++;
            }else{
                answer+=secondMax;
                cnt=1;
            }
        }


        return answer;
    }

    public int betterSolution(int[] a, int[] b) {
        int answer = 0;

        int n = a[0];
        int m = a[1];
        int k = a[2];

        Arrays.sort(b);
        int max = b[n-1];
        int secondMax = b[n-2];

        // 가장 큰 수가 더해지는 횟수 계산
        int count = (m / (k+1)) * k; // 최대 k번까지 더 할 수 있으므로 k+1을 해줘야 연속하지 않은 횟수 구할 수 있음, +1이 secondMax를 의미
        count += m % (k+1); // 나머지 더해줌

        answer += count*max;
        answer += (m-count) * secondMax;

        return answer;
    }
}
