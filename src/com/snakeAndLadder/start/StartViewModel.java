package com.snakeAndLadder.start;

import java.util.List;
import java.util.Map;

import com.snakeAndLadder.dto.Player;
import com.snakeAndLadder.repository.Repository;

public class StartViewModel {

	private StartView startView;
	private Repository repository = Repository.getInstance();
	public StartViewModel(StartView startView) {
		this.startView=startView;
	}
	public void addPlayer(List<Player> players) {
		repository.addPlayer(players);
	}
	public void addSnakes(Map<Integer, Integer> snakes) {
		repository.setSnakes(snakes);
		
	}
	public void addLadders(Map<Integer, Integer> ladders) {
		repository.setLadders(ladders);
		
	}
	public void initializeBoard(int size, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
		int[][]board = new int[size][size];
		int k=1;
		for(int i=size-1;i>=0;i--) {
			if(i%2==0) {
				for(int j=0;j<size;j++) {
					board[i][j]=k;
					k++;
				}
			}else {
				for(int j=size-1;j>=0;j--) {
					board[i][j]=k;
					k++;
				}
			}
		}
		repository.setBoard(board);
	}

	
}
