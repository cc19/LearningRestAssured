import org.testng.annotations.DataProvider;

public class DataForTest {

    @DataProvider(name = "users_data")
    public Object[][] dataProvide() {
//        Object[][] data = new Object[2][3]; //we have 2 rows for 3 columns
//        data[0][0] = "Rajat";
//        data[0][1] = "Kapoor";
//        data[0][2] = 6;
//
//        data[1][0] = "Seema";
//        data[1][1] = "Biswas";
//        data[1][2] = 3;
//
//        return data;
//      Same thing as above can be done also as:

        return new Object[][]  {
                {"Leena", "Vaidya", 1},
                {"Pramod", "Mathur", 3},
                {"Captain","Cool", 8}
        };

    }

    //Deletion using DataProvider
    @DataProvider(name = "deletionData")
    public Object[] dataForDeletion() {
        return new Object[] {
                2,9
        };
    }
}
