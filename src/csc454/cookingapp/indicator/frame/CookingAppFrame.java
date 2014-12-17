package csc454.cookingapp.indicator.frame;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import csc454.cookingapp.gear.Recipe;
import csc454.cookingapp.indicator.panel.EditRecipePanel;
import csc454.cookingapp.indicator.panel.IndividualStepPanel;
import csc454.cookingapp.indicator.panel.MainMenuPanel;
import csc454.cookingapp.indicator.panel.StepSummary;
import csc454.cookingapp.mechanism.RecipeAction;

import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

public class CookingAppFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6688388302281403540L;
	private JPanel contentPane;
	private static JPanel panels;
	private JLabel statusLabel;
	public final static String EDIT_RECIPE_PANEL = "Edit Recipe Panel";
	public final static String INDIVIDUAL_STEP_PANEL = "Individual Step Panel";
	public final static String MAIN_MENU_PANEL = "Main Menu Panel";
	public final static String STEP_SUMMARY_PANEL = "Step Summary Panel";
	
	public static int recipeID;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CookingAppFrame frame = new CookingAppFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void forceRepaint(){
		panels.repaint();
	}

	/**
	 * Create the frame.
	 */
	public CookingAppFrame() {
		setTitle("Sous Chef");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 570);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("exiting app");
				System.exit(0);
			}
		});
		
		mnFile.add(exitMenuItem);
		getContentPane().setLayout(new CardLayout(0, 0));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		panels = new JPanel();
		panels.setLayout(new CardLayout(0, 0));
		panels.add(new MainMenuPanel(this),MAIN_MENU_PANEL);
		panels.add(new EditRecipePanel(this), EDIT_RECIPE_PANEL);
		panels.add(new IndividualStepPanel(this),INDIVIDUAL_STEP_PANEL);
		panels.add(new StepSummary(this),STEP_SUMMARY_PANEL);
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(panels);
		
		/**
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CardLayout cl = (CardLayout)panels.getLayout();
				cl.show(panels, (String)e.getItem());
				panels.repaint();
			}
		});
		comboBox.addItem(MAIN_MENU_PANEL);
		comboBox.addItem(EDIT_RECIPE_PANEL);
		comboBox.addItem(INDIVIDUAL_STEP_PANEL);
		comboBox.addItem(STEP_SUMMARY_PANEL);
		
		contentPane.add(comboBox, BorderLayout.NORTH);
		
		JPanel statusPanel = new JPanel();
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setPreferredSize(new Dimension(getWidth(), 16));
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
		statusLabel = new JLabel("status");
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusPanel.add(statusLabel);
		*/
		
	}
	
	public void changeStatus(String newStatus) {
		statusLabel.setText(newStatus);
	}
	
	public void switchToPanel(String panelName) {
		CardLayout cl = (CardLayout)panels.getLayout();
		cl.show(panels, panelName);		
	}
	
	/**
	 * load all panels with recipe
	 * @param index
	 */
	public void loadRecipe(int index) {
	}
	
}
