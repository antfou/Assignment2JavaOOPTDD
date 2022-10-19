import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Inlämningsuppgift2test {

    ProgramMethods method = new ProgramMethods();
    ProgramFileHandler fileHandler = new ProgramFileHandler();
    Program program = new Program();

    Person testPerson = new Person("AlHamBra aromes","7703021234","2202-07-01");



    String inFile = "test/inputTest.txt";
    String outFile = "test/outputTest.txt";
    @Test
    public void compareDateToFileTest(){

        assertTrue(method.compareDateToFile(testPerson));

    }
    @Test
    public void getBoolNameFromFileTest(){
        String fileLine = "7703021234, Alhambra Aromes";
        String trueInputName = "aLhamBrA AroMes";
        String falseInputName = "Oskar Sturesson";
        assertTrue(method.getBoolNameFromFile(testPerson, trueInputName));
        assertFalse(method.getBoolNameFromFile(testPerson, falseInputName));
    }
    @Test
    public void getBoolIDnrFromFileTest(){
        String trueInputIDnr = "7703021234";
        String falseInputIDnr = "7702011244";
        assertTrue(method.getBoolIDnrFromFile(testPerson,trueInputIDnr));
        assertFalse(method.getBoolIDnrFromFile(testPerson,falseInputIDnr));
    }
    @Test
    public void readDataFromFileTest(){
        List<Person> persons = fileHandler.readDataFromFile(inFile);
        assertEquals(2, persons.size());
        assertNotEquals(1,persons.size());
    }

    @Test
    public void inputHandlerTest(){
        String input1 = "Alhambra Aromes";
        String input2 = "BlahBlahBlippo";
        Boolean test = true;
        assertEquals(input1,program.inputHandler(input1,test));
        assertEquals(input2,program.inputHandler(input2,test));
        assertNotEquals(input1,program.inputHandler(input2,test));
    }
    @Test
    public void systemOutHandlerTest(){
        Person testPerson1 = new Person("Jicky Juul", "9902149834", "2019-09-27");
        testPerson1.setHasPaid(false);
        testPerson1.setInProgram(true);
        Person testPerson2 = new Person("Alhambra Aromes", "7703021234", "2022-07-01");
        testPerson2.setHasPaid(true);
        testPerson2.setInProgram(true);
        Person testPerson3 = new Person("","","");
        assertEquals(program.systemOutHandler(testPerson1),"Jicky Juul har inte ett aktivt medlemskap och får inte träna.");
        assertEquals(program.systemOutHandler(testPerson2),"Alhambra Aromes har ett aktivt medlemskap och får träna.");
        assertEquals(program.systemOutHandler(testPerson3),"Denna person finns inte i systemet, kan du ha stavat fel?");
    }
    @Test
    public void printToFileHandlerTest(){
        Person testPerson1 = new Person("Jicky Juul", "9902149834", "2019-09-27");
        testPerson1.setHasPaid(false);
        testPerson1.setInProgram(true);
        Person testPerson2 = new Person("Alhambra Aromes", "7703021234", "2022-07-01");
        testPerson2.setHasPaid(true);
        testPerson2.setInProgram(true);
        Person testPerson3 = new Person("","","");
        LocalDate theDate = LocalDate.now();
        assertEquals(fileHandler.printToFileHandler(testPerson1,outFile),"");
        assertEquals(fileHandler.printToFileHandler(testPerson2,outFile),"Alhambra Aromes Tränade senast: " + theDate + "\n");
        assertEquals(fileHandler.printToFileHandler(testPerson3,outFile),"");
    }
    @Test
    public void checkListAgainstUserInputTest(){
        Person testPerson = new Person("Alhambra Aromes", "7703021234", "2022-07-01");
        testPerson.setHasPaid(true);
        testPerson.setInProgram(true);
        Person realPerson = program.checkListAgainstUserInput("Alhambra Aromes");
        assertEquals(testPerson.name,realPerson.name);
        assertEquals(testPerson.idNumber,realPerson.idNumber);
        assertEquals(testPerson.lastPaymentDate,realPerson.lastPaymentDate);
        assertEquals(testPerson.hasPaid,realPerson.hasPaid);
        assertEquals(testPerson.inProgram,realPerson.inProgram);

    }
    /* public int countPeopleInFileForTestsONLY(String testFileToCount){ //Method to count the amount of lines in a document, only for tests
         int linesTotal = 0;
         try(BufferedReader br = new BufferedReader(new FileReader(testFileToCount));){
             while(br.readLine() != null ){linesTotal++;}
         }catch (Exception e){
             System.out.println("Fel i testfilen");
             e.printStackTrace();
         }return linesTotal;
     }

     @Test
     public void printDataToFileTest(){
         //7502031234, Anna Andersson
         //2022-05-03
         //8505132345, Per Persson
         //2019-12-29
         Person person1 = new Person("Anna Andersson", "7502031234", "2022-05-03");
         Person person2 = new Person("Per Persson","8505132345","2019-12-29");
         List<Person> personList = Arrays.asList(person1,person2);

         fileHandler.printDataToFile(outFile, personList);
         assertEquals(4, countPeopleInFileForTestsONLY(outFile));
         assertNotEquals(2, countPeopleInFileForTestsONLY(outFile));
     }
     */

}
