import java.util.ArrayList;

/**
 * The Thesaurus class finds synonyms for a given word.
 * It checks if the word exists in the stems list and retrieves its synonyms.
 */
public class Thesaurus {

  private String userInput;
  private ArrayList<String> stems;
  private ArrayList<String> synonyms;

  /**
   * Constructor that initializes the Thesaurus with the user's input word
   * and loads stem words and synonyms from files.
   *
   * @param userInput        The word inputted by the user.
   * @param stemsFilename    The file containing word stems.
   * @param synonymsFilename The file containing synonyms.
   */
  public Thesaurus(String userInput, String stemsFilename, String synonymsFilename) {
    this.userInput = userInput;
    stems = FileReader.toStringList(stemsFilename);
    synonyms = FileReader.toStringList(synonymsFilename);
  }

  /**
   * Runs the synonym lookup process.
   * - Checks if the word exists in the stems list.
   * - Finds synonyms for the root word.
   * - Randomly selects and prints one synonym if found.
   */
  public void run() {
    String checked = checkInput();

    if (!(checked.equals("String Not Found"))) {

      String[] found = findSynonyms(checked);

      if (!(found[0].equals("Empty"))) {
        // Print a random synonym from the found list
        System.out.println(found[(int) (Math.random() * found.length)]);
      } else {
        System.out.println("Checked but not Found");
      }

    } else {
      System.out.println("Check Failed");
    }
  }

  /**
   * Checks if the user's word exists in the stems list.
   * If found, returns the root form of the word.
   * 
   * @return The root word if found, otherwise "String Not Found".
   */
  public String checkInput() {
    // Loop through each line in the stems list
    for (int i = 0; i < stems.size(); i++) {
      String currentLine = stems.get(i);
      String[] options = currentLine.split(" -> "); // Splitting word variations and root
      String[] versions = options[0].split(" "); // List of word variations
      String root = options[1].substring(options[1].indexOf("-") + 1); // Extract root word

      // Check if user input matches any word variation
      for (int j = 0; j < versions.length; j++) {
        if (versions[j].equals(userInput)) {
          return root;
        }
      }

      // Check if the user input is already the root word
      if (root.equals(userInput)) {
        return root;
      }
    }

    return "String Not Found"; // Return if word is not found
  }

  /**
   * Finds synonyms for a given word by checking the synonyms list.
   * 
   * @param userWord The word whose synonyms need to be found.
   * @return An array of synonyms if found, otherwise an array with "Empty".
   */
  public String[] findSynonyms(String userWord) {
    String[] empty = new String[1];
    empty[0] = "Empty"; // Default return value if no synonyms found

    // Loop through each line in the synonyms list
    for (int i = 0; i < synonyms.size(); i++) {
      String row = synonyms.get(i);
      String[] choices = row.split(", "); // Splitting synonyms by comma

      // Check if the word is present in the row
      for (int j = 0; j < choices.length; j++) {
        if (userWord.equals(choices[j])) {
          return choices;
        }
      }
    }

    return empty; // Return "Empty" if no synonyms were found
  }

}