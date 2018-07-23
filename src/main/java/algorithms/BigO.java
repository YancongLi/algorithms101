package algorithms;

public class BigO {

    //O(n)
    public void foo(int[] array) {

        for (int i = 0; i < array.length; i++) {//loop over n elements
            // ...
        }

        for (int i = 0; i < array.length; i++) {//loop over n elements
            // ...
        }
    }

    //O(n * m)
    public void bar(int[] array1, int[] array2) {

        for (int i = 0; i < array1.length; i++) {//loop over n elements
            // ...
            for (int j = 0; j < array2.length; j++) {//loop over m elements
                // ...
            }
        }
    }

    //O(n^2)
    public void baz(int[] array) {

        for (int i = 0; i < array.length; i++) {//loop over n elements
            // ...
            for (int j = 0; j < array.length; j++) {//loop over n elements
                // ...
                if (array[i] < array[j]) {//O(1)
                    // Launch!
                }
            }
        }
    }

    //O(n^2)
    public void beep(int[] array) {

        for (int i = 0; i < array.length; i++) {//loop over n elements
            // ...
            for (int j = 0; j < array.length; j++) {//loop over n elements
                // ...
                for (int k = 0; k < 9999999; k++) {//O(1) because 9999999 is a constant
                    // Jump!
                }
            }
        }
    }
}