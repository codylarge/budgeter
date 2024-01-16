package file;

import utils.Utils;

import java.util.Scanner;

// The DataFields class is a class that stores some data about the player that will be changed throughout the game such as cash for easy access.
// The DataFields class also contains methods to read and update data.
public class DataField
{
    /* DATA */
    private String name;
    private int budget, totalSpent, foodSpent, gasSpent, coffeeSpent, personalSpent, necessitySpent, otherSpent, budgetDuration;
    int[] weights; // represents the percentages of the budget that each category should spend
    public DataField()
    {
        this
        (
            null,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            30,
            new int[]{25, 10, 10, 10, 30, 15}
        );
    }

    public DataField(String name, int budget, int totalSpent, int foodSpent, int gasSpent,
                     int coffeeSpent, int personalSpent, int necessitySpent, int otherSpent, int budgetDuration, int[] weights)
    {
        this.name = name;
        this.budget = budget;
        this.totalSpent = totalSpent;
        this.foodSpent = foodSpent;
        this.gasSpent = gasSpent;
        this.coffeeSpent = coffeeSpent;
        this.personalSpent = personalSpent;
        this.necessitySpent = necessitySpent;
        this.otherSpent = otherSpent;
        this.weights = weights;
    }

    // Setters
    public void setName(String name)
    {
        this.name = name;
    }
    public void setBudget(int budget)
    {
        this.budget = budget;
    }
    public void setTotalSpent(int totalSpent)
    {
        this.totalSpent = totalSpent;
    }
    public void setFoodSpent(int foodSpent)
    {
        this.foodSpent = foodSpent;
    }
    public void setGasSpent(int gasSpent)
    {
        this.gasSpent = gasSpent;
    }
    public void setCoffeeSpent(int coffeeSpent)
    {
        this.coffeeSpent = coffeeSpent;
    }
    public void setPersonalSpent(int personalSpent)
    {
        this.personalSpent = personalSpent;
    }
    public void setNecessitySpent(int necessitySpent)
    {
        this.necessitySpent = necessitySpent;
    }
    public void setOtherSpent(int otherSpent)
    {
        this.otherSpent = otherSpent;
    }
    public void setWeights(int[] weights)
    {
        this.weights = weights;
    }
    public void setBudgetDuration(int budgetDuration)
    {
        this.budgetDuration = budgetDuration;
    }

    // Getters
    public String getName()
    {
        return this.name;
    }
    public int getBudget()
    {
        return this.budget;
    }
    public int getTotalSpent()
    {
        return this.totalSpent;
    }
    public int getFoodSpent()
    {
        return this.foodSpent;
    }
    public int getGasSpent()
    {
        return this.gasSpent;
    }
    public int getCoffeeSpent()
    {
        return this.coffeeSpent;
    }
    public int getPersonalSpent()
    {
        return this.personalSpent;
    }
    public int getNecessitySpent()
    {
        return this.necessitySpent;
    }
    public int getOtherSpent()
    {
        return this.otherSpent;
    }

    public int getBudgetDuration()
    {
        return this.budgetDuration;
    }
    public int[] getWeights() {
        return this.weights;
    }

    public void printWeights()
    {
        System.out.println("Food: " + this.weights[0] + "%");
        System.out.println("Gas: " + this.weights[1] + "%");
        System.out.println("Coffee: " + this.weights[2] + "%");
        System.out.println("Personal: " + this.weights[3] + "%");
        System.out.println("Necessity: " + this.weights[4] + "%");
        System.out.println("Other: " + this.weights[5] + "%");
    }

    public void changeWeights()
    {
        int weightsTotal = 0; // Ensures the user can never enter weights that dont add to 100%
        while(weightsTotal != 100) {

            // 1: food, 2: gas, 3: coffee, 4: personal, 5: necessity, 6: other
            Scanner userInput = new Scanner(System.in);
            System.out.println("NOTE: Categories are:  1: food, 2: gas, 3: coffee, 4: personal, 5: necessity, 6: other. Total percentages must add to 100%");
            int[] weights = new int[this.weights.length];

            for (int i = 1; i < weights.length; i++) {
                System.out.print("Enter weight for " + getWeightCategory(i) + ": ");
                weights[i] = userInput.nextInt();
            }
            weightsTotal = Utils.getIntArraySum(weights);
        }
        this.setWeights(weights);
    }

    public String toString()
    {
        return "Name: " + this.name +
             "\nBudget: " + this.budget +
             "\nBudget Duration: " + this.budgetDuration +
             "\nTotal Spent: " + this.totalSpent +
             "\nFood Spent: " + this.foodSpent +
             "\nGas Spent: " + this.gasSpent +
             "\nCoffee Spent: " + this.coffeeSpent +
             "\nPersonal Spent: " + this.personalSpent +
             "\nNecessity Spent: " + this.necessitySpent +
             "\nOther Spent: " + this.otherSpent;
    }

    public String getWeightCategory(int i)
    {
        return switch (i)
        {
            case 1 -> "Food";
            case 2 -> "Gas";
            case 3 -> "Coffee";
            case 4 -> "Personal";
            case 5 -> "Necessity";
            case 6 -> "Other";
            default -> "Invalid category";
        };
    }

}
