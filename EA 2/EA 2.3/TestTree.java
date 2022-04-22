public class TestTree {
    public static void main(String[] args) {
        BinaryTree a = new BinaryTree();
        a.insert(5);
        System.out.println(a.contains(5) == true);
        a.insert(6);
        System.out.println(a.contains(1) == false);
        System.out.println(a.contains(6) == true);

        BinaryTree myTree = new BinaryTree(6);
        myTree.insert(5);
        myTree.insert(4);
        myTree.insert(12);
        myTree.insert(11);
        myTree.insert(10);
        myTree.inorder();

        System.out.println(myTree.contains(10));
        System.out.println(myTree.contains(11));
        System.out.println(myTree.contains(13));
    }
}