import java.util.Arrays;

class DataItem {
    int data;
    int key;

    public DataItem(int key, int data) {
        this.key = key;
        this.data = data;
    }
}

public class DoubleHashing {

    private static final int SIZE = 20;
    private static final int PRIME = 17;
    private DataItem[] hashArray;
    private DataItem dummyItem;

    public DoubleHashing() {
        hashArray = new DataItem[SIZE];
        dummyItem = new DataItem(-1, -1);
    }

    private int hash1(int key) {
        return key % SIZE;
    }

    private int hash2(int key) {
        return PRIME - (key % PRIME);
    }

    public void insert(int key, int data) {
        DataItem item = new DataItem(key, data);
        int hashIndex = hash1(key);
        int stepSize = hash2(key);
        int i = 0;

        while (true) {
            int index = (hashIndex + i * stepSize) % SIZE;

            if (hashArray[index] == null || hashArray[index].key == -1) {
                hashArray[index] = item;
                return;
            }

            i++;
            if (i == SIZE) {
                System.out.println("Hash table is full. Cannot insert key: " + key);
                return;
            }
        }
    }

    public DataItem search(int key) {
        int hashIndex = hash1(key);
        int stepSize = hash2(key);
        int i = 0;

        while (hashArray[(hashIndex + i * stepSize) % SIZE] != null) {
            int index = (hashIndex + i * stepSize) % SIZE;

            if (hashArray[index].key == key) {
                return hashArray[index];
            }

            i++;
            if (i == SIZE) break;
        }

        return null;
    }

    public DataItem delete(DataItem item) {
        int key = item.key;
        int hashIndex = hash1(key);
        int stepSize = hash2(key);
        int i = 0;

        while (hashArray[(hashIndex + i * stepSize) % SIZE] != null) {
            int index = (hashIndex + i * stepSize) % SIZE;

            if (hashArray[index].key == key) {
                DataItem temp = hashArray[index];
                hashArray[index] = dummyItem;
                return temp;
            }

            i++;
            if (i == SIZE) break;
        }

        return null;
    }

    public void display() {
        Arrays.stream(hashArray).forEach(item -> {
            if (item != null)
                System.out.printf(" (%d,%d)", item.key, item.data);
            else
                System.out.printf(" ~~ ");
        });

        System.out.println();
    }

    public static void main(String[] args) {
        DoubleHashing hashTable = new DoubleHashing();

        // 🔁 Updated inserted items
        hashTable.insert(5, 55);
        hashTable.insert(21, 105);
        hashTable.insert(7, 77);
        hashTable.insert(33, 133);
        hashTable.insert(18, 88);
        hashTable.insert(29, 119);
        hashTable.insert(11, 66);
        hashTable.insert(15, 150);
        hashTable.insert(9, 99);

        hashTable.display();

        DataItem item = hashTable.search(33);

        if (item != null) {
            System.out.println("Element found: " + item.data);
        } else {
            System.out.println("Element not found");
        }

        hashTable.delete(item);
        item = hashTable.search(33);

        if (item != null) {
            System.out.println("Element found: " + item.data);
        } else {
            System.out.println("Element not found");
        }
    }
}
