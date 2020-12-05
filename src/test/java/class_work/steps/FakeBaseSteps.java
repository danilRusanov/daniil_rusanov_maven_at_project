package class_work.steps;

import drivers.ThreadsDriver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class FakeBaseSteps {

    private static final Logger LOGGER = Logger.getLogger(FakeBaseSteps.class);
    private static double passed, failed;
    private static List<String> failedNames = new ArrayList<>();

    static {
        try {
            afterAll();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Before
    public void doBefore() throws MalformedURLException {
        System.out.println("Init WebDriver");
//        ThreadsDriver.getWebDriver();
    }

    @After
    public void doAfter(Scenario scenario) throws MalformedURLException {
//        ThreadsDriver.setThreadLocalWebDriver();
        if (scenario.isFailed()) {
            failedNames.add(scenario.getName() + " at line: "
                    + scenario.getLine() + System.getProperty("line.separator"));
            failed++;
        } else {
            passed++;
        }

    }

    public static void afterAll() throws FileNotFoundException {

        String ls = System.getProperty("line.separator");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Test execution report!");
            sb.append("Test executed: " + (passed + failed) + ls);
            sb.append(" - passed: " + passed + ls);
            sb.append(" - failed: " + failed + ls);
            sb.append(" - pass ratio: ").append((passed/ (passed + failed)) * 100).append(" %").append(ls);
            sb.append("Failed list: " + ls);
            failedNames.forEach(sb::append);

            System.out.println(sb.toString());

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("report.txt")))) {
                writer.write(sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

    }

}
