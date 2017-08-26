import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by daljit-pc on 26-Aug-17.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/feature/movies.feature"}, glue = {"steps"})
public class RunnerTest {
}
