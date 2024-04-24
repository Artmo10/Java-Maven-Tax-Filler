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

package com.cestar.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cestar.dao.TaxFilersDao;
import com.cestar.model.TaxFilersModel;

@ManagedBean(name="ctlr")
@SessionScoped

public class TaxFilersController {
	
	TaxFilersDao dao = new TaxFilersDao();
	
	// create a global variable for old id of updated tax filer record
	
	int old_id = 0 ;
	
	// For displaying all Records 
	
	public List<TaxFilersModel> getAllRecs(){
		
		List<TaxFilersModel>  recs = dao.displayRecs();
		
		return recs;
		
		}
	
   // For Inserting New Tax Filer Record and sending the user to display. This method calls the dao insert rec, dao uses the tax filer record object
   // coming from the insert.xhtml page. Basically these are the values you entered on the form. Then it will call the display.xhtml
	
	public String insertTaxRec(TaxFilersModel rec_from_form) {
		
		dao.insertRec(rec_from_form);
		
		return "display";
	}
	
	public String editTaxRec(int id_from_display_page) {
		
		// Assign the id_from_display_page to global variable old_id
		
		old_id = id_from_display_page;
		
		// get the Tax Filer Record using id_from_display_page
		
		TaxFilersModel rec_from_db = dao.getRecById(id_from_display_page);
		
		// We have to add this employee to session map
		
		Map<String , Object>  session_map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		//session_map.put uses a key-value parameter. This is what we use on the edit.xhtml page. That page will then call the updateTaxRec method
		// to commit the changes made to the DB.
		
		session_map.put("rec_to_edit",rec_from_db );
		
		return "edit" ;
	}
	
	
	public String updateTaxRec(TaxFilersModel updated_from_edit_page) {
		
		
		int oldId = old_id ;
		//This calls the dao method updateRecById using the old id and the Tax Filer Record object that came from the edit.xhtml page.
		//Then calls the display.xhtml
		
		dao.updateRecById(oldId, updated_from_edit_page);
		
		return "display" ;
		
	}
	
	public String deleteTaxRec(int id_from_display_page) {
		
		//This calls the dao method deleteById using the id from the display page that corresponds to the id of the Tax Record
		
		dao.deleteById(id_from_display_page);
		
		
		return "display" ;
				
	}
}
	
	