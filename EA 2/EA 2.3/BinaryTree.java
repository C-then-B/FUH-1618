import java.util.Stack;

public class BinaryTree {
    private BinaryNode root;

    public BinaryTree(int value) {
        insert(value);
    }

    public BinaryTree() {
    }

    public boolean contains(int value) {
        if (root == null)
            return false;

        // Rekursive Lösung
        else
            return root.contains(value);

        // Iterative Lösung
        // else {
        //     BinaryNode curr = root;
        //     while (curr != null) {
        //         if (value > curr.value) {
        //             curr = curr.rightSon;
        //         } else if (value < curr.value) {
        //             curr = curr.leftSon;
        //         } else
        //             return true;
        //     }
        //     return false;
        // }
    }

    public void insert(int value) {
        if (root == null)
            root = new BinaryNode(value);

        // Rekursive Lösung
        else
            root.insert(value);

        // Iterative Lösung
        // else {
        //     BinaryNode curr = root;
        //     while (true) {
        //         if (value > curr.value) {
        //             if (curr.rightSon != null)
        //                 curr = curr.rightSon;
        //             else {
        //                 curr.rightSon = new BinaryNode(value);
        //                 break;
        //             }
        //         } else if (value < curr.value) {
        //             if (curr.leftSon != null)
        //                 curr = curr.leftSon;
        //             else {
        //                 curr.leftSon = new BinaryNode(value);
        //                 break;
        //             }
        //         }
        //     }
        // }
    }

    public void inorder() {
        // Variante 1: iterativ; kein stack
        BinaryNode curr, pre;
        curr = root;

        while (curr != null) {
            if (curr.leftSon == null) {
                System.out.println(curr.value);
                curr = curr.rightSon;
            } else {
                pre = curr.leftSon;
                while (pre.rightSon != null && pre.rightSon != curr)
                    pre = pre.rightSon;

                if (pre.rightSon == null) {
                    pre.rightSon = curr;
                    curr = curr.leftSon;
                }

                else {
                    pre.rightSon = null;
                    System.out.println(curr.value);
                    curr = curr.rightSon;
                }
            }
        }

        System.out.println("-----");

        // Variante 2: iterativ; /w stack
        Stack<BinaryNode> path = new Stack<BinaryNode>();
        BinaryNode curr2 = root;
        while (curr2 != null || !path.isEmpty()) {
            if (curr2 != null) {
                path.push(curr2);
                curr2 = curr2.leftSon;
            } else {
                curr2 = path.pop();
                System.out.println(curr2.value);
                curr2 = curr2.rightSon;
            }
        }

        System.out.println("-----");

        // Variante 3: rekursiv
        if (root != null)
            root.inorder();
    }

    private static class BinaryNode {
        private BinaryNode leftSon, rightSon;

        private int value;

        public BinaryNode(int value) {
            this.value = value;
        }

        boolean contains(int value) {
            if (value == this.value)
                return true;
            if (value > this.value && rightSon != null)
                return rightSon.contains(value);
            else if (value < this.value && leftSon != null)
                return leftSon.contains(value);
            else
                return false;
        }

        void insert(int value) {
            if (value > this.value) {
                if (rightSon != null)
                    rightSon.insert(value);
                else
                    rightSon = new BinaryNode(value);
            } else if (value < this.value) {
                if (leftSon != null)
                    leftSon.insert(value);
                else
                    leftSon = new BinaryNode(value);
            }
        }

        void inorder() {
            if (leftSon != null)
                leftSon.inorder();

            System.out.println(value);

            if (rightSon != null)
                rightSon.inorder();
        }
    }
}