import file.DataFile;
import file.SaveManager;
import org.junit.*;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class BudgeterTests
{
    private DataFile df;
    Facade tester;
    @Before
    public void setup()
    {
        File file = new File("test.txt");
        this.df = new DataFile(file);
        this.tester = new Facade(new SaveManager(this.df));
    }
    @Test
    public void testInitializeFile()
    {
        setup();
        System.out.println(this.df.getData().toString());

        assertEquals(this.df.getData().getName(), "test");
        assertEquals(this.df.getData().getBudget(), 1000);
        assertEquals(this.df.getData().getBudgetDuration(), 35);
        assertEquals(this.df.getData().getTotalSpent(), 600);
        assertEquals(this.df.getData().getFoodSpent(), 100);
        assertEquals(this.df.getData().getGasSpent(), 100);
        assertEquals(this.df.getData().getCoffeeSpent(), 100);
        assertEquals(this.df.getData().getPersonalSpent(), 100);
        assertEquals(this.df.getData().getOtherSpent(), 100);
        assertEquals(this.df.getData().getWeights()[5], 10);
    }

    @Test
    public void testEditBudget()
    {

        String scanner = "2\n" +
                         "";
        System.setIn(new java.io.ByteArrayInputStream(scanner.getBytes()));
        setup();
    }
    private int editBudgetAdjust()
    {
        return 0;
    }

    private int editBudgetDistribution()
    {
        return 0;
    }
}
