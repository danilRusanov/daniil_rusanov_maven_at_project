package runners.cucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"src/test/java/runners/testrail"},
        features = {"/Users/daniilrusanov/dev/maven_at_project/daniil_rusanov_maven_at_project/src/test/java/testdata/features/first.feature"},
strict = true)

public class CucumberRunner {

}
