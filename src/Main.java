import java.util.*;

interface Ingredient {
    String getName();
    double getQuantity();
}

class SolidIngredient implements Ingredient {
    private final String _name;
    private final double _qtyInGrams;
    public SolidIngredient(String name, double qtyInGrams) {
        _name = name;
        _qtyInGrams = qtyInGrams;
    }
    public String getName() {
        return _name;
    }
    public double getQuantity() {
        return _qtyInGrams;
    }
}

class LiquidIngredient implements Ingredient {
    private final String _name;
    private final double _qtyInMl;
    public LiquidIngredient(String name, double qtyInMl) {
        _name = name;
        _qtyInMl = qtyInMl;
    }
    public String getName() {
        return _name;
    }
    public double getQuantity() {
        return _qtyInMl;
    }
}

class Recipe<T extends Ingredient> {
    private ArrayList<T> _ingredients;
    private String _name;
    private String _instructions;
    public Recipe (String name, String instructions) {
        _name = name;
        _instructions = instructions;
        _ingredients = new ArrayList<>();
    }
    public void addIngredient(T t) {
        _ingredients.add(t);
    }
    public void print() {
        if (!_ingredients.isEmpty()) {
            System.out.println("Recipe: " + _name);
            System.out.println("Instructions: " + _instructions);
            System.out.println("Ingredients: ");
            for (T t: _ingredients)
                System.out.println("- " + t.getName() + ": " + t.getQuantity());
        } else {
            System.out.println("No ingredients in the recipe.");
        }
    }
}

public class Main {
    public static int menu(Scanner scan) {
        System.out.println(" Recipe Book System ");
        System.out.println("---------------------------");
        System.out.println("Enter recipe name: ");
        String recipeName = scan.nextLine();
        System.out.println("Enter recipe instructions: ");
        String recipeInstructions = scan.nextLine();
        Recipe<Ingredient> recipe = new Recipe<>(recipeName, recipeInstructions);
        System.out.println(" Recipe Book System ");
        System.out.println("---------------------------");
        System.out.println("1. Add an ingredient");
        System.out.println("2. List recipe ingredients");
        System.out.println("3. Exit");
        int choice = scan.nextInt();
        try {
            while (choice != 3) {
                if (choice == 1)
                    addIngredient(recipe, scan);
                else if (choice == 2)
                    recipe.print();
                else
                    System.out.println("Invalid choice, please select again.");
                System.out.println(" Recipe Book System ");
                System.out.println("---------------------------");
                System.out.println("1. Add an ingredient");
                System.out.println("2. List recipe ingredients");
                System.out.println("3. Exit");
                choice = Integer.parseInt(scan.nextLine());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid data entered. Please enter a number (1-3).");
        }
        System.out.println("Goodbye!");
        return choice;
    }

    public static void addIngredient(Recipe<Ingredient> recipe, Scanner scan) {
        System.out.println("Solid(s) or liquid (l)?");
        char type = scan.next().toLowerCase().charAt(0);
        System.out.println("Enter ingredient name: ");
        String name = scan.nextLine();
        name = scan.nextLine();
        System.out.println("Enter quantity: ");
        double quantity = 0;
        try {
            quantity = Double.parseDouble(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity entered.");
            return;
        }

        Ingredient ingredient;
        if (type == 's') {
            ingredient = new SolidIngredient(name, quantity);
        } else if (type == 'l') {
            ingredient = new LiquidIngredient(name, quantity);
        } else {
            System.out.println("Invalid ingredient type. Please enter 's' for solid or 'l' for liquid.");
            return;
        }
        recipe.addIngredient(ingredient);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        menu(scan);
        scan.close();
    }
}
