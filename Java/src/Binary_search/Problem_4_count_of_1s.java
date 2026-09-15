package Binary_search;

public class Problem_4_count_of_1s {

    public static int countOnes(int arr[], int N){

        int left = 0;
        int right = N - 1;

        while(right>=left){

            int mid = (left + right) / 2;

            if ((mid==N-1 || arr[mid + 1] ==0) && arr[mid] == 1){
                return mid + 1;
            }
            else if(arr[mid] == 0){

                right = mid-1;
            }
            else{
                left = mid +1;
            }

        }
        return 0;

    }

    public static void main(String[] args) {
        int []arr = {1,1,1,1,1,0,0,0,0,0}; //non increasing binary array
        System.out.println(countOnes(arr,arr.length));
    }
}
