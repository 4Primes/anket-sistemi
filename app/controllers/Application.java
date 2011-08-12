package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller{	
	

    public static void index() {

    	ArrayList arrayList = new ArrayList();

    	for (int i = 0; i < 81 ; i++)
    	{
    		
    	ArrayList l2 = new ArrayList(); 

    	l2.add(Vote.count("category=? and location=?", "AKP",String.valueOf(i)));
    	l2.add(Vote.count("category=? and location=?", "CHP",String.valueOf(i))) ;
    	l2.add(Vote.count("category=? and location=?", "MHP",String.valueOf(i))) ;
    	l2.add(Vote.count("category=? and location=?", "Diger",String.valueOf(i)));
    	arrayList.add(l2);
    	}
           
     // List<Object[]> votes = Vote.find("select location, category, count(*) from Vote group by location, category order by location, category")
       //         .fetch();
        //String location = null;
        //for (Object[] vote : votes) {
          //  if (!vote[0].equals(location)) {
            //    location = (String) vote[0];
              //  System.out.println("*********************************************");
          //  }
           // System.out.println(vote[0] + "=> " + vote[1] + ": " + vote[2]);
       // }
     
        render();
    }
    
    public static void yonetim() {
    	render();
    }
    
    public static void getVote2() {
    	ArrayList<ArrayList<Long>> lists = new ArrayList<ArrayList<Long>>();
    	ArrayList<Long> liste;
    	for(int i=0;i<82;i++){
    	liste =new ArrayList<Long>();
    	liste.add(Vote.count("category=? and location=?", "AKP",i+""));
    	liste.add(Vote.count("category=? and location=?", "CHP",i+"")) ;
    	liste.add(Vote.count("category=? and location=?", "MHP",i+"")) ;
    	liste.add(Vote.count("category=? and location=?", "Diger",i+""));
    	lists.add(liste);
    	}
    	renderJSON(lists);
    }

    public static void getVote(String il) {
    	ArrayList<Long> liste;
    	liste =new ArrayList<Long>();
    	liste.add(Vote.count("category=? and location=?", "AKP",il));
    	liste.add(Vote.count("category=? and location=?", "CHP",il)) ;
    	liste.add(Vote.count("category=? and location=?", "MHP",il)) ;
    	liste.add(Vote.count("category=? and location=?", "Diger",il));
    	renderJSON(liste);
    }  
    
    
}