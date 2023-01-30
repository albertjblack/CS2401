package Arrays;

class sameEnds {
    public static void main(String args[]) {
        int arr[] = { 5, 6, 7, 9, 13, 5, 6 };
        int n = 2;
        System.out.println(hasSameEnds(arr, n));
    }

    public static boolean hasSameEnds(int[] nums, int len) {

        // Jose A. Robles Tostado

        int n = len;
        int idx2 = nums.length - n;
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[idx2]) {
                return false;
            }
            idx2++;
        }

        return true;

    }
}
