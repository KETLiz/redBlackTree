import java.util.ArrayList;
import java.util.List;

public class PrintTree{
    Tree tree;
    Node node;

    public PrintTree(Tree tree) {
        this.tree = tree;
    }
    public void printTree(String nullString, String indent1, String indent2) {
        if(tree.root == null) {
            System.out.println("пустота");
        }
        System.out.println(nullString + indent1 + tree.root.getValue() + indent2);

        print(tree.root, nullString);
    }

    private void print(Node node, String nullString) {
        if(node.left != null && node.right != null) {
            System.out.print(nullString + node.left.getValue());
            System.out.print(nullString + node.right.getValue());
            nullString = nullString.substring(0, nullString.length()/2);
            System.out.println();

            print(node.right, nullString);

            print(node.left, nullString);
            System.out.println();
        }
//        if(node.left != null) {
//            System.out.print(nullString + node.left.getValue());
//            nullString = nullString.substring(0, nullString.length()/2);
//            System.out.println();
//            print(node.left, nullString);
//        }
//        if(node.right != null) {
//            StringBuilder sb = new StringBuilder(nullString);
//            sb.append(nullString);
//            System.out.println(sb.toString() + node.right.getValue());
//            System.out.println();
//            print(node.right, sb.toString());
//        }
    }

    public void loopPrint(String nullString) {
        List<Node> line = new ArrayList<>();
        List<Node> nextLine = new ArrayList<>();
        line.add(tree.root);
        System.out.println(nullString + tree.root);
        while(!line.isEmpty()) {
            for(Node node : line) {
                nextLine.add(node.left);

                nextLine.add(node.right);
                System.out.println(nextLine);
            }
            line = nextLine;
        }
    }
}
