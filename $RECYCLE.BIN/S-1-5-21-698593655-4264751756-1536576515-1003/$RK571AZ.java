package da;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import dataobject.UnitOfMeasure;

public class UnitOfMeasureDA extends WHConnection{
	
	public Vector<UnitOfMeasure> getAllUnitofmeasure(){
		String sql = "SELECT * FROM unitofmeasure";
		Vector<UnitOfMeasure> unitofmeasureList = new Vector<>();
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				
				UnitOfMeasure uni = new UnitOfMeasure(rs.getInt("id"), rs.getString("unitname"));
				unitofmeasureList.add(uni);
				
				
			}
			return unitofmeasureList;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}

}
