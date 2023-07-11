package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/resources/empty-login.feature",
                "src/test/java/resources/incorrect-login.feature",
                "src/test/java/resources/correct-login.feature"},
        glue = "stepdefinitions"
)
public class RunnerTests {

}
