import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class App extends JFrame {

	private JPanel contentPane;
	private JTextField titleText;
	private JPanel savePanel;
	private JPanel InterviewPanel;
	private JPanel descriptionPanel;
	private JPanel interviewerPanel;
	private JPanel intervieweePanel;
	private JLabel lblLowerThird1;
	private JTextField lowerThird2;
	private JTextField description1;
	private JTextField description2;
	private JTextField lowerThird1;
	File[] updateFiles = {new File("files\\Title.txt"), new File("files\\Lower Third 1.txt"),
			new File("files\\Description 1.txt"), new File("files\\Lower Third 2.txt"),
			new File("files\\Description 2.txt")};
	private JLabel lblX;
	private JButton btnPlaceholder;
	private int xx, xy;

	private void updateAll() {
		String[] updateText = {titleText.getText(), lowerThird1.getText(), description1.getText(),
				lowerThird2.getText(), description2.getText()};
		for (int i = 0; i < updateText.length; i++) {
			update(updateText[i], updateFiles[i]);
		}
	}
	
	private void updatePlaceholder() {
		String[] updateText = {"Title", "Lower Third 1", "Description 1",
				"Lower Third 2", "Description 2"};
		for (int i = 0; i < updateText.length; i++) {
			update(updateText[i], updateFiles[i]);
		}
	}

	private void update(String text, File file) {
		try {
			PrintWriter writer = new PrintWriter(file);
			writer.print(text);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		
		// Make the frame draggable
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				App.this.setLocation(x-xx, y-xy);
			}
		});
		setTitle("Lower Thirds Maker");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLowerThirdsMaker = new JLabel("Lower Thirds Maker");
		lblLowerThirdsMaker.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblLowerThirdsMaker.setHorizontalAlignment(SwingConstants.CENTER);
		lblLowerThirdsMaker.setBounds(150, 5, 245, 39);
		contentPane.add(lblLowerThirdsMaker);

		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(5, 55, 535, 51);
		contentPane.add(titlePanel);
		titlePanel.setLayout(new BorderLayout(0, 0));

		JLabel lowerThirdTitle = new JLabel("Lower Third Title");
		lowerThirdTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lowerThirdTitle.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.add(lowerThirdTitle, BorderLayout.NORTH);

		titleText = new JTextField();
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		titleText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titlePanel.add(titleText, BorderLayout.SOUTH);
		titleText.setColumns(1);

		InterviewPanel = new JPanel();
		InterviewPanel.setBounds(5, 117, 535, 56);
		contentPane.add(InterviewPanel);
		InterviewPanel.setLayout(null);

		interviewerPanel = new JPanel();
		interviewerPanel.setBounds(0, 0, 266, 56);
		InterviewPanel.add(interviewerPanel);
		interviewerPanel.setLayout(new BorderLayout(0, 0));

		lblLowerThird1 = new JLabel("Lower Third 1");
		lblLowerThird1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLowerThird1.setHorizontalAlignment(SwingConstants.CENTER);
		interviewerPanel.add(lblLowerThird1, BorderLayout.NORTH);

		lowerThird1 = new JTextField();
		lowerThird1.setHorizontalAlignment(SwingConstants.CENTER);
		lowerThird1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		interviewerPanel.add(lowerThird1, BorderLayout.SOUTH);

		intervieweePanel = new JPanel();
		intervieweePanel.setBounds(270, 0, 266, 56);
		InterviewPanel.add(intervieweePanel);
		intervieweePanel.setLayout(new BorderLayout(0, 0));

		JLabel lblLowerThird2 = new JLabel("Lower Third 2");
		lblLowerThird2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLowerThird2.setHorizontalAlignment(SwingConstants.CENTER);
		intervieweePanel.add(lblLowerThird2, BorderLayout.NORTH);

		lowerThird2 = new JTextField();
		lowerThird2.setHorizontalAlignment(SwingConstants.CENTER);
		lowerThird2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		intervieweePanel.add(lowerThird2, BorderLayout.SOUTH);

		descriptionPanel = new JPanel();
		descriptionPanel.setBounds(5, 184, 535, 56);
		contentPane.add(descriptionPanel);
		descriptionPanel.setLayout(null);

		JPanel descriptor1Panel = new JPanel();
		descriptor1Panel.setBounds(0, 0, 266, 56);
		descriptionPanel.add(descriptor1Panel);
		descriptor1Panel.setLayout(new BorderLayout(0, 0));

		JLabel descriptor1Label = new JLabel("Description");
		descriptor1Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		descriptor1Label.setHorizontalAlignment(SwingConstants.CENTER);
		descriptor1Panel.add(descriptor1Label, BorderLayout.NORTH);

		description1 = new JTextField();
		description1.setHorizontalAlignment(SwingConstants.CENTER);
		description1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		descriptor1Panel.add(description1, BorderLayout.SOUTH);
		description1.setColumns(10);

		JPanel descriptor2Panel = new JPanel();
		descriptor2Panel.setBounds(270, 0, 266, 56);
		descriptionPanel.add(descriptor2Panel);
		descriptor2Panel.setLayout(new BorderLayout(0, 0));

		JLabel descriptor2Label = new JLabel("Description");
		descriptor2Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		descriptor2Label.setHorizontalAlignment(SwingConstants.CENTER);
		descriptor2Panel.add(descriptor2Label, BorderLayout.NORTH);

		description2 = new JTextField();
		description2.setHorizontalAlignment(SwingConstants.CENTER);
		description2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		descriptor2Panel.add(description2, BorderLayout.SOUTH);
		description2.setColumns(10);

		savePanel = new JPanel();
		savePanel.setBounds(5, 251, 535, 33);
		contentPane.add(savePanel);
		savePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateAll();
			}
		});
		savePanel.add(btnSave);
		
		btnPlaceholder = new JButton("Placeholder");
		btnPlaceholder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updatePlaceholder();
				
			}
		});
		savePanel.add(btnPlaceholder);
		
		lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(518, 5, 26, 25);
		contentPane.add(lblX);
	}
}
