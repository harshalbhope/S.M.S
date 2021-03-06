import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;

class MainFrame extends JFrame
{
	Container c;
	JButton btnAdd, btnView, btnUpdate , btnDelete;

	MainFrame()
	{
		c = getContentPane();
		c.setLayout(new FlowLayout());
	btnAdd = new JButton("Add");
	btnView = new JButton("View"); 
	btnUpdate = new JButton("Update");
	btnDelete = new JButton("Delete");

	c.add(btnAdd);
	c.add(btnView);
	c.add(btnUpdate);
	c.add(btnDelete);

btnAdd.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae)
	{
		AddFrame a =new AddFrame();
		dispose();
	}
});

btnView.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae)
	{
		ViewFrame a =new ViewFrame();
		dispose();
	}
});

btnUpdate.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
		UpdateFrame a = new UpdateFrame();
		dispose();
	}
});

btnDelete.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
		DeleteFrame a = new DeleteFrame();
		dispose();

	}
});


	setTitle("S. M. S");
	setSize(350,200);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}


	public static void main(String[] args) 
	{
		MainFrame m = new MainFrame();	
	}

}


class DbHandler
{
	
	public void addStudent(int rno , String name) 
	{
		try
		{
			DriverManager.registerDriver
			(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			String sql = "insert into student values(?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,rno);
			pst.setString(2,name);
			int r =pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog() , r + " records inserted");
			con.close();

		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog(),"ii" +e);
		}
	}

	public String viewStudent() 
	{
		StringBuffer sb = new StringBuffer();
		try
		{
			DriverManager.registerDriver
			(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			String sql = "select * from Student";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				int rno = rs.getInt(1);
				String name = rs.getString(2);
				sb.append("Rno " + rno + "Name " + name + "\n");
			}
			rs.close();
			con.close();

		}
		catch(SQLException e)
		{
			
		}
		return sb.toString();
	}

	public void UpdateStudent(int rno ,String name)
	{	
		try
		{
			DriverManager.registerDriver
			(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			String sql1 = "update student set name=? where rno=? ";
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			pstmt1.setInt(2, rno);
			pstmt1.setString(1,name);
			int z = pstmt1.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),z + "Name Updated" );
			con.close();


		}
		catch(SQLException e)
		{
			System.out.println("Update issue" + e);
		}
	}
	public void DeleteStudent(int rno)
	{
		try
		{
			DriverManager.registerDriver
			(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			String s2 = "delete from student where rno=?";
			PreparedStatement p1 = con.prepareStatement(s2);
			p1.setInt(1,rno);
			int r = p1.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(), r + "Student Data Deleted ");
			con.close();


		}
		catch(SQLException e)
		{
			System.out.println("Delete issue" + e);
		}
	


	}

} // end of DBHandler class


/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class MainFrame extends JFrame
{
	Container c;
	JButton btnAdd, btnView, btnUpdate , btnDelete;

	MainFrame()
	{
		c = getContentPane();
		c.setLayout(new FlowLayout());
	btnAdd = new JButton("Add");
	btnView = new JButton("View"); 
	btnUpdate = new JButton("Update");
	btnDelete = new JButton("Delete");

	c.add(btnAdd);
	c.add(btnView);
	c.add(btnUpdate);
	c.add(btnDelete);

btnAdd.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae)
	{
		AddFrame a =new AddFrame();
		dispose();
	}
});

btnView.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae)
	{
		ViewFrame a =new ViewFrame();
		dispose();
	}
});

btnUpdate.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
		UpdateFrame a = new UpdateFrame();
		dispose();
	}
});


	setTitle("S. M. S");
	setSize(350,200);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}


	public static void main(String[] args) 
	{
		MainFrame m = new MainFrame();	
	}

}


class DbHandler
{
	public void addStudent(int rno , String name) 
	{
		try
		{
			DriverManager.registerDriver
			(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			String sql = "insert into student values(?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,rno);
			pst.setString(2,name);
			int r =pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog() , r + "records inserted");
			con.close();

		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog(),"ii" +e);
		}
	}

	public String viewStudent() 
	{
		StringBuffer sb = new StringBuffer();
		try
		{
			DriverManager.registerDriver
			(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			String sql = "select * from Student";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				int rno = rs.getInt(1);
				String name = rs.getString(2);
				sb.append("Rno " + rno + "Name " + name + "\n");
			}
			rs.close();
			con.close();

		}
		catch(SQLException e)
		{
			
		}
		return sb.toString();
	}

	public void UpdateStudent()
	{	
		try
		{
			DriverManager.registerDriver
			(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			Statement stmt1 = con.createStatement();
			String sql1 = "update student set name='Harshal' where rno=4 ";
			int z = stmt1.executeUpdate(sql1);
			JOptionPane.showMessageDialog(new JDialog(),z + "Name Updated" );
			con.close();


		}
		catch(SQLException e)
		{
			System.out.println("Update issue" + e);
		}



	}

} // end of DBHandler class
*/