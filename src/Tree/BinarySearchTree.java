package Tree;

public class BinarySearchTree {
    class Node {
        int data;
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

        if (root == null) {
            root = new Node(newData);
        }
        else{
            Node head = root; //빈 노드 찾아서 이동
            Node currentNode; //leaf 노드의 자식으로 insert!

            while(true){
                currentNode = head;
                if (head.data >= newData) {
                    head = head.left;
                    if(head == null){
                        currentNode.left = new Node(newData);
                        break;
                    }
                } else {
                    head = head.right;
                    if(head == null){
                        currentNode.right = new Node(newData);
                        break;
                    }
                }
            }
        }


    }
    public void deleteNode(int element) {
        Node removeNode = root;
        Node parentOfRemoveNode = null;

        while (removeNode.data != element) { //삭제할 값 탐색
            parentOfRemoveNode = removeNode;
            if (removeNode.data > element)
                removeNode = removeNode.left;
             else
                 removeNode = removeNode.right;

            if (removeNode == null) {
                System.out.println("삭제 할 node값 존재하지 않음");
                return;
            }
        }

        if (removeNode.left == null && removeNode.right == null) { //leaf node일 때
            if (removeNode == root)
                root = null;
            else if (removeNode == parentOfRemoveNode.right)
                parentOfRemoveNode.right = null;
            else
                parentOfRemoveNode.left = null;

        }

        else if (removeNode.left == null) { // 오른쪽 자식만 존재
            if (removeNode == root)
                root = removeNode.right;
             else if (removeNode == parentOfRemoveNode.right)  // 삭제 대상의 오른쪽 자식 노드를 삭제 대상 위치에 둔다.
                parentOfRemoveNode.right = removeNode.right;
             else
                parentOfRemoveNode.left = removeNode.right;
        }
        else if (removeNode.right == null) { // 왼쪽 자식만 존재
            if (removeNode == root)
                root = removeNode.left;
            else if (removeNode == parentOfRemoveNode.right)  //삭제 대상의 왼쪽 자식을 삭제 대상 위치에 둔다.
                parentOfRemoveNode.right = removeNode.left;
            else
                parentOfRemoveNode.left = removeNode.left;
        }
        else { // 자식 노드가 2개 존재 - 오른쪽 서브 트리에 있는 가장 작은 값 올리기
            Node parentOfReplaceNode = removeNode;
            Node replaceNode = parentOfReplaceNode.right; // 오른쪽 서브 트리 탐색

            while (replaceNode.left != null) { // min값 탐색
                parentOfReplaceNode = replaceNode;
                replaceNode = replaceNode.left;
            }
            if (replaceNode != removeNode.right) {
                parentOfReplaceNode.left = replaceNode.right; // 대체 노드의 왼쪽 자식은 빈 노드가 됨
                replaceNode.right = removeNode.right;
            }
            if (removeNode == root) { // 삭제할 노드가 루트 노드인 경우
                root = replaceNode;
            } else if (removeNode == parentOfRemoveNode.right) {
                parentOfRemoveNode.right = replaceNode;
            } else {
                parentOfRemoveNode.left = replaceNode;
            }
            replaceNode.left = removeNode.left;   // 삭제 노드의 왼쪽 자식을 잇기
        }

    }

    public void preorder(Node root) {  //전위 순회
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public void inorder(Node root) {  //중위 순회
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void postorder(Node root) { //후위 순회
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
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
        bst.insert(10);
        System.out.println("preorder");
        bst.preorder(bst.root);
        System.out.println("\n삭제 후 preorder");
        //bst. deleteNode(15);
        bst.preorder(bst.root);
        System.out.println("\n\ninorder");

        bst.inorder(bst.root);
        System.out.println("\n삭제 후 inorder");
        //bst.deleteNode(7);
        bst.inorder(bst.root);

        System.out.println("\n\npostorder");
        bst.postorder(bst.root);
        System.out.println("\n삭제 후 postorder");
        bst.deleteNode(15);
        bst.postorder(bst.root);

    }
}