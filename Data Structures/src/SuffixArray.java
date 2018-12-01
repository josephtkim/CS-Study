/*
Idea:
Get each suffix of a string from the rightmost character.
0 banana
1 anana
2 nana
3 ana
4 na
5 a

Sort these based on the suffixes
5 a
3 ana
1 anana
0 banana
4 na
2 nana

Suffix array is thus {5, 3, 1, 0, 4, 2}
*/

import java.util.Arrays;
import java.util.Comparator;

public class SuffixArray {

    private class Suffix {
        String suffix;
        int index;

        public Suffix(String suffix, int index) {
            this.suffix = suffix;
            this.index = index;
        }
    }

    public int[] array(String word) {
        int length = word.length();
        Suffix[] suffixes = new Suffix[length];
        int[] indexes = new int[length]; // Contains the suffix array indexes

        for (int i = 0; i < length; i++) {
            suffixes[i] = new Suffix(word.substring(i, length), i);
        }

        Arrays.sort(suffixes, new Comparator<Suffix>() {
            @Override
            public int compare(Suffix string1, Suffix string2) {
                return string1.suffix.compareTo(string2.suffix);
            }
        });

        for (int i = 0; i < suffixes.length; i++) {
            indexes[i] = suffixes[i].index;
        }

        return indexes;
    }

    public static void main(String[] args) {
        SuffixArray obj = new SuffixArray();

        int[] answer = obj.array("BANANA");
        System.out.println(Arrays.toString(answer));
    }
}
