import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber"},
        features = "src/test/features/",
        glue = {"steps"}
)

public class MainRunner extends AbstractTestNGCucumberTests {
}
