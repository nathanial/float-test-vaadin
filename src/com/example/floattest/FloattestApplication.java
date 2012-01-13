package com.example.floattest;

import com.vaadin.Application;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutAction.ModifierKey;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Runo;

public class FloattestApplication extends Application {
	

	private TextField value;
	private ComboBox bits;
	private Button calculate;
	private Table table;
	
	private Panel formPanel;
	private Panel mainPanel;
	private Panel innerPanel;
	private Panel resultsPanel;
	
	private FormLayout formLayout;
	private AbsoluteLayout innerLayout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout resultsLayout;
	
	@Override
	public void init() {
		Window mainWindow = new Window("Float Test");

		createFloatFields();
		createFormPanel();
		createResultsPanel();
		createInnerPanel();
		createMainPanel();
		
		mainWindow.getContent().setHeight("100%");
		
		mainWindow.addComponent(mainPanel);
		setMainWindow(mainWindow);
	}
	
	void createFloatFields(){
		bits = new ComboBox("Float Bits");
		bits.setInputPrompt("Select number of bits");
		bits.addItem("8 Bits");
		bits.addItem("16 Bits");
		bits.addItem("32 Bits");

		value = new TextField("Float Value");
		value.setInputPrompt("0.00");

		calculate = new Button("Calculate");
		calculate.setClickShortcut(KeyCode.D, ModifierKey.CTRL);
		calculate.addListener(new ClickListener(){
			public void buttonClick(ClickEvent event) {

				table.addItem(new Object[] {"1","2","3","4","5"}, null);
			}
		});
		
		table = new com.vaadin.ui.Table();
		table.addContainerProperty("Hex", String.class, null);
		table.addContainerProperty("Sign", String.class, null);
		table.addContainerProperty("Exponent", String.class, null);
		table.addContainerProperty("Mantissa", String.class, null);
		table.addContainerProperty("Value", String.class, null);
		
	}
	
	private void createResultsPanel(){
		resultsPanel = new Panel();
		resultsPanel.setStyleName("borderless " + Runo.PANEL_LIGHT);
		resultsLayout = new VerticalLayout();
		resultsPanel.setContent(resultsLayout);
		
		resultsLayout.addComponent(table);
		resultsLayout.setWidth("100%");
		resultsLayout.setHeight("100%");
		table.setWidth("100%");
		table.setHeight("100%");
	}
	

	private void createFormPanel() {
		formPanel = new Panel();
		formPanel.setStyleName("borderless " + Runo.PANEL_LIGHT);
		
		formLayout = new FormLayout();
		formPanel.setContent(formLayout);
		formLayout.setHeight("200px");
		
		formLayout.addComponent(bits);
		formLayout.addComponent(value);
		formLayout.addComponent(calculate);
	}
	
	private void createInnerPanel(){
		innerPanel = new Panel();
		innerLayout = new AbsoluteLayout();
		innerPanel.setContent(innerLayout);
		
		innerPanel.setHeight("100%");
		
		innerLayout.addComponent(formPanel, "left:10px;top:0px;");
		innerLayout.addComponent(resultsPanel, "left:300px;top:15px;right:7.5%;bottom:10px;");
	}
	
	private void createMainPanel(){
		mainPanel = new Panel();
		mainLayout = new AbsoluteLayout();
		mainPanel.setContent(mainLayout);
		mainPanel.setSizeFull();
		
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		
		mainLayout.addComponent(innerPanel, "top:10px;left:10px;right:10px;bottom:10px;");
	}

}
