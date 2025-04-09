import java.util.Scanner;

class LinearProbingHashTable {
    private int[] hashTable;
    private int size;
    private static final int EMPTY = -1;
    private static final int DELETED = -2;

    public LinearProbingHashTable(int size) {
        this.size = size;
        this.hashTable = new int[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = EMPTY; // -1 means empty
        }
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hashFunction(key);
        int startIndex = index;

        while (hashTable[index] != EMPTY && hashTable[index] != DELETED) {
            System.out.println("Collision at index " + index + " for key " + key);
            index = (index + 1) % size;
            if (index == startIndex) {
                System.out.println("Hash table is full. Couldn't insert " + key);
                return;
            }
        }

        hashTable[index] = key;
        System.out.println("Inserted " + key + " at index " + index);
    }

    public void display() {
        System.out.println("\nHash Table Contents:");
        for (int i = 0; i < size; i++) {
            if (hashTable[i] == EMPTY) {
                System.out.println("Index " + i + ": Empty");
            } else if (hashTable[i] == DELETED) {
                System.out.println("Index " + i + ": Deleted");
            } else {
                System.out.println("Index " + i + ": " + hashTable[i]);
            }
        }
    }

    public boolean search(int key) {
        int index = hashFunction(key);
        int startIndex = index;

        while (hashTable[index] != EMPTY) {
            if (hashTable[index] == key) {
                System.out.println("Key " + key + " found at index " + index);
                return true;
            }
            index = (index + 1) % size;
            if (index == startIndex) break;
        }

        System.out.println("Key " + key + " not found in the hash table.");
        return false;
    }

    public boolean delete(int key) {
        int index = hashFunction(key);
        int startIndex = index;

        while (hashTable[index] != EMPTY) {
            if (hashTable[index] == key) {
                hashTable[index] = DELETED;
                System.out.println("Key " + key + " deleted from index " + index);
                return true;
            }
            index = (index + 1) % size;
            if (index == startIndex) break;
        }

        System.out.println("Key " + key + " not found. Deletion failed.");
        return false;
    }
}

public class LinearProbingDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinearProbingHashTable hashTable = new LinearProbingHashTable(10);

        // Insert values
        int[] values = {23, 43, 13, 27, 16, 33, 57, 90};
        for (int value : values) {
            hashTable.insert(value);
        }

        hashTable.display();

        // Search for a value
        System.out.print("\nEnter value to search: ");
        int searchKey = scanner.nextInt();
        hashTable.search(searchKey);

        // Delete a value
        System.out.print("\nEnter value to delete: ");
        int deleteKey = scanner.nextInt();
        hashTable.delete(deleteKey);

        // Display after deletion
        hashTable.display();

        scanner.close();
    }
}

