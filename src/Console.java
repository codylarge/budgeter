import file.DataFile;
import file.SaveManager;

import java.io.File;

public class Console
{
    public static void main(String[] args)
    {
        Facade system = Facade.GetInstance();
        system.run();
    }

}
