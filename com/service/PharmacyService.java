package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.Pharmacy_distributor;
import com.util.DBConnection;

public class PharmacyService {
	Connection con=null;

	public PharmacyService() {
		
	}
	public ArrayList<Pharmacy_distributor> getAllRecords(){
		ArrayList<Pharmacy_distributor> list=new ArrayList<>();
		Statement stmt=null;
		try{
			
			//To get all Records
			con=DBConnection.getConnection();
			 stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from distributordetails");
			//Add all Records in ArrayList		
							
			while(rs.next()) {
				
				list.add(new Pharmacy_distributor(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
				
				
						
			}
			con.close();
			
			}
			catch(Exception e){
				e.printStackTrace();
			}	
			
			
		return list;
	}
		
	//Insert Record in Table
			public int insertRecord(Pharmacy_distributor distributor){
				int result=0;
				try{
					con=DBConnection.getConnection();
					
					
					
					//To insert records 
					PreparedStatement ps=con.prepareStatement("insert into distributorDetails(D_id, D_name,int ph_no,int item_no) values(?,?,?,?)");
					ps.setInt(1,distributor.getD_id());
					ps.setString(2,distributor.getD_name());
					ps.setInt(3,distributor.getPh_no());
					ps.setInt(4,distributor.getItem_no());
					result=ps.executeUpdate();
					con.close();
					}
					catch(Exception e){
						e.printStackTrace();
					}
				return result;
			
			}
			public int deleteRecord(int rollno){
				int result=0;
				try{
					con=DBConnection.getConnection();
					
					PreparedStatement ps=con.prepareStatement("delete from distributordetails where rollno=?");
					
					ps.setInt(1,rollno);
					
					result=ps.executeUpdate();
				con.close();	
				}
				
					catch(Exception e){
						e.printStackTrace();
					}
				return result;
			}
			
			public int updateRecord(Pharmacy_distributor distributor){
				int result=0;
				try{
					con=DBConnection.getConnection();
	//To insert records 
					PreparedStatement ps=con.prepareStatement("update distributorDetails set D_name=?,ph_no=?,item_no=? where D_id=?");
					ps.setInt(4,distributor.getD_id());
					ps.setString(1,distributor.getD_name());
					ps.setInt(2,distributor.getPh_no());
					ps.setInt(4,distributor.getItem_no());
					result=ps.executeUpdate();
					con.close();
					
					}
					catch(Exception e){
						e.printStackTrace();
					}
			
				return result;
			}
			public Pharmacy_distributor getPharmacy_distributorByDid(int D_id){
				Pharmacy_distributor distributor=null;
				try{
					con=DBConnection.getConnection();
					PreparedStatement ps=con.prepareStatement("Select * from distributordetails where D_id=?");
					ps.setInt(1, D_id);
					ResultSet rs=ps.executeQuery();
					if(rs.next())
						distributor=new Pharmacy_distributor(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
					
					con.close();
					}
					catch(Exception e){
						e.printStackTrace();
					}
				return distributor;
			}

	

}
