package Framework.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

//import commonutilities.TestUtil;

public class CustomListeners implements ITestListener {

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestSuccess(ITestResult result) {


		System.out.println("Test case pass");
		
	}

	
	public void onTestFailure(ITestResult result) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");
        TestUtil.captureScreenshot();
        String path = TestUtil.mailscreenshotpath;
        System.out.println(path);
		Reporter.log("<a target=\"_blank\" href="+path+">screenshot</a>");
		System.out.println("CaptureScreenshot");
		
		String path1 = ("<a  target='_blank' href='" + path + "' ><img height=200, width=200, src=\"" + path + "\" alt=\"\"/></img></a>");
		Reporter.log(path1);
		
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
