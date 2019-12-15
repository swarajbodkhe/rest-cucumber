package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        plugin = {"pretty", "html:target/cucumber"},
        plugin = { "de.monochromata.cucumber.report.PrettyReports:target/cucumber" },
        glue = {"steps"},
        features = {"src/test/resources/features/"},
        tags = "not @Sanity"
)
public class TrelloBasicRunnerTest {

}
