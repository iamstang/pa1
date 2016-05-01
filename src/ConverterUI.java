package w9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/*
 * User interface for converter
 * @author Khanutchon Ammawong
 */
public class ConverterUI extends JFrame {


	// attributes for graphical components
	private JButton convertButton = new JButton("Convert");
	private JButton clearButton = new JButton("Clear");
	private UnitConverter unitconverter;
	private JTextField input;
	private JTextField result;
	private JComboBox unit1ComboBox;
	private JComboBox unit2ComboBox;
	private JLabel equal = new JLabel(" = ");
	Container top = new Container();

	JMenuBar menuBar;
	JMenu menu;
	JMenuItem length = new JMenuItem("Length");
	JMenuItem weight = new JMenuItem("Weight");
	JMenuItem area = new JMenuItem("Area");
	JMenuItem exit = new JMenuItem("Exit");


	public ConverterUI( UnitConverter uc ){

		this.unitconverter = uc;

		this.setTitle("Length Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
	}


	/*
	 * initialize components in the windows
	 */
	public void initComponent(){

		this.setLayout(new GridLayout( 1 , 0 ));

		top.setLayout(new FlowLayout());

		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		menuBar.add(menu);


		this.setJMenuBar(menuBar);
		this.add(top);


		input = new JTextField(7);
		result = new JTextField(7);


		unit1ComboBox = new JComboBox<Unit>(Length.values());
		unit2ComboBox = new JComboBox<Unit>(Length.values());

		top.add(input);
		top.add(unit1ComboBox);
		top.add(equal);
		top.add(result);
		top.add(unit2ComboBox);
		top.add(convertButton);
		top.add(clearButton);
		
		
		clearButton.addActionListener( new ClearButtonListener() );

		
		/*
		 * convert the value from left to right
		 */
		convertButton.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				convert();
			}
			
		});
		
		/*
		 * convert the amount automatically when user interact with the textfield
		 */
		input.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(java.awt.event.KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(java.awt.event.KeyEvent e) {
				// TODO Auto-generated method stub
				String s;
				Unit unit1 , unit2 ;
				s = input.getText().trim();

				unit1 = (Unit) unit1ComboBox.getSelectedItem();
				unit2 = (Unit) unit2ComboBox.getSelectedItem();

				if ( s.length() > 0 ){
					try {

						double value = Double.valueOf( s );
						double temp = unitconverter.convert( value , unit1 , unit2 );
						result.setText( String.format("%.5g",temp) );		

					} catch ( NumberFormatException error ){
						
					}
				}
			}

		});

		
		/*
		 * convert the amount automatically when user interact with the textfield
		 */
		result.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(java.awt.event.KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(java.awt.event.KeyEvent e) {
				// TODO Auto-generated method stub
				String s;
				Unit unit1 , unit2 ;

				s = result.getText().trim();

				unit1 = (Unit) unit2ComboBox.getSelectedItem();
				unit2 = (Unit) unit1ComboBox.getSelectedItem();
				if ( s.length() > 0 ){
					try {

						double value = Double.valueOf( s );
						double temp = unitconverter.convert( value , unit1 , unit2 );

						input.setText( String.format("%.5g",temp) );

					} catch ( NumberFormatException error ){
						
					}
				}
			}

		});



		menu.add(length);
		menu.add(weight);
		menu.add(area);
		menu.add(exit);
		
		exit.addActionListener( new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		/*
		 * change the measurement when user interact with this from the menu bar
		 */
		length.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// change the combo box to measurement user select
				unit1ComboBox.setModel(new javax.swing.DefaultComboBoxModel(Length.values()));
				unit2ComboBox.setModel(new javax.swing.DefaultComboBoxModel(Length.values()));
			}

		});

		/*
		 * change the measurement when user interact with this from the menu bar
		 */
		weight.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// change the combo box to measurement user select
				unit1ComboBox.setModel(new javax.swing.DefaultComboBoxModel(Weight.values()));
				unit2ComboBox.setModel(new javax.swing.DefaultComboBoxModel(Weight.values()));
			}

		});

		/*
		 * change the measurement when user interact with this from the menu bar
		 */
		area.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// change the combo box to measurement user select
				unit1ComboBox.setModel(new javax.swing.DefaultComboBoxModel(Area.values()));
				unit2ComboBox.setModel(new javax.swing.DefaultComboBoxModel(Area.values()));
			}

		});

		this.setSize(700,100);
		this.setResizable(false);
		this.setVisible(true);
	}





	/*
	 * Action listener for clear button
	 * Clear all text in JTextField
	 */
	class ClearButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			input.setText("");
			result.setText("");
		}
	}

	

	/*
	 * convert input amount to selected unit from left to right
	 */
	public void convert(){

		String s;
		Unit unit1 , unit2 ;

		s = input.getText().trim();

		unit1 = (Unit) unit1ComboBox.getSelectedItem();
		unit2 = (Unit) unit2ComboBox.getSelectedItem();


		if ( s.length() > 0 ){
			try {

				double value = Double.valueOf( s );
				double temp = unitconverter.convert( value , unit1 , unit2 );
			
				result.setText( String.format("%.5g",temp) );
				
			} catch ( NumberFormatException error ){
				
			}
		}
	}


}
