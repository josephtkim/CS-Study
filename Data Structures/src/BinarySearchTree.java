public class BinarySearchTree {

    private BSTNode treeRoot;
    private int size;

    public class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;
        BSTNode parent;

        public BSTNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    public BinarySearchTree() {
        this.treeRoot = null;
        this.size = 0;
    }

    public void insert(int value) {
        this.treeRoot = insertRec(this.treeRoot, value);
    }

    public BSTNode insertRec(BSTNode root, int value) {
        if (root == null) {
            root = new BSTNode(value);
            this.size++;
            return root;
        }

        if (value < root.data) {
            root.left = insertRec(root.left, value);

            if (root.left != null) {
                root.left.parent = root;
            }
        } else {
            root.right = insertRec(root.right, value);

            if (root.right != null) {
                root.right.parent = root;
            }
        }

        return root;
    }

    public void remove(int value) {
        this.treeRoot = removeRec(this.treeRoot, value);
        this.size--;
    }

    public BSTNode removeRec(BSTNode root, int value) {
        if (root == null) {
            return root;
        }

        if (value < root.data) {
            root.left = removeRec(root.left, value);
        } else if (value > root.data) {
            root.right = removeRec(root.right, value);
        } else { // Found the node to delete
            // Three cases

            // 0 children
            // Node is leaf, so just remove it.
            // 1 child
            // Replace the node with the child.
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            // 2 children
            // Only look in the right subtree.
            // Replace node with inorder successor.
            root = getMin(root.right);
            int successorValue = root.data;

            // Delete the successor's position.
            root.right = removeRec(root.right, successorValue);
        }

        return root;
    }

    public boolean contains(BSTNode root, int value) {
        if (root == null) {
            return false;
        }

        if (value == root.data) {
            return true;
        }

        if (value < root.data) {
            return contains(root.left, value);
        } else {
            return contains(root.right, value);
        }
    }

    public int getHeight(BSTNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public BSTNode getSuccessor(BSTNode root, BSTNode node) {
        if (node == null || root == null) {
            return root;
        }

        // Successor is never in left subtree.
        // Either it is the minimum in the right subtree
        // or it is an ancestor.
        if (node.right != null) {
            return getMin(node.right);
        } else {
            BSTNode y = node.parent;
            BSTNode x = node;

            while (x != y.left && y != null) {
                x = y;
                y = y.parent;
            }

            return y;
        }
    }

    public BSTNode getMin(BSTNode root) {
        // Left most leaf in the tree
        if (root == null) {
            return root;
        }

        // Iterative
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public BSTNode getMax(BSTNode root) {
        // Right most left in the tree
        if (root == null) {
            return root;
        }

        while (root.right != null) {
            root = root.right;
        }

        return root;
    }

    public int getSize() {
        return this.size;
    }

    // Tree traversals
    // Recursive
    public void inOrder(BSTNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder(BSTNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        inOrder(root.left);
        inOrder(root.right);
    }

    public void postOrder(BSTNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        inOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("Constructing tree...");
        bst.insert(6);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        bst.insert(1);

        System.out.println("Size of tree is: ");
        System.out.println(bst.getSize());

        System.out.println("Traversing tree...");
        bst.inOrder(bst.treeRoot);
        System.out.println("");
        bst.preOrder(bst.treeRoot);
        System.out.println("");
        bst.postOrder(bst.treeRoot);
        System.out.println("");

        System.out.println("Removing nodes from tree.");
        bst.remove(5);
        bst.remove(7);

        System.out.println(bst.getSize());
        bst.inOrder(bst.treeRoot);
        System.out.println("");
        bst.preOrder(bst.treeRoot);
        System.out.println("");
        bst.postOrder(bst.treeRoot);
        System.out.println("");

        System.out.println(bst.contains(bst.treeRoot, 1));
        System.out.println(bst.contains(bst.treeRoot, 5));
        System.out.println(bst.getHeight(bst.treeRoot));
        System.out.println(bst.getMin(bst.treeRoot).data);
        System.out.println(bst.getMax(bst.treeRoot).data);
        System.out.println(bst.getSize());
    }
}