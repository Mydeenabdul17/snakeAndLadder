package com.snakeAndLadder.leastSteps;

public class LeastStepsView {

	private LeastStepsViewModel leastStepsViewModel;
	public LeastStepsView() {
		leastStepsViewModel = new LeastStepsViewModel(this);
	}
	public void findLeasteps() {
		int minSteps = leastStepsViewModel.leastSteps();
		System.out.println("The least Steps required to win : "+minSteps);
	}
}
