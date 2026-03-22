public class App {
    public static void main(String[] args) throws Exception {
        Search search = new Search("Recipes.txt");
        search.checkAllergens();
        Input.getAllPrefrences(search);
        search.checkAllergens();


    }
}
