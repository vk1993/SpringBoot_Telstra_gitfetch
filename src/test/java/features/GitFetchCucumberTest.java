package features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/GitController.feature", plugin = {"pretty"})
//         format = {"html:target/cucumber-html-report",
//        "junit:target/cucumber-junit-report.xml"})

public class GitFetchCucumberTest {
}