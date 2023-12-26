public class Node {
    private int value;
    private Color color;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        color = Color.RED;
    }

    public int getValue() {
        return value;
    }

}
