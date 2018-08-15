import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateFrame extends JFrame
{
	Container c;
	JLabel lblRno , lblName;
	JTextField txtRno, txtName;
	JButton btnSave , btnBack;
	JPanel p1,p2;

	UpdateFrame()
	{
		c = getContentPane();
		c.setLayout(new BoxLayout(c , BoxLayout.Y_AXIS));

		p1 = new JPanel();
		lblRno = new JLabel("Rno: ");
		txtRno = new JTextField((4));
		lblName = new JLabel("Name: ");
		txtName = new JTextField((10));
		p1.add(lblRno);
		p1.add(txtRno);
		p1.add(lblName);
		p1.add(txtName);
		c.add(p1);

		p2 = new JPanel();
		btnSave = new JButton("Save");
		btnBack = new JButton("Back");
		p2.add(btnSave);
		p2.add(btnBack);
		c.add(p2);

		setTitle("Update Student Info.");
		setLocationRelativeTo(null);
		setSize(350,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);


		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
			MainFrame a = new MainFrame();
			dispose();
			}
		});

		btnSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String rno = txtRno.getText();
				String name = txtName.getText();
				DbHandler db = new DbHandler();
				db.UpdateStudent(Integer.parseInt(rno),name);


			}
		});

	}

	public static void main(String[] args)
	{
		UpdateFrame uf = new UpdateFrame();	
}

}