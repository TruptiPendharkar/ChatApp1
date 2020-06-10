package myChatApp1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.lang.*;
public class Server extends JFrame implements ActionListener{
	JPanel p1;
	JTextField T1;
	JButton B1;
	JTextField T2;
	static JTextArea A1;
	JScrollPane pane;
	static ServerSocket skt;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	
	Server(){
//pane=new JScrollPane();
		
		
		
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(7,94,84));
		p1.setBounds(0,0, 480, 60);
		add(p1);
		ImageIcon I1= new ImageIcon(ClassLoader.getSystemResource("myChatApp1/Icons/arrow.png"));
		Image I2= I1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
		ImageIcon I3=new ImageIcon(I2);
//		
		JLabel L1= new JLabel(I3);
//		
		L1.setBounds(5, 15, 30,30);
		p1.add(L1);
//		getContentPane().setBackground(Color.CYAN);
		
		L1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);
			}
		});
		
		ImageIcon I4= new ImageIcon(ClassLoader.getSystemResource("myChatApp1/Icons/Trupti.jpg"));
		Image I5= I4.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon I6=new ImageIcon(I5);
//		
		JLabel L2= new JLabel(I6);
//		
		L2.setBounds(40, 5, 50,50);
//		
		p1.add(L2);
		
		JLabel L3 =new JLabel("Trupti");
		L3.setFont(new Font("SAN_SERIF",Font.BOLD,15));
		L3.setForeground(Color.BLACK);
		L3.setBounds(100,12,80,20);
		
		p1.add(L3);
		
		
		JLabel L4 =new JLabel("Active Now");
		L4.setFont(new Font("SAN_SERIF",Font.PLAIN,10));
		L4.setForeground(Color.BLACK);
		L4.setBounds(100,22,80,30);
		
		p1.add(L4);
		
		ImageIcon I7= new ImageIcon(ClassLoader.getSystemResource("myChatApp1/Icons/videoone.png"));
		Image I8= I7.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
		ImageIcon I9=new ImageIcon(I8);
//		
		JLabel L5= new JLabel(I9);
		L5.setBounds(320, 10, 30,30);
//		L5.setForeground(Color.WHITE);
		p1.add(L5);
		
		
		
		ImageIcon I10= new ImageIcon(ClassLoader.getSystemResource("myChatApp1/Icons/voiceCall.png"));
		Image I11= I10.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
		ImageIcon I12=new ImageIcon(I11);
//		
		JLabel L6= new JLabel(I12);
		L6.setBounds(390, 10, 30,30);
//		
		p1.add(L6);
		
		
		ImageIcon I13= new ImageIcon(ClassLoader.getSystemResource("myChatApp1/Icons/dots.png"));
		Image I14= I13.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
		ImageIcon I15=new ImageIcon(I14);
//		
		JLabel L7= new JLabel(I15);
		L7.setBounds(440, 10, 30,30);
//		
		p1.add(L7);
		
		
		A1 =new JTextArea();
		A1.setBounds(3,65,470,490);
		A1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
		A1.setBackground(Color.WHITE);
		A1.setForeground(Color.BLACK);
		A1.setEditable(false);
		A1.setLineWrap(true);
		A1.setWrapStyleWord(true);
	
		
//		pane =new JScrollPane(A1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	add(A1);
//		add(pane);
		T1=new JTextField();
		T1.setBounds(5,560 ,350 ,30);
		T1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
	
		add(T1);
		B1=new JButton("Send");
		B1.setBounds(360, 560, 110, 30);
		B1.setBackground(new Color(7,94,84));
		B1.setForeground(Color.BLACK);
		B1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
		B1.addActionListener(this);
		add(B1);
		
		

		setLayout(null);
		setSize(480,600);
		setLocation(400,100);
//		setContentPane(pane);
		setUndecorated(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		try{String out=T1.getText();
//		A1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		A1.setText(A1.getText()+"\n\n"+" YOU "+"\n"+out);
		dout.writeUTF(out);
		T1.setText("");
		}
		catch(Exception e) {}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server().setVisible(true);
		
		String msgInput="";
	
	
		
		try {
			skt=new ServerSocket(6001);
			while(true) {
			s=skt.accept();
			din=new DataInputStream(s.getInputStream());
			dout=new DataOutputStream(s.getOutputStream());
			
			while(true) {
			msgInput=din.readUTF();
			A1.setText(A1.getText()+"\n\n"+" TRUPTI "+"\n"+msgInput);

			}
//			skt.close();
//			s.close();
			}
			}
		catch(Exception e) {}

	}

}
