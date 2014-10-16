
package fyp.hammer.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServiceAsync {
	void sayHello(String name, AsyncCallback callback);
	void addTwoNumbers(int num1, int num2, AsyncCallback callback);
	void processInput(String type, String loc, String time, String date, String reporterName, 
			String reporterID, String reporterPhone, AsyncCallback callback);
	void sayWhat(String name, AsyncCallback callback);
	void processPowerInput(String user_input, AsyncCallback callback);
}
