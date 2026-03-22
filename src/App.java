public class App {
    public static void main(String[] args) throws Exception {
        Search search = new Search("Recipes.tt");
        search.checkAllergens();
        search.enableSoy();
        search.enablePeanuts();
        search.checkAllergens();


    }
}
