import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Search {

    private String[] soyAllergens = FileReader.toStringArray("soy.txt");
    private boolean enableSoy = false;
    private boolean enablePeanuts = false;
    private boolean enableKosher = false;
    private boolean enableVegetarian = false;


    public Search() {
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

    public boolean checkSoy(String filename) {
         try {
            // Read the entire file content into a String
            String content = new String(Files.readAllBytes(Paths.get(filename)));
            // Split by punctuation and whitespace
            String[] words = content.split("[\\p{Punct}\\s]+");
            // checks if any of the soy allergens are present in the words array      
            for (int i = 0; i < soyAllergens.length; i++) {
                for (int x = 0; x < words.length; x++) {
                    if (words[x].toLowerCase().equals(soyAllergens[i])) {
                        return true;
                }
            }
        }
        } catch (IOException e) {
            return false;
        }
        // returns false if no soy allergens are found or if there is an error reading the file
        return false;
    }
    public boolean checkSoy(String filename) {
         try {
            // Read the entire file content into a String
            String content = new String(Files.readAllBytes(Paths.get(filename)));
            // Split by punctuation and whitespace
            String[] words = content.split("[\\p{Punct}\\s]+");
            // checks if any of the soy allergens are present in the words array      
            for (int i = 0; i < soyAllergens.length; i++) {
                for (int x = 0; x < words.length; x++) {
                    if (words[x].toLowerCase().equals(soyAllergens[i])) {
                        return true;
                }
            }
        }
        } catch (IOException e) {
            return false;
        }
        // returns false if no soy allergens are found or if there is an error reading the file
        return false;
    }



    


}