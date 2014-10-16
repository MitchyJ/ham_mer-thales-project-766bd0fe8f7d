package fyp.hammer.client.gui;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.TextBox;

import fyp.hammer.client.service.ServiceClientImpl;

public class powertbKeyPressHandler implements KeyPressHandler {
	private TextBox _tb;
	private ServiceClientImpl _serviceImpl;

	public powertbKeyPressHandler(ServiceClientImpl serviceImpl, TextBox powerTB) {
		_tb = powerTB;
		_serviceImpl = serviceImpl;
	}

	@Override
	public void onKeyPress(KeyPressEvent event) {
		if ((int)event.getCharCode() == KeyCodes.KEY_ENTER) {
				submitQuery();
		}
	}

	private void submitQuery() {
		System.out.println("keypress SubmitQuery");
		_serviceImpl.processPowerInput(_tb.getText());
	}
}
