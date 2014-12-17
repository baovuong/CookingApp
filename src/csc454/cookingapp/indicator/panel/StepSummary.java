package csc454.cookingapp.indicator.panel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.JScrollPane;

import csc454.cookingapp.gear.Ingredient;
import csc454.cookingapp.gear.Recipe;
import csc454.cookingapp.indicator.frame.CookingAppFrame;
import csc454.cookingapp.mechanism.RecipeAction;
import java.awt.Font;

public class StepSummary extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -606369440637422502L;
	private CookingAppFrame mainFrame;
	private static JTextPane stepsTextPane;
	private static JTextPane ingredientsTextPane;
	
	
	/**
	 * Create the panel.
	 */
	public StepSummary(CookingAppFrame frame) {
		super();
		mainFrame = frame;
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.switchToPanel("Main Menu Panel");
			}
		});
		
		JLabel lblNewLabel = new JLabel("Ingredients");
		
		JLabel lblNewLabel_1 = new JLabel("Steps");
		
		JButton btnNewButton_1 = new JButton("Begin");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.switchToPanel("Individual Step Panel");
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addContainerGap())
		);
		
		stepsTextPane = new JTextPane();
		stepsTextPane.setEditable(false);
		scrollPane_1.setViewportView(stepsTextPane);
		stepsTextPane.setText("1. Heat water in microwave for 5 minutes\n2. Heat noodles in microwave for 5 minutes\n3. Drain noodles\n4. Stir in cheese and butter\5. Serve warm with hot dogs");
		
		ingredientsTextPane = new JTextPane();
		ingredientsTextPane.setEditable(false);
		scrollPane.setViewportView(ingredientsTextPane);
		setLayout(groupLayout);
		ingredientsTextPane.setText("Noodles - One Box\nCheese - One Packet\nButter - 1/4 Cup\nWater - 2 Cups");

	}
	
	public static void loadRecipe(int index) {
		
		
	}
}
