package runners.testrail;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "utils.reporter.CustomCucumberPlugin"},
        glue = {"tests/testrail/demoqa"},
        features = {"src/test/resources/testrail/elements.feature"},
        strict = true)


public class CucumberRunner1 {


}
