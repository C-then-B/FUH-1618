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
        //     while (curr.value != value) {
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
        // Variante 1: rekursiv
        if (root != null)
            root.inorder();

        // Variante 2: iterativ; kein stack
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

        // Variante 3: iterativ; /w stack
        java.util.Stack<BinaryNode> path = new java.util.Stack<BinaryNode>();
        curr = root; // Reset if 3 runs ontop 2
        while (curr != null || !path.isEmpty()) {
            if (curr != null) {
                path.push(curr);
                curr = curr.leftSon;
            } else {
                curr = path.pop();
                System.out.println(curr.value);
                curr = curr.rightSon;
            }
        }
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