package testCase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {
	//declare webdriver as a class variable
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br) throws IOException, InterruptedException {
	    System.out.println(">>> Setting up browser: " + br);  
		//configuring reading config.properties file
	    try {
	        FileReader file = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config.properties");
	        p = new Properties();
	        p.load(file);
	        System.out.println(">>> Config loaded");
	    } catch (Exception e) {
	        System.out.println(">>> Error loading config: " + e.getMessage());
	    }

		//confgng logging		
	    logger = LogManager.getLogger(this.getClass());
	    
	    //configuring browser
	    switch(br.toLowerCase()) {
	    case "chrome":driver = new ChromeDriver(); break;
	    case "edge":driver = new EdgeDriver(); break;
	    default: System.out.println("invalid browser");
	    return;
	    }
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);  // just to visually confirm site loads

	    }
		
	@AfterClass
	void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String captureScreen(String tname) throws IOException {
	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
	    File target = new File(destination);
	    FileUtils.copyFile(source, target);
	    return destination;
	}

		
		
	}

