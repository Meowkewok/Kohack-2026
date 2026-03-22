public class App {
    public static void main(String[] args) throws Exception {
        Search search = new Search("Recipes.txt");
        search.checkAllergens();
        search.enableKosher();
        //Input.getAllPrefrences(search);
        //search.checkAllergens();
        //Input.editPreferences(search);
        //search.checkAllergens();
        //Input.close();
        Substitutes substitutes = new Substitutes("Recipes.txt");
        substitutes.enableSoy();
        System.out.println(substitutes.substituteAll());

    }
}
