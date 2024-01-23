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

        nullString = nullString.substring(0, nullString.length()/2);
        indent1 = indent1.substring(0, indent1.length()/2+1);
        indent2 = indent2.substring(indent2.length()/2);
        print(tree.root, nullString, indent1, indent2);
    }

    private void print(Node node, String nullString, String indent1, String indent2) {
        if(node.left != null && node.right != null) {
            System.out.print(nullString + indent1 + node.left.getValue() + indent2);
            System.out.print(nullString + indent1 + node.right.getValue() + indent2);

            System.out.println();
            String nullString2 = nullString + nullString;
            print(node.right, nullString2, indent1, indent2);

            print(node.left, nullString, indent1, indent2);
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

        line.add(tree.root);
        System.out.println(nullString + tree.root);
        while(!line.isEmpty()) {
            List<Node> nextLine = new ArrayList<>();
            for(Node node : line) {
                nextLine.add(node.left);

                nextLine.add(node.right);
                System.out.println(nextLine);
            }
            line = nextLine;
        }
    }
}
