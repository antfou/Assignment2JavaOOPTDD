import java.time.LocalDate;

public class ProgramMethods {


    public boolean compareDateToFile(String inputDate) { //Compares string (date) from file with current date (-1year) returns bool
        LocalDate minLastPaymentDate = LocalDate.now().minusYears(1);
        LocalDate lastPaymentDate = LocalDate.parse(inputDate);
        // return LocalDate.now().minusYears(1).compareTo(LocalDate.parse(inputDate)) < 0; //Streamlined method but impossible to read.
        return minLastPaymentDate.compareTo(lastPaymentDate) < 0;
    }

    public boolean getBoolNameFromFile(String fileLine, String userInput) { //Compares string from user with string from file, returns bool
        String[] stringArray = fileLine.split(",");
        String nameFromFile = stringArray[1].trim();
        return userInput.equalsIgnoreCase(nameFromFile);
    }

    public boolean getBoolIDnrFromFile(String fileLine, String userInput) { //Compares string from user with string from file, returns bool
        String[] stringArray = fileLine.split(",");
        String idnrFromFile = stringArray[0].trim();
        return userInput.equals(idnrFromFile);
    }

    public String getNameFromFile(String fileLine) { //Compares string from user with string from file, returns name from file
        String[] stringArray = fileLine.split(",");
        String nameFromFile = stringArray[1].trim();
        return nameFromFile;
    }
}
