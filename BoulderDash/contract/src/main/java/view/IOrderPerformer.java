package view;

import java.io.IOException;

import model.UserOrder;

public interface IOrderPerformer {
	
	void orderPerform(UserOrder userOrder) throws IOException;
}
