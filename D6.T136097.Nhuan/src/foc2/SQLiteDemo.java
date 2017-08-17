package foc2;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 */

/**
 * @author US
 *
 */
public class SQLiteDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insert("TV", 8, 2, 5);
		update("TV", 8, 5, 6, 78);
		delete(71);
		getAllProducts();
	}

	private static Connection connect() {
		String url = "jdbc:sqlite:sales.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	private static void getAllProducts() {
		String sql = "SELECT * FROM products";
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				// System.out.println(rs.getInt("productid")+ "\t" +
				// rs.getString("productname")+ "\t" +
				// rs.getDouble("unitprice"));
				System.out.format("%3d %-40s %7.2f %4d\n",
						rs.getInt("productid"), rs.getString("productname"), rs.getDouble("unitprice"),
						rs.getInt("unitinstock"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	 public static void insert(String name,int categoryid, double pPrice, int
	 pUnitInStock){
	 String sql = "INSERT INTO products(productname, categoryid, unitprice, unitinstock)" + "VALUES(?,?,?,?,?)";
	 try(Connection conn = connect();
	 PreparedStatement pstmt = conn.prepareStatement(sql)){
	 pstmt.setString(1, name);
	 pstmt.setInt(2, categoryid);
	 pstmt.setDouble(3, pPrice);
	 pstmt.setInt(4, pUnitInStock);
	 pstmt.executeUpdate();
	 }catch(SQLException e){
		 System.out.println(e.getMessage());
	 }
	 }
	 
	 public static void update(String name,int categoryid, double pPrice, int
			 pUnitInStock, int productid){
			 String sql = "UPDATE products set productname = ?, categoryid = ?, unitprice = ?, unitinstock = ?"
					 + "WHERE(productid = ?)";
			 try(Connection conn = connect();
			 PreparedStatement pstmt = conn.prepareStatement(sql)){
			 pstmt.setString(1, name);
			 pstmt.setInt(2, categoryid);
			 pstmt.setDouble(3, pPrice);
			 pstmt.setInt(4, pUnitInStock);
			 pstmt.setInt(5, productid);
			 pstmt.executeUpdate();
			 }catch(SQLException e){
				 System.out.println(e.getMessage());
			 }
			 }
	 public static void delete(int productid){
			 String sql = "DELETE FROM products WHERE productid = ?" ;
			 try(Connection conn = connect();
			 PreparedStatement pstmt = conn.prepareStatement(sql)){
			 pstmt.setInt(1, productid);
			 pstmt.executeUpdate();
			 }catch(SQLException e){
				 System.out.println(e.getMessage());
			 }
			 }
	 
}
