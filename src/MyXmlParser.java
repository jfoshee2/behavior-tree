import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Used to parse through xml files
 */
public class MyXmlParser {

    private Scanner input; // Used to read in file

    /**
     * Creates MyXmlParser instance
     * @param file - xml file to be parsed
     */
    public MyXmlParser(File file) throws FileNotFoundException {
        input = new Scanner(file);
    }

    /**
     * Builds tree from xml file
     * @return built tree
     */
    public MyTree buildTree() {
        MyTreeNode root = new MyTreeNode();

        buildTreeNode(root);

        return new MyTree(root);
    }

    /**
     * Reads file and adds children to the node
     * @param node - node that is being built from xml file
     */
    private void buildTreeNode(MyTreeNode node) {

        while (input.hasNext()) {

            String line = input.nextLine();

            if (line.contains("<root")) {
                node.setData("behavior = ROOT");
                buildTreeNode(node);
            } else if (line.contains("<node")) {

                String[] parts = line.split("\"");

                MyTreeNode newNode;

                // Check whether node is behavior or response
                if (!parts[1].isEmpty()) {
                    newNode = new MyTreeNode("behavior = " + parts[1]);
                    node.addChild(newNode);
                    buildTreeNode(newNode);
                } else if (!parts[3].isEmpty()) {
                    newNode = new MyTreeNode("response = " + parts[3]);
                    node.addChild(newNode);
                }

            } else if (line.contains("</")) {
                return;
            }

        }




    }
}
