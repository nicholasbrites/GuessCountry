package application;

import model.entities.Country;
import model.enums.Color;
import model.enums.Continent;
import model.lists.CountryList;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("Countries amount: " + CountryList.countries().size());
		
		/*
		CountryList cl = new CountryList();
		
		Scanner sc = new Scanner(System.in);
		
		Random rd = new Random();
		int num = rd.nextInt(10);
		
		for(int i = 1 ; i <= 5 ; i++) {
			System.out.print("Enter with a country: ");
			String answer = sc.next();
			
			if(answer.equals(cl.countries().get(num).getName())) {
				System.out.println("That's correct!");
				i = 10;
			}
			else {
				System.out.println("Incorrect.");
			}
			System.out.println();
		}

		sc.close();
		*/
	}

}
