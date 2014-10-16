package fyp.hammer.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("service")
public interface Service extends RemoteService{
	String sayHello(String name);
	int addTwoNumbers(int num1, int num2);
	String processInput(String type, String loc, String time, String date, String reporterName, 
			String reporterID, String reporterPhone);
	String processPowerInput(String user_input);
	String sayWhat(String name);
}
