import java.util.*;

/**
 * Used to hold data for behaviors and responses
 */
public class MyTree {

    private MyTreeNode root;

    /**
     * Creates instance of tree
     * @param root - root node
     */
    public MyTree(MyTreeNode root) {
        this.root = root;
    }

    /**
     * Returns the tree's root node
     * @return - the root node
     */
    public MyTreeNode getRoot() {
        return root;
    }

    /**
     * Finds the target using Breadth First Search algorithm
     * @param target - target to be searched for
     * @return node with target if target is not found null is returned
     */
    public MyTreeNode getNodeBFS(String target) {

        //Create empty Set s and empty Queue q
        Set<MyTreeNode> s = new HashSet<>();
        Queue<MyTreeNode> q = new LinkedList<>();

        s.add(getRoot());
        q.add(getRoot());

        int steps = 0;

        //While q is not empty
        while (!q.isEmpty()) {
            MyTreeNode current = q.remove();

            String data = current.getData();
            String[] dataSections = data.split("= ");
            String attribute = dataSections[dataSections.length - 1];

            if (target.equals(attribute)) {
                System.out.println(target + " found with " + steps + " steps using BFS");
                return current;
            }

            ArrayList<MyTreeNode> children = current.getChildren();

            // Iterate through current's children and add them to s and q
            children.stream().filter(child -> !s.contains(child)).forEach(child -> {
                s.add(child);
                q.add(child);
            });
            ++steps;
        }
        return null;
    }

    /**
     * Finds the target using Depth First Search algorithm
     * @param target - target to be searched for
     * @return node with target if target is not found null is returned
     */
    public MyTreeNode getNodeDFS(String target) {

        // Create empty Stack s
        Stack<MyTreeNode>  s = new Stack<>();

        s.push(getRoot());

        int steps = 0;

        // While s is not empty
        while (!s.empty()) {
            MyTreeNode current = s.pop();

            String data = current.getData();
            String[] dataSections = data.split("= ");
            String attribute = dataSections[dataSections.length - 1];

            if (target.equals(attribute)) {
                System.out.println(target + " found with " + steps + " steps using DFS");
                return current;
            }

            ArrayList<MyTreeNode> children = current.getChildren();

            // Add the children to the stack
            children.forEach(s::push);

            ++steps;
        }
        return null;
    }

    /**
     * Converts tree to a displayable string
     * @return - tree as a string
     */
    @Override
    public String toString() {
        return displayMyTree(root, 0);
    }

    /**
     * Builds a String starting from root node
     * @param root - root node of MyTree instance
     * @param level - level the method is at in the tree
     * @return MyTree instance as a String
     */
    private static String displayMyTree(MyTreeNode root, int level) {

        String result = "";

        // Build tabs if necessary
        for (int i = 0; i < level; i++) {
            result += "\t";
        }

        result += root.getData() + "\n";
        for (MyTreeNode child: root.getChildren()) {
            result += displayMyTree(child, level + 1);
        }
        return result;
    }
}
