package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

// When new data is added, must change the following: SaveManager.saveToFile | DataFile.initializeData | DataField entire class

public class SaveManager
{
    DataFile df; // SaveManager will prompt user for datafile when created, must use SaveManager.getDataFile() to access df object in gameManager.
    public SaveManager()
    {
        this.df = new DataFile(selectSaveFile()); // When creating saveManager, prompt user for save file immediately.

        // If it's a new save
        if(this.getDataFile().getData().getName().equals("null"))
        {
            initializeNewSave();
        }
    }

    /* GETTERS */
    public DataFile getDataFile()
    {
        return this.df;
    }

    public String getSaveFileData() // returns dataFile of current save
    {
        return(this.df.getData().toString());
    }

    public void initializeNewSave()
    {
        DataField data = this.getDataFile().getData(); // DataField associated with this save file
        String fileName = this.getDataFile().getFile().getName(); // fileName of this save file (with .txt)

        String name = fileName.substring(0, fileName.lastIndexOf('.')); // remove file extension from fileName

        // Initialize new save data
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter your budget: ");
        int budget = userInput.nextInt();
        System.out.print("Enter amount of money already spent: ");
        int totalSpent = userInput.nextInt();
        System.out.print("Enter budget duration: ");
        int budgetDuration = userInput.nextInt();

        // Set new save data
        data.setName(name);
        data.setBudget(budget);
        data.setBudgetDuration(budgetDuration);
        data.setTotalSpent(totalSpent);

        // Change default distribution
        System.out.println("Current budget distribution: ");
        data.printWeights();
        System.out.println("Change? (y/n)");
        String choice = userInput.next();
        if(choice.startsWith("y"))
            data.changeWeights();

        this.saveToFile();
    }

    public void saveToFile()
    { // Updates the file associated with this object's DataFile effectively saving the game.
        try (PrintWriter writer = new PrintWriter(this.df.getFile()))
        {
            for (String line : this.df.getFileLines())
            {
                if (line.startsWith("name"))
                    writer.println("name: " + this.df.getData().getName());
                else if (line.startsWith("budget"))
                  writer.println("budget: " + this.df.getData().getBudget());
                else if (line.startsWith("duration"))
                    writer.println("duration: " + this.df.getData().getBudgetDuration());
                else if (line.startsWith("total spent"))
                  writer.println("total spent: " + this.df.getData().getTotalSpent());
                else if (line.startsWith("food spent"))
                  writer.println("food spent: " + this.df.getData().getFoodSpent());
                else if (line.startsWith("gas spent"))
                  writer.println("gas spent: " + this.df.getData().getGasSpent());
                else if (line.startsWith("coffee spent"))
                  writer.println("coffee spent: " + this.df.getData().getCoffeeSpent());
                else if (line.startsWith("personal spent"))
                  writer.println("personal spent: " + this.df.getData().getPersonalSpent());
                else if (line.startsWith("necessity spent"))
                    writer.println("necessity spent: " + this.df.getData().getNecessitySpent());
                else if (line.startsWith("other spent"))
                  writer.println("other spent: " + this.df.getData().getOtherSpent());
                else if (line.startsWith("weights"))
                    writer.println("weights: " + Arrays.toString(this.df.getData().getWeights()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public File selectSaveFile() // Returns null if user wants to go back to main menu
    {
        Scanner userInput = new Scanner(System.in);
        String directoryPath = "saves";
        File directory = new File(directoryPath);

        // Ensure the directory exists and is a directory
        if (directory.exists() && directory.isDirectory())
        {
            File[] files = directory.listFiles();
            System.out.println("Select a save: ");
            if (files != null)
            {
                int i = 0;
                for (File file : files)
                {
                    if ((file.isFile() && file.getName().endsWith(".txt")))
                    {
                        i++;
                        System.out.println("[" +i+ "]" + " " + file.getName());
                    }
                }
                System.out.println("[" +(++i)+ "]" + " Create new save");
                System.out.println("[" +(++i)+ "]" + " Exit");
                int choice = userInput.nextInt();

                /* INVALID CHOICE */
                if(choice < 1 ||  choice > files.length + 3)
                {
                    System.out.println("Invalid choice.");
                    return null;
                }

                /* EXIT */
                else if(choice == files.length + 2)
                {
                    System.exit(0);
                }

                /* CREATE NEW FILE */
                else if(choice == files.length + 1)
                {
                    //DataFile defaultSave = getDefaultSave();
                    System.out.print("Enter a name for your save file: ");
                    String fileName = userInput.next();

                    return createDefaultFile(directoryPath, fileName, getDefaultSave());
                }

                /* USE EXISTING SAVE */
                else
                {
                    return files[choice - 1];
                }

                /* GO BACK */
            } else { // No files in directory
                System.out.println("No files found in the specified directory.");
            }
        } else { // Directory doesn't exist
            System.out.println("Invalid directory path.");
        }
        return null; // If no file is found, return null and handle it in calling method
    }


    private static File createDefaultFile(String directoryPath, String fileName, DataFile defaultSave) {
        File newSave = new File(directoryPath + "/" + fileName + ".txt");
        try {
            PrintWriter writer = new PrintWriter(newSave);
            for(String s : defaultSave.getFileLines())
            {
                writer.println(s);
            }

            writer.close();
        } catch (FileNotFoundException e) {
            //System.out.println("File not found");
        }
        return newSave;
    }

     DataFile getDefaultSave() {
         return new DataFile(new File("defaultlog.txt"));
     }
}
