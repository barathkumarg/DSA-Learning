package Recursion;

/*
* Print the steps for tower of hanoi
*
*
*
* */

public class problem_3_tower_of_hanoi {
    public static void toh(int pugs,char char_1,char char_2,char char_3){
        if (pugs==0)
            return;
        if (pugs == 1){ //base condition
            System.out.println(char_1 + " is moved to "+char_3);
            return;
        }
        toh(pugs-1,char_1,char_3,char_2);
        System.out.println(char_1 + " is moved to "+char_3);
        toh(pugs-1,char_2,char_1,char_3);

    }

    public static void main(String[] args) {
        int pugs = 4;
        toh(pugs,'A','B','C');

    }
}
