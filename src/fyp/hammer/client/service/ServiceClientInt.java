package fyp.hammer.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServiceClientInt {
	void sayHello(String name);
	void addTwoNumbers(int num1, int num2);
	void processInput(String type, String loc, String time, String date, String reporterName, String reporterID, String reporterPhone);
	void processPowerInput(String input);
	void sayWhat(String name);
}
