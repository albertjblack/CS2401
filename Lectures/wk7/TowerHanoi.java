public class TowerHanoi {

    public static void main(String args[]) {
        /* Insturctions */
        // tell a priests step by step instructions on what disk to move
        solve_steps(4, 'a', 'b', 'c');

    }

    public static void solve_steps(int n, char src, char dest, char aux) {
        if (n == 1) {
            System.out.println("Move top disk from pole " + src + " to pole " + dest);
            return;
        } else {
            solve_steps(n - 1, src, aux, dest);
            solve_steps(1, src, dest, aux);
            solve_steps(n - 1, aux, dest, src);
        }
    }

    public static void solve_arr(int n, char src[], char dest[], char aux[]) {
        if (n == 1) {

        }
    }

}