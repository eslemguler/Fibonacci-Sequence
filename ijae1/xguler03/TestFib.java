package ijae1.xguler03;

import java.util.Arrays;
import java.util.Scanner;
// This library helps us to get the input from user

public class TestFib {

    // This is the method I use for running the fibonacci
    static void firstElements(int x1, int x2, int p){
        int x3, i;

        System.out.println(x1);
        System.out.println(x2);
        //First, I printed the first 2 members of the fibonacci which was given

        for (i = 0; i < p-2; i++) {
            x3 = x2 + x1;           //Then assigned the third member of fibonacci
            System.out.println(x3);
            x1 = x2;                //To continue running this program, we have to allocate memory for others coming
            x2 = x3;                //That's why I assigned the second element to first and third to second
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);  //This tells java that we will get input in variable 'scan'
        String userInput = scan.nextLine();     //This gets the input

        if (userInput.isEmpty() || userInput.equals(" ")) { //Checking if the input is empty
            System.out.println("No argument specified.");
        }

        String[] words = userInput.split(" ");

        try {
            int[] ints = Arrays.stream(words).mapToInt(Integer::parseInt).toArray();
                /*
                This method was the only one it worked for me because I had to use string to cluster my choices by
                having one element or three. In this method I try to copy the elements in the 'words' string array to
                'ints' integer array. I used try catch because if there is a text or a word in the 'words' array program
                will print that this is not a number, so it cannot be copied. This helps because instead of giving an
                error to user, I just let user know this is not a number in a more convenient way.
                 */
        }
        catch (NumberFormatException e) {
            System.out.println("Argument is not a number.");
        }

        /*
         I got the input as a string because we have to decide if the input has 1 or 3 elements to continue.
         However, since the input is string, I had to convert it to integer and to do that, firstly I had to
         separate the elements and count them to cluster them. Line 34 separates the string and assign the string
         to an array called 'words'
        */

        if (words.length != 1 && words.length != 3){
            System.out.println("Incorrect number of arguments.");
            //Checking if the number of arguments are correct
        }

        if (words.length == 1 ){
            //If the array has 1 element, it only has to print first n elements of fibonacci
            int n = Integer.parseInt(words[0]);
            firstElements(0,1, n);
        }

        if (words.length == 3){
            //I used parse again to convert the elements entered to integers
            int seed1 = Integer.parseInt(words[0]);
            int seed2 = Integer.parseInt(words[1]);
            int n = Integer.parseInt(words[2]);

            if (seed1>=seed2){
                System.out.println("First number has to be smaller than the second.");
            }

            else{
                        firstElements(seed1, seed2, n);
                    }
            }
        }
    }


