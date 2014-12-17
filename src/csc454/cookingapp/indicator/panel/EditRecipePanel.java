package csc454.cookingapp.indicator.panel;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

import java.awt.*;
import java.awt.event.*;

import csc454.cookingapp.gear.*;
import csc454.cookingapp.indicator.frame.CookingAppFrame;
import csc454.cookingapp.mechanism.RecipeAction;

public class EditRecipePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7908064423167992409L;
	private JTextField nameTextField;
	private JTextArea notesTextField;
	private JTable ingredientsTable;
	private JTable stepsTable;
	private JSpinner servingsSpinner;
	
	private int currentRecipeId;
	private static Recipe currentRecipe;
	
	private CookingAppFrame mainFrame;
	
	/**
	 * Create the panel.
	 */
	public EditRecipePanel(CookingAppFrame frame) {
		super();
		mainFrame = frame;
		JButton saveButton = new JButton("Save");
		
		JButton cancelButton = new JButton("Cancel");
		
		
		
		
		JLabel lblName = new JLabel("Name:");
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		notesTextField = new JTextArea();
		notesTextField.setColumns(10);
		
		JLabel lblIngredients = new JLabel("Ingredients:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblSteps = new JLabel("Steps:");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblServings = new JLabel("Servings:");
		
		servingsSpinner = new JSpinner();
		
		JLabel lblNotes = new JLabel("Notes:");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblName)
						.addComponent(lblIngredients)
						.addComponent(lblSteps)
						.addComponent(lblNotes)
						.addComponent(lblServings))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addComponent(notesTextField, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
						.addComponent(servingsSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(cancelButton)
							.addGap(73)
							.addComponent(saveButton)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(servingsSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblServings))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(notesTextField, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNotes))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIngredients))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSteps))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(cancelButton)
						.addComponent(saveButton))
					.addGap(43))
		);
		
		JEditorPane editorPane = new JEditorPane();
		scrollPane_2.setViewportView(editorPane);
		
		stepsTable = new JTable();
		stepsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		stepsTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null}
			},
			new String[] {
				"Procedure"
			}
		));
		stepsTable.getColumnModel().getColumn(0).setResizable(false);
		stepsTable.getColumnModel().getColumn(0).setPreferredWidth(200);
		scrollPane_1.setViewportView(stepsTable);
		
		ingredientsTable = new JTable();
		scrollPane.setViewportView(ingredientsTable);
		ingredientsTable.setRowSelectionAllowed(false);
		ingredientsTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Name", "Amount"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -3287132755215691356L;
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		
		saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	Recipe newRecipe = new Recipe();
                System.out.println("You clicked the save button");
          /*     
                DefaultTableModel dtm = (DefaultTableModel) ingredientsTable.getModel();
                DefaultTableModel dtm2 = (DefaultTableModel) stepsTable.getModel();
                int nRow = dtm.getRowCount(), nRow2 = dtm2.getRowCount();
                
                //Initializing ingredients and steps
                Ingredient[] ingrd = new Ingredient[nRow];
                Step[] steps = new Step[nRow2];
                for(int i = 0; i < nRow; i++) {
                	ingrd[i] = new Ingredient();
                }
                for(int i = 0; i < nRow2; i++) {
                	steps[i] = new Step();
                }
                
                for(int i=0; i < nRow; i++) {
            //    	System.out.println("A:" + dtm.getValueAt(i, 0).toString());
                	if(dtm.getValueAt(i, 0) != null && dtm.getValueAt(i, 1) != null) {
                		System.out.println(dtm.getValueAt(i, 0).toString());
                		ingrd[i].setName(dtm.getValueAt(i, 0).toString());
                		ingrd[i].setAmount(dtm.getValueAt(i, 1).toString());
                	}
                	
                }
                //This is where the ingredients are stored in the recipe
                newRecipe.setIngreds(ingrd);
                
                for(int i=0; i < nRow2; i++) {
            //    	System.out.println("B" + dtm2.getValueAt(i, 0).toString());
                	if(dtm2.getValueAt(i, 0) != null && dtm2.getValueAt(i, 1) != null) {
                		System.out.println(dtm2.getValueAt(i, 0).toString());
                		steps[i].setStep(dtm2.getValueAt(i, 0).toString());
                		steps[i].setIngreds(dtm2.getValueAt(i, 1).toString());
                	}
                	
                }*/
                //This is where the text in Name and Notes and the steps/servings are stored in a recipe.
           //     newRecipe.setSteps(steps);
                newRecipe.setName(nameTextField.getText());
           //     newRecipe.setNotes(notesTextField.getText());
          //      newRecipe.setServings(Double.parseDouble(servingsSpinner.getValue().toString()));
                
                // let backend save it
                RecipeAction.addRecipe(newRecipe);
                
                // close edit screen and go back to where it needs to be!
                MainMenuPanel.updateRecipeList();
                mainFrame.switchToPanel(CookingAppFrame.MAIN_MENU_PANEL);
                
            }
        });
		cancelButton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                mainFrame.switchToPanel(CookingAppFrame.MAIN_MENU_PANEL);
            }
        });
		ingredientsTable.getColumnModel().getColumn(0).setResizable(false);
		ingredientsTable.getColumnModel().getColumn(0).setPreferredWidth(200);
		ingredientsTable.getColumnModel().getColumn(1).setResizable(false);
		ingredientsTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		ingredientsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayout(groupLayout);
	}
	public int getCurrentRecipeId() {
		return currentRecipeId;
	}
	public void setCurrentRecipeId(int currentRecipeId) {
		this.currentRecipeId = currentRecipeId;
	}
	
	public static void loadRecipe(int id) {
		currentRecipe = RecipeAction.recipeDB.get(id);
	}
}
