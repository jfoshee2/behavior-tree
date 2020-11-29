import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File sample = new File("sample.xml");
        Scanner input = new Scanner(System.in);


        MyXmlParser parser = new MyXmlParser(sample);

        MyTree tree = parser.buildTree();

        System.out.println("Behavior Tree Loaded...");
        System.out.println(tree);
        System.out.println("------------------------------------------------");

        while (true) {
            System.out.print("Event ('quit' to exit): ");
            String userInput = input.nextLine();

            if (userInput.equals("quit")) {
                break;
            }

            MyTreeNode behavior = tree.getNodeBFS(userInput);
            tree.getNodeDFS(userInput);

            if (behavior == null) {
                System.out.println("Behavior not found");
            } else {
                System.out.println(behavior.getRandomResponse().getData());
            }
        }
    }



}
