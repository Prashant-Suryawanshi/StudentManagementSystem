package studentManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManagementSystem {
	private Connection connection;
	public StudentManagementSystem() {
		// TODO Auto-generated constructor stub
		try {
			this.connection = ConnectionFactory.createConnection("mysql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void insertData(Student student){
		String query = "insert into student values(?,?,?,?,?,?)";
		try (PreparedStatement preparedstatement = connection.prepareStatement(query)) {
			preparedstatement.setString(1, student.getName());
			preparedstatement.setInt(2, student.getRollNo());
			preparedstatement.setInt(3, student.getStandard());
			preparedstatement.setInt(4, student.getScienceMark());
			preparedstatement.setInt(5, student.getMathMark());
			preparedstatement.setInt(6, student.getEnglishMark());
			
			preparedstatement.executeUpdate();
			System.out.println("Data inserted successfully...!");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteData(int rollNo) {
		String query = "delete from student where rollNo = ?";
		try(PreparedStatement preparedstatement = connection.prepareStatement(query)){
			preparedstatement.setInt(1, rollNo);
			int count = preparedstatement.executeUpdate();
			if (count == 0) {
				System.out.println("No Students to delete...!");
			}
			else {
				System.out.println(count +" Students deleted...!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void searchData(int rollNo) {
		String query = "select * from student where rollNo = ?";
		try (PreparedStatement preparedstatement = connection.prepareStatement(query);
				) {
			preparedstatement.setInt(1, rollNo);
			try (ResultSet resultSet = preparedstatement.executeQuery()) {
				while(resultSet.next()) {
					String name = resultSet.getString("name");
					int rollnumber = resultSet.getInt("rollNo");
	                int standard = resultSet.getInt("standard");
	                int scienceMark = resultSet.getInt("scienceMark");
	                int mathMark = resultSet.getInt("mathMark");
	                int englishMark = resultSet.getInt("englishMark");
	                System.out.println("Name: " + name +", Roll Number: "+ rollnumber + ", Standard: " + standard + ", Science Mark: " + scienceMark
	                        + ", Math Mark: " + mathMark + ", English Mark: " + englishMark);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void displayAllData() {
		String query = "select * from student";
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query)) {
			while(resultSet.next()) {
				String name = resultSet.getString(1);
				int rollnumber = resultSet.getInt(2);
                int standard = resultSet.getInt(3);
                int scienceMark = resultSet.getInt(4);
                int mathMark = resultSet.getInt(5);
                int englishMark = resultSet.getInt(6);
                System.out.println("Name: " + name +", Roll Number: "+ rollnumber + ", Standard: " + standard + ", Science Mark: " + scienceMark
                        + ", Math Mark: " + mathMark + ", English Mark: " + englishMark);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeConnection() throws SQLException {
		if(connection!=null) {
			connection.close();
		}
	}
	
//	public  void createTable() throws SQLException {
//		String query = "create table Student (name varchar(250), rollNo int, standard int, scienceMark int,mathMark int,englishMark int)";
//		String primaryKey = "alter table student add primary key(rollNo)";
//		try (Statement statement = connection.createStatement()) {
//			DatabaseMetaData metaData = connection.getMetaData();
//			ResultSet resultSet = metaData.getTables(null, null, "Student", null);
//			if(resultSet.next()) {
//				statement.executeUpdate(query);
//	            System.out.println("Table created successfully.");
//	            statement.executeUpdate(primaryKey);
//	            System.out.println("primary key added ");
//			}
//			else {
//				System.out.println("hello");
//			}
//            
//        }
//	}
}
