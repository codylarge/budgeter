import file.DataField;
import file.SaveManager;

import java.util.Scanner;

public class Facade
{
    private static Facade instance;
    private final SaveManager log;
    // Private constructor to prevent creating instances outside this class.
    private Facade()
    {
        this.log = new SaveManager();
    }

    public static Facade GetInstance()
    {
        if (instance == null)
        {
            instance = new Facade();
        }
        return instance;
    }

    public int run()
    {
        budgeterMenu();
        log.saveToFile();
        return 1;
    }

    public void budgeterMenu()
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Current budget data: ");
        printFileData();

        System.out.println("1. Add expense");
        System.out.println("2. Adjust budget");
        System.out.println("3. Exit");

        int input = userInput.nextInt();
        switch (input)
        {
            case 1:
                addExpense(userInput);
                break;
            case 2:
                System.out.println("New budget: ");
                int newBudget = userInput.nextInt();
                this.log.getDataFile().getData().setBudget(newBudget);
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    public void addExpense(Scanner userInput)
    {
        System.out.println("Enter expense category");
        System.out.println("1. Food");
        System.out.println("2. Gas");
        System.out.println("3. Coffee");
        System.out.println("4. Personal");
        System.out.println("5. Other");

        int input = userInput.nextInt();

        System.out.println("Enter amount spent");
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

}
