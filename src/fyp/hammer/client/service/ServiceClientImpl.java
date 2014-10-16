package fyp.hammer.client.service;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

import fyp.hammer.client.gui.HeaderGUI;
import fyp.hammer.client.gui.MainGUI;
import fyp.hammer.client.gui.ResultGUI;

public class ServiceClientImpl implements ServiceClientInt{
	private ServiceAsync service;
	private MainGUI maingui;
	private HeaderGUI headergui;
	private ResultGUI resultgui;
	
	public ServiceClientImpl(String url) {
		System.out.println(url);
		this.service = GWT.create(Service.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) this.service;
		endpoint.setServiceEntryPoint(url);
		this.headergui = new HeaderGUI(this);
		this.maingui = new MainGUI(this);
		this.resultgui = new ResultGUI(this);
	}

	@Override
	public void sayHello(String name) {
		
		this.service.sayHello(name, new DefaultCallback());
	}

	@Override
	public void addTwoNumbers(int num1, int num2) {
		this.service.addTwoNumbers(num1, num2, new DefaultCallback());
	}
	
	@Override
	public void processInput(String type, String loc, String time, String date, String reporterName, String reporterID, String reporterPhone) {
		this.service.processInput(type, loc, time, date, reporterName, reporterID, reporterPhone, new DefaultCallback());
	}
	
	public MainGUI getMainGUI() {
		return this.maingui;
	}
	
	public HeaderGUI getHeaderGUI() {
		return this.headergui;
	}

	@Override
	public void sayWhat(String name) {
		this.service.sayWhat(name, new DefaultCallback());
	}

	public ResultGUI getResultGUI() {
		return this.resultgui;
	}

	@Override
	public void processPowerInput(String input) {
		System.out.println("ServiceClientImpl processPowerInput");
		this.service.processPowerInput(input, new PowerCallback(maingui));
	}
	
	private class DefaultCallback implements AsyncCallback {
		@Override
		public void onFailure(Throwable caught) {
			System.out.println("An error has occured");
		}

		@Override
		public void onSuccess(Object result) {
			if (result instanceof String) {
				String greeting = (String) result;
				maingui.updateLabel(greeting);
				maingui.serverResponseLabel.setText(greeting);
				maingui.showMsg("Result");
			}
		}	
	}
}
