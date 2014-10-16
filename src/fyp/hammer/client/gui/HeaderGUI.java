package fyp.hammer.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fyp.hammer.client.gui.tbFocushandler;
import fyp.hammer.client.service.ServiceClientImpl;

public class HeaderGUI extends Composite {	
	//private HorizontalPanel logoHP = new HorizontalPanel();
	//private HorizontalPanel powerHP = new HorizontalPanel();
	private HorizontalPanel headerHP = new HorizontalPanel();

	private TextBox powerTB;
	private ServiceClientImpl serviceImpl;

	public HeaderGUI(ServiceClientImpl serviceImpl) {
		initWidget(this.headerHP);
		this.serviceImpl = serviceImpl;
		String defaultText = "for new incident, try 'add <event type> <event time/date> <event location>'";
		final Image image = new Image();
		image.setUrl(GWT.getModuleBaseURL() + "gwt/clean/images/logo.png");
		//image.setUrl("http://www.google.com/images/logo.gif");
		powerTB = new TextBox();
		powerTB.setWidth("500px");
		powerTB.setText(defaultText);
		powerTB.addFocusHandler(new tbFocushandler(defaultText, powerTB));
		powerTB.addKeyPressHandler(new powertbKeyPressHandler(this.serviceImpl, powerTB));

		this.headerHP.add(image);
		this.headerHP.add(powerTB);
		headerHP.setCellVerticalAlignment(image, VerticalPanel.ALIGN_MIDDLE);
		headerHP.setCellHorizontalAlignment(image, HorizontalPanel.ALIGN_CENTER);

		headerHP.setCellVerticalAlignment(powerTB, VerticalPanel.ALIGN_MIDDLE);
		//headerHP.setCellHorizontalAlignment(powerTB, HorizontalPanel.ALIGN_CENTER);

		headerHP.setCellWidth(image, "170");
		headerHP.setCellWidth(powerTB, "600");
	}

}
