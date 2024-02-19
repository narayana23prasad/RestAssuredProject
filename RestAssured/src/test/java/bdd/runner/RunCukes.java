package bdd.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions( dryRun = false,
features = {"src/test/java/bdd/features"},
glue = {"bdd.steps"},
monochrome = true,
tags = "@RunTest and @GetIncident"

)
public class RunCukes extends AbstractTestNGCucumberTests{

}
