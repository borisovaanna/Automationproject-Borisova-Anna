package Task_19;

import org.testng.Assert;
import org.testng.annotations.Test;

import static MySQL.DeleteHelper.getDelete;
import static MySQL.SelectHelper.*;
import static MySQL.InsertHelper.*;
import static MySQL.UpdateHelper.getUpdate;


public class Task_19 {

    @Test(priority = 1)
    public void SelectTest1(){
        Assert.assertEquals(getSelect().select("*").
                from("user").
                where("age = 32").
                getMapData().
                get("first_name").
                stream().count(), 2);
    }

    @Test(priority = 2)
    public void SelectTest2(){
        getSelect().select("*").
                from("user").
                where("last_name = 797").
                getMapData().
                get("age").
                stream().forEach(System.out::println);
    }

    @Test(priority = 3)
    public void InsertTest1(){
        getInsert().table("user").into("id").values("11").execute();
        Assert.assertTrue(getSelect().select("*").
                from("user").
                where("id = 11").
                getMapData().
                get("first_name").
                contains(null));
    }

    @Test(priority = 4)
    public void InsertTest2(){
        getInsert().table("user").into("id").values("12").execute();
        Assert.assertTrue(getSelect().
                select("*").
                from("user").
                where("id = 12").
                getMapData().
                get("last_name").
                contains(null));
    }

    @Test(priority = 5)
    public void UpdateTest1(){
        getUpdate().update("user").set("first_name = 'User_11'").where("id = 11").execute();
        getUpdate().update("user").set("last_name = 'User_11'").where("first_name = 'User_11'").execute();
        getUpdate().update("user").set("age = 47").where("last_name = 'User_11'").execute();
        Assert.assertTrue(getSelect().
                select("*").
                from("user").
                where("id = 11").
                getMapData().
                get("first_name").
                contains("User_11"));
        Assert.assertTrue(getSelect().
                select("*").
                from("user").
                where("last_name = 'User_11'").
                getMapData().
                get("age").
                contains("47"));
    }

    @Test(priority = 6)
    public void UpdateTest2(){
        getUpdate().update("user").set("first_name = 'User_12'").where("id = 12").execute();
        getUpdate().update("user").set("last_name = 'User_12'").where("first_name = 'User_12'").execute();
        getUpdate().update("user").set("age = 26").where("last_name = 'User_12'").execute();
        Assert.assertTrue(getSelect().
                select("*").
                from("user").
                where("id = 12").
                getMapData().
                get("first_name").
                contains("User_12"));
        Assert.assertTrue(getSelect().
                select("*").
                from("user").
                where("last_name = 'User_12'").
                getMapData().
                get("age").
                contains("26"));
    }

    @Test(priority = 7)
    public void DeleteTest1(){
        getDelete().from("user").where("id = 11").execute();
        Assert.assertEquals(getSelect().select("*").
                from("user").
                where("id = 11").
                getMapData().
                get("first_name").
                stream().count(), 0);
    }

    @Test(priority = 8)
    public void DeleteTest2(){
        getDelete().from("user").where("id = 12").execute();
        Assert.assertEquals(getSelect().select("*").
                from("user").
                where("id = 12").
                getMapData().
                get("last_name").
                stream().count(), 0);
    }
}
