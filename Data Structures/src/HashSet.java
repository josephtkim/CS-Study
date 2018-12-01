/*
Instead of key-value pairs, just records if the
keys are the in a set, no values.

based on implementation for leetcode by icydragoon

Assumes input key values from 1 to 100,000.
*/

public class HashSet {

    // Utilize a boolean array of arrays.
    private int numBuckets = 100;
    private int bucketSize = 100;
    private boolean[][] table;

    public HashSet() {
        table = new boolean[numBuckets][];
    }

    // Returns the hash code
    public int hash(int key) {
        return key % numBuckets;
    }

    // Returns the index in the bucket
    public int positionInBucket(int key) {
        return key / numBuckets;
    }

    public void insert(int key) {
        int index = hash(key);

        if (table[index] == null) {
            table[index] = new boolean[bucketSize];
        }

        table[index][positionInBucket(key)] = true;
    }

    public void remove(int key) {
        int index = hash(key);

        if (table[index] != null) {
            table[index][positionInBucket(key)] = false;
        }
    }

    public boolean contains(int key) {
        int index = hash(key);

        if (table[index] != null) {
            return table[index][positionInBucket(key)];
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        HashSet h =  new HashSet();
        System.out.println(h.contains(1));
        h.insert(1);
        System.out.println(h.contains(1));
        h.remove(1);
        System.out.println(h.contains(1));
    }
}
