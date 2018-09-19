package challenges.arraysAndStrings;

import java.util.Arrays;

public class PermutationDetector {
    public boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();

        Arrays.sort(a1);
        Arrays.sort(a2);

//        for (int i = 0; i < a1.length; i++) {
//            if (a1[i] != a2[i]) {
//                return false;
//            }
//        }
//        return true;
//  Or:
        return Arrays.equals(a1, a2);
    }




















//    public boolean isPermutation(String text, String perm) {
//        if (perm.length() != text.length()) return false;
//
//        return sort(text).equals(sort(perm));
//    }
//
//    private String sort(String s) {
//        char[] content = s.toCharArray();
//        Arrays.sort(content);
//        return new String(content);
//    }

}
