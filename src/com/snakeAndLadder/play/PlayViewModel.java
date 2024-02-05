package com.snakeAndLadder.play;

import java.util.List;
import java.util.Map;

import com.snakeAndLadder.dto.Player;
import com.snakeAndLadder.repository.Repository;

public class PlayViewModel {

	private PlayView playView;

	private Repository repository = Repository.getInstance();
	public PlayViewModel(PlayView playView) {
		this.playView = playView;
	}

	public boolean isGameOver() {
		List<Player> players = repository.getPlayers();
		for (Player player : players) {
            if (player.getPosition() == repository.getWiningPosition()) {
                repository.setWinner(player);
                return true;
            }
        }
        return false;
	}

	public Player getWinner() {
		return repository.getWinner();
	}

	public void Play() {
		int size = repository.getSize();
		Map<Integer, Integer> snakes = repository.getSnakes();
	    Map<Integer, Integer> ladders = repository.getLadders();
		List<Player> players = repository.getPlayers();
		for (Player player : players) {
			int dice,noOfSixes=0;
			do {
				dice = playView.getPosition(player);
				if(dice==6) {
					noOfSixes++;
				}
				int newPosition = player.getPosition()+dice;
//				int newPosition = playView.getPosition(player);
				if(newPosition <= repository.getWiningPosition()) {
					 player.setPosition(newPosition);

	                 if (snakes.containsKey(newPosition)) {
	                     player.setPosition(snakes.get(newPosition));
	                     playView.bited(player.getPosition());
	                 } else if (ladders.containsKey(newPosition)) {
	                     player.setPosition(ladders.get(newPosition));
	                     playView.gotLadder(player.getPosition());
	                 } else {
	                	 playView.currentPosition(player.getPosition());
	                 }
				}else {
					playView.neededSteps((size * size) - player.getPosition());
	            }
			} while (dice == 6&&noOfSixes<=6);
		}
	}
	
}
