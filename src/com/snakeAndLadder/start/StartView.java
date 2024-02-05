package com.snakeAndLadder.start;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.snakeAndLadder.dto.Player;
import com.snakeAndLadder.leastSteps.LeastStepsView;
import com.snakeAndLadder.play.PlayView;

public class StartView {

	private StartViewModel model;
	public StartView() {
		model = new StartViewModel(this);
	}
	public void start() {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the board (e.g., 10 for a 10x10 board): ");
        int size = scanner.nextInt();

        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for player " + (i + 1) + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }
        model.addPlayer(players);
        
        Map<Integer, Integer> snakes = new HashMap<>();
        System.out.print("Enter the number of snakes: ");
        int numSnakes = scanner.nextInt();
        for (int i = 0; i < numSnakes; i++) {
            System.out.print("Enter the head position of snake " + (i + 1) + ": ");
            int head = scanner.nextInt();
            System.out.print("Enter the tail position of snake " + (i + 1) + ": ");
            int tail = scanner.nextInt();
            snakes.put(head, tail);
        }
        model.addSnakes(snakes);

        Map<Integer, Integer> ladders = new HashMap<>();
        System.out.print("Enter the number of ladders: ");
        int numLadders = scanner.nextInt();
        for (int i = 0; i < numLadders; i++) {
            System.out.print("Enter the bottom position of ladder " + (i + 1) + ": ");
            int bottom = scanner.nextInt();
            System.out.print("Enter the top position of ladder " + (i + 1) + ": ");
            int top = scanner.nextInt();
            ladders.put(bottom, top);
        }
        model.addLadders(ladders);
        model.initializeBoard(size,snakes,ladders);
        System.out.println("chooce \n1. to Play\n2. to find least no of steps needed to complete");
        switch (scanner.nextInt()){
		case 1 ->{
	        new PlayView().play();
			
		}
		case 2 ->{
			new LeastStepsView().findLeasteps();
		}
		default ->{
			System.out.println("Input Mismatch");
		}
        }
	}
}
