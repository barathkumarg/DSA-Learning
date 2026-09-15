package Math;

/*  sieve of erathanos
*  -> Construct the array with n integers
* -> mark and sweep method as follows  [0 1 2 3 4 5 6 7]
*
* */




import java.util.*;

public class Problem_4_sieve_of_eranthonas {

    public static void main(String[] args) {
        int num = 37 + 1;
        Boolean[] arr = new Boolean[num];
        Arrays.fill(arr, true);

        for (int i = 2; i < num; i++) {

            if (arr[i]) {
                System.out.println(i);
                for (int j = i * i; j < num; j += i) {
                    arr[j] = false;
                }
            }
        }
    }
}
