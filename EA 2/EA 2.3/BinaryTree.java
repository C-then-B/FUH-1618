import java.util.Stack;

public class BinaryTree {
    private BinaryNode root;

    public BinaryTree(int value) {
        insert(value);
    }

    public BinaryTree() {
    }

    public boolean contains(int value) {
        BinaryNode curr = root;
        while (curr != null) {
            if (value > curr.value) {
                curr = curr.rightSon;
            } else if (value < curr.value) {
                curr = curr.leftSon;
            } else
                return true;
        }
        return false;

        // Rekursive Lösung
        //return root.contains(value);
    }

    public void insert(int value) {
        if (root == null)
            root = new BinaryNode(value);
        else {
            BinaryNode curr = root;
            while (true) {
                if (value > curr.value) {
                    if (curr.rightSon != null)
                        curr = curr.rightSon;
                    else {
                        curr.rightSon = new BinaryNode(value);
                        break;
                    }
                } else if (value < curr.value) {
                    if (curr.leftSon != null)
                        curr = curr.leftSon;
                    else {
                        curr.leftSon = new BinaryNode(value);
                        break;
                    }
                }
            }
        }

        // Rekursive Lösung
        //root.insert(value);
    }

    public void inorder() {
        Stack<BinaryNode> todo = new Stack<BinaryNode>();
        BinaryNode curr = root;
        while (true) {
            if (curr != null) {
                todo.push(curr);
                curr = curr.leftSon;
            } else if (!todo.isEmpty()) {
                curr = todo.pop();
                System.out.println(curr.value);
                curr = curr.rightSon;
            } else
                break;
        }

        // Rekursive Lösung
        //root.inorder();
    }

    private static class BinaryNode {
        private BinaryNode leftSon, rightSon;

        private int value;

        public BinaryNode(int value) {
            this.value = value;
        }

        /* 
            Rekursive Lösungen (oben auskommentieren!)
        */
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