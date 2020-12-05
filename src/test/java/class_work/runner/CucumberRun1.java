package class_work.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "report.custom.CustomCuke"},
        glue = {"class_work.steps"},
        features = {"src/test/resources/classwork/features/fake/FakeOne.feature"
//                "src/test/resources/classwork/features/fake/FakeTwo.feature"
        },
        strict = true)
public class CucumberRun1 {

}
