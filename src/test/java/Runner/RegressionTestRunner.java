package Runner;

import Utilities.FileReaderManager;
import Utilities.ReadProperties;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import java.io.File;

@CucumberOptions(
        plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"},

//                if you need to run specific feature files then add tag here and in the
//                  feature file then it will run those feature files

        tags = "@SM",

//                path for the my feature Files
        features = {"src/test/java/features"},

//                location of the step definitions
        glue={"stepDefinition"},

//                if the dry run is true it is making sure your feature files steps are
//                  created in the step definition
        dryRun = false
)

public class RegressionTestRunner extends AbstractTestNGCucumberTests {

        @AfterClass
        public static void setup()
        {
                Reporter.loadXMLConfig(new File("src\\test\\java\\features\\extent-config.xml"));
                //Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
                Reporter.setSystemInfo("User Name", "Ali Koklu");
                Reporter.setSystemInfo("Application Name", "Basqar ");
                Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
                Reporter.setSystemInfo("Environment", "QA");
                Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
        }
}


