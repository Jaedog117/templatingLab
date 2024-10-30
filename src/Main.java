import java.util.*;
import java.io.*;

interface Ingredient {
    String getName();
    double getQuantity();
}

class SolidIngredient implements Ingredient {
    private final String _name;
    private final double _quantity;
    public SolidIngredient(String name, double quantity) {
        _name = name;
        _quantity = quantity;
    }
    public String getName() {
        return _name;

    }
    public double getQuantity() {
        return _quantity;
    }
}

class LiquidIngredient implements Ingredient {
    private final String _name;
    private final int _quantity;
    public LiquidIngredient(String name, int quantity) {
        _name = name;
        _quantity = quantity;
    }
    public String getName() {
        return _name;
    }
    public double getQuantity() {
        return _quantity;
    }
}

class Recipe<T extends Ingredient> {
    private ArrayList<T> _ingredients;
    private String _name;
    private String _instructions;
    public Recipe (ArrayList<T> ingredients, String name, String instructions) {}
    public void addIngredient(T t) {
        _ingredients.add(t);
    }
    public void print() {
        if (_ingredients != null)
            System.out.println("Name: " + _name + "Ingredients: " + _ingredients + "Instructions: " + _instructions);
        else
            System.out.println("null member variable");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}