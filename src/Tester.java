import java.io.*;
import java.util.Scanner;

class Tester {
    static DT newTree;
    public static double entropy;
    public static void main(String[] args) throws IOException {
        String[] list_attribute = {"age","student","cred_rating", "income","buys_computer"};
        int attributeSelection = 0;
        String[][] user = {
                {"youth", "no", "fair", "high", "false"},
                {"youth", "no", "excellent", "high", "false"},
                {"youth", "no", "fair", "medium", "false"},
                {"youth","yes","fair","low","true"},
                {"youth","yes","excellent","medium","true"},
                {"middle_age","no","fair","high","true"},
                {"middle_age","yes","excellent","low","true"},
                {"middle_age","no","excellent","medium","true"},
                {"middle_age","yes","fair","high","true"},
                {"senior","no","fair","medium","true"},
                {"senior","yes","excellent","low","true"},
                {"senior","yes","excellent","low","false"},
                {"senior","yes","fair","medium","true"},
                {"senior","no","excellent","medium","false"}
        };

        //PART2
        printTuple(list_attribute, user, attributeSelection); //printing as substitution for tree.
        entropy = entropy(user);
        attributeSelection = splitting_attribute(user);
        System.out.println("");
        System.out.println("Youth");
        printTuple(list_attribute, split_attributes("youth" ,user), attributeSelection);
        System.out.println("");
        System.out.println("Middle_age");
        printTuple(list_attribute, split_attributes("middle_age" ,user), attributeSelection);
        System.out.println("");
        System.out.println("Senior");
        printTuple(list_attribute, split_attributes("senior" ,user), attributeSelection);

        //PART3
        newTree = new DT();
        // Generate tree
        TreeGeneration.generateTree(newTree);

        // Query tree
        TreeGeneration.queryTree(newTree);
    }

    static void printTuple(String[] attribute, String[][] user, int attToRemove){
        for(int i = 0; i < 5; i++) {
            if(i == (attToRemove - 1)) continue;
            System.out.print(attribute[i] + "  ");
        }
        System.out.println("");
        for(int i = 0; i < user.length; i++){
            for (int k = 0; k < user[i].length; k++) {
                if (user[i][k] == null) continue;
                if(k == (attToRemove - 1)) continue;
                System.out.print(user[i][k] + "   ");
            }
            System.out.print("\n");
        }
    }

    static double entropy(String[][] user) {
        int belongToClass = 0;
        int noBelongToClass = 0;
        int tuples = 14;
        double entropy;

        for (int i = 0; i < user.length; i++) {
            for (int k = 0; k < user[i].length; k++) {
                if (user[i][k] == "true") belongToClass++;
                if (user[i][k] == "false") noBelongToClass++;
            }
        }

        //entropy algorithm
        double w, x, y, z;
        w = (double) belongToClass / (double) tuples;
        x = w * log2(w);
        y = (double) noBelongToClass / (double) tuples; //also used for categories
        z = y * log2(y);
        entropy = -x - z;

        return entropy;
    }

    public static double log2(double num)
    {
        return (Math.log(num)/Math.log(2));
    }

    public static int splitting_attribute(String[][]user) {
        int att = 0;
        for (int i = 0; i < user.length; i++) {
            for (int k = 0; k < user[i].length; k++) {
                if (user[i][k] == "age") att++;
                att = 1;
                return att;
            }
        }
        return att;
    }

    public static String[][] split_attributes(String attribute, String[][] user) {
        String[][] data_splited = new String[5][14];
        int[] rows_chosen = {16,16,16,16,16,16,16,16,16,16,16,16,16};
        int count = 0;
        for (int i = 0; i < user.length; i++) {
            for (int k = 0; k < user[i].length; k++) {
                if (user[i][k] == attribute){
                    rows_chosen[count] = i;
                    count++;
                }
            }
        }

        for (int i = 0; i < rows_chosen.length; i++){
            //data_splited[][] = rows_chosen[i];
            for (int x = 0; x < user.length; x++) {
                for (int k = 0; k < user[x].length; k++) {
                    if (x == rows_chosen[i]) {
                        data_splited[i][k] = user[x][k];
                    }
                }
            }
        }
        return data_splited;
    }
}