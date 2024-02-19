package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/main/java/features/",glue="steps",tags="@smoke",publish=true)
public class RunTests extends AbstractTestNGCucumberTests{

}
