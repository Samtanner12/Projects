import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        while ((line = br.readLine()) != null && !line.isEmpty()) {

            int numline = Integer.parseInt(line);
            int[][] g = new int[numline][numline];

            int par3, par, par2;
            StringTokenizer stringtok;
            for (int i = 0; i < numline; i++) {
                stringtok = new StringTokenizer(br.readLine());
                par = Integer.parseInt(stringtok.nextToken());
                par--;
                par3 = Integer.parseInt(stringtok.nextToken());
                for (int j = 0; j < par3; j++) {
                    par2 = Integer.parseInt(stringtok.nextToken());

                    par2--;

                    g[par][par2] = 1;
                }
            }

            for (int i = 0; i < numline; i++) {
                for (int j = 0; j < numline; j++) {
                    if (j < numline - 1) {

                        System.out.print(g[i][j] + " ");

                    } else {

                        System.out.print(g[i][j] + "\n");
                    }
                }

            }
        }

    }
}
