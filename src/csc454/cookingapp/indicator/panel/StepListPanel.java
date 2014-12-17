package csc454.cookingapp.indicator.panel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;

import csc454.cookingapp.gear.Ingredient;
import csc454.cookingapp.gear.Recipe;
import csc454.cookingapp.indicator.dialog.AlertDialog;
import csc454.cookingapp.mechanism.RecipeAction;

public class StepListPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3472333202389817127L;
	final static JList list = new JList();
	static DefaultListModel listModel;
	Recipe currentRecipe;
	
	public void loadRecipe(int id){
		currentRecipe = RecipeAction.recipeDB.get(id);
		loadRecipe(RecipeAction.recipeDB.get(id));
	}
	
	public void loadRecipe(Recipe r){
		listModel.clear();
		Ingredient[] ingreds = r.getIngreds();
		int sizeOfList = ingreds.length;
		
		for(int i = 0; i < sizeOfList; i++){
			listModel.addElement(ingreds[i].toString());
		}
	}

	/**
	 * Create the panel.
	 */
	public StepListPanel() {
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(3)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
		);
		
		list.setModel(listModel = new DefaultListModel() { });
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IndividualStepPanel.setCurrentStep(list.getSelectedValue().toString());
			}
		});
		
		listModel.addElement("Heat water in microwave for 5 minutes");
		listModel.addElement("Heat noodles in microwave for 5 minutes");
		listModel.addElement("Drain noodles");
		listModel.addElement("Stir in cheese and butter");
		listModel.addElement("Serve warm with hot dogs");
		
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		setLayout(groupLayout);

	}
}
