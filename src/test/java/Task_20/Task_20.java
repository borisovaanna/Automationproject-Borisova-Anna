package Task_20;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/features"}, plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"}, glue = {"Task_20/steps"})
public class Task_20 extends AbstractTestNGCucumberTests {

    @DataProvider
    @Override
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
