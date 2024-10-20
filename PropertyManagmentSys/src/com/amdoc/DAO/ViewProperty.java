package com.amdoc.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewProperty {

	public void viewProperty(Connection con) {
		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PropInfo");

			System.out.printf("%-5s %-20s %-15s %-10s %-20s %-20s%n", "ID", "Name", "Area", "Price", "Owner Name",
					"Buyer Name");

			while (rs.next()) {
				int id = rs.getInt("Pid");
				String name = rs.getString("PName");
				String area = rs.getString("PArea");
				Float price = rs.getFloat("Price");
				String owner = rs.getString("OwnerName");
				String buyer = rs.getString("BuyerName");

				System.out.printf("%-5d %-20s %-15s %-10.2f %-20s %-20s%n", id, name, area, price, owner, buyer);
			}
			System.out.println("\n");

		} catch (Exception e) {
			System.out.println("SQL exception occured" + e);
		}
	}

}
