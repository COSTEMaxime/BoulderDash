package controller;

import view.IOrderPerformer;

public interface IController {

	void play() throws InterruptedException;
	
	IOrderPerformer getOrderPerformer();
}
