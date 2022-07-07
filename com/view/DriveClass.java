package com.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.controller.PharmacyController;
import com.model.Pharmacy_distributor;

public class DriveClass {
	public static void main(String[] args) throws Exception{
		String cont;
		do{
		System.out.println("***********************Distributor Details**********************");
		System.out.println(" 1. Add Record");
		System.out.println("2. Update Record");
		System.out.println("3. Delete Record");
		System.out.println("4. View Records");
		System.out.println("5. View a Record");
		System.out.println("************************************************************************");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice");
		int choice =sc.nextInt();
		PharmacyController distributorctrl=new PharmacyController();
		Pharmacy_distributor distributor;
		int D_id;
		String D_name;
		int ph_no;
		int item_no;
		int result;
		switch(choice){
		case 1: 
			System.out.println("Enter D_id, D_name, ph_no,item_no");
			D_id=sc.nextInt();sc.nextLine();
			D_name=sc.nextLine();
			ph_no=sc.nextInt();
			item_no=sc.nextInt();
			distributor=new Pharmacy_distributor(D_id, D_name, ph_no,item_no);
			 result=distributorctrl.insertRecord(distributor);
			if(result>0)
				System.out.println("Record Inserted");
			else
				System.out.println("Record not inserted");
			break;
		case 2:
			System.out.println("Enter D_id, D_name, ph_no,item_no");
			D_id=sc.nextInt();sc.nextLine();
			D_name=sc.nextLine();
			ph_no=sc.nextInt();
			item_no=sc.nextInt();
			distributor=new Pharmacy_distributor(D_id, D_name, ph_no,item_no);
			
			result=distributorctrl.updateRecord(distributor);
			if(result>0)
				System.out.println("Record Updated");
			else
				System.out.println("Record not Updated");
			break;
		case 3:
			System.out.println("Enter D_id");
			D_id=sc.nextInt();
			result=distributorctrl.deleteRecord(D_id);
				if(result>0)
					System.out.println("Record Deleted");
				else
					System.out.println("Record not Deleted");
			break;
		case 4:
			ArrayList<Pharmacy_distributor> list=distributorctrl.getAllRecords();
			if(list==null)
				System.out.println("No Record found");
			else{
			for(Pharmacy_distributor dist : list){
				System.out.println(dist.getD_id()+"\t"+dist.getD_name()+" "+dist.getPh_no()+" "+dist.getItem_no());
			}
			}
			break;
		case 5:
		
			System.out.println("Enter D_id");
			D_id=sc.nextInt();
			distributor=distributorctrl.getPharmacy_distributorByDid( D_id);
			if(distributor==null)
				System.out.println("Record not found");
			else{
					System.out.println("D_id="+distributor.getD_id());
					System.out.println("D_name="+distributor.getD_name());
					System.out.println("ph_no="+distributor.getPh_no());
					System.out.println("item_no="+distributor.getItem_no());
					
				}
			break;
		default: System.out.println("Wrong option");
		}
		System.out.println("Want to perform next operation? ");
		 cont=sc.next();
		}while(cont.equalsIgnoreCase("y"));
	}


}
