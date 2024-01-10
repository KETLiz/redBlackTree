public class Tree {
    Node root;
    public boolean add(int value) {

        if(root == null) {
            root = new Node(value);
            root.setColor(Color.BLACK);
            return true;
        }
        if(root.getValue() == value) {
            return false;
        }
        addNode(root, value);
        return true;
    }

    /**
     * Добавление новой ноды в дерево
     * @param node нода, с которой сравниваем входящий value
     * @param value значение для новой ноды
     * @return new Node()
     */
    private Node addNode(Node node, int value) {
        if(node.getValue() == value) {
            return null;
        }
        if(node.getValue() > value) {
            if(node.left == null) {
                node.left = new Node(value);
                node.left = rebalance(node.left);
                return node.left;
            }
            Node newNode = addNode(node.left, value);
        }
        if(node.getValue() < value) {
            if(node.right == null) {
                node.right = new Node(value);
                node.right = rebalance(node.right);
                return node.right;
            }
            Node newNode = addNode(node.right, value);
            return newNode;
        }
        return null;
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if(result.right != null && result.right.getColor() == Color.RED
                && (result.left == null || result.left.getColor() == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if(result.left != null && result.left.getColor() == Color.RED &&
                result.left.left != null && result.left.left.getColor() == Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if(result.left != null && result.left.getColor() == Color.RED &&
                    result.right != null && result.right.getColor() == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        }
        while (needRebalance);
        return result;
    }

    private void colorSwap(Node node) {
        node.setColor(Color.RED);
        node.left.setColor(Color.BLACK);
        node.right.setColor(Color.BLACK);
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.left;
        Node between = leftChild.right;
        leftChild.right = node;
        node.left = between;
        leftChild.setColor(node.getColor());
        node.setColor(Color.RED);
        return leftChild;
    }

    private Node rightSwap(Node node) {
        Node right = node.right;
        Node between = right.left;
        right.left = node;
        node.right = between;
        right.setColor(node.getColor());
        node.setColor(Color.RED);
        return right;
    }
}
