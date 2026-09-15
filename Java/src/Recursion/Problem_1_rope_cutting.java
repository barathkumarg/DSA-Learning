package Recursion;
import java.lang.Math;
import java.util.ArrayList;

/* Cut the rope with the given size atlast it should be cut in given length, number of times may be anything
*  if length = 12 cuts = (3,4,6)
* => possible ways (3,3,3,3),  (4,4,4)  (3,6,3) (6,6)
*
*
* */


public class Problem_1_rope_cutting {

    public static int rope_cutting(int lenght,int cut_1,int cut_2,int cut_3){
        if (lenght == 0)
            return 0;
        if (lenght < 0 )
            return -1;

        int result = Math.max(rope_cutting(lenght-cut_1,cut_1,cut_2,cut_3),
                Math.max(rope_cutting(lenght-cut_2,cut_1,cut_2,cut_3),
        rope_cutting(lenght-cut_3,cut_1,cut_2,cut_3)));

        if(result == -1)
            return -1;
//        System.out.println(lenght);
        return result+1;

    }

    public static void main(String[] args) {

        int length = 12;
        int cut_1 = 3;
        int cut_2 = 4;
        int cut_3 = 6;


        System.out.println(rope_cutting(length,cut_1,cut_2,cut_3));


   }
}
