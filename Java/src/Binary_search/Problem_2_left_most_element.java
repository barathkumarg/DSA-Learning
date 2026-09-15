package Binary_search;

public class Problem_2_left_most_element {
    static int leftbinarysearch(int N, int arr[], int X)
    {
        int left = 0;
        int right = N-1;
        while (right>=left){

            int mid = (right + left) / 2;

            if((mid==0 || arr[mid-1] < X) && arr[mid] == X){

                return mid;
            }

            else if(arr[mid] < X){ //search for the left most side
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

        System.out.println(leftbinarysearch(7,arr,3));

    }
}
