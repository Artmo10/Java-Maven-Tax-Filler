/*
Authors: SUPR-S GROUP
		Sergio Morales Veliz		C0850889
		Uma Adhikari				C0851787
		Prajnana Kumar Taraphdar	C0852961
		Rezil Mae Sumarinas			C0848587
		Santiago Devia Valderrama	C0850607
		
Title	: CSD_4464_3_Group_Project
Date	: April 18, 2023		
*/

package com.cestar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cestar.model.TaxFilersModel;

public class TaxFilersDao {
		// Write a method for Connection to database
		// This method has a return type of Connection

		public Connection getConnection() {

			Connection con = null;

			String user = "root";

			String pwd = "";

			String url = "jdbc:mysql://127.0.0.1/filersRecord";

			// Load the Driver

			try {

				Class.forName("com.mysql.jdbc.Driver");

				con = DriverManager.getConnection(url, user, pwd);

				System.out.println("Connection To Database Successfull");

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;

		}
		
		//This will display all the Tax Filers Record
		public List<TaxFilersModel> displayRecs() {

			List<TaxFilersModel> recs = new ArrayList<>();

			Connection con = getConnection();

			String sql = "select * from taxfilers";

			try {

				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {

					TaxFilersModel rec = new TaxFilersModel(rs.getInt("filerID"), rs.getString("name"), rs.getString("contact"),
							rs.getFloat("annualIncome"), rs.getFloat("expenses"), rs.getInt("taxYear"), rs.getDate("dateFiled"));

					recs.add(rec);

				}

				System.out.println(recs);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return recs;

		}
		
		// This method will insert a new Tax Filer record into the database.
		public int insertRec(TaxFilersModel rec_tob_inserted) {
			
			int status = 0 ;
			
			Connection con = getConnection();
			
			String sql = "insert INTO taxfilers (filerID, name, contact, annualIncome, expenses, taxYear, dateFiled) VALUES (?,?,?,?,?,?,?)";
		
			try {
				
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1,rec_tob_inserted.getFilerID());
				
				pstmt.setString(2, rec_tob_inserted.getName());
				
				pstmt.setString(3, rec_tob_inserted.getContact());
				
				pstmt.setFloat(4, rec_tob_inserted.getAnnualIncome());
				
				pstmt.setFloat(5, rec_tob_inserted.getExpenses());
				
				pstmt.setInt(6, rec_tob_inserted.getTaxYear());
				
				//On our model class we use the Date.util whereas SQL uses Date.sql and our xhtml uses String. So we need the conversion.
				// First on the insert and edit xhtml pages we convert using convertDateTime. We then use this to create a new sql.date object
				// And use that to set the date which will then be written on the DB.
				
				java.sql.Date date = new java.sql.Date(rec_tob_inserted.getDateFiled().getTime());
				
				pstmt.setDate(7, date);
				
				status = pstmt.executeUpdate();
				
				if(status>0) {
					
					System.out.println("New Tax Filer Record Addedd Successfully!!!");
					displayRecs();
				}
				else {
					
					System.out.println("An Error Occured. Please try again. If error persists contact your administration!!!");
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;
				
		}
				
		// This method will get the record by Id.
		public TaxFilersModel getRecById(int id_to_getRec) {
			
			TaxFilersModel rec = null ;
			
			Connection con = getConnection();
			
			String sql = "select * from taxfilers where filerID = ?";
			
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
			
				pstmt.setInt(1, id_to_getRec);
			    
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					 rec = new TaxFilersModel(rs.getInt(1), rs.getString(2), rs.getString(3),
								rs.getFloat(4), rs.getFloat(5), rs.getInt(6), rs.getDate(7));
				}
				
				System.out.println(rec);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rec;
			
		}
		
		//This method will delete the particular tax filer record.
		public void deleteById(int id_to_del_rec) {
			
			Connection con = getConnection();
			
			String sql = "delete from taxfilers where filerID = ?";
			
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
			
			    pstmt.setInt(1, id_to_del_rec);
			    
			    int status = pstmt.executeUpdate();
			    
			    if(status>0) {
			    	
			    	System.out.println("Record Deleted!!!");
			    }
			
			    else {
			    	
			    	System.out.println("Try Again Please!!!");
			    }
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		// Same with the insert rec, we used the conversion here for the date. This method is being called once the user edit a specific record.
		public void updateRecById(int curr_id , TaxFilersModel updated_rec) {
			
		Connection con = getConnection();
		
		String sql = "update taxfilers set filerID=?,name=?,contact=?,annualIncome=?,expenses=?,taxYear=?,dateFiled=? where filerID=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
		
			pstmt.setInt(1,updated_rec.getFilerID());
			
			pstmt.setString(2, updated_rec.getName());
			
			pstmt.setString(3, updated_rec.getContact());
			
			pstmt.setFloat(4, updated_rec.getAnnualIncome());
			
			pstmt.setFloat(5, updated_rec.getExpenses());
			
			pstmt.setInt(6, updated_rec.getTaxYear());
			
			java.sql.Date date = new java.sql.Date(updated_rec.getDateFiled().getTime());
			
			pstmt.setDate(7, date);
			
			//pstmt.setDate(7, updated_rec.getDateFiled());
		
			pstmt.setInt(8, curr_id);
		
		    int status = pstmt.executeUpdate();
		    
		    if(status>0) {
		    	
		    	System.out.println("Record Updated!!!");
		    }
		    else {
		    	
		    	System.out.println("Try Again Please!!!");
		    }		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		}
		
	}