import java.io.IOException;
import java.util.Scanner;

public class TreeGeneration {
    static void generateTree(DT newTree) {
        System.out.println("\nGENERATE DECISION TREE");
        System.out.println("======================");
        newTree.createRoot(1,"Is the user young?");
        newTree.addYesNode(1,2,"Is the user student?");
        newTree.addNoNode(1,3,"Is the user middle_age?");
        newTree.addYesNode(2,4,"THE USER WIll BUY THE COMPUTER");
        newTree.addNoNode(2,5,"THE USER WONT BUY THE COMPUTER");
        newTree.addYesNode(3,6,"THE USER WIll BUY THE COMPUTER"); //if middle age will always buy it
        newTree.addNoNode(3,7,"Is the user a student?"); //no node if senior
        newTree.addYesNode(7,8,"Is user's cred_rating fair?");
        newTree.addNoNode(7,9,"Is user's cred_rating fair?");
        newTree.addYesNode(8,10,"THE USER WIll BUY THE COMPUTER");
        newTree.addNoNode(8,11,"THE USER WONT BUY THE COMPUTER");
        newTree.addYesNode(9,12,"THE USER WIll BUY THE COMPUTER");
        newTree.addNoNode(9,13,"THE USER WONT BUY THE COMPUTER");
    }
    static void queryTree(DT newTree) throws IOException {
        System.out.println("\nQUERY DECISION TREE");
        System.out.println("===================");
        newTree.queryBinTree();

        // Option to exit

        optionToExit(newTree);
    }

    static void optionToExit(DT newTree) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Exit? (enter \"Yes\" or \"No\")");
        String answer = keyboard.nextLine();

        if (answer.equals("Yes")) return;
        else {
            if (answer.equals("No")) queryTree(newTree);
            else {
                System.out.println("ERROR: Must answer \"Yes\" or \"No\"");
                optionToExit(newTree);
            }
        }
    }
}
