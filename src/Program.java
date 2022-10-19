import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Program extends ProgramMethods{
    ProgramFileHandler fileHandler = new ProgramFileHandler();
    String inFilePath = ("src/Customers.txt");
    String outFilePath = ("src/trainersList.txt");

    public Person checkListAgainstUserInput(String input) {
        List<Person> personList = fileHandler.readDataFromFile(inFilePath);
        int counter = 0;
        Person returnKund = new Person("","","");
        for (Person person : personList) {
            Person kund = personList.get(counter);
            counter++;
            if (getBoolNameFromFile(kund, input) || getBoolIDnrFromFile(kund, input)) {
                kund.setInProgram(true);
                if (compareDateToFile(person)) {
                    kund.setHasPaid(true);
                }
                returnKund = kund;
            }
        }
        return returnKund;
    }
}
