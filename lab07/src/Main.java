import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private int counter;
    private int[] a;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            int nico = Integer.parseInt(in.readLine());
            String[] se = in.readLine().split(" ");

            a = new int[nico];
            for (int i = 0; i < nico; i++) {
                a[i] = Integer.parseInt(se[i]);
            }

            mergeSort(0, nico);

            System.out.print(a[0]);
            for (int i = 1; i < nico; i++) {
                System.out.print(" " + a[i]);
            }
            System.out.println();
            System.out.println(counter);
        } catch (NumberFormatException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
//merge





    public void merge(int left, int middle, int right) {
        int n1 = middle - left;
        int n2 = right - middle;

        int[] l = new int[n1];
        int[] r = new int[n2];

        for (int i = 0; i < n1; i++) {
            l[i] = a[left + i];
        }

        for (int i = 0; i < n2; i++) {
            r[i] = a[middle + i];
        }

        int i = 0;
        int j = 0;
        for (int k = left; k < right; k++) {
            counter++;

            if (i == n1) {
                a[k] = r[j];
                j++;
                continue;
            }
            if (j == n2) {
                a[k] = l[i];
                i++;
                continue;
            }

            if (l[i] <= r[j]) {
                a[k] = l[i];
                i++;
            } else {
                a[k] = r[j];
                j++;
            }
        }
    }





    public void mergeSort(int left, int right) {
        if ((left + 1) < right) {
            int middle = (left + right) / 2;
            mergeSort(left, middle);
            mergeSort(middle, right);
            merge(left, middle, right);
        }
    }
}

