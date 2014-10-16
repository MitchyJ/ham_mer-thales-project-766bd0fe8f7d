package fyp.hammer.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fyp.hammer.client.service.CommandParser;
import fyp.hammer.client.service.Service;
import java.sql.*;
import fyp.hammer.server.command_type;


public class ServiceImpl extends RemoteServiceServlet implements Service {

	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "mydatabase";
	String driver = "com.mysql.jdbc.Driver";
	String userName = "root"; 
	String password = "1234";

	@Override
	public String sayHello(String name) {
		String greet = "Hello" + name;
		return greet;
	}

	@Override
	public int addTwoNumbers(int num1, int num2) {
		int y = num1 + num2;
		return y;
	}

	@Override
	public String processInput(String type, String loc, String time, String date, String reporterName,
			String reporterID, String reporterPhone) {
		int num = getMaxEid() + 1;
		System.out.print("Next eid: ");
		System.out.println(num);
		try {
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url+dbName,userName,password);
			Statement st = conn.createStatement();	
			int val = st.executeUpdate("INSERT into mydatabase.edata VALUES(" +
					num + ",'" +
					type + "','" +
					loc + "','" +
					date + "','" +
					time + "','" +
					reporterName + "','" +
					reporterID + "','" +
					reporterPhone + "');");
			if(val==1)
				return ("Successfully inserted value");
			conn.close();

		} catch (Exception e) {
			System.out.println("Fail inserting value");
			e.printStackTrace();
		}
		return "Save Process is unsuccessful";
	}

	private String searchByType(String type) {
		System.out.print("search by type function : ");
		System.out.println(type);
		try {
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url+dbName,userName,password);
			Statement st = conn.createStatement();	
			ResultSet rs = st.executeQuery("SELECT * from mydatabase.edata;");
			String location;
			while ( rs.next() ) {
				location = rs.getString("Location");
				System.out.print("Location is: ");
				System.out.println(location);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fail searching");
		}
		return null;
	}

	@Override
	public String sayWhat(String name) {
		return "what " + name;
	}

	private int getMaxEid() {
		int max_eid = 0;
		try {
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url+dbName,userName,password);
			Statement st = conn.createStatement();	
			ResultSet val = st.executeQuery("select count(*) from mydatabase.edata;");
			val.next();
			max_eid = val.getInt(1);
			System.out.print("get max eid: ");
			System.out.println(max_eid);
			conn.close();
		} catch (Exception e) {
			System.out.println("Fail get max eid");
			e.printStackTrace();
		}
		return max_eid;
	}

	@Override
	public String processPowerInput(String user_input) {
		CommandParser parser = new CommandParser(user_input);
		command_type comType = parser.getCommandType();
		switch (comType) {
			case SEARCH_BY_TYPE:  
				searchByType(parser.getParameter());
				break;
			default: 
				break;
		}
		return user_input;
	}
}
