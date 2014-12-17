package csc454.cookingapp.indicator.panel;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import csc454.cookingapp.indicator.frame.CookingAppFrame;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IndividualStepPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8908010939837966355L;
	private CookingAppFrame mainFrame;

	static JLabel lblNewLabel = new JLabel("");

	public static void setCurrentStep(String newText) {
		lblNewLabel.setText(newText);
	}

	/**
	 * Create the panel.
	 */
	public IndividualStepPanel(CookingAppFrame frame) {
		super();
		mainFrame = frame;
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.switchToPanel("Main Menu Panel");
			}
		});

		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (StepListPanel.list.getSelectedValue() != null) {
					int tempIndex = StepListPanel.list.getSelectedIndex() + 1;
					StepListPanel.list.setSelectedIndex(tempIndex);
					if (StepListPanel.list.getSelectedValue() == null) {
						StepListPanel.list.setSelectedIndex(tempIndex - 1);
					}
					setCurrentStep(StepListPanel.list.getSelectedValue()
							.toString());
				} else {
					StepListPanel.list.setSelectedIndex(0);
					setCurrentStep(StepListPanel.list.getSelectedValue()
							.toString());
				}
			}
		});

		JButton btnNewButton_2 = new JButton("Previous");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (StepListPanel.list.getSelectedValue() != null) {
					int tempIndex = StepListPanel.list.getSelectedIndex() - 1;
					StepListPanel.list.setSelectedIndex(tempIndex);
					if (StepListPanel.list.getSelectedValue() == null) {
						StepListPanel.list.setSelectedIndex(tempIndex + 1);
					}
					setCurrentStep(StepListPanel.list.getSelectedValue()
							.toString());
				} else {
					StepListPanel.list.setSelectedIndex(0);
					setCurrentStep(StepListPanel.list.getSelectedValue()
							.toString());
				}
			}
		});

		JLabel lblNewLabel_1 = new JLabel(""); // TIMER WOULD GO HERE
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel = new StepListPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(440)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnNewButton_2)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnNewButton_1))))
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
