import file.DataField;
import file.SaveManager;

import java.util.Scanner;

public class Facade
{
    private static Facade instance;
    private final SaveManager log;
    // Private constructor to prevent creating instances outside this class.
    public Facade()
    {
        this.log = new SaveManager();
    }

    /*
    public static Facade GetInstance()
    {
        if (instance == null)
        {
            instance = new Facade();
        }
        return instance;
    }
    */

    public void run()
    {
        int menu;

        do menu = budgeterMenu();
        while (menu != -1);

        log.saveToFile();
    }

    public int budgeterMenu()
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("\nCurrent budget data: ");
        printFileData();

        System.out.println("1. Add expense");
        System.out.println("2. Adjust budget");
        System.out.println("3. Budget analysis");
        System.out.println("4. Budget duration");
        System.out.println("5. Save & Exit");

        int input = userInput.nextInt();
        switch (input)
        {
            case 1:
                addExpense(userInput);
                break;
            case 2:
                editBudget(userInput);
                break;
            case 3:
                System.out.println("\nBudget analysis: ");
                break;
            case 4:
                return -1;
            case 5:
                return -1;
            default:
                System.out.println("\nInvalid input");
                break;
        }
        return 0;
    }

    public void budgetAnalysis()
    {
        int totalSpent = getData("total spent");
        int budget = getData("budget");
        int foodSpent = getData("food spent");
        int gasSpent = getData("gas spent");
        int coffeeSpent = getData("coffee spent");
        int personalSpent = getData("personal spent");
        int otherSpent = getData("other spent");
    }

    public void editBudget(Scanner sc)
    {
        System.out.print("1. Adjust budget");
        System.out.print("2. Change budget distribution");
        int input = sc.nextInt();

        switch(input)
        {
            case 1:
                System.out.println("Enter new budget: ");
                int budget = sc.nextInt();
                if(budget > 0)
                    getDataField().setBudget(budget);
                else System.out.println("Invalid input");

                getDataField().setBudget(budget);
                break;

            case 2:
                getDataField().changeWeights();
                break;
        }

        int newBudget = sc.nextInt();
        this.log.getDataFile().getData().setBudget(newBudget);
    }

    // Adds expense to current budget file. All info needed is prompted from user.
    public void addExpense(Scanner userInput)
    {
        System.out.println("\nEnter expense category");
        System.out.println("1. Food");
        System.out.println("2. Gas");
        System.out.println("3. Coffee");
        System.out.println("4. Personal");
        System.out.println("5. Other");

        int input = userInput.nextInt();

        System.out.println("\nEnter amount spent");
        int amount = userInput.nextInt();

        DataField d = this.log.getDataFile().getData();
        int currentSpent;
        switch (input)
        {
            case 1:
                currentSpent = d.getFoodSpent();
                d.setFoodSpent(amount + currentSpent);
                break;
            case 2:
                currentSpent = d.getGasSpent();
                d.setGasSpent(amount + currentSpent);
                break;
            case 3:
                currentSpent = d.getCoffeeSpent();
                d.setCoffeeSpent(amount + currentSpent);
                break;
            case 4:
                currentSpent = d.getPersonalSpent();
                d.setPersonalSpent(amount + currentSpent);
                break;
            case 5:
                currentSpent = d.getOtherSpent();
                d.setOtherSpent(amount + currentSpent);
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    public void printFileData()
    {
        System.out.println(this.log.getSaveFileData());
    }

    public DataField getDataField()
    {
        return this.log.getDataFile().getData();
    }

    public int getData(String dataType)
    {
        dataType = dataType.toLowerCase();
        DataField df = getDataField();
        if(dataType.equals("budget"))
            return df.getBudget();
        else if(dataType.contains("total"))
            return df.getTotalSpent();
        else if(dataType.contains("food"))
            return df.getFoodSpent();
        else if(dataType.contains("gas"))
            return df.getGasSpent();
        else if(dataType.contains("coffee"))
            return df.getCoffeeSpent();
        else if(dataType.contains("personal"))
            return df.getPersonalSpent();
        else if(dataType.contains("other"))
            return df.getOtherSpent();
        else
            return -1;
    }

    /**
     ** Returns the SaveManager object
     ** Should only be used for testing purposes!!
     **/
    public SaveManager getSaveManager()
    {
        return this.log;
    }

}
