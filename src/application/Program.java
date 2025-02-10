package application;

import java.util.Random;
import java.util.Scanner;

import model.lists.CountryList;
import model.services.GameService;
import model.services.Messages;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		GameService gs = new GameService();
		
		System.out.println(Messages.textBlue("Welcome to 'Guess Coutry Game'!! \ngame by: Nicholas Brites, 2025 \n"));
		System.out.println(Messages.textBlue("Do you want play? \n")
				+ Messages.textYellow("1") + " - Random round\n"
				+ Messages.textYellow("2") + " - Daily challenge\n");
		
		int num = 0;
		do {
			try {
				System.out.print(Messages.textBlue("Enter with a number: "));
				num = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				sc.nextLine();
			}
		} while(num != 1 && num != 2);
		
		if(num == 1) {
			System.out.println();
			gs.gamePlay(null, CountryList.countries().get(new Random().nextInt(CountryList.countries().size())), sc);
		}
		else {
			gs.gamePlay(null, CountryList.countries().get(gs.dailyChallenge()), sc);
		}
		
		sc.close();
	}

}
