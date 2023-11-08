import file.DataFile;
import file.SaveManager;

import java.io.File;

public class Console
{
    public static void main(String[] args)
    {
        SaveManager s = new SaveManager();
        System.out.println(s.getDataFile());
    }

}
