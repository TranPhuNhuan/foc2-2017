package foc2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class SQLiteDB {
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

	static void getAllProducts() {
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
	 public Vector<String> getCategories(){
		 String sql = "SELECT * FROM categories";
		 Vector<String> categoryList = new Vector();
		 try(Connection conn = connect();
				 Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					Category cat = new Category();
					cat.setCategoryID(rs.getInt("categoryid"));
					cat.setCategoryName(rs.getString(categoryname));
					
				}
				return categoryList;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		 return null;
	 }
}
