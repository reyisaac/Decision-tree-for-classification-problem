import java.io.*;
import java.util.Scanner;

public class DT {

    //CREATING THE TREE
    private class Tree {
        private int key;
        private String questOrAns = null;
        private Tree yes = null;
        private Tree no = null;

        public Tree(int key, String questOrAns) {
            this.key = key;
            this.questOrAns = questOrAns;
        }
    }

    Tree root = null;

    //DEFAULT CONSTRUCTOR
    public DT() { }

    /* CREATE ROOT NODE */

    public void createRoot(int newNodeID, String newQuestAns) {
        root = new Tree(newNodeID,newQuestAns);
        System.out.println("Created root node " + newNodeID);
    }

    /* ADD YES NODE */

    public void addYesNode(int existingNodeID, int newNodeID, String newQuestAns) {
        // If no root node do nothing

        if (root == null) {
            System.out.println("ERROR: No root node!");
            return;
        }

        // Search tree

        if (searchAddYesNode(root, existingNodeID, newNodeID, newQuestAns)) {
            System.out.println("Added node " + newNodeID +
                    " onto \"yes\" branch of node " + existingNodeID);
        }
        else System.out.println("Node " + existingNodeID + " not found");
    }

    /* SEARCH TREE AND ADD YES NODE */

    private boolean searchAddYesNode(Tree node, int existingNodeKey, int newNodeKey, String newQuestAns) {

        if (node.key == existingNodeKey) {
            // Found node
            if (node.yes == null) node.yes = new
                    Tree(newNodeKey,newQuestAns);
            else {
                System.out.println("WARNING: Overwriting previous node " +
                        "(id = " + node.yes.key +
                        ") linked to yes branch of node " +
                        existingNodeKey);
                node.yes = new Tree(newNodeKey,newQuestAns);
            }
            return(true);
        }
        else {
            // Try yes branch if it exists
            if (node.yes != null) {
                if (searchAddYesNode(node.yes, existingNodeKey ,newNodeKey, newQuestAns)) {
                    return(true);
                }
                else {
                    // Try no branch if it exists
                    if (node.no != null) {
                        return(searchAddYesNode(node.no, existingNodeKey, newNodeKey, newQuestAns));
                    }
                    else return(false);	// Not found here
                }
            }
            return(false);		// Not found here
        }
    }

    /* ADD NO NODE */

    public void addNoNode(int existingNodeKey, int newNodeKey, String newQuestAns) {
        // If no root node do nothing

        if (root == null) {
            System.out.println("ERROR: No root node!");
            return;
        }

        // Search tree

        if (searchAddNoNode(root,existingNodeKey, newNodeKey,newQuestAns)) {
            System.out.println("Added node " + newNodeKey + " onto \"no\" branch of node " + existingNodeKey);
        }
        else System.out.println("Node " + existingNodeKey + " not found");
    }

    /* SEARCH TREE AND ADD NO NODE */

    private boolean searchAddNoNode(Tree node, int existingNodeKey, int newNodeKey, String newQuestAns) {

        if (node.key == existingNodeKey) {
            // Found node
            if (node.no == null) node.no = new
                    Tree(newNodeKey,newQuestAns);
            else {
                System.out.println("WARNING: Overwriting previous node " +
                        "(id = " + node.no.key +
                        ") linked to yes branch of node " +
                        existingNodeKey);
                node.no = new Tree(newNodeKey,newQuestAns);
            }
            return(true);
        }
        else {
            // Try yes branch if it exists
            if (node.yes != null) {
                if (searchAddNoNode(node.yes, existingNodeKey, newNodeKey, newQuestAns)) {
                    return(true);
                }
                else {
                    // Try no branch if it exists
                    if (node.no != null) {
                        return(searchAddNoNode(node.no,
                                existingNodeKey,newNodeKey,newQuestAns));
                    }
                    else return(false);	// Not found here
                }
            }
            else return(false);	// Not found here
        }
    }

    /* --------------------------------------------- */
    /*                                               */
    /*               TREE QUERY METHODS             */
    /*                                               */
    /* --------------------------------------------- */

    public void queryBinTree() throws IOException {
        queryBinTree(root);
    }

    private void queryBinTree(Tree currentNode) throws IOException {

        // Test for leaf node (answer) and missing branches

        if (currentNode.yes==null) {
            if (currentNode.no==null) System.out.println(currentNode.questOrAns);
            else System.out.println("Error: Missing \"Yes\" branch at \"" +
                    currentNode.questOrAns + "\" question");
            return;
        }
        if (currentNode.no==null) {
            System.out.println("Error: Missing \"No\" branch at \"" +
                    currentNode.questOrAns + "\" question");
            return;
        }

        // Question

        askQuestion(currentNode);
    }

    private void askQuestion(Tree currentNode) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(currentNode.questOrAns + " (enter \"Yes\" or \"No\")");
        String answer = keyboard.nextLine();
        if (answer.equals("Yes")) queryBinTree(currentNode.yes);
        else {
            if (answer.equals("No")) queryBinTree(currentNode.no);
            else {
                System.out.println("ERROR: Must answer \"Yes\" or \"No\"");
                askQuestion(currentNode);
            }
        }
    }

    /* ----------------------------------------------- */
    /*                                                 */
    /*               TREE OUTPUT METHODS               */
    /*                                                 */
    /* ----------------------------------------------- */

    /* OUTPUT BIN TREE */

    public void outputBinTree() {

        outputBinTree("1",root);
    }

    private void outputBinTree(String tag, Tree currentNode) {

        // Check for empty node

        if (currentNode == null) return;

        // Output

        System.out.println("[" + tag + "] nodeID = " + currentNode.key +
                ", question/answer = " + currentNode.questOrAns);

        // Go down yes branch

        outputBinTree(tag + ".1",currentNode.yes);

        // Go down no branch

        outputBinTree(tag + ".2",currentNode.no);
    }
}




