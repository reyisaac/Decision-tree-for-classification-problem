import java.io.*;
import java.util.Scanner;

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
        TreeGeneration.generateTree(newTree);

        // Query tree
        TreeGeneration.queryTree(newTree);
    }

}