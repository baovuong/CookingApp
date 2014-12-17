package csc454.cookingapp.indicator.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * AlertDialog will be a Singleton class. Only one AlertDialog can be displayed
 * @author bvuong
 *
 */

public class AlertDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private static boolean displayed = false;
	private static AlertDialog activeDialog = null;
	private static Queue<String> alertQueue = new LinkedList<String>();

	
	public static synchronized void displayAlert(String alertString) {
		if (activeDialog == null) {
			activeDialog = new AlertDialog(alertString);
			activeDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			activeDialog.setVisible(true);
		}
	}
	
	
	
	
	
	/**
	 * Create the dialog.
	 */
	private AlertDialog(String alertString) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				displayed = false;
				activeDialog = null;
			}
		});
		setTitle("Alert");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblNewLabel = new JLabel(alertString);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
