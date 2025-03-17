import java.util.Scanner;

public class NLPRunner {
  
  /**
   * Main method that runs the NLP program.
   * Continuously asks the user for a word to find synonyms for,
   * until the user types "end".
   * 
   * @param args Command-line arguments (not used).
   */
  public static void main(String[] args) {
    
    // Scanner object to get user input
    Scanner input = new Scanner(System.in);
    String user = "";

    // Loop continues until user enters "end"
    while (!(user.equals("end"))) {
      
      // Ask the user for a word
      System.out.println("What word would you like to see synonyms for: ");
      
      // Read user input
      user = input.nextLine();
      
      // Create a Thesaurus object with the input word
      Thesaurus salik = new Thesaurus(user, "stems.txt", "synonyms.txt");
      
      // Run the Thesaurus process
      salik.run();
    }
    
  }
}