package Runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",glue="steps", strict = true,
        plugin = {"pretty", "html:target/cucumber"} )
public class TestRunner {
}

