package com.controller;

import java.util.ArrayList;

import com.model.Pharmacy_distributor;
import com.service.PharmacyService;

public class PharmacyController {
	PharmacyService distService=new PharmacyService();
	public ArrayList<Pharmacy_distributor> getAllRecords(){
		ArrayList<Pharmacy_distributor> list=new ArrayList<>();
		list=distService.getAllRecords();
		return list;
		}
		//Insert Record in Table
		public int insertRecord(Pharmacy_distributor distributor){
			int result=0;
			result=distService.insertRecord(distributor);
			return result;
		
		}
		public int deleteRecord(int D_id){
			int result=0;
			result=distService.deleteRecord(D_id);
			return result;
		}
		
		public int updateRecord(Pharmacy_distributor distributor){
			int result=0;
			result=distService.updateRecord(distributor);
			return result;
		}
		public Pharmacy_distributor getPharmacy_distributorByDid(int D_id){
			Pharmacy_distributor distributor=null;
			distributor=distService.getPharmacy_distributorByDid(D_id);
			return distributor;
		}



}
