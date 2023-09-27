import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();


        int[][] z    = new int[num+1][num+1];
        int[] finder   = new int[num+1];
        int[] end = new int[num+1];




        for (int i = 0; i < num; i++) {
            int u = scanner.nextInt();

            int k = scanner.nextInt();
            for (int j = 0; j < k; j++) {
                int v = scanner.nextInt();
                z[u][v] = 1;
            }
        }

        Deque<Integer> dequer = new ArrayDeque<Integer>();
        int time = 0;
        for (int k = 1; k <= num; k++ ) {
            if (finder[k] != 0) continue;


            dequer.push(k);
            while(!dequer.isEmpty()) {
                int top = dequer.peek();
                if (finder[top] == 0) finder[top] = ++time;
                int j;
                for (j = 1; j <= num; j++) {
                    if (z[top][j] == 1 && finder[j] == 0) {
                        dequer.push(j);
                        finder[j] = ++time;
                        break;
                    }
                }
                if (j == num + 1) {
                    dequer.pop();
                    end[top] = ++time;
                }
            }
        }



        for (int i = 1; i <= num; i++) {
            System.out.println(i + " " + finder[i] + " " + end[i]);
        }
    }
}