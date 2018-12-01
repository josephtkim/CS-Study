/*
Hash table implemented with chaining.
Stores key-value pairs.

Stored in array of linked lists.

Keys are unique.
Allows duplicate value.
*/

public class HashTable {

    private int numBuckets = 16;
    private HashNode[] table;

    private class HashNode {
        int key;
        String value;
        HashNode next;

        public HashNode(int key, String value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    public HashTable() {
        table = new HashNode[numBuckets];
    }

    public int hash(int key) {
        return key % numBuckets;
    }

    public void add(int key, String value) {
        // Replaces value if key already in the table
        int index = hash(key);
        HashNode entry = new HashNode(key, value);

        // Check if the index is empty
        if (table[index] == null) {
            // If empty, set the head to the new entry.
            table[index] = entry;
            return;
        } else {
            // Insert at head of the linked list.
            HashNode prevHead = table[index];
            entry.next = prevHead;
            table[index] = entry;
            return;
        }
    }

    public void remove(int key) {
        if (!contains(key)) {
            System.out.println("Key not found");
            return;
        } else {
            int index = hash(key);
            HashNode current = table[index];

            if (current.key == key) {
                table[index] = current.next;
            }

            while (current.next != null) {
                if (current.next.key == key) {
                    current.next = current.next.next;
                    return;
                }

                current = current.next;
            }
        }
    }

    // Remove value of the given key
    public String get(int key) {
        int index = hash(key);

        if (table[index] == null) {
            System.out.println("Key not found.");
            return "";
        } else {
            HashNode temp = table[index];

            while (temp != null) {
                if (temp.key == key) {
                    return temp.value;
                }

                temp = temp.next;
            }

            return "";
        }
    }

    public boolean contains(int key) {
        int index = hash(key);

        if (table[index] == null) {
            return false;
        }

        else {
            HashNode temp = table[index];

            while (temp != null) {
                if (temp.key == key) {
                    return true;
                }
                temp = temp.next;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        HashTable h = new HashTable();

        System.out.println(h.contains(1));
        h.add(1, "Test");
        System.out.println(h.contains(1));
        System.out.println(h.get(1));

        h.remove(1);
        System.out.println(h.contains(1));
    }
}