import java.io.*;
import java.util.ArrayList;

class Tester {

    static BufferedReader keyboardInput = new
            BufferedReader(new InputStreamReader(System.in));
    static DT newTree;
    static ArrayList<Users> user;

    public static void main(String[] args) throws IOException {

        newTree = new DT();
        user.add(new Users("youth","no","fair","high","no"));
        user.add(new Users("youth","no","excellent","high","no"));
        user.add(new Users("youth","no","fair","medium","no"));
        user.add(new Users("youth","yes","fair","low","yes"));
        user.add(new Users("youth","yes","excellent","medium","yes"));
        user.add(new Users("middle_age","no","fair","fair","yes"));
        user.add(new Users("middle_age","yes","excellent","excellent","yes"));
        user.add(new Users("middle_age","no","excellent","excellent","yes"));
        user.add(new Users("middle_age","yes","fair","fair","yes"));
        user.add(new Users("senior","no","fair","high","yes"));
        user.add(new Users("senior","yes","fair","high","yes"));
        user.add(new Users("senior","yes","excellent","high","no"));
        user.add(new Users("senior","yes","fair","high","yes"));
        user.add(new Users("senior","no","excellent","high","no"));

        // Generate tree
        generateTree();

        // Output tree

        System.out.println("\nOUTPUT DECISION TREE");
        System.out.println("====================");
        newTree.outputBinTree();

        // Query tree

        queryTree();
    }

    /* GENERATE TREE */

    static void generateTree() {
        System.out.println("\nGENERATE DECISION TREE");
        System.out.println("======================");
        newTree.createRoot(1,"Does animal eat meat?");
        newTree.addYesNode(1,2,"Does animal have stripes?");
        newTree.addNoNode(1,3,"Does animal have stripes?");
        newTree.addYesNode(2,4,"Animal is a Tiger");
        newTree.addNoNode(2,5,"Animal is a Leopard");
        newTree.addYesNode(3,6,"Animal is a Zebra");
        newTree.addNoNode(3,7,"Animal is a Horse");
    }

    /* QUERY TREE */

    static void queryTree() throws IOException {
        System.out.println("\nQUERY DECISION TREE");
        System.out.println("===================");
        newTree.queryBinTree();

        // Option to exit

        optionToExit();
    }

    /* OPTION TO EXIT PROGRAM */

    static void optionToExit() throws IOException {
        System.out.println("Exit? (enter \"Yes\" or \"No\")");
        String answer = keyboardInput.readLine();
        if (answer.equals("Yes")) return;
        else {
            if (answer.equals("No")) queryTree();
            else {
                System.out.println("ERROR: Must answer \"Yes\" or \"No\"");
                optionToExit();
            }
        }
    }
}