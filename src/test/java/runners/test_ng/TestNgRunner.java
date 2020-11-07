package runners.test_ng;


import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class TestNgRunner {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        final TestNG testNG =
                new TestNG(true);

        //run with xml
//        final Parser parser = new Parser("/Users/daniilrusanov/dev/maven_at_project/daniil_rusanov_maven_at_project/src/test/java/runners/test_ng/test_ng_run_xml");

        //run with yaml
        final Parser parser = new Parser("/Users/daniilrusanov/dev/maven_at_project/daniil_rusanov_maven_at_project/src/test/java/runners/test_ng/test_ng_runner.yaml");

        final List<XmlSuite> suites = parser.parseToList();
        testNG.setXmlSuites(suites);
        testNG.run();

    }
}