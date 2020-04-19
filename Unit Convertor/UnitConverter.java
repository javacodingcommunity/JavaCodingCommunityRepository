package javacodingcommunity.main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class UnitConverter {
	private boolean state = true; // default state
	public UnitConverter() {
		
	JFrame frame = new JFrame("Unit Converter v.1.0 by Java Coding Community"); // title
	
	frame.setLocationRelativeTo(null);
	// first row
	// adding labels
	JButton convert1 = new JButton("Convert");
	JLabel label1 = new JLabel("Enter km/h :");
	label1.setHorizontalAlignment(SwingConstants.CENTER);
	label1.setVerticalAlignment(SwingConstants.CENTER);
	JLabel end_label1 = new JLabel("m/s");
	end_label1.setHorizontalAlignment(SwingConstants.CENTER);
	end_label1.setVerticalAlignment(SwingConstants.CENTER);
	JTextField textfield1= new JTextField();
	textfield1.setHorizontalAlignment(SwingConstants.CENTER);
	JTextField output1 = new JTextField();
	
	// when you hit the button convert1
	// this happens
	
	convert1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(state) { // checks the state
				// this allows us to switch between states
			double kilometers_per_hour = Double.parseDouble(textfield1.getText());
			double meters_per_second = 5*kilometers_per_hour/18;
			output1.setText(String.format("%.10g",meters_per_second));
			}
			else {
				
				double meters_per_second = Double.parseDouble(textfield1.getText());
				double kilometers_per_hour = 3.6* meters_per_second;
				output1.setText(String.format("%.10g",kilometers_per_hour));
				
			}
			// converts
		}
	});
	
	// second row
	JButton convert2 = new JButton("Convert");
	convert2.setVerticalAlignment(SwingConstants.CENTER);
	convert2.setHorizontalAlignment(SwingConstants.CENTER);
	JLabel end_label2 = new JLabel("Kilometers");
	end_label2.setVerticalAlignment(SwingConstants.CENTER);
	end_label2.setHorizontalAlignment(SwingConstants.CENTER);
	JLabel label2 = new JLabel();		
	label2.setText("Enter Miles :");
	label2.setVerticalAlignment(SwingConstants.CENTER);
	label2.setHorizontalAlignment(SwingConstants.CENTER);
	JTextField textfield2= new JTextField();
	textfield2.setHorizontalAlignment(SwingConstants.CENTER);
	JTextField text_output2 = new JTextField();
	
	convert2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(state) {
			double miles = Double.parseDouble(textfield2.getText());
			double kilometers = miles * 1.609344;
			text_output2.setText(String.format("%.10g",kilometers));
			}
			else {
				double kilometers = Double.parseDouble(textfield2.getText());
				double miles = kilometers / 1.609344;
				text_output2.setText(String.format("%.10g",miles));
			}
				
		}
	});
	
	
	// third row
	JButton convert3 = new JButton("Convert");
	convert3.setVerticalAlignment(SwingConstants.CENTER);
	convert3.setHorizontalAlignment(SwingConstants.CENTER);
	JLabel end_label3 = new JLabel("Dollars");
	end_label3.setVerticalAlignment(SwingConstants.CENTER);
	end_label3.setHorizontalAlignment(SwingConstants.CENTER);
	JLabel label3 = new JLabel();		
	label3.setText("Enter Euros :");
	label3.setVerticalAlignment(SwingConstants.CENTER);
	label3.setHorizontalAlignment(SwingConstants.CENTER);
	JTextField textfield3= new JTextField();
	textfield3.setHorizontalAlignment(SwingConstants.CENTER);
	JTextField text_output3 = new JTextField();
	
	convert3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(state) {
				
			
			double euro = Double.parseDouble(textfield3.getText());
			double dollars = euro * 1.09;
			text_output3.setText(String.format("%.5g",dollars));
			}
			else {
				double dollars = Double.parseDouble(textfield3.getText());
				double euro = dollars * 0.92;
				text_output3.setText(String.format("%.5g",euro));
			}
			
		}
	});
	
	
	
	
	
	
	
	
	
	frame.setSize(new Dimension(600,300)); // dimensions
	frame.setResizable(false); // resizable = false
	frame.setVisible(true); // visible
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	GridLayout gl = new GridLayout(0, 5,10,5);	 // we use
	// the grid layout
	
	
	//ADDING COMPONETNS
	
	// first row
	frame.setLayout(gl);
	frame.add(label1);
	frame.add(textfield1);
	frame.add(convert1);
	frame.add(output1);
	frame.add(end_label1);
	
	// second row
	frame.add(label2);
	frame.add(textfield2);
	frame.add(convert2);
	frame.add(text_output2);
	frame.add(end_label2);

	
	// third row
	
	frame.add(label3);
	frame.add(textfield3);
	frame.add(convert3);
	frame.add(text_output3);
	frame.add(end_label3);
	
	// switch units button
	
	JButton switch_button = new JButton("Switch Units");
	frame.add(switch_button);
	
	switch_button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// this button switches the state, and updates the text
			if(state) {
				state = false;
				label1.setText("Enter m/s:");
				end_label1.setText("km/h");
				label2.setText("Enter Kilometers: ");
				end_label2.setText("Miles");
				label3.setText("Enter Dollars: ");
				end_label3.setText("Euros");
			}
			else if(!state) {
				state = true;
				label1.setText("Enter km/h: ");
				end_label1.setText("m/s");
				label2.setText("Enter Miles: ");
				end_label2.setText("Kilometers");
				label3.setText("Enter Euros: ");
				end_label3.setText("Dollars");
			}
			
			
		}
	});
	



	
	
	
	

}
	
	
	public static void main(String[] args) {
		new UnitConverter();
		
	}
}



