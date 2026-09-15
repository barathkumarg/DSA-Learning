package Binary_search;

public class Problem_1_simple_binary_search {

    static int binarysearch(int N, int arr[], int X)
    {
        int left = 0;
        int right = N-1;
        while (right>=left){

            int mid = (right + left) / 2;

            if(arr[mid] == X){

                return mid;
            }

            else if(arr[mid] < X){
                left = mid + 1;

            }
            else{
                right = mid - 1;
            }
        }
        return -1;


    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};

        System.out.println(binarysearch(7,arr,3));

    }
}
