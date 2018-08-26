package algorithms;

class FibonacciMemorized {

    int fib(int n) {
        int[] f = new int[n+2]; // 1 extra to handle case, n = 0

        f[0] = 0;
        System.out.println("n = 0");
        f[1] = 1;
        System.out.println("n = 1");

        for (int i = 2; i <= n; i++) {
            System.out.println("n = " + i);
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }

//    private int[] memo = new int[1001];
//
//    int fib(int n) {
//        System.out.println("n = " + n);
//        if (n <= 0) {
//            return 0;
//        } else if (n == 1) {
//            return 1;
//        } else if (memo[n] == 0){
//            memo[n] = fib(n - 1) + fib(n - 2);
//        }
//        return memo[n];
//    }
}
