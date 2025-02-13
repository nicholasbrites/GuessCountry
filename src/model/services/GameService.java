package model.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
		
		System.out.println(Messages.textYellow("\nYou confirmed Daily Challenge. Today is ") + date.format(formatter) + "\n");
		
		return dailyChallenge;
	}
	
	public void topFive(List<Country> answer, Scanner sc) {
		System.out.println(Messages.textYellow("\nThe criterion is POPULATION\n"));
		Country[] guess = new Country[5];
		for(int i = 0 ; i < 5 ; i++) {
			int position;
			try {
				do {System.out.print(Messages.textBlue(answer.get(i).getName() + "'s position: "));
				position = sc.nextInt()-1;;
				if(position >= 0 && position <= 4) {
					if(guess[position] != null) {
						System.out.println(Messages.textYellow("This position is occupied. Try again."));
						i -= 1;
						continue;
					}
				}
				else {
					System.out.println(Messages.textYellow("Invalid position. Try again."));
				}
			}while(position < 0 || position > 4);
			guess[position] = answer.get(i);
			} catch (Exception e) {
				i -= 1;
				System.out.println(Messages.textYellow("Only numbers. Try again."));
				sc.nextLine();
			}
			
		}
		answer.sort((b1, b2) -> -b1.getPopulation().compareTo(b2.getPopulation()));
		
		System.out.println(Messages.textYellow("\nANSWER:"));
		for(int i = 0 ; i < 5 ; i++) {
			if(guess[i].getName().equals(answer.get(i).getName())) {
				System.out.println(Messages.textGreen((i+1) + " - " + guess[i].getName()));
			}
			else {
				System.out.println(Messages.textRed((i+1) + " - " + guess[i].getName() + " | " + answer.get(i).getName()));
			}
		}
		
	}
	
}
