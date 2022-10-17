import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Inlämningsuppgift2test {

    ProgramMethods method = new ProgramMethods();

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

}
