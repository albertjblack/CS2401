public class BinarySearch {
    public static void main(String args[]) {
        int[] arr = { 0, 2, 3, 4, 5, 6, 7, 8 };
        int target = 2;

        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2; // mid either is center if odd or if even it will be the left of the center

        while (left <= right) {
            if (arr[mid] == target) {
                System.out.println("Found at index " + mid);
                break;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }

        if (left > right) {
            System.out.println("Not found");
        }

    }

}
