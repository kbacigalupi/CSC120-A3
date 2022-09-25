import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.lang.*;

class Conversation {


  public static void main(String[] arguments) {
    System.out.println("Hello! How many round of conversation would you like?");
    Scanner input = new Scanner(System.in); 
    int rounds = input.nextInt(); //Takes in the number of rounds, used in for loop below to determine number of computer replies
    System.out.println("What are you thinking about today?"); //Starts the covnersation the same way every time 

//Starts the transcript with the original question-this transcript array is added onto throughout

    ArrayList<String> transcript = new ArrayList<String>();
      transcript.add("What are you thinking about today?");


    for (int i = 0; i < rounds; i++) {
      Scanner convo = new Scanner(System.in);
      String reply = convo.nextLine();

      transcript.add(reply); //Adds the reply to the transcript


      reply = reply.toLowerCase();//Makes input lower case after it has been added to the transcript to mirror words more easily

      String[] strSplit = reply.split(" ");
      ArrayList<String> mirrored = new ArrayList<String>(Arrays.asList(strSplit));
      String response = "";

      for (String str: mirrored) {
        response += mirror(str);
      }
      response = response.substring(1, response.length());

      if (!response.toLowerCase().equals(reply)) {
        transcript.add(response); //Adds the new question to the transcript
        response += "?";
        System.out.println(response); //Prints out the new question
      }

    else {

      String[] canned_response = {
          "Really?", "Definitley", "Hmmm tell me more about that", "Interesting", "Wait me too!", "Hmmm I understand", "Wow I was thinking the same!"
        };

      Random rand = new Random(); 
      int index = rand.nextInt(canned_response.length);
      String question = canned_response[index];
      System.out.println(question);
      transcript.add(question);
    }

   }

   //If it is the last round of conversation, the program goes to the ending sequence
    transcript.add("Mmmhmmm"); //Adds Mmmhmmm to the transcript
    System.out.println("Mmmhmmm"); 
    System.out.println("See ya!");
    transcript.add("See ya!");
    System.out.println(" "); //Creates a space
    System.out.println("TRANSCRIPT:"); //Tells the user that a transcript is coming
    for (int j = 0; j < transcript.size(); j++) { //prints every item in the transcript 
      System.out.println(transcript.get(j));
      }

  }

public static String mirror (String word) {
    if (word.equals("i")) {
      return " you";
    }
    if (word.equals("me")) {
      return " you";
    }
    if (word.equals("am")) {
      return " are ";
    }
    if (word.equals("are")) {
      return " am";
    }
    if (word.equals("you")) {
      return " I";
    }
    if (word.equals("my")) {
      return " your";
    }
    if (word.equals("your")) {
      return " my";
    }
    if (word.equals("i'm")) {
      return " you're";
    }
    if (word.equals("you're")) {
      return " I'm";
    }
    else {
      return (" " + word);
    }
  }
}


/*I -> you
* me -> you
* am -> are
* you -> I
* my -> your
* your -> my/* */