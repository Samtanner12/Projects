import java.util.*;
public class Main {
    static int X[][];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int next=in.nextInt(); X =new int[next][next];
        for(int i=0;i<next;i++) {
            for(int j=0;j<next;j++) X[i][j]=Integer.parseInt(in.next());
        }
        prim(next);
    }
    static void prim(int input) {
        int INFINITY=2000000000, a[]=new int[input], b[]=new int[input];
        char charIn[]=new char [input];
        for(int i=0;i<input;i++) {

            a[i]=INFINITY;
            charIn[i]='W';
        }
        a[0]=0; b[0]=-1;
        while(true) {
            int mincost=INFINITY,u=-1;
            for(int i=0;i<input;i++) {

                if(charIn[i] !='B' && a[i]<mincost) {
                    mincost=a[i];
                    u=i;
                }}
            if(mincost==INFINITY)break;
            charIn[u]='B';
            for(int j=0;j<input;j++) {
                if (charIn[j] != 'B' && X[u][j] != -1) {
                    if (X[u][j] < a[j]) {
                        a[j] = X[u][j];
                        b[j] = u;
                        charIn[j] = 'G';
                    }}
            }}
        int endsum =0;
        for(int i=1;i<input;i++) {
            endsum += X[i][b[i]];
        }
        System.out.println(endsum);
    }}

