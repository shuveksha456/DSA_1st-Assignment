import java.util.Arrays;

class DataItem {
    int data;
    int key;

    public DataItem(int key, int data) {
        this.key = key;
        this.data = data;
    }
}

public class QuadraticProbing {

    private static final int SIZE = 20;
    private DataItem[] hashArray;
    private DataItem dummyItem;

    public QuadraticProbing() {
        hashArray = new DataItem[SIZE];
        dummyItem = new DataItem(-1, -1);
    }

    private int hashCode(int key) {
        return key % SIZE;
    }

    public DataItem search(int key) {
        int hashIndex = hashCode(key);
        int i = 0;

        while (hashArray[(hashIndex + i * i) % SIZE] != null) {
            int index = (hashIndex + i * i) % SIZE;

            if (hashArray[index].key == key) {
                return hashArray[index];
            }

            i++;
            if (i == SIZE) break;
        }

        return null;
    }

    public void insert(int key, int data) {
        DataItem item = new DataItem(key, data);
        int hashIndex = hashCode(key);
        int i = 0;

        while (true) {
            int index = (hashIndex + i * i) % SIZE;
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

    public DataItem delete(DataItem item) {
        int key = item.key;
        int hashIndex = hashCode(key);
        int i = 0;

        while (hashArray[(hashIndex + i * i) % SIZE] != null) {
            int index = (hashIndex + i * i) % SIZE;

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
        QuadraticProbing hashTable = new QuadraticProbing();

        // 🔢 Updated insertions
        hashTable.insert(6, 60);
        hashTable.insert(25, 125);
        hashTable.insert(14, 114);
        hashTable.insert(32, 132);
        hashTable.insert(11, 111);
        hashTable.insert(17, 117);
        hashTable.insert(9, 109);
        hashTable.insert(20, 120);
        hashTable.insert(18, 118);

        hashTable.display();

        DataItem item = hashTable.search(18);

        if (item != null) {
            System.out.println("Element found: " + item.data);
        } else {
            System.out.println("Element not found");
        }

        hashTable.delete(item);
        item = hashTable.search(18);

        if (item != null) {
            System.out.println("Element found: " + item.data);
        } else {
            System.out.println("Element not found");
        }
    }
}

