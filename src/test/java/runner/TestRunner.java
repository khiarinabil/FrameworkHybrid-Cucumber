package runner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@io.cucumber.junit.CucumberOptions(
		         features="src/test/resource/features",
		         tags= ("@search"),
                 glue={"stepdefintions","hooks"},
                 
                 publish= true,
                 
                 plugin = {"pretty", "html:target/CucumberReports/CucumberReport.html","json:target/cucumber.json"})
public class TestRunner {
	

}
