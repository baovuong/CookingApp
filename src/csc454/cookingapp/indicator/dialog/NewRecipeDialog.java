package csc454.cookingapp.indicator.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import csc454.cookingapp.indicator.frame.CookingAppFrame;
import csc454.cookingapp.mechanism.RecipeAction;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewRecipeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField recipeNameTextField;
	private String recipeName;
	private CookingAppFrame mainFrame;
	
	private static NewRecipeDialog instance = null;
	
	
	public static NewRecipeDialog getInstance(CookingAppFrame frame) {
		if (instance == null) {
			instance = new NewRecipeDialog(frame);
			instance.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			instance.setVisible(true);
			
		}
		return instance;
	}
	
	/**
	 * Create the dialog.
	 */
	private NewRecipeDialog(CookingAppFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		recipeNameTextField = new JTextField();
		recipeNameTextField.setColumns(10);
		
		JLabel lblEnterNameOf = new JLabel("Enter Name of Recipe");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnterNameOf)
						.addComponent(recipeNameTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEnterNameOf)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(recipeNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(171, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// add new recipe for editing
						String name = recipeNameTextField.getText();
						RecipeAction.createRecipe(name);
						dispose();
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
