package com.snakeAndLadder.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.snakeAndLadder.dto.Player;

public class Repository {

	private static Repository repository;
	private int[][] board;
    private int size;
    private Player winner;
    private List<Player> players;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;
	private Repository() {
		
	}
	public static Repository getInstance() {
		if(repository==null) {
			repository = new Repository();
		}
		return repository;
	}
	public void addPlayer(List<Player> players) {
		this.players = players;
	}
	public void setSnakes(Map<Integer, Integer> snakes) {
//		System.out.println(snakes);
		this.snakes = snakes;
		
	}
	public void setLadders(Map<Integer, Integer> ladders) {
//		System.out.println(ladders);
		this.ladders = ladders;
		
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public int getWiningPosition() {
		return board.length*board.length;
	}
	public void setWinner(Player player) {
		winner = player;
	}
	public Player getWinner() {
		return winner;
	}
	public int getSize() {
		return board.length;
	}
	public int[][] getBoard() {
//		for (int[] is : board) {
//			System.out.println(Arrays.toString(is));
//		}
		return board;
	}
	public Map<Integer, Integer> getSnakes() {
		return snakes;
	}
	public Map<Integer, Integer> getLadders() {
		return ladders;
	}
}
