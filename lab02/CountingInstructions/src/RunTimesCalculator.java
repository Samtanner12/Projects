public class RunTimesCalculator {
        static void instrCount(int num){
            int n = num;
            int sum2 = 0;
            int opCounter=0;
            int opCounter2=0;
            for(int i = 1; i <= n; i ++) {
                 opCounter++;
                for (int j = 1; j <= n; j++){
                     opCounter++;
                     sum2++;
                    opCounter++;
            }}
            System.out.println("example 1:");
            System.out.println("n = "+n+"      instrCounter = "+opCounter+"   (instrCounter / n) ="+opCounter/n);

            int sum3 = 0;
            for(int i = 1; i <= n; i ++) {
                 opCounter2++;
                for (int j = 1; j <= i; j++) {
                     opCounter2++;
                      sum3++;
                    opCounter2++;

                }
            }
            System.out.println("example 2:");
            System.out.println("n = "+n+"      instrCounter = "+opCounter2+"   (instrCounter / n) ="+opCounter2/n);

        }
    public static void main(String[] args){

    }


}
