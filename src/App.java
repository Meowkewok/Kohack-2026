
public class App {
    public static void main(String[] args) throws Exception {
        Substitutes substitutes = new Substitutes("Recipes.txt");
        GUI.makeGUI(substitutes);
    }
}
