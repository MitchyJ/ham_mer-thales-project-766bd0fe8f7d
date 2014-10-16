package fyp.hammer.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fyp.hammer.client.gui.MainGUI;

public class PowerCallback implements AsyncCallback {
	MainGUI _maingui;
	
	public PowerCallback(MainGUI maingui) {
		_maingui = maingui;
		System.out.println("power callback creation");
	}
	
	@Override
	public void onFailure(Throwable caught) {
		System.out.println("'POWER' callback failure");
	}

	@Override
	public void onSuccess(Object result) {
		if (result instanceof String) {
			String greeting = (String) result;
			_maingui.updateLabel(greeting);
			_maingui.serverResponseLabel.setText(greeting);
			_maingui.showMsg("Result");
		}
		System.out.println("'POWER' callback success");
	}

}
