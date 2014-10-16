package fyp.hammer.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fyp.hammer.client.service.ServiceClientImpl;

public class MainGUI extends Composite {
	private VerticalPanel mainVP = new VerticalPanel();
	private VerticalPanel incidentVP = new VerticalPanel();
	private VerticalPanel firstVP = new VerticalPanel();
	private VerticalPanel secondVP = new VerticalPanel();
	private VerticalPanel thirdVP = new VerticalPanel();
	
	private Label detailL;
	private TextBox typeTB;
	private TextBox locTB;
	private TextBox timeTB;
	private TextBox dateTB;
	private Label reporterL;
	private TextBox reporterNameTB;
	private TextBox reporterIdTB;
	private TextBox reporterPhoneTB;
	private TextBox incidentIdTB;

	private Button saveBtn;
	private Label resultL;
	
	private ServiceClientImpl serviceImpl;
	private boolean defaultvalue = true;
	private DialogBox dialogBox = new DialogBox();
	public VerticalPanel dialogVPanel = new VerticalPanel();
	
	final public HTML serverResponseLabel = new HTML();
	
	public MainGUI(ServiceClientImpl serviceImpl) {
		initWidget(this.mainVP);
		this.serviceImpl = serviceImpl;
		
		this.detailL = new Label("Details");
		this.typeTB = new TextBox();
		this.typeTB.setText("Type..");
		typeTB.addFocusHandler(new tbFocushandler());
		
		this.locTB = new TextBox();
		this.locTB.setText("Location..");
		this.timeTB = new TextBox();
		this.timeTB.setText("Time..");
		this.dateTB = new TextBox();
		this.dateTB.setText("Date..");
	
		this.firstVP.add(detailL);
		this.firstVP.add(typeTB);
		this.firstVP.add(locTB);
		this.firstVP.add(timeTB);
		this.firstVP.add(dateTB);
		this.incidentVP.add(firstVP);

		this.reporterL = new Label("Reporter");
		this.reporterNameTB = new TextBox();
		this.reporterNameTB.setText("Name..");
		this.reporterIdTB = new TextBox();
		this.reporterIdTB.setText("ID..");
		this.reporterPhoneTB = new TextBox();
		this.reporterPhoneTB.setText("Phone..");
		
		this.incidentIdTB = new TextBox();
		this.incidentIdTB.setText("Incident ID..");


		this.secondVP.add(reporterL);
		this.secondVP.add(reporterNameTB);
		this.secondVP.add(reporterIdTB);
		this.secondVP.add(reporterPhoneTB);
		this.incidentVP.add(secondVP);
		
		
		this.saveBtn = new Button("Save");
		saveBtn.addClickHandler(new saveBtnClkHandler());
		this.thirdVP.add(saveBtn);
		this.thirdVP.getElement().setAttribute("align", "right");
		this.incidentVP.add(thirdVP);
		
		this.resultL = new Label("");
		this.incidentVP.add(resultL);
		
		this.mainVP.add(incidentVP);
		//header.add(powerVP);

		this.mainVP.getElement().setAttribute("align", "left");
		
		
		// Create the popup dialog box
		dialogBox.setWidth("350px");
		dialogBox.setText("Result");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		dialogVPanel.setWidth("340px");
		dialogVPanel.addStyleName("dialogVPanel");
		//dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);					
		
		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new closeClickHandler());
	}
	

	// actions
	private class closeClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			dialogBox.hide();
		}
	}
	
	public void updateLabel(String greeting) {
		this.resultL.setText(greeting);
	}
	
	public void showMsg(String greeting) {
		dialogBox.setText(greeting);
		dialogBox.center();
	}
	private class tbFocushandler implements FocusHandler {

		@Override
		public void onFocus(FocusEvent event) {
			if (defaultvalue) {
				typeTB.setText("");
				defaultvalue = false;
			}
		}
	}	
	
	private class saveBtnClkHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			String type = typeTB.getText();
			String loc = locTB.getText();
			String time = timeTB.getText();
			String date = dateTB.getText();
			String reporterName = reporterNameTB.getText();
			String reporterID = reporterIdTB.getText();
			String reporterPhone = reporterPhoneTB.getText();
			System.out.print(type);
			
			//serviceImpl.sayWhat(type);
			serviceImpl.processInput(type, loc, time, date, reporterName, reporterID, reporterPhone);
			//serviceImpl.sayHello(type);
			//dialogBox.center();
		}	
	}
}
