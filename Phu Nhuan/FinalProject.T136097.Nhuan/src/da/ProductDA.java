package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDA extends WHConnection{
	
	public void getAllProducts(){
		String sql = "SELECT * FROM products";
		
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				
				System.out.format("%3d %-40s %6.2f %4d \n", 
						rs.getInt("productid"),
						rs.getString("productname"),
						rs.getDouble("unitprice"),
						rs.getInt("unitinstock"));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public void insert (String pCode, String pName, int categoryid, int brandid, int unitid, double unitprice, String description){
		String sql = "INSERT INTO products(productcode, productname, categoryid, brandid, unitofmeasure,)"
				+ "VALUES(?,?,?,?,?,?,?)";
		
		try (Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, pCode);
			pstmt.setString(2, pName);
			pstmt.setInt(3, categoryid);
			pstmt.setInt(4, brandid);
			pstmt.setInt(5, unitid);
			pstmt.setDouble(6, unitprice);
			pstmt.setString(7, description);
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
