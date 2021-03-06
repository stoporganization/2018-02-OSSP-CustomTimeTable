import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class TimeTable extends JFrame {

	 JPanel contentPane;
	 
	Font font = new Font("나눔바른고딕", Font.PLAIN, 17);
	 
MainFrame mFrame = null;
	
	JPanel uTablePanel = new JPanel();
	JPanel mTablePanel = new JPanel();
	JPanel lTablePanel= new JPanel();
	JPanel tableShift = new JPanel();
	public CardLayout cards = new CardLayout();
	
	private JButton leftBtn = new JButton();
	private JButton rightBtn = new JButton();
	private final JPanel weekPan = new JPanel();
	private final JPanel hourPan = new JPanel();
	
	private final JLabel monLabel = new JLabel("    월");
	private final JLabel tueLabel = new JLabel("    화");
	private final JLabel wedLabel = new JLabel("    수");
	private final JLabel thuLabel = new JLabel("    목");
	private final JLabel friLabel = new JLabel("    금");
	private final JLabel hour8 = new JLabel("   8");
	private final JLabel hour9 = new JLabel("   9");
	private final JLabel hour10 = new JLabel("  10");
	private final JLabel hour11 = new JLabel("  11");
	private final JLabel hour12 = new JLabel("  12");
	private final JLabel hour13 = new JLabel("   1");
	private final JLabel hour14 = new JLabel("   2");
	private final JLabel hour15 = new JLabel("   3");
	private final JLabel hour16 = new JLabel("   4");
	private final JLabel hour17 = new JLabel("   5");
	private final JLabel hour18 = new JLabel("   6");
	private final JLabel hour19 = new JLabel("   7");
	private final JLabel hour20 = new JLabel("   8");
	private final JLabel hour21 = new JLabel("   9");
	
	private final JButton crsButton = new JButton("만들기");

	CardPanel card[] = new CardPanel[17];
	int insNum = 0;
	public TimeTable(MainFrame _frame)
	{
		mFrame = _frame;
		setLayout(new BorderLayout());
		this.setPreferredSize(getSize());
		
		mTablePanel.setBackground(new Color(254, 254, 254));
		uTablePanel.setLayout(new GridLayout(1,0,0,0));
		mTablePanel.setLayout(new BorderLayout(0, 0));
		lTablePanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		// Upper Area
		//위쪽 부분 
		leftBtn.setText("◀");
		leftBtn.setFont(new Font(null, Font.PLAIN, 38));
		leftBtn.addActionListener(new LeftEventHandler(this));
		rightBtn.setText("▶");
		rightBtn.setFont(new Font(null, Font.PLAIN, 38));
		rightBtn.addActionListener(new RightEventHandler(this));
		uTablePanel.add(leftBtn);
		uTablePanel.add(rightBtn);
		
		// Middle Area
		monLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		friLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//satLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//sunLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		weekPan.setBounds(40, 0, 600, 40); //840,40
		weekPan.setLayout(new GridLayout(1, 0, 0, 0));
		weekPan.setBorder(new EtchedBorder());
		
		monLabel.setFont(font);
		tueLabel.setFont(font);
		wedLabel.setFont(font);
		thuLabel.setFont(font);
		friLabel.setFont(font);
		//satLabel.setFont(font);
		//sunLabel.setFont(font);
		weekPan.add(monLabel);			
		weekPan.add(tueLabel);			
		weekPan.add(wedLabel);		
		weekPan.add(thuLabel);
		weekPan.add(friLabel);
		//weekPan.add(satLabel);
		//weekPan.add(sunLabel);
			
		hourPan.setBounds(0, 40, 40, 592);
		//hourPan.setBackground(new Color(243, 250, 255));
		hourPan.setLayout(new GridLayout(14, 1, 0, 0));	
		hourPan.setBorder(new EtchedBorder());
		hour8.setFont(font);
		hour9.setFont(font);
		hour10.setFont(font);
		hour11.setFont(font);
		hour12.setFont(font);
		hour13.setFont(font);
		hour14.setFont(font);
		hour15.setFont(font);
		hour16.setFont(font);
		hour17.setFont(font);
		hour18.setFont(font);
		hour19.setFont(font);
		hour20.setFont(font);
		hour21.setFont(font);
		hourPan.add(hour8);
		hourPan.add(hour9);
		hourPan.add(hour10);
		hourPan.add(hour11);
		hourPan.add(hour12);
		hourPan.add(hour13);
		hourPan.add(hour14);
		hourPan.add(hour15);
		hourPan.add(hour16);
		hourPan.add(hour17);
		hourPan.add(hour18);
		hourPan.add(hour19);
		hourPan.add(hour20);
		hourPan.add(hour21);
		
		mTablePanel.add(weekPan);
		mTablePanel.add(hourPan);
		
		uTablePanel.add(leftBtn);
		uTablePanel.add(rightBtn);
		
		tableShift.setLayout(cards);
		tableShift.setOpaque(false);
		mTablePanel.add(tableShift);
		
		// Under Area
		//crsButton.setBackground(btnColor);
		crsButton.setFont(font);
		crsButton.addActionListener(new TransEventHandler(this));
		lTablePanel.add(crsButton);
		
		add(uTablePanel, BorderLayout.NORTH);
		add(mTablePanel, BorderLayout.CENTER);
		add(lTablePanel, BorderLayout.SOUTH);			
	}
	
	public void addCard(MainFrame frame)
	{
		insNum = 0;
		Iterator itr = frame.Clist.cal.insStorage.iterator();
		while(itr.hasNext())
		{
			Instance ins = (Instance) itr.next();
			card[insNum] = new CardPanel(mFrame, ins, insNum+1);
			++insNum;
		}
		for(int i = 0; i<insNum; ++i)
		{
			tableShift.add(card[i]);
		}
	}
}

