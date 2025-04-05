Sample POM Selenium WebDriver framework.

What is POM? 
POM (Page Object Model) is a design pattern that is used in selenium test automation for organizing the helper code for maintainability and reducing code duplication. A page object or a page class is basically a representation of all or some of the actions and operations which can be performed on that page of your application and also acts as an interface to a page of your application under test.


What is LoadableComponent? 
LoadableComponent is a base class that aims to ensure:
* Pages are loaded.
* The initial state of the page is asserted.
* The elements are intractable before we use them.
It helps in debugging the failure of a page to load and in reducing flakiness due to page load issues.

Anatomy of locators file 
Locators file could be of any format, such as .properties, .xml, .json, .yaml, .ini, .toml. For demonstration purposes, .properties is considered.
Keys present in the locators file should be suffixed with the type of locator. Selenium supports:
* id – id attribute of a HTML tag.
* linkText – text of <a> tag.
* partialLinkText – substring text of <a> tag
* name – name attribute of a HTML tag.
* tagName – name of the HTML tag.
* xpath – querying nodes or values from XML.
* className – class attribute of a HTML tag.
* cssSelector – querying nodes or values from HTML using CSS.
And the value of keys is the locator itself.



Build Management:
- Gradle (it caches dependencies locally and downloads them in parallel)
- Install JDK and then install Gradle 
- To learn more about Gradle follow this link

Gradle needs Java JDK or JRE version 8 or higher to be installed as a prerequisite.
The current latest version of Gradle can be downloaded from here.
To install Gradle on Linux or Windows, follow the user guide.
For installation on Mac via command line, you can use the below brew command:
brew install gradle

Configuration management:
- properties files 
Expected: the framework should be able to read the configurable parameters from any of the sources and be able to change the behavior of the features provided by the framework.

Reporting:
TestNG
AllureReport

Logging: 
Expected: the content of log messages will be printed on the console and written to different files according to the levels (INFO level in info.log, DEBUG level in debug.log, and so on).

Once the logback.xml is created under any of these locations in the project 
<project.dir>/src/main/resources 
or <project.dir>/src/test/resources
we can use the below Java code to log
==
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main( String args[] ) {

        LOG.trace("log trace");
        LOG.trace("log trace with arguments '{}'", "arg");

        LOG.warn("log warn");
        LOG.warn("log warn with arguments '{}'", "arg");
        
        LOG.info("log info");
        LOG.info("log info with arguments '{}'", "arg");

        LOG.debug("log debug");
        LOG.debug("log debug with arguments '{}", "arg");

        LOG.error("log error");
        LOG.error("log error with arguments '{}'", "arg");
    }
}
