import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteFrame extends JFrame
{
	Container c;
	JLabel lblRno;
	JTextField txtRno;
	JButton btnDelete , btnBack;
	JPanel p1, p2 ;

	DeleteFrame()
	{
		c =getContentPane();
		c.setLayout(new BoxLayout(c , BoxLayout.Y_AXIS));

		p1 = new JPanel();
		lblRno = new JLabel("Roll No");
		txtRno = new JTextField((4));
		p1.add(lblRno);
		p1.add(txtRno);
		c.add(p1);

		p2 = new JPanel();
		btnDelete = new JButton("Delete");
		btnBack = new JButton("Back");
		p2.add(btnDelete);
		p2.add(btnBack);
		c.add(p2);

		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try
				{
				int rno = Integer.parseInt(txtRno.getText());
				DbHandler db = new DbHandler();
				
				if(rno < 0)
				{
					throw new NumberGreaterException();	
				}
				
				db.DeleteStudent(rno);
				}
				catch(NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(new JDialog(), "Please Enter Integers only");
				}
				
				catch(NumberGreaterException nge)
				{
					JOptionPane.showMessageDialog(new JDialog(), "Number should be greater than 0");	
				}	


			}
		});

		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				MainFrame a = new MainFrame();
				dispose();
			}});


		setTitle("Delete Student Data");
		setSize(350,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);



	} // end of deletefrAme
}

