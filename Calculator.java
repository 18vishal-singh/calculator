import java.awt.*;
import java.awt.event.*;
class Calculator implements ActionListener
{
	String[] s1={"MC","MR","MS","M+","M-","7","8","9","CE","C","4","5","6","/","%","1","2","3","*","+","0",".","1/x","-","="};
	Frame f;
	String ss1="";
	String ss2="";
	String ss3="";
	String ans="";
	float mem;
	int flag;
	Button[] b=new Button[25];
	TextField tf;
	
	Calculator(String s)
	{
		f=new Frame(s);

		tf=new TextField();
		tf.setBounds(20,40,245,50);
		f.add(tf);
		f.addWindowListener(new WindowEventListener());

		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				b[j+5*i]=new Button(s1[j+5*i]);
				b[j+5*i].setBounds(20+(j*50),120+(i*50),40,40);
				b[j+5*i].setFont( new Font("Helvetica", Font.PLAIN, 18) );
     				b[j+5*i].setBackground(Color.lightGray);
				b[j+5*i].addActionListener(this);
				f.add(b[j+5*i]);
			}
		}
		
		f.setLayout(null);
		f.setSize(280,380);
		f.setVisible(true);
	}

	public static void main(String s[])
	{
		new Calculator("CALCULATOR");
	}
	public void actionPerformed(ActionEvent e)
	{
		tf.setText("");

		if(e.getSource()==b[5])
			tf.setText("7");
		
		if(e.getSource()==b[6])
			tf.setText("8");
		
		if(e.getSource()==b[7])
			tf.setText("9");
		
		if(e.getSource()==b[10])
			tf.setText("4");
		
		if(e.getSource()==b[11])
			tf.setText("5");
		
		if(e.getSource()==b[12])
			tf.setText("6");
		
		if(e.getSource()==b[15])
			tf.setText("1");

		if(e.getSource()==b[16])
			tf.setText("2");

		if(e.getSource()==b[17])
			tf.setText("3");

		if(e.getSource()==b[20])
			tf.setText("0");
		if(flag==0)
		{
			if(e.getSource()==b[21])
			{	
				tf.setText(".");
				flag=1;
			}
		}

		if(e.getSource()==b[13])
		{	ss3="/";
			flag=0;
		}
		if(e.getSource()==b[18])
		{	ss3="*";
			flag=0;
		}
		if(e.getSource()==b[19])
		{	ss3="+";
			flag=0;
		}
		if(e.getSource()==b[23])
		{	ss3="-";
			flag=0;
		}
		if(e.getSource()==b[14])
		{	ss3="%";
			flag=0;
		}
		if(e.getSource()==b[9])
		{
			ss1="";
			ss2="";
			ss3="";
			ans="";
		}
		if(e.getSource()==b[8])
		{
			ss1="";
			ss2="";
			ss3="";
			ans="";
			mem=0;
		}
		if(e.getSource()==b[22])
		{
			if(ss1=="")						//*******************
			{	tf.setText("Enter the number first");
				ss1="";
				ss2="";
				ss3="";
				ans="";
				mem=0;
			}
			else
			{
				if(Float.parseFloat(ss1)==0)
					tf.setText("ca not divide by zero");
				else
				{
				float a1=Float.parseFloat(ss1);
				ans=""+(1/a1);
				tf.setText(ans);
				toDefault();
				}
			}
		}
		
		if(ss3=="")
		{	ss1=ss1+tf.getText();
			System.out.println(ss1);
		}
		
		if(ss3!="")
		{	ss2=ss2+tf.getText();
			System.out.println(ss2);
		}

//*************************************
		if(e.getSource()==b[3])
		{
			ss3="m+";
			flag=0;
			if(ss1!="" && ss2=="" && ss3=="m+")
			{	float a1=Float.parseFloat(ss1);
				mem+=a1;
			}
			else
			{
				float a1=Float.parseFloat(ans);
				mem+=a1;
			}
		}
		if(e.getSource()==b[4])
		{
			ss3="m-";
			flag=0;
			if(ss1!="" && ss2=="" && ss3=="m-")
			{	float a1=Float.parseFloat(ss1);
				mem-=a1;
			}
			else
			{
				float a1=Float.parseFloat(ans);
				mem-=a1;
			}
		}
		if(e.getSource()==b[2])
		{		
			ss3="ms";
			flag=0;
			tf.setText(""+mem);
		}
//*************************************	
		
			
		if(e.getSource()==b[24])
		{	
			if(ss3!="" && (ss1=="" || ss2=="")||ss3=="")
			{	tf.setText("Enter the operand");
				toDefault();
			}
			if(ss1!="" && ss2!="")
			{
			if(ss3=="+")
			{
				System.out.println(ss1+ss3+ss2);
				float a1=Float.parseFloat(ss1);
				float a2=Float.parseFloat(ss2);
				ans=(a1+a2)+"";
				tf.setText(ans);
				toDefault();
			}
			if(ss3=="-")
			{
				System.out.println(ss1+ss3+ss2);
				float a1=Float.parseFloat(ss1);
				float a2=Float.parseFloat(ss2);
				ans=(a1-a2)+"";
				tf.setText(ans);
				toDefault();
			}
			if(ss3=="*")
			{
				System.out.println(ss1+ss3+ss2);
				float a1=Float.parseFloat(ss1);
				float a2=Float.parseFloat(ss2);
				ans=(a1*a2)+"			";
				tf.setText(ans);
				toDefault();
			}
			if(ss3=="/")
			{
				System.out.println(ss1+ss3+ss2);
				float a1=Float.parseFloat(ss1);
				float a2=Float.parseFloat(ss2);
				
				if(a2==0)
					tf.setText("denominator can not be zero");
				else
				{	ans=(a1/a2)+"";
					tf.setText(ans);
				}
				toDefault();
			}
			if(ss3=="%")
			{
				System.out.println(ss1+ss3+ss2);
				float a1=Float.parseFloat(ss1);
				float a2=Float.parseFloat(ss2);
				
				if(a2==0)
					tf.setText("denominator can not be zero");
				else
				{	ans=(a1%a2)+"";
					tf.setText(ans);
				}
				toDefault();
			}
			}
						
		}
		
	}
	void toDefault()
	{
		ss1=ans;
		ss2="";
		ss3="";
		
	}
}
	
class WindowEventListener extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}
