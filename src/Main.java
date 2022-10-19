public class Main {

    Main() {
        Program program = new Program();
        ProgramFileHandler fileHandler = new ProgramFileHandler();
        String input = program.inputHandler("", false);
        Person person = program.checkListAgainstUserInput(input);
        fileHandler.printToFileHandler(person, program.outFilePath);
        program.systemOutHandler(person);

        /*
        Person kund = program.checkListAgainstUserInput(program.inputHandler("",false));

        System.out.println(kund.name);
        System.out.println(kund.idNumber);
        System.out.println(kund.lastPaymentDate);
        System.out.println("has paid: " + kund.hasPaid);
        System.out.println("in system: " + kund.isInProgram());
        */
    }
    public static void main(String[] args) {
        new Main();
    }
}