package Bitwise_operations;
/*
* Find the 2 odd occurence numbers in the array
* Time complexity : o(n)
*
* space complexity : o(1)
* */


public class Problem_2_Find_2_odd_occurence_numbers {

    private static int xor_traverse(int[] array) {
        int result = 0;
        for (int i=0;i<array.length;i++){
            result = result ^ array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {5,5,5,6,6,7,8,8};
        int result_1 = 0;
        int result_2 = 0;

        //Find the xor for whole array
        int xor_first = xor_traverse(array);

        int set_difference = (xor_first  & (~(xor_first - 1)));
        System.out.println(set_difference);

        for(int i=0;i<array.length;i++){
            if ((set_difference & array[i]) != 0){
                result_1 = result_1 ^ array[i];
            }
            else{
                result_2 = result_2 ^ array[i];
            }
        }
        System.out.println(result_1 + "   "+result_2);

    }


}
