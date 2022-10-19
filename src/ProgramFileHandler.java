import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramFileHandler {

    public List<Person> readDataFromFile(String dataFromFile) {
        String nameAndIDnrLine; //Every odd-numbered line in the text doc
        String lastPaymentDateLine; //Every even-numbered line in the text doc
        Path inFilePath; //Path to read the text doc
        List<Person> personList = new ArrayList<>();
        String[] personDataNameAndIDnrLine = new String[2];
        String[] personDataLastPaymentDateLine = new String[1];
        inFilePath = Paths.get(dataFromFile); //Gets the path for the file from outside the method for inFilePath

        try(Scanner fileScanner = new Scanner(inFilePath)){ //try + scanner för att läsa in från fil
            while(fileScanner.hasNext()){
                nameAndIDnrLine = fileScanner.nextLine();
                personDataNameAndIDnrLine = nameAndIDnrLine.split(",");
                if(fileScanner.hasNext()){
                    lastPaymentDateLine = fileScanner.nextLine();
                    personDataLastPaymentDateLine = lastPaymentDateLine.split(",");
                }
                Person person = new Person(personDataNameAndIDnrLine[1].trim(),
                        personDataNameAndIDnrLine[0].trim(),
                        personDataLastPaymentDateLine[0].trim());
                personList.add(person);
            }
        }catch (IOException i){ //catch exceptions som har med fil-indata
            System.out.println("Fel med path från fil");
            i.printStackTrace();
        }return personList;
    }

    public String printToFileHandler(Person person, String outFile) {
        Path outFilePath = Paths.get(outFile);//Fetches where the method will print to
        String printableString = "";
        try (FileWriter fileWriter = new FileWriter(outFilePath.toFile(), true);
             PrintWriter printer = new PrintWriter(fileWriter)) {


            if (person.hasPaid) {
                printableString = person.name + " Tränade senast: " + LocalDate.now() + "\n";
                printer.println(printableString);
            }

            return printableString;
        } catch (FileNotFoundException f) {
            System.out.println("Fil path till fil");
            f.printStackTrace();
        } catch (IOException i) {
            System.out.println("Gick inte att skriva till filen");
            i.printStackTrace();
        } catch (Exception e) {
            System.out.println("Vettefan vad som gick fel");
            e.printStackTrace();
        }


        return printableString;
    }
}
