package greedy;

/**
 * 거스름돈
 * 500원 100원 50원 10원
 * N : 손님에게 거슬러 줘야 할 돈
 * 거슬러 줘야 할 동전의 최소 개수
 * 단, 거슬러 줘야 할 돈 N은 항상 10의 배수
 */
public class Change {

    public int solution(int n) {
        int count = 0;

        int[] coinTypes = {500,100,50,10};

        for(int i=0; i<coinTypes.length; i++) {
            int coin = coinTypes[i];
            count += n / coin;
            n %= coin;
        }
        return count;
    }


}
