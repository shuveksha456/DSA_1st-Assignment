class Node {
    int data;
    Node left, right;

    // Constructor to create a new node
    public Node(int value) {
        data = value;
        left = right = null;
    }
}

public class BinarySearchTree {

    private static int[] insertedValues = new int[100];  // Assuming max of 100 insertions for simplicity
    private static int counter = 0;

    // Insert a value into the BST
    public static Node insert(Node root, int value) {
        insertedValues[counter++] = value;

        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Find a value in the BST
    public static Node find(Node root, int value) {
        if (root == null) {
            return null;
        }

        if (value == root.data) {
            return root;
        } else if (value < root.data) {
            return find(root.left, value);
        } else {
            return find(root.right, value);
        }
    }

    // Delete a node from the BST
    public static Node deleteNode(Node root, int value) {
        if (root == null) return root;

        if (value < root.data) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.data) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node minNode = findMinimum(root.right);
            root.data = minNode.data;
            root.right = deleteNode(root.right, minNode.data);
        }

        return root;
    }

    // Find the minimum node in the right subtree
    public static Node findMinimum(Node root) {
        Node current = root;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Display the values in the order of insertion
    public static void displayInsertionOrder() {
        System.out.println("Values in the order of insertion:");
        for (int i = 0; i < counter; i++) {
            System.out.print(insertedValues[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = null;

        root = insert(root, 50);
        insert(root, 30);
        insert(root, 70);
        insert(root, 20);
        insert(root, 40);
        insert(root, 60);
        insert(root, 80);

        displayInsertionOrder();

        int searchValue = 60;
        Node result = find(root, searchValue);
        if (result != null) {
            System.out.println("Node " + searchValue + " found in the BST.");
        } else {
            System.out.println("Node " + searchValue + " not found in the BST.");
        }

        int deleteValue = 30;
        root = deleteNode(root, deleteValue);
        System.out.println("After deleting node " + deleteValue + ":");
        displayInsertionOrder();
    }
}

