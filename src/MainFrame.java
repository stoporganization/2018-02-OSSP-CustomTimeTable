import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	CourseList Clist = new CourseList();
	TimeTable Ttable = new TimeTable(this);
	CourseListFrame Cframe = new CourseListFrame(this);
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 455);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		/**************************************************************************************/
		//엑셀을 읽어옴
		JButton btnNewButton = new JButton("Start");
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.setBounds(484, 225, 115, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int ret = chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) { 
					JOptionPane.showMessageDialog(null, "선택된 파일이 없습니다","寃쎄퀬",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String filePath = chooser.getSelectedFile().getPath();
			    //엑셀을 string으로 받아와 Clist객체로 저장
				Clist.setCourse(filePath);
				Cframe.setVisible(true);
				dispose();
		
			 
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
	
		/************************************************************************************/
		
		JButton btnCondition = new JButton("Condition");
		btnCondition.setBackground(UIManager.getColor("Button.light"));
		btnCondition.setBounds(484, 103, 115, 37);
		contentPane.add(btnCondition);
		
		
		btnCondition.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			Condition con = new Condition(Clist);
				con.setVisible(true);
				con.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						con.setVisible(false);
						con.dispose();
					}
				});
				//dispose();
			}
		});

		/************************************************************************************/
		ImageIcon ic =new ImageIcon("./src/rCTT.png");
		JLabel panel = new JLabel(ic);
		panel.setBackground(Color.WHITE);
		panel.setBounds(112, 103, 350, 150);
		contentPane.add(panel);
	
	}
	
	
}
