package file;
// The DataFields class is a class that stores some data about the player that will be changed throughout the game such as cash for easy access.
// The DataFields class also contains methods to read and update data.
public class DataField
{
    /* DATA */
    private String name;
    private int budget, totalSpent, foodSpent, gasSpent, coffeeSpent, personalSpent, otherSpent;
    public DataField() // Not yet used
    {
        this.name = null;
        this.budget = 0;
        this.totalSpent = 0;
        this.foodSpent = 0;
        this.gasSpent = 0;
        this.coffeeSpent = 0;
        this.personalSpent = 0;
        this.otherSpent = 0;
    }

    public DataField(String name, int budget, int totalSpent, int foodSpent, int gasSpent,
                     int coffeeSpent, int personalSpent, int otherSpent)
    {
        this.name = name;
        this.budget = budget;
        this.totalSpent = totalSpent;
        this.foodSpent = foodSpent;
        this.gasSpent = gasSpent;
        this.coffeeSpent = coffeeSpent;
        this.personalSpent = personalSpent;
        this.otherSpent = otherSpent;
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
    public void setOtherSpent(int otherSpent)
    {
        this.otherSpent = otherSpent;
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
    public int getOtherSpent()
    {
        return this.otherSpent;
    }


    public String toString()
    {
        return "Name: " + this.name +
             "\nBudget: " + this.budget +
             "\nTotal Spent: " + this.totalSpent +
             "\nFood Spent: " + this.foodSpent +
             "\nGas Spent: " + this.gasSpent +
             "\nCoffee Spent: " + this.coffeeSpent +
             "\nPersonal Spent: " + this.personalSpent +
             "\nOther Spent: " + this.otherSpent;
    }
}
