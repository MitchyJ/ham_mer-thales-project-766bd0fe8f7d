package fyp.hammer.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fyp.hammer.client.service.ServiceClientImpl;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWT_project_two implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		ServiceClientImpl clientImpl = new ServiceClientImpl(GWT.getModuleBaseURL() + "service");
		RootPanel.get("header").add(clientImpl.getHeaderGUI());
		RootPanel.get("mycontainer").add(clientImpl.getMainGUI());
		RootPanel.get("resultdata").add(clientImpl.getResultGUI());	
	}
}
