import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Inlämningsuppgift2test {

    ProgramMethods method = new ProgramMethods();
    ProgramFileHandler fileHandler = new ProgramFileHandler();





    String inFile = "test/inputTest.txt";
    String outFile = "test/outputTest.txt";
    @Test
    public void compareDateToFileTest(){
        String trueInputDate = "2022-07-01";
        String falseInputDate = "2019-10-11";
        assertTrue(method.compareDateToFile(trueInputDate));
        assertFalse(method.compareDateToFile(falseInputDate));
    }
    @Test
    public void getBoolNameFromFileTest(){
        String fileLine = "7703021234, Alhambra Aromes";
        String trueInputName = "aLhamBrA AroMes";
        String falseInputName = "Oskar Sturesson";
        assertTrue(method.getBoolNameFromFile(fileLine, trueInputName));
        assertFalse(method.getBoolNameFromFile(fileLine, falseInputName));
    }
    @Test
    public void getBoolIDnrFromFileTest(){
        String fileLine = "7703021234, Alhambra Aromes";
        String trueInputIDnr = "7703021234";
        String falseInputIDnr = "7702011244";
        assertTrue(method.getBoolIDnrFromFile(fileLine,trueInputIDnr));
        assertFalse(method.getBoolIDnrFromFile(fileLine,falseInputIDnr));
    }
    @Test
    public void getNameFromFileTest(){
        String fileLine = "7703021234, Alhambra Aromes";
        assert(method.getNameFromFile(fileLine).equals("Alhambra Aromes"));
        assert(!method.getNameFromFile(fileLine).equals("7703021234"));
    }
    @Test
    public void readDataFromFileTest(){
        List<Person> persons = fileHandler.readDataFromFile(inFile);
        assertEquals(2, persons.size());
        assertNotEquals(1,persons.size());
    }

    public int countPeopleInFileForTestsONLY(String testFileToCount){ //Method to count the amount of lines in a document, only for tests
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

}
