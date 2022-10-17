public class Person { //Class for each separate client in the program.
    protected String name;
    protected String idNumber;
    protected String lastPaymentDate;

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
}
