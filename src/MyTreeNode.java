import java.util.ArrayList;
import java.util.Random;

/**
 * Used to store nodes for tree
 */
public class MyTreeNode {

    private String data;
    private ArrayList<MyTreeNode> children;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setChildren(ArrayList<MyTreeNode> children) {
        this.children = children;
    }

    /**
     * Creates instance of MyTreeNode
     * @param data - behavior/response
     */
    public MyTreeNode(String data) {
        this.data = data;
        children = new ArrayList<>();
    }

    /**
     * Default constructor for creating MyTreeNode instance
     */
    public MyTreeNode() {
        children = new ArrayList<>();
    }

    /**
     * Adds children to node
     * @param child - the child that is to be added to the node
     */
    public void addChild(MyTreeNode child) {
        children.add(child);
    }

    /**
     * Returns the node's children
     * @return - list of node's children
     */
    public ArrayList<MyTreeNode> getChildren() {
        return children;
    }

    public MyTreeNode getRandomResponse() {
        Random random = new Random();
        int index = random.nextInt(children.size());
        MyTreeNode result = children.get(index);
        String[] dataSections = result.getData().split(" = ");

        if (dataSections[0].equals("behavior")) {
            return result.getRandomResponse();
        } else {
            return result;
        }
    }
}
