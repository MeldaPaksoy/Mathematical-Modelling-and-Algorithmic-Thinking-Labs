
//Node Class for AVL tree with integer data type

class Node {
    int data;
    Node left, right;
    int height;

    // constructor with the parameter "int data" 
    public Node(int data) {
        this.data = data;
        this.height = 1;
    }
}

public class AVLTreeFromArray {

    // height method to get height of node
    static int height(Node node) {
        return node == null ? 0 : node.height;
    }

    // Method to update height
    static void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    // Method to get balance factor
    static int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // Method for right rotate
    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    // Method for left rotate
    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    // insert method for inserting a new node into AVL
    static Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.data)
            node.left = insert(node.left, key);
        else
            node.right = insert(node.right, key);

        updateHeight(node);

        int balance = getBalance(node);

        // Balancing tree
        if (balance > 1 && key < node.left.data)
            return rightRotate(node);
        if (balance < -1 && key > node.right.data)
            return leftRotate(node);
        if (balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // sortedArray method to convert a given an integer array to an AVL tree
    static Node sortedArrayToAVL(int[] arr) {
        Node root = null;
        for (int val : arr) {
            root = insert(root, val);
        }
        return root;
    }

    //  inOrder method to traverse the tree according to inorder traversal
    static void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    // main method to test functions
    public static void main(String[] args) {
        int[] array = {3, 6, 7, 8, 9, 11};
        Node root = sortedArrayToAVL(array);

        System.out.println("InOrder Traversal of AVL Tree:");
        inOrder(root);  // Output should be: 3 6 7 8 9 11
    }
}



/*
5. What is the worst-case time complexity of your “array to tree convert method”? 

 Worst case time complexity is O(n log n)

6. Explain why it has this time complexity?

  We are inserting all of the elements of the array into the AVL tree one by one. This makes n process.
  Height of an AVLTree is log n. So, each insertion in an AVL tree takes O(log n) time to maintain balance. Because the worst case includes height updates and rotations.
  Therefore, the worst case time complexity is O(n log n).

*/
