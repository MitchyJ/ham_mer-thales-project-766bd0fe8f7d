package fyp.hammer.client.gui;

import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.TextBox;

public class tbFocushandler implements FocusHandler {
	public boolean getReady;
	private TextBox _tb;
	
	public tbFocushandler(String defaultText, TextBox tb) {
		_tb = tb;
		if (defaultText.equals(_tb.getText())) {
			getReady = true;
		}
		else {
			getReady = false;
		}
	}

	@Override
	public void onFocus(FocusEvent event) {
		if (getReady) {
			_tb.setText("");
		}
	}
}
