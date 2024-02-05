package com.snakeAndLadder.play;

import java.util.Scanner;

import com.snakeAndLadder.dto.Player;

public class PlayView {

	private PlayViewModel model;
	private Scanner sc = new Scanner(System.in);
	public PlayView() {
		model = new PlayViewModel(this);
	}
	public void play() {
		while (!isGameOver()) {
			model.Play();
		}
		System.out.println(model.getWinner().getName()+" wins!");
	}
	private boolean isGameOver() {
		return model.isGameOver();
	}
	public int getPosition(Player player) {
		System.out.println("*************************************************************************");
		System.out.println("It's " + player.getName() + "'s turn.");
        System.out.print("Press Enter to roll the dice...");
        sc.nextLine();

        int diceRoll = (int) (Math.random() * 6) + 1;
        System.out.println("You rolled a " + diceRoll);

        return diceRoll;
	}
	public void neededSteps(int i) {
		System.out.println("You need " + i + " to win.");
		
	}
	public void currentPosition(int position) {
		System.out.println("You are now at position " + position);
		
	}
	public void gotLadder(int position) {
		System.out.println("Hurray! You landed on a ladder. Move forward to position " + position);
	}
	public void bited(int position) {
		System.out.println("Oops! You landed on a snake. Go back to position " + position);
	}
}
