package csc454.cookingapp.indicator.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import csc454.cookingapp.mechanism.RecipeAction;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteRecipeDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 887929160945827108L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblAreYouSure;

	/**
	 * Launch the application.
	 */
	public static void main(String delstr, int delidx) {
		try {
			DeleteRecipeDialog dialog = new DeleteRecipeDialog(delstr, delidx);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DeleteRecipeDialog(String delStr, final int delIdx) {
		setTitle("Delete Recipe");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblAreYouSure = new JLabel("<html><body style='width: 300px'>Are you sure you want to delete " + delStr + " from your recipes?");
			lblAreYouSure.setHorizontalAlignment(SwingConstants.CENTER);
			lblAreYouSure.setAutoscrolls(true);
			lblAreYouSure.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAreYouSure, GroupLayout.PREFERRED_SIZE, 376, Short.MAX_VALUE)
					.addGap(17))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(56)
					.addComponent(lblAreYouSure)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Delete");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("Deleting");
						RecipeAction.deleteRecipe(delIdx);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Don't delete!");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("Not deleting");
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
