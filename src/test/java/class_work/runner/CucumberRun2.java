package class_work.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"class_work.steps"},
        features = {"src/test/resources/classwork/features/fake/FakeTwo.feature"
        },
        strict = true)

public class CucumberRun2 {
}
