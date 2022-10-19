public class Person { //Class for each separate client in the program.
    protected String name;
    protected String idNumber;
    protected String lastPaymentDate;
    protected boolean hasPaid;
    protected boolean inProgram;

    public Person(String name, String idNumber, String lastPaymentDate) {
        this.name = name;
        this.idNumber = idNumber;
        this.lastPaymentDate = lastPaymentDate;
    }

    public String getName() {
        return name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getLastPaymentDate() {
        return lastPaymentDate;
    }

    public boolean getHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    public boolean isInProgram() {
        return inProgram;
    }

    public void setInProgram(boolean inProgram) {
        this.inProgram = inProgram;
    }
}
