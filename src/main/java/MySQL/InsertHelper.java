package MySQL;

public class InsertHelper extends DBConnector{
    private String table;
    private String into;
    private String values;

    public static InsertHelper getInsert() {
        return new InsertHelper();
    }

    public InsertHelper table(String table) {
        this.table = table;
        return this;
    }

    public InsertHelper into(String into) {
        this.into = into;
        return this;
    }

    public InsertHelper values(String values) {
        this.values = values;
        return this;
    }

    public void execute() {
        try {
            getStatement().executeUpdate("INSERT INTO " + table + " ( " + into + " )" + " VALUES " + "( " + values + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
