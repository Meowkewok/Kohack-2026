import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Search {

    // instance variable used to disable the allergen checks if the file is invalid
    private boolean disable = false;

    // instance array of words from the recipe
    private String[] words;

    // arrays of allergens for each category, read from text files
    private String[] soyAllergens = FileReader.toStringArray("soy.txt");
    private String[] peanutAllergens = FileReader.toStringArray("peanut.txt");
    private String[] kosherAllergens = FileReader.toStringArray("kosher.txt");
    private String[] vegetarianAllergens = FileReader.toStringArray("vegetarian.txt");
    
    // instance variables to enable or disable each allergen check based on user input
    private boolean enableSoy = false;
    private boolean enablePeanuts = false;
    private boolean enableKosher = false;
    private boolean enableVegetarian = false;

    // instantiates a search object using a given file name and then calls the method to get the words from the recipe
    public Search(String filename) {
        getWordsFromRecipe(filename);
    }

    public String[] getSoyAllergens() {
        return soyAllergens;
    }
    public String[] getPeanutAllergens() {
        return peanutAllergens;
    }
    public String[] getKosherAllergens() {
        return kosherAllergens;
    }
    public String[] getVegetarianAllergens() {
        return vegetarianAllergens;
    }

    // Enables or diables the soy allergen check
    public void enableSoy() {
        this.enableSoy = true;
    }
    public void disableSoy() {
        this.enableSoy = false;
    }
    // Enables or diables the peanut allergen check
    public void enablePeanuts() {
        this.enablePeanuts = true;
    }
    public void disablePeanuts() {
        this.enablePeanuts = false;
    }
    // Enables or diables the kashrut check
    public void enableKosher() {
        this.enableKosher = true;
    }
    public void disableKosher() {
        this.enableKosher = false;
    }
    // Enables or diables the vegetarian check
    public void enableVegetarian() {
        this.enableVegetarian = true;
    }
    public void disableVegetarian() {
        this.enableVegetarian = false;
    }

    // returns the words array
    public String[] getWords() {
        return words;
    }

    // checks for allergens based on the user preferences and prints the results to the console
    public void checkAllergens() {
        if (!disable) {
            if (enableSoy) {
                if (checkSoy()) {
                    System.out.println("This recipe contains soy allergens.");
                } else {
                    System.out.println("This recipe does not contain soy allergens.");
                }
            }
            if (enablePeanuts) {
                if (checkPeanuts()) {
                    System.out.println("This recipe contains peanut allergens.");
                } else {
                    System.out.println("This recipe does not contain peanut allergens.");
                }
            }
            if (enableKosher) {
                if (checkKosher()) {
                    System.out.println("This recipe contains kashrut issues.");
                } else {
                    System.out.println("This recipe does not contain kashrut issues.");
                }
            }
            if (enableVegetarian) {
                if (checkVegetarian()) {
                    System.out.println("This recipe contains vegetarian issues.");
                } else {
                    System.out.println("This recipe does not contain vegetarian issues.");
                }
            }
        }
    }

    // reads the words from the given file and seperates them into an array
    private void getWordsFromRecipe(String filename) {
         try {
            // checks if the file is a .txt file
            if (filename.contains(".txt")) {
                // Read the entire file content into a String
                String content = new String(Files.readAllBytes(Paths.get(filename)));
                // Split by punctuation and whitespace
                words = content.split("[\\p{Punct}\\s]+");
                if (words.length == 0) {
                    System.out.println("The file is empty or contains no valid words.");
                }
                if (words.length > 0) {
                    System.out.println("Recipe loaded sucessfully.");
                }
            }
            else {
                System.out.println("Invalid file type. Please provide a .txt file.");
                disable = true;
            }
            } catch (IOException e) {
        }
    }

    public boolean checkSoy() {
        // checks if any of the soy allergens are present in the words array      
        for (String soyAllergen : soyAllergens) {
            for (String word : words) {
                if (word.toLowerCase().equals(soyAllergen)) {
                    // returns true if a soy allergen is found
                    return true;
                }
            }
        }
        // returns false if no soy allergens are found
        return false;
    }
    
    public boolean checkPeanuts() {
        // checks if any of the peanut allergens are present in the words array
        for (String peanutAllergen : peanutAllergens) {
            for (String word : words) {
                if (word.toLowerCase().equals(peanutAllergen)) {
                    // returns true if a peanut allergen is found
                    return true;
                }
            }
        }
        // returns false if no peanut allergens are found
        return false;
    }

    public boolean checkKosher() {
        // checks if any of the kosher "allergens" are present in the words array
        for (String kosherAllergen : kosherAllergens) {
            for (String word : words) {
                if (word.toLowerCase().equals(kosherAllergen)) {
                    // returns true if a kashrut issue is found
                    return true;
                }
            }
        }
        // returns false if no kashrut issues are found
        return false;
    }
    
    private boolean checkVegetarian() {
        // checks if any of the vegetarian "allergens" are present in the words array
        for (String vegetarianAllergen : vegetarianAllergens) {
            for (String word : words) {
                if (word.toLowerCase().equals(vegetarianAllergen)) {
                    // returns true if a vegetarian issue is found
                    return true;
                }
            }
        }
        // returns false if no vegetarian issues are found
        return false;
    }
}