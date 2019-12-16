/*
Name: Jeremy Gart
Date: Ocotber 23, 2019
Purpose: To test the code written in MinStack
Signiature: JG
*/
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BST_Tester {
    public static void main(String []args) 
    throws IOException, FileNotFoundException, EmptyStackException{
        
    //creates an object to read in the data from test.txt
    File text = new File("./test.txt");
    //creates a scanner to read in from the file
    Scanner scnr = new Scanner(text);
    //string to hold output to log files
    String results = new String();
    
    try{
        results += "Test Empty Constructor:";
        //Empty Constructor code we want to test
          BST maple = new BST();
           results+= "\nSize should be: 0, Actual: " + maple.size()
                   + "\nPassed: " + (maple.size() == 0)
                   + "\n";
        
        for (int i = 0; i < 8; i++){
        String s = scnr.nextLine();
        String[] sarray = s.split(" ");
        int one = Integer.parseInt(sarray[0]);
        int two = Integer.parseInt(sarray[1]);
        int three = Integer.parseInt(sarray[2]);
        int four = Integer.parseInt(sarray[3]);
        int five = Integer.parseInt(sarray[4]);

        maple.put(one, two);
        results += "Put/Get should be: " + one + " with value " + two + ", actual value: " + maple.get(one) + " at key " + one;

        results += "Size should be: " + five +  ", actual: " + maple.size()
                + "\nPassed: " + (maple.size() == five)
                + "\n";
        
        results += "Minimum should be " + three + " and maximum should be " + four
                + "\nPassed: " + (maple.min().equals(three) && maple.max().equals(four))
                + "\n";
        
        results += "ToString: " + maple.toString();
        }

        for (int i = 0; i < 7; i++){
            String s = scnr.nextLine();
            String[] sarray = s.split(" ");
            int one = Integer.parseInt(sarray[0]);
            int two = Integer.parseInt(sarray[1]);
            int three = Integer.parseInt(sarray[2]);
            
            results += "Remove key " + one + ": " + maple.remove(one) + "New size should be: " + (6-i) + " , actual: " + maple.size();
            results += "Minimum should be " + two + " and maximum should be " + three
                    + "\nPassed: " + (maple.min().equals(two) && maple.max().equals(three))
                    + "\n";
            results += "New ToString: " + maple.toString();
        }

}
    catch(Exception e){//what happens if code throws an error
        results+="\nERROR: " + e + "\n";
     }

        //setting up log system
        Scanner e = new Scanner(System.in);
        System.out.println("enter log name");
        BufferedWriter writer = new BufferedWriter(new FileWriter(e.nextLine()));
        writer.write(results);

        writer.close();
}
}