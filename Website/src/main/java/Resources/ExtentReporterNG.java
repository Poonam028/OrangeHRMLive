package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() {
		// TODO Auto-generated method stub
		ExtentReports extent;
		{
			
			String path = System.getProperty("user.dir")+"\\reports\\index.html";
			ExtentSparkReporter reporter= new ExtentSparkReporter(path);
			reporter.config().setReportName("Poonam sawant");
			reporter.config().setDocumentTitle("Priya");
			
		    extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Poonam Sawant");
			return extent;
			}
	}

}
