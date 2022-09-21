package Tree;

public class BinarySearchTree {
    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;

    public BinarySearchTree() {
        this.root = null; //initialise
    }

    public void insert(int newData) {
        this.root = insert(root, newData);
    }

    public Node insert(Node root, int newData) {
        if (root == null) {
            root = new Node(newData);
            return root;
        }
        else if (root.data >= newData) {
            root.left = insert(root.left, newData);
        } else {
            root.right = insert(root.right, newData);
        }
        return root;
    }

    public void deleteANode(Node node) {
        deleteNode(this.root, node);
    }

    private Node deleteNode(Node root, Node node) {
        if (root == null) return null;
        else if (node.data < root.data) { // process the left sub tree
            root.left = deleteNode(root.left, node);
        } else if (node.data > root.data) { // process the right sub tree
            root.right = deleteNode(root.right, node);
        } else if(root.data==node.data){ // two child
            if (root.left != null && root.right != null) {
                int lmax = findMaxData(root.left);
                root.data = lmax;
                root.left = deleteNode(root.left, new Node(lmax));
                return root;
            }
            // one child
            // only left child
            else if (root.left != null) {
                return root.left;
            }
            // only right child
            else if (root.right != null) {
                return root.right;
            }
            // no child
            else {
                return null;
            }
        }
        return root;
    }
    public int findMaxData(Node root) {
        if (root.right != null) {
            return findMaxData(root.right);
        } else {
            return root.data;
        }
    }


    public void preorder() {  //전위 순회
        preorder(root);
        System.out.println();
    }

    public void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder() {  //중위 순회
        inorder(root);
        System.out.println();
    }

    public void inorder(Node root) {
        if (root == null) return;
        preorder(root.left);
        System.out.print(root.data + " ");
        preorder(root.right);
    }

    public void postorder() { //후위 순회
        postorder(root);
        System.out.println();
    }

    public void postorder(Node root) {
        if (root == null) return;
        preorder(root.left);
        preorder(root.right);
        System.out.print(root.data + " ");
    }


    public static void main(String[] args) {
        // Creating the object of BinarySearchTree class
        BinarySearchTree bst = new BinarySearchTree();
        // call the method insert
        bst.insert(8);
        bst.insert(5);
        bst.insert(9);
        bst.insert(3);
        bst.insert(7);
        bst.insert(11);
        bst.insert(1);
        bst.insert(100);
        bst.insert(15);
        bst.insert(18);
        System.out.println("preorder");
        bst.preorder();
        bst.deleteANode(new Node(9));
        bst.preorder();
        System.out.println("inorder");
        bst.inorder();
        bst.deleteANode(new Node(100));
        bst.inorder();
        System.out.println("postorder");
        bst.postorder();
        bst.deleteANode(new Node(15));
        bst.postorder();

    }
}