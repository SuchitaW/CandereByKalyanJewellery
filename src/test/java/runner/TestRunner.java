package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



	
	
	@RunWith(Cucumber.class)
	@CucumberOptions(
		
			
//			features="classpath:Feature",
//					glue="",
//					tags="",
			
			features={"src/test/resources/Feature/End2EndJounery.feature"},           //Path of Feature folder which hold feature file
	        glue={"StepDefination","HomeStepDef" }, // Path of StepDefinition file
	        tags= " @e2eMultipleitems", 
	        plugin = {"pretty",                      
	            "html:target/html/htmlReport.html",
	            "json:target/json/jsonReport.json",
	            
	            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"    
			},
			
			monochrome=true,
			        publish= true,
			        dryRun=false
			)
	
	
	public class TestRunner {
		

}
