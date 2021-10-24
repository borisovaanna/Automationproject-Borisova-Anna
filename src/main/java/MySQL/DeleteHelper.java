package MySQL;

public class DeleteHelper extends DBConnector{
    private String from;
    private String where;

    public static DeleteHelper getDelete() {
        return new DeleteHelper();
    }

    public DeleteHelper from(String from) {
        this.from = from;
        return this;
    }

    public DeleteHelper where(String where) {
        this.where = where;
        return this;
    }

    public void execute() {
        try {
            getStatement().executeUpdate("DELETE FROM " + from + " WHERE " + where);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
