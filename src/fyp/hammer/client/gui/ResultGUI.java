package fyp.hammer.client.gui;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import fyp.hammer.client.service.ServiceClientImpl;

public class ResultGUI extends Composite {
	private static final int HeaderRowIndex = 0;
	private HorizontalPanel resultHP = new HorizontalPanel();
	private Label detailL;
	private FlexTable flexTable = new FlexTable();
	private static final Object[][] rowData = {
		{ "A", "D", "I", "J"},
		{ "B", "E",  "H", "K"},
		{ "C", "F", "G", "L"},
	};



	public ResultGUI(ServiceClientImpl serviceClientImpl) {
		initWidget(this.resultHP);
		//this.detailL = new Label("result label hereee");
		//this.resultHP.add(detailL);
		flexTable.insertRow(HeaderRowIndex);
		flexTable.getRowFormatter().addStyleName(HeaderRowIndex,"FlexTable-Header");

		addColumn("Column1");
		addColumn("Column12");
		addColumn("Column13");
		addColumn("Column14");

		for (int row = 0; row < rowData.length; row++) {
			addRow(rowData[row]);        
		}

		applyDataRowStyles();

		flexTable.setCellSpacing(0);
		flexTable.addStyleName("FlexTable"); 
		resultHP.add(flexTable);
		//resultHP.setCellWidth(flexTable, "700");
		//resultHP.setCellHorizontalAlignment(flexTable, HorizontalPanel.ALIGN_LEFT);
		resultHP.setWidth("900");
		resultHP.addStyleName("ResultHP"); 

	}

	private void addColumn(Object columnHeading) {
		Widget widget = createCellWidget(columnHeading);
		int cell = flexTable.getCellCount(HeaderRowIndex);

		widget.setWidth("100%");
		widget.addStyleName("FlexTable-ColumnLabel");

		flexTable.setWidget(HeaderRowIndex, cell, widget);

		flexTable.getCellFormatter().addStyleName(
				HeaderRowIndex, cell,"FlexTable-ColumnLabelCell");
	}

	private Widget createCellWidget(Object cellObject) {
		Widget widget = null;

		if (cellObject instanceof Widget)
			widget = (Widget) cellObject;
		else
			widget = new Label(cellObject.toString());

		return widget;
	}
	int rowIndex = 1;
	private void addRow(Object[] cellObjects) {

		for (int cell = 0; cell < cellObjects.length; cell++) {
			Widget widget = createCellWidget(cellObjects[cell]);
			flexTable.setWidget(rowIndex, cell, widget);
			flexTable.getCellFormatter().addStyleName(rowIndex,cell,"FlexTable-Cell");
		}
		rowIndex++;
	}

	private void applyDataRowStyles() {
		HTMLTable.RowFormatter rf = flexTable.getRowFormatter();

		for (int row = 1; row < flexTable.getRowCount(); ++row) {
			if ((row % 2) != 0) {
				rf.addStyleName(row, "FlexTable-OddRow");
			}
			else {
				rf.addStyleName(row, "FlexTable-EvenRow");
			}
		}
	}


}
