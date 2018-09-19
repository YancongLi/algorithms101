package challenges.arraysAndStrings;

public class Compressor {
    public String compress(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        int pointerToChar = 0;
        int pointerToDuplicate = 0;
        int counter = 1;
        while (true) {
            if (pointerToDuplicate >= str.length()) {
                stringBuilder.append(str.charAt(pointerToChar));
                stringBuilder.append(counter);
                break;
            }

            if (pointerToChar == pointerToDuplicate) {
                counter = 1;
                pointerToDuplicate++;
                continue;
            }
            if (str.charAt(pointerToChar) == str.charAt(pointerToDuplicate)) {
                counter++;
                pointerToDuplicate++;
            } else {
                stringBuilder.append(str.charAt(pointerToChar));
                stringBuilder.append(counter);
                pointerToChar = pointerToDuplicate;
            }
        }

        String compressedStr = stringBuilder.toString();
        return compressedStr.length() < str.length() ? compressedStr : str;

    }

    //does not work with case:  Assert.assertEquals("aabbaabb", compressor.compress("aabbaabb"));
//    public String compress(String str) {
//        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
//        int length = str.length();
//        for (int i = 0; i < length; i++) {
//            Character character = str.charAt(i);
//            if (map.containsKey(character)) {
//                map.put(character, map.get(character) + 1);
//            } else {
//                map.put(character, 1);
//            }
//        }
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            stringBuilder.append(entry.getKey());
//            stringBuilder.append(entry.getValue());
//        }
//
//        String compressedStr = stringBuilder.toString();
//        return (compressedStr.length() < length ? compressedStr : str);
//    }


//    // This one is better for obvious reasons.
//    // Tip: StringBuilder much faster than appending to String manually
//    public String compress(String str) {
//        StringBuilder compressed = new StringBuilder();
//        int count = 0;
//        for (int i = 0; i < str.length(); i++) {
//            count++;
//
//            // If next char different, append this result
//            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
//                compressed.append(str.charAt(i));
//                compressed.append(count);
//                count = 0;
//            }
//        }
//        return compressed.length() < str.length() ? compressed.toString() : str;
//    }
//
//    // This was an early attempt that went off the rails...
//    public String compressFirstAttempt(String text) {
//
//        // Walk the string, counting the number of characters and updating
//        // a pointer as we go.
//
//        int pointer = 0;
//        int count = 0;
//        boolean lastLetter = false;
//        char letter = '!';
//        StringBuilder results = new StringBuilder();
//
//        while (pointer < text.length() - 1) {
//
//            letter = text.charAt(pointer);
//            System.out.println("Letter: " + letter + " count: " + count + " pointer: " + pointer);
//
//            // walk the text as long as the char is the same as the next
//            while (letter == text.charAt(pointer)) {
//
//                pointer++;
//                System.out.println("Letter: " + letter + " count: " + count + " pointer: " + pointer);
//
//                if (pointer == text.length()) {
//                    System.out.println("Breaking");
//                    pointer--;
//                    lastLetter = true;
//                    break;
//                }
//                count++;
//
//            }
//
//            if (count == 0) {
//                count = 1;
//            }
//
//            // means the next character is different - record our results
//            System.out.println("Saving: " + letter + " count: " + count + " pointer: " + pointer);
//            results.append(String.valueOf(letter) + count);
//
//            if (!lastLetter) {
//                count = 1;
//            }
//        }
//
//        // handle last element
//        if (count == 1) {
//            letter = text.charAt(pointer);
//            results.append(String.valueOf(letter) + count);
//        }
//
//        return results.toString();
//
//        // Abandoned...
//    }

}