class CardPanel extends JPanel{
	private MainFrame mFrame;
	public Instance ins;
	Color color[] = new Color[10];
	public JLabel name = new JLabel();
	public JLabel creditSum = new JLabel();
	public JLabel prioSum = new JLabel();
	public JLabel subSum = new JLabel();
	public int num;

	private JPanel analPan = new JPanel();
	public Vector<Course> crsStorage = new Vector<Course>();	
	public JList list = new JList();
	public JScrollPane scrollPane=null;
	
	//Font font = MainFrame.font21;
	//Font font = MainFrame.font17;
	Color listColor = new Color(254, 255,255);
	public CardPanel(MainFrame _frame, Instance _ins, int _num)
	{
		num = _num;
		setBounds(0, 0, 880, 640);
		setLayout(null);
		analPan.setBounds(640, 0, 240, 640);
		analPan.setLayout(null);
		mFrame = _frame;
		ins = _ins;
		
		drawTable(ins);
		add(analPan);
		setVisible(true);
	}
	
	public void drawTable(Instance ins)
	{
		name.setText(num+" 시간표");
		name.setBounds(80, 20, 180, 30);
		creditSum.setText("총점 : "+ins.m_creditSum);
		creditSum.setBounds(10, 55, 180, 30);
		subSum.setText("과목수 : "+ins.m_subNum);
		subSum.setBounds(10, 90, 180, 30);
		prioSum.setText("우선도 : "+ins.m_priorSum);
		prioSum.setBounds(10, 125, 180, 30);
		analPan.add(name);
		analPan.add(creditSum);
		analPan.add(subSum);
		analPan.add(prioSum);
		
		
		color[0] = new Color(221,87,122);
		color[1] = new Color(73,174,192);
		color[2] = new Color(255,240,207);
		color[3] = new Color(237,229,226);
		color[4] = new Color(155,240,233);
		color[5] = new Color(244,178,213);
		color[6] = new Color(12,141,206);
		color[7] = new Color(5,191,181);
		color[8] = new Color(241,156,40);
		color[9] = new Color(241,94,0);
		
		int cnt = 1;
		int colorGet = 0;
		if(ins.m_subNum==0)
			return;
		Iterator citr = mFrame.Clist.crsStorage.iterator();
		Iterator titr = null;
		Course cnext = null;
		Time tnext = null;
		
		
		
		while(citr.hasNext())
		{	
			cnext = (Course) citr.next();
			if(ins.m_key.contains(cnext.num))
			{
			titr = cnext.timeStorage.iterator();
			while(titr.hasNext())
			{
				tnext = (Time) titr.next();
				JPanel jpan = new JPanel();
				jpan.setLayout(new BorderLayout(0, 0));
				jpan.setBounds(40+(tnext.wDay*120), 
						41+((tnext.sIndex-1)%28)*21, 
						120, 
						(tnext.eIndex-tnext.sIndex)*21);
				JLabel name = new JLabel(cnext.name);
				JLabel prof = new JLabel(cnext.professor);
				name.setHorizontalAlignment(JLabel.CENTER); 
				jpan.add(name, BorderLayout.NORTH);
				jpan.add(prof, BorderLayout.SOUTH);
				//jpan.setBackground(color[cnt%10]);
				jpan.setBorder(new EtchedBorder());
				this.add(jpan);
			}
			++cnt;
			crsStorage.add(cnext);
			}
		}
		for(int i = 0; i<5; ++i)
			for(int j = 0; j<28; ++j)
			{
				JPanel jpan = new JPanel();
				jpan.setLayout(new BorderLayout(0, 0));
				if(i%2==j%2)jpan.setBackground(new Color(240,245,245));
				else jpan.setBackground(new Color(255,255,255));
				jpan.setBounds(40+(i*120), 
						41+(j%28)*21, 
						120, 
						21);
				this.add(jpan);
			}
		
		//list.setFont(MainFrame.font19);
		list.setBackground(listColor);
		list.setListData(crsStorage);
		list.setBounds(10, 160, 223, 470);
		scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 160, 223, 470);
		analPan.add(scrollPane);
	}
}

class TransEventHandler implements ActionListener
{
	TimeTable layer;
	public TransEventHandler(TimeTable _layer)
	{
		layer = _layer;
	}
	public void actionPerformed(ActionEvent e)
	{
		//layer.mFrame.Change();
	}
}

class LeftEventHandler implements ActionListener
{
	TimeTable layer;
	public LeftEventHandler(TimeTable _layer)
	{
		layer = _layer;
	}
	public void actionPerformed(ActionEvent e)
	{
		layer.cards.previous(layer.tableShift);
	}
}
class RightEventHandler implements ActionListener
{
	TimeTable layer;
	public RightEventHandler(TimeTable _layer)
	{
		layer = _layer;
	}
	public void actionPerformed(ActionEvent e)
	{
		layer.cards.next(layer.tableShift);
	}
}