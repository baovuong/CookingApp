package csc454.cookingapp.indicator.panel;

import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.JList;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

import csc454.cookingapp.gear.Recipe;
import javax.swing.JButton;

public class RecipePreviewPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1871809193591105662L;
	
	private JLabel recipeTitleLabel;
	private JScrollPane scrollPane;
	private JList<String> ingredientsList;
	/**
	 * Create the panel.
	 */
	public RecipePreviewPanel() {
		
		recipeTitleLabel = new JLabel("Recipe");
		recipeTitleLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		
		scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(recipeTitleLabel, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(recipeTitleLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
					.addContainerGap())
		);
		ingredientsList = new JList<String>();
		ingredientsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(ingredientsList);
		setLayout(groupLayout);

	}
	
	public void previewRecipe(Recipe recipe) {
		recipeTitleLabel.setText(recipe.getName());
		final String[] values = new String[10];
		values[0] = "yes";
		ingredientsList = new JList<String>(values);
		ingredientsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
}
