import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProgramMethods {


    public boolean compareDateToFile(Person person) { //Compares string (date) from file with current date (-1year) returns bool
        String personDate = person.lastPaymentDate;
        LocalDate minLastPaymentDate = LocalDate.now().minusYears(1);
        LocalDate lastPaymentDate = LocalDate.parse(personDate);
        // return LocalDate.now().minusYears(1).compareTo(LocalDate.parse(inputDate)) < 0; //Streamlined method but impossible to read.
        return minLastPaymentDate.compareTo(lastPaymentDate) < 0;
    }

    public boolean getBoolNameFromFile(Person person, String userInput) { //Compares string from user with string from file, returns bool
        String nameFromFile = person.name;
        return userInput.equalsIgnoreCase(nameFromFile);
    }

    public boolean getBoolIDnrFromFile(Person person, String userInput) { //Compares string from user with string from file, returns bool
        String idnrFromFile = person.idNumber;
        return userInput.equals(idnrFromFile);
    }

    public String inputHandler(String input, boolean test) {
        Scanner scanner;
        if(!test) {
            scanner = new Scanner(System.in);
        }else{
            scanner = new Scanner(input);
        }
        System.out.println("Skriv in För och Efternamn, eller IDnr på den kund du vill söka efter i systemet: ");
        String answer = scanner.nextLine();
        return answer;
    }


    public String systemOutHandler(Person person) {
        String printableString = "";
        if(person.inProgram){
            printableString = person.name + " har inte ett aktivt medlemskap och får inte träna.";
            if(person.hasPaid){
                printableString = person.name + " har ett aktivt medlemskap och får träna.";
            }
        }else{
            printableString = "Denna person finns inte i systemet, kan du ha stavat fel?";
        }
        System.out.println(printableString);
        return printableString;
    }


}





