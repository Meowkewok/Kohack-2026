public class App {
    public static void main(String[] args) throws Exception {
        Search search = new Search("recipe.txt");
        search.checkAllergens();
        search.enableSoy();
        search.enablePeanuts();
        search.checkAllergens();


    }
}
