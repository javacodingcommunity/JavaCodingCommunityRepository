
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class Calculator {
	
	
	private JFrame frame = new JFrame("GUI Calculator by Java Coding Community - v.1.0"); // set the title
	
	private JTextArea txtScreen = new JTextArea(); // this is the screen where the user types numbers from the calc
	private JTextArea outputScreen = new JTextArea(); // this is the screen to present the output / invalid values
	
	private ImageIcon image = new ImageIcon("src\\javacodingcommunity.png"); // icon in top left
	
	
	
	
	// creating number buttons;
	// *NOTE: button 1 stands for number 0
	private JButton button1 = new JButton("0");
	private JButton button2 = new JButton("1");
	private JButton button3 = new JButton("2");
	private JButton button4 = new JButton("3");
	private JButton button5 = new JButton("4");
	private JButton button6 = new JButton("5");
	private JButton button7 = new JButton("6");
	private JButton button8 = new JButton("7");
	private JButton button9 = new JButton("8");
	private JButton button10 = new JButton("9");
	
	
	// creating operator numbers
	private JButton divideButton = new JButton("/");
	private JButton multiplyButton = new JButton("*");
	private JButton addButton = new JButton("+");
	private JButton substractButton = new JButton("-");
	private JButton powerOf = new JButton("**");
	private JButton root = new JButton("sqrt");
	private JButton clears = new JButton("clr");
	private JButton parenthesis_left = new JButton("(");
	private JButton parenthesis_right = new JButton(")");
	private JButton back = new JButton("←");
	
	
	// equals button is more special
	private JButton equals = new JButton("=");
	
	
	
	public Calculator() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default close operation
		frame.setSize(400,550); // calculator size
		frame.setResizable(false); // can't resize it
		frame.setLayout(null); // default layout
		Color customBlue = new Color(133,220,186); // custom colors
		Color customGray = new Color(232,232,232); // custom colors
		frame.getContentPane().setBackground(customBlue);
		// set background
		
		
		//editing the txtScreen 
		txtScreen.setSize(380,50);
		txtScreen.setLocation(7,5);
		
		//editing the output screen
		outputScreen.setSize(380,50);
		outputScreen.setLocation(7,70);
		outputScreen.setBackground(customGray);
		
		// button equals;
		// it is more special than the others :P
		equals.setSize(100,50);
		equals.setLocation(270,450);
		equals.addActionListener(new ActionListener() {
			//this happens when the button is clicked
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// we try to evaluate the text from the text screen
					// using eval function from Evaluation.java
					double x = Evaluation.eval(txtScreen.getText());
					
					if(x == (1.0/0.0) || x ==(-1.0/0.0) || x == (0.0/0.0)) {
						// just forbidding the division by 0 as it is Infinity in Java
						System.out.println("Division by 0 is NOT allowed!");
						outputScreen.setText("Division by 0 is NOT  allowed.");
					}
					else {
						// if it works then it is printed on the screen
						outputScreen.setText(Double.toString(x));
						System.out.println(x);

					}
				} catch (Exception e1) {
					// catching any exception
					// printing it on the screen
					// and console
					outputScreen.setText("Invalid Input, Please Try Again!");	
					outputScreen.append("\n"+e1.getMessage());
					e1.printStackTrace();
				}
				
			}
		});
		
		
		createButtons(); // method that creates buttons
		
		createActionListeners(); // method that creates  Action Listeners that add numbers
		
		addObjectsToScreen(); // method that adds objects to screen
		
	
		
		frame.setVisible(true); // this goes after adding elements
		// so it repaints normally


	}

	private void addObjectsToScreen() {
		
		// function to add all objects to screen
		// it is here to make the code more readable
		frame.add(txtScreen);
		frame.add(outputScreen);
		frame.add(clears);
		frame.add(equals);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.add(button5);
		frame.add(button6);
		frame.add(button7);
		frame.add(button8);
		frame.add(button9);
		frame.add(button10);
		frame.add(divideButton);
		frame.add(multiplyButton);
		frame.add(addButton);
		frame.add(substractButton);
		frame.add(powerOf);
		frame.add(root);
		frame.add(parenthesis_left);
		frame.add(parenthesis_right);
		frame.add(back);
		frame.setIconImage(image.getImage());
		
	}

	private void createButtons() {
		
		// creates buttons
		// it is here to make the program more readable
		
			//button 1;
			button1.setSize(100,50);
			button1.setLocation(169,299);
			
			
			// button 2;
			button2.setSize(100,50);
			button2.setLocation(169,450);
			
			
			// button 3;
			button3.setSize(100,50);
			button3.setLocation(69,450);

			
			// button 4;
			button4.setSize(100,50);
			button4.setLocation(270,399);
			
			
			
			// button 5;
			button5.setSize(100,50);
			button5.setLocation(169,399);
			
			

			// button 6;
			button6.setSize(100,50);
			button6.setLocation(69,399);
			
			
			

			// button 7;
			button7.setSize(100,50);
			button7.setLocation(270,349);
			


			// button 8;
			button8.setSize(100,50);
			button8.setLocation(169,349);

			

			// button 9;
			button9.setSize(100,50);
			button9.setLocation(69,349);

			
			//button 10;
			button10.setSize(100,50);
			button10.setLocation(270,299);
			
			
			
			
			//button clr
			clears.setSize(100,50);
			clears.setLocation(69, 299);
			
			// button divide
			divideButton.setSize(100,50);;
			divideButton.setLocation(270,220);
			
			// multiply button
			multiplyButton.setSize(100,50);
			multiplyButton.setLocation(169,220);
			
			// addition button
			addButton.setSize(100,50);
			addButton.setLocation(69,220);
			
			// substract button
			substractButton.setSize(100,50);
			substractButton.setLocation(270,170);	
			
			//to the power of
			powerOf.setSize(100,50);
			powerOf.setLocation(169,170);
			
			// square root button
			root.setSize(100,50);
			root.setLocation(69,170);
			
			// ( button
			parenthesis_left.setSize(50,50);
			parenthesis_left.setLocation(9,170);
			
			// ) button
			parenthesis_right.setSize(50,50);
			parenthesis_right.setLocation(9,220);
			
			
			// back button
			back.setSize(50,50);
			back.setLocation(9,300);
			
	}

	private void createActionListeners() {
		
		// creates action listeners that add text to screen
		// it is here to make the program more readable
		
		button10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtScreen.append("9");
			}
		});
		
		
		button9.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				txtScreen.append("8");
			}
		});
		
		
		button8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtScreen.append("7");
			}
		});
		
		
		button7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtScreen.append("6");
			}
		});
		
			button6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtScreen.append("5");
			}
		});
			
			button5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("4");
				}
			});
			
			
			button4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("3");
				}
			});
			
			
			button3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("2");
				}
			});
			
			button2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("1");
				}
			});
			
			button1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("0");
				}
			});
			
			
			divideButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("/");
				}
			});
			
			
			multiplyButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("*");
				}
			});
			
			
			addButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("+");
				}
			});
			
			
			substractButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("-");
				}
			});
			
			
			powerOf.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("^");
				}
			});
			
			
			root.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("sqrt(");
				}
			});
			
			
			clears.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.setText("");
				}
			});
			
				parenthesis_left.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("(");
				}
			});
				
				parenthesis_right.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						txtScreen.append(")");
					}
				});
				
				
				back.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(txtScreen.getText().length() != 0) {
							String text = txtScreen.getText().substring(0,txtScreen.getText().length()-1);
							txtScreen.setText(text);
						}
						else {
							outputScreen.setText("There is nothing to remove!");

						}
						
					}
				});
				
				
					
				
				
				
				
					
						
						
					
				
				
		
		
		
		
	}

	public static void main(String[] args) {
		
		new Calculator(); // we call the Calculator constructor and start the program.

	}

}
