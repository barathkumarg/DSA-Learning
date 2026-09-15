package Binary_search;

public class Problem_5_find_square_root {
    public static long floorSqrt(long x)
    {
        long left = 0;
        long right = x;
        long result = 0;
        while(right >= left){
            long mid = (left + right) / 2;

            long mid_square = mid * mid; //square calculation

            if(mid_square == x){
                return mid;
            }
            else if (mid_square < x){
                result = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(89));
    }
}
