import java.util.Random;

public class randomDNA {


        public static void main(String[] args)

        {

            Random rnd = new Random();
            String[] dna = {"A", "T", "C", "G"};
            String solutionStr = "";
            for (int i = 0; i < 20; i++) {

                int t = rnd.nextInt(4);
                solutionStr += (dna[t]);
            }

            System.out.println(solutionStr);
        }


}
