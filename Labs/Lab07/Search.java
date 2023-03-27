import java.util.Arrays;

class Search {
    public static void main(String args[]) {
        // number for averages of time of algorithms
        final int EPOCHS = 1_000_000;

        // size of array
        int size = 100_000;
        double arr[] = new double[size];

        // fill array

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random();
        }

        // time to sort array
        long start_sort = System.currentTimeMillis();
        Arrays.sort(arr);
        long end_sort = System.currentTimeMillis();
        System.out.println();
        System.out.printf("%.6f\n", ((double) (end_sort - start_sort)));

        // random value to find in array
        int index = (int) (Math.random() * size % size);
        double value_to_look_for = arr[index];
        System.out.println("Value to look for: " + value_to_look_for + " at index " + index);
        System.out.println();

        // sum for average calculation
        long sum_time_ls = 0, sum_time_bsi = 0, sum_time_bsr = 0;

        // test
        System.out.println("Linear s. idx:" + linear_search(arr, value_to_look_for));
        System.out.println("Binary s. it. idx:" + binary_search_iterative(arr, value_to_look_for));
        System.out.println("Binary s. rec. idx:" + binary_search_recursive(arr, value_to_look_for, 0, arr.length - 1));

        // times calculation // sum

        // time for linear search sum times
        System.out.println();
        for (int i = 0; i < EPOCHS; i++) {
            long start = System.currentTimeMillis();
            linear_search(arr, value_to_look_for);
            long end = System.currentTimeMillis();
            sum_time_ls += (end - start);
        }

        // time for binary iterative search sum times

        for (int i = 0; i < EPOCHS; i++) {
            long start = System.currentTimeMillis();
            binary_search_iterative(arr, value_to_look_for);
            long end = System.currentTimeMillis();
            sum_time_bsi += (end - start);
        }

        // time for binary recursive search sum times

        for (int i = 0; i < EPOCHS; i++) {
            long start = System.currentTimeMillis();
            binary_search_recursive(arr, value_to_look_for, 0, arr.length - 1);
            long end = System.currentTimeMillis();
            sum_time_bsr += (end - start);
        }

        // calculating average times
        double average_time_ls = (double) sum_time_ls / EPOCHS, average_time_bsi = (double) sum_time_bsi / EPOCHS,
                average_time_bsr = (double) sum_time_bsr / EPOCHS;

        System.out.printf("LS: %f, BSI: %f, BSR: %f\n", average_time_ls, average_time_bsi, average_time_bsr);

    }

    // linear search
    public static int linear_search(double arr[], double x) {
        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    // binary search iterative
    public static int binary_search_iterative(double arr[], double x) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    // binary search recursive
    public static int binary_search_recursive(double arr[], double x, int l, int r) {
        if (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                return binary_search_recursive(arr, x, mid + 1, r);

            } else {
                return binary_search_recursive(arr, x, l, mid - 1);
            }
        }
        return -1;
    }
}
