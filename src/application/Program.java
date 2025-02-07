package application;

import java.util.Random;
import java.util.Scanner;

import model.entities.Country;
import model.lists.CountryList;

public class Program {
	
	public static String comparePib(Country guess, Country answer){
		if(guess.getPib() > answer.getPib()) {
			return "\033[31mPIB is lower!\033[0m";
		}
		else {
			if(guess.getPib() < answer.getPib()) {
				return "\033[31mPIB is higher!\033[0m";
			}
			else {
				return "\033[32mPIB is correct!\033[0m";
			}
		}
	}

	public static void main(String[] args) {
		
		System.out.println("Countries amount: " + CountryList.countries().size());
		
		Scanner sc = new Scanner(System.in);
		
		Country answer = CountryList.countries().get(new Random().nextInt(CountryList.countries().size()));
		Country guess = null;
		
		System.out.println(answer);
		
		for(int i = 1 ; i <= 5 ; i++) {
			System.out.print("Enter with a country: ");
			String name = sc.next().toUpperCase();
			
			for(Country country : CountryList.countries()) {
				if(country.getName().toUpperCase().equals(name.toUpperCase())) {
					guess = country;
					break;
				}
			}
			
			if(guess == null) {
				System.out.println("Country not found. Try again.");
				continue;
			}
			
			if(name.equals(answer.getName().toUpperCase())) {
				System.out.println("\033[32mThat's correct!\033[0m");
				System.out.println(comparePib(guess, answer));
				break;
			}
			else {
				System.out.println("\033[31mIncorrect.\033[0m");
				System.out.println(comparePib(guess, answer));
			}
			System.out.println();
		}

		sc.close();
	}

}
