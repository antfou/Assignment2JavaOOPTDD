public class Main {

    Main() {
        Program program = new Program();
        ProgramFileHandler fileHandler = new ProgramFileHandler();
        String input = program.inputHandler("", false);
        Person person = program.checkListAgainstUserInput(input);
        fileHandler.printToFileHandler(person, program.outFilePath);
        program.systemOutHandler(person);

    }
    public static void main(String[] args) {
        new Main();
    }
}