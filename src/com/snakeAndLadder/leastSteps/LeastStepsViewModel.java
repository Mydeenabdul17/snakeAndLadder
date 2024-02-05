package com.snakeAndLadder.leastSteps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.snakeAndLadder.repository.Repository;

public class LeastStepsViewModel {

	private LeastStepsView leastStepsView;

	private Repository repository = Repository.getInstance();
	public LeastStepsViewModel(LeastStepsView leastStepsView) {
		this.leastStepsView = leastStepsView;
	}
	public int leastSteps() {
		Map<Integer, Integer> snakes = repository.getSnakes();
	    Map<Integer, Integer> ladders = repository.getLadders();
	    int target = repository.getWiningPosition();
	    Queue<List<Integer>> steps = new LinkedList<>();
	    for(int i=1;i<=6;i++) {
	    	List<Integer> l = new ArrayList<>();
	    	l.add(i);
	    	steps.offer(l);
	    }
	    while(steps.size()!=0) {
	    	List<Integer> temp = steps.poll();
	    	int lastPosition = temp.get(temp.size()-1);
	    	if(lastPosition==target) {
	    		System.out.println(temp);
	    		return temp.size();
	    	}
	    	if(ladders.containsKey(lastPosition)) {
	    		List<Integer> l = new ArrayList<>(temp);
    			l.add(ladders.get(lastPosition));
    			steps.offer(l);
	    	}else if(snakes.containsKey(lastPosition)) {
	    		List<Integer> l = new ArrayList<>(temp);
    			l.add(snakes.get(lastPosition));
    			steps.offer(l);
	    	}else {
	    		for(int i=1;i<=6;i++) {
		    		if(lastPosition+i<=target) {
		    			List<Integer> l = new ArrayList<>(temp);
		    			l.add(lastPosition+i);
		    			steps.offer(l);
		    		}
		    	}
	    	}
	    	
	    }
		return 0;
	}
	
}
