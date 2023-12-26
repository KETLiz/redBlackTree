public class Tree {
    Node root;
    public void add(int value) {
        if(root == null) {
            root = new Node(value);
        }
        addNode(root, value);
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
                return node.left;
            }
            Node newNode = addNode(node.left, value);
        }
        if(node.getValue() < value) {
            if(node.right == null) {
                node.right = new Node(value);
                return node.right;
            }
            Node newNode = addNode(node.right, value);
            return newNode;
        }
        return null;
    }


}
