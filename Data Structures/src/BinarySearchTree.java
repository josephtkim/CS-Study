public class BinarySearchTree {

    public class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;

        public BSTNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public BSTNode root;

    public BinarySearchTree() {
        this.root = null;
    }


}
