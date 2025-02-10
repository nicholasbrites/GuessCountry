package model.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Country;
import model.lists.CountryList;

public class GameService {

	public void gamePlay(Country guess, Country answer, Scanner sc) {
		String name;
		for(int i = 1 ; i <= 6 ; i++) {
			System.out.println(Messages.textBlue("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"));
			do {
				System.out.print(Messages.textBlue("||| " + i + "# Enter with a country: "));
				name = sc.nextLine().toUpperCase();
				
				if(name.toUpperCase().equals("FINT")) {
					System.out.println(Messages.textBlue("||| \n||| ") + Messages.textYellow("The country's firts letter: ") + answer.getName().charAt(0));
					System.out.println(Messages.textBlue("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| \n\n"));
					System.out.println(Messages.textBlue("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"));
					i += 1;
					continue;
				}
				
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
	}
	
	public int dailyChallenge() {
		LocalDate date = LocalDate.now();
		int dailyChallenge = Math.abs(date.getDayOfMonth()*2 + date.getDayOfMonth()*2 + date.getMonthValue()*5 - date.getYear() % CountryList.countries().size());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		System.out.println(Messages.textYellow("You confirmed Daily Challenge. Today is ") + date.format(formatter) + "\n");
		
		return dailyChallenge;
	}
	
}
