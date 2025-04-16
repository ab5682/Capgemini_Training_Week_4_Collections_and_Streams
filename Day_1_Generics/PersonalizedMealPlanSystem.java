interface MealPlan {
    String getMealDetails();
}

class VegetarianMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Vegetarian Meal: Salad, Grilled Vegetables, Rice.";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Vegan Meal: Tofu Stir Fry, Quinoa, Smoothie.";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Keto Meal: Grilled Chicken, Avocado Salad, Cheese.";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "High Protein Meal: Steak, Boiled Eggs, Protein Shake.";
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        return new Meal<>(mealPlan);
    }
}

public class PersonalizedMealPlanSystem {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generateMealPlan(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(new VeganMeal());
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(new KetoMeal());
        Meal<HighProteinMeal> proteinMeal = MealPlanGenerator.generateMealPlan(new HighProteinMeal());

        System.out.println(vegMeal.getMealPlan().getMealDetails());
        System.out.println(veganMeal.getMealPlan().getMealDetails());
        System.out.println(ketoMeal.getMealPlan().getMealDetails());
        System.out.println(proteinMeal.getMealPlan().getMealDetails());
    }
}
