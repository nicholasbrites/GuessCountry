package application;

import java.util.Random;
import java.util.Scanner;

import model.entities.Country;
import model.lists.CountryList;
import model.services.CountryService;
import model.services.Messages;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Country answer = CountryList.countries().get(new Random().nextInt(CountryList.countries().size()));
		Country guess = null;
		String name;
		
		//System.out.println(answer);
		
		for(int i = 1 ; i <= 6 ; i++) {
			System.out.println(Messages.textBlue("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"));
			
			do {
				System.out.print(Messages.textBlue("||| Enter with a country: "));
				name = sc.nextLine().toUpperCase();
				
				for(Country country : CountryList.countries()) {
					if(country.getName().toUpperCase().equals(name.toUpperCase())) {
						guess = country;
						break;
					}
				}
				if(guess == null) {
					System.out.println(Messages.textBlue("||| ")  + Messages.textYellow("Country not found. Try again."));
				}
			} while (guess == null);
			
			if(name.equals(answer.getName().toUpperCase())) {
				System.out.println(Messages.modelCompare(guess, answer));
				System.out.println(Messages.textGreen("\nYOU WON! \nCongratulations."));
				break;
			}
			else {
				System.out.println(Messages.modelCompare(guess, answer));
				if(i == 6) {
					System.out.println(Messages.textRed("\nYOU LOSE! \n" + answer.getName() + " was the correct answer."));
				}
			}
			guess = null;
			System.out.println("\n");
		}
		

		sc.close();
	}

}
