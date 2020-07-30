import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber", "json:cucumberReports/cucumber.json",
		"junit:cucumberReports/cucumber.xml"},
		features = {"src/test/resources"}, strict = true, tags = {"@smoke"})
public class RunCuckestTest {
}
