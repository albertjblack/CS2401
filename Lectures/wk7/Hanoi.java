public class Hanoi {
    public static int iteration = 0;

    public static void main(String args[]) {
        solve(3, 1, 3);
    }

    public static void solve(int n, int start, int end) {
        // assume start is in [1,3] and so is end // these are the numbered towers
        if (start == end) {
            System.out.println("Start is equal to end. No steps needed.");
            return;
        }
        if (n <= 0) {
            System.out.println("No disks to move.");
            return;
        }

        if (n == 1) {
            helper_print(start, " -> ", end);
            return;
        } else {

            int other = (start + end) <= 3 ? (start + end) : (end - start);
            solve(n - 1, start, other);
            helper_print(start, " -> ", end);
            solve(n - 1, other, end);

        }

    }

    public static void helper_print(int start, String str, int end) {
        System.out.println(iteration + ". " + start + str + end);
        iteration++;
        return;
    }

}