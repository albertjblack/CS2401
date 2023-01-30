package Arrays;

public class has12 {
    public static void main(String args[]) {

        int arr[] = { 3, 1, 4, 1, 6, 2 };
        System.out.println(getHas12(arr));

    }

    public static boolean getHas12(int[] nums) {

        // 1 2 works
        // 2 1 does not

        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1 && idx1 == -1) {
                idx1 = i;
            } else if (nums[i] == 2) {
                idx2 = i;
            }

            if (idx1 != -1 && idx2 != -1 && idx1 < idx2) {
                return true;
            }

        }
        return false;

    }
}
