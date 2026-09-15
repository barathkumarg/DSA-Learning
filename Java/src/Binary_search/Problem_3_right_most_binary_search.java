package Binary_search;

public class Problem_3_right_most_binary_search {
    static int rightbinarysearch(int N, int arr[], int X)
    {
        int left = 0;
        int right = N-1;
        while (right>=left){

            int mid = (right + left) / 2;

            if((mid==N-1 || arr[mid+1] > X) && arr[mid] == X){

                return mid;
            }

            else if(arr[mid] > X){ //search for the right most side
                right = mid - 1;


            }
            else{
                left = mid + 1;
            }
        }
        return -1;


    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,7,8};

        System.out.println(rightbinarysearch(9,arr,7));

    }
}
