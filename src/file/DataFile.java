package file;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// The DataFile class is the main data class in this program, It stores the DataFields object which contains quick access data such as money and character items (car, house, job)
// It also contains the file being used in the program and has the ability to update the file with values stored its DataFields object (Whenever user saves)
// Upon creation, it immediately fills The DataFields variables money, car, house, and job with the values from the file.
public class DataFile
{
    private final File file;
    private List<String> fileLines;
    private final DataField data;


    /* FILE METHODS */
    public DataFile(File file)
    {
        this.file = file;
        readFile();
        this.data = new DataField();
        initializeDataField();
    }

    public DataField getData()
    {
        return data;
    }
    public List<String> getFileLines()
    {
        return fileLines;
    }
    public File getFile()
    {
        return file;
    }


    // Fill fileLines
    private void readFile()
    {
        fileLines = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(file))
        {
            while (fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                fileLines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    // Print fileLines
    public String printFile()
    {
        StringBuilder fileString = new StringBuilder();
        for (String line : fileLines) {
            fileString.append(line).append("\n");
        }
        return fileString.toString();
    }


    /* DATAFIELD METHODS */
    public void initializeDataField()
    { //initialize data fields from file and enters them into the DataFile object's data
        for (String line : fileLines)
        {
            String[] split = line.split(":");
            if (line.toLowerCase().startsWith("name")) {
                this.data.setName(split[1].trim());
            } else if (line.toLowerCase().startsWith("budget")) {
                this.data.setBudget(Integer.parseInt(split[1].trim()));
            } else if (line.toLowerCase().startsWith("total spent")) {
                this.data.setTotalSpent(Integer.parseInt(split[1].trim()));
            } else if (line.toLowerCase().startsWith("food spent")) {
                this.data.setFoodSpent(Integer.parseInt(split[1].trim()));
            } else if (line.toLowerCase().startsWith("gas spent")) {
                this.data.setGasSpent(Integer.parseInt(split[1].trim()));
            } else if (line.toLowerCase().startsWith("coffee spent")) {
                this.data.setCoffeeSpent(Integer.parseInt(split[1].trim()));
            } else if (line.toLowerCase().startsWith("personal spent")) {
                this.data.setPersonalSpent(Integer.parseInt(split[1].trim()));
            } else if (line.toLowerCase().startsWith("other spent")) {
                this.data.setOtherSpent(Integer.parseInt(split[1].trim()));
            } else if (line.contains("-----")) {
                break;
            } else {
                throw new ExceptionInInitializerError("Invalid line in file: " + line);
            }
        }
    }

    public String toString()
    {
        return "\n File: \n" + this.printFile() + "\nData: \n" + this.data;
    }
}
