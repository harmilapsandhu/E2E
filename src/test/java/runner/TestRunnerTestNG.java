package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features",
		glue = "definitions"
		)

public class TestRunnerTestNG extends AbstractTestNGCucumberTests {

//We create a separate .xml file to run our Cucumber Test cases with testNG
//Also create a separate TestRunner file which is this class
//Now add cucumber TestNG dependency to download relevant jars	
//Here to covert our JUnit Test Cases to TestNG, use the above syntax
//And use 'extends AbstractTestNGCucumberTests' & import package	

}
