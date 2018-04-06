import java.io.*;
import java.util.ArrayList;

class Tester {

    static BufferedReader keyboardInput = new
            BufferedReader(new InputStreamReader(System.in));
    static DT newTree;

    public static void main(String[] args) throws IOException {

        newTree = new DT();
        Users[] user = new Users[14];
        //added database of users
        user[0] = new Users("youth","no","fair","high","no");
        user[1] = new Users("youth","no","excellent","high","no");
        user[2] = new Users("youth","no","fair","medium","no");
        user[3] = new Users("youth","yes","fair","low","yes");
        user[4] = new Users("youth","yes","excellent","medium","yes");
        user[5] = new Users("middle_age","no","fair","high","yes");
        user[6] = new Users("middle_age","yes","excellent","low","yes");
        user[7] = new Users("middle_age","no","excellent","medium","yes");
        user[8] = new Users("middle_age","yes","fair","high","yes");
        user[9] = new Users("senior","no","fair","medium","yes");
        user[10] = new Users("senior","yes","excellent","low","yes");
        user[11] = new Users("senior","yes","excellent","low","no");
        user[12] = new Users("senior","yes","fair","medium","yes");
        user[13] = new Users("senior","no","excellent","medium","no");

        // Generate tree
        generateTree();

        // Query tree
        queryTree();
    }

    /* GENERATE TREE WITH SET VALUES GIVEN FROM TRAINING AND INFORMATION GAIN*/

    static void generateTree() {
        System.out.println("\nGENERATE DECISION TREE");
        System.out.println("======================");
        newTree.createRoot(1,"Is user young?");
        newTree.addYesNode(1,2,"Is user student?");
        newTree.addNoNode(1,3,"Is user middle_age?");
        newTree.addYesNode(2,4,"WIll BUY IT");
        newTree.addNoNode(2,5,"WONT BUY IT");
        newTree.addYesNode(3,6,"WIll BUY IT"); //if middle age will always buy it
        newTree.addNoNode(3,7,"Is user student?"); //no node if senior
        newTree.addYesNode(7,8,"Is user's cred_rating fair?");
        newTree.addNoNode(7,9,"Is user's cred_rating fair?");
        newTree.addYesNode(8,10,"WIll BUY IT");
        newTree.addNoNode(8,11,"WONT BUY IT");
        newTree.addYesNode(9,12,"WIll BUY IT");
        newTree.addNoNode(9,13,"WONT BUY IT");
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