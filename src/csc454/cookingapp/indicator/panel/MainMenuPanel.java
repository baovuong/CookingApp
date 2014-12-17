package csc454.cookingapp.indicator.panel;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;

import csc454.cookingapp.gear.Ingredient;
import csc454.cookingapp.gear.Recipe;
import csc454.cookingapp.geartrain.RecipeDB;
import csc454.cookingapp.indicator.dialog.AlertDialog;
import csc454.cookingapp.indicator.dialog.DeleteRecipeDialog;
import csc454.cookingapp.indicator.frame.CookingAppFrame;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import java.awt.Component;

import csc454.cookingapp.mechanism.RecipeAction;


public class MainMenuPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static private JList recipeList = new JList();
	private CookingAppFrame mainFrame;
	static DefaultListModel listModel;
	public JList recipePreviewPanel = new JList();
	
	
	/**
	 * Create the panel.
	 */
	public MainMenuPanel(CookingAppFrame frame) {
		super();
		mainFrame = frame;
		
		
		JButton btnOpenRecipe = new JButton("Open Recipe");
		btnOpenRecipe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Opening Recipe");
				if(recipeList.getSelectedValue() != null){
					mainFrame.switchToPanel(CookingAppFrame.STEP_SUMMARY_PANEL);
					StepSummary.loadRecipe(recipeList.getSelectedIndex());
				}
			}
		});

		
		JButton btnNewRecipe = new JButton("New Recipe");
		btnNewRecipe.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	new EditRecipePanel(mainFrame);
            	mainFrame.switchToPanel(CookingAppFrame.EDIT_RECIPE_PANEL);
            }
        });
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		recipePreviewPanel.setVisible(false);//aHEEERE
		
		JButton btnNewButton = new JButton("Delete Recipe");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Delete recipe");
				if(recipeList.getSelectedValue() != null){
					DeleteRecipeDialog.main(recipeList.getSelectedValue().toString(), recipeList.getSelectedIndex());
				}
			}
		});
		
		JButton btnEditRecipe = new JButton("Edit Recipe");
		btnEditRecipe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				new EditRecipePanel(mainFrame);
				if(recipeList.getSelectedValue() != null){
					mainFrame.switchToPanel(CookingAppFrame.EDIT_RECIPE_PANEL);
					EditRecipePanel.loadRecipe(recipeList.getSelectedIndex());
				}
			}
		});
		
		JLabel lblSelectARecipe = new JLabel("Select a Recipe:");
		lblSelectARecipe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewRecipe, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSelectARecipe)
							.addGap(37)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(btnEditRecipe, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
							.addGap(38)
							.addComponent(btnOpenRecipe, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(recipePreviewPanel, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(recipePreviewPanel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSelectARecipe)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewRecipe, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditRecipe, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOpenRecipe, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		scrollPane.setViewportView(recipeList);
		/*
		recipeList.setModel(new AbstractListModel() {
			String[] values = new String[] {"ein", "zwei", "drei", "vier", "funf", "sechs", "sieben", "acht", "nein", "zehn", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
=======
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Apple Pie", "Chocolate Cake", "NEW"};
>>>>>>> refs/remotes/origin/master
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		*/
		recipeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		updateRecipeList();
		setLayout(groupLayout);
		
		recipeList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (Recipe recipe : RecipeAction.getAllRecipes()) {
					if(recipe.getName() == recipeList.getSelectedValue()) {
						recipePreviewPanel.setVisible(true);
						recipePreviewPanel.setModel(listModel = new DefaultListModel() { });
						
						listModel.addElement("Ingredients:");
						listModel.addElement("Noodles - One Box");
						listModel.addElement("Cheese - One Packet");
						listModel.addElement("Butter - 1/4 Cup");
						listModel.addElement("Water - 2 Cups");
						listModel.addElement("");
						listModel.addElement("");
						listModel.addElement("Steps: ");
						listModel.addElement("Heat water in microwave for 5 minutes.");
						listModel.addElement("Heat noodles in microwave for 5 minutes.");
						listModel.addElement("Drain Noodles.");
						listModel.addElement("Stir in cheese and butter.");
						listModel.addElement("Serve warm with hot dogs.");
					}
				}
			}
		});

	}
	
	public static void updateRecipeList() {
		
		recipeList.setModel(listModel = new DefaultListModel() { });
		String[] values = new String[RecipeAction.getAllRecipes().size()];
		for (int i = 0; i < values.length; i++) {
			values[i] = new String();
		}
		for (int i = 0; i < values.length; i++) {
			values[i] = RecipeAction.getAllRecipes().get(i).getName();
			System.out.println(values[i]);
		}
		
		
		listModel.clear();
		for(int i = 0; i < values.length; i++){
			listModel.addElement(values[i].toString());
			
		}
		
		System.out.println(values.length);
		//recipeList.setModel(arg0);
		//recipeList = new JList(values);
		//recipeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//recipeList.repaint();
	}
}
