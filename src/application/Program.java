package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import model.entities.Country;
import model.lists.CountryList;
import model.services.GameService;
import model.services.Messages;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		GameService gs = new GameService();
		
		System.out.println(Messages.textBlue("\n====================================\n Welcome to 'Guess Country Game'!!"
				+ "\n  Game by: Nicholas Brites, 2025 \n====================================\n"));
		System.out.println(Messages.textBlue("Do you want play? \n")
				+ Messages.textYellow("1") + " - Daily Challenge\n"
				+ Messages.textYellow("2") + " - Random Round\n"
				+ Messages.textYellow("3") + " - Guess Top 5\n");
		
		int num = 0;
		do {
			try {
				System.out.print(Messages.textYellow("Enter with a number: "));
				num = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				sc.nextLine();
			}
		} while(num < 1 || num > 3);
		
		if(num == 2) {
			System.out.println();
			gs.gamePlay(null, CountryList.countries().get(new Random().nextInt(CountryList.countries().size())), sc);
		}
		if(num == 1) {
			gs.gamePlay(null, CountryList.countries().get(gs.dailyChallenge()), sc);
		}
		if(num == 3) {
			List<Country> answer = new ArrayList<>();
			for(int i = 0 ; i < 5 ; i++) {
				int random = new Random().nextInt(CountryList.countries().size());
				answer.add(CountryList.countries().get(random));
			}
			gs.topFive(answer, sc);
		}
		
		System.out.print("\nThanks for playing! Press 'Enter' for end.");
		String finish = sc.nextLine() + "a";
		
		sc.close();
	}

}
