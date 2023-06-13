import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends JFrame {
    final GuiVersion gui;
    public final List<String> availableIngredients;
    public final List<Recipe> recipes;

    public Main() {
        availableIngredients = Arrays.asList("dal", "tomato", "onion", "garlic", "mustard oil",
                "salt", "pepper", "pasta", "cheese","green chillies","potato","olive oil");
        recipes = new ArrayList<>();
        recipes.add(new Recipe("Dal Makhani",
                Arrays.asList("dal", "green chillies", "tomato", "onion", "garlic", "mustard oil", "salt", "pepper")));
        recipes.add(new Recipe("Cheesy Tomato Pasta",
                Arrays.asList("pasta", "tomato", "garlic", "olive oil", "salt", "pepper", "cheese")));
        recipes.add(new Recipe("Aloo Masala",
                Arrays.asList("potato", "green chillies","onion", "garlic", "mustard oil", "salt", "pepper")));

        gui = new GuiVersion(this);
    }

    public List<Recipe> findMatchingRecipes(List<String> userIngredients, List<Recipe> recipes) {
        List<Recipe> matchingRecipes = new ArrayList<>();

        for (Recipe recipe : recipes) {
            List<String> requiredIngredients = recipe.getRequiredIngredients();
            if (userIngredients.containsAll(requiredIngredients)) {
                matchingRecipes.add(recipe);
            }
        }

        return matchingRecipes;
    }

    static class Recipe {
        private final String name;
        private final List<String> requiredIngredients;

        public Recipe(String name, List<String> requiredIngredients) {
            this.name = name;
            this.requiredIngredients = requiredIngredients;
        }

        public String getName() {
            return name;
        }

        public List<String> getRequiredIngredients() {
            return requiredIngredients;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
