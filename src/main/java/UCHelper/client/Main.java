/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UCHelper.client;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import UCHelper.adt.*;
import UCHelper.entity.*;

/**
 *
 * @author Marcus Lee, marcustutorial@hotmail.com
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		BinarySearchTree<Club> clubs = new BinarySearchTree<>();
		ClubManager clubManager = new ClubManager(clubs);

//		clubs.add(2);
//		clubs.add(1);
//		clubs.add(3);
//		clubs.add(5);

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
			Date firstDate = sdf.parse("06/24/2017");
			Date secondDate = sdf.parse("06/30/2017");

			Range<Date> range = new Range<>(firstDate, secondDate);
			System.out.println("Start: " + range.start());
			System.out.println("End: " + range.end());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
