package MySQL;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectHelper extends DBConnector{
    private String select;
    private String from;
    private String where;
    private static SelectHelper selectHelper;

    public static SelectHelper getSelect(){
        if (selectHelper == null){
            selectHelper = new SelectHelper();
        }
        return selectHelper;
    }

    public static void reset(){
        selectHelper = new SelectHelper();
    }

    public SelectHelper select(String select) {
        this.select = select;
        return this;
    }

    public SelectHelper from(String from) {
        this.from = from;
        return this;
    }

    public SelectHelper where(String where) {
        this.where = where;
        return this;
    }

    public ResultSet resultSet(){
        try{
            ResultSet resultSet = getStatement().executeQuery("select " + select + " from " + from + (where == null ? "" : " where " + where));
            return resultSet;
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            reset();
        }
        return null;
    }

    public Map<String, List<String>> getMapData(){
        Map<String, List<String>> data = new HashMap<>();
        List<List<String>> listData = getListData();
        try{
            ResultSet resultSet = resultSet();
            ResultSetMetaData metaData = resultSet.getMetaData();
            List<String> titles = new ArrayList<>();
            for(int i = 1; i <= metaData.getColumnCount(); i++){
                titles.add(metaData.getColumnLabel(i));
            }
            for(int i = 0; i < titles.size(); i++){
                List<String> column = new ArrayList<>();
                for(int j = 0; j < listData.size(); j++){
                    column.add(listData.get(j).get(i));
                }
                data.put(titles.get(i), column);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public List<List<String>> getListData(){
        List<List<String>> data = new ArrayList<>();
        try{
            ResultSet resultSet = resultSet();
            while(resultSet.next()){
                List<String> row = new ArrayList<>();
                for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++){
                    row.add(resultSet.getString(i));
                }
                data.add(row);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
