package MySQL;

public class UpdateHelper extends DBConnector{
    private String update;
    private String set;
    private String where;

    public static UpdateHelper getUpdate() {
        return new UpdateHelper();
    }

    public UpdateHelper update(String update) {
        this.update = update;
        return this;
    }

    public UpdateHelper set(String set) {
        this.set = set;
        return this;
    }

    public UpdateHelper where(String where) {
        this.where = where;
        return this;
    }

    public void execute() {
        try {
            getStatement().executeUpdate("UPDATE " + update + " SET " + set + " WHERE " + where);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
