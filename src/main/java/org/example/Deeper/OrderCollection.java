package org.example.Deeper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.util.List;

public class OrderCollection {

	private ObservableList<Order> orders = FXCollections.observableArrayList();

	public List<Order> getOrders(){
		return orders;
	}
	public void addOrder(Order o){
		orders.add(o);
	}
	public void removeAll(){
		orders.clear();
	}
	@Override
	public String toString(){
		//THIS MUST RETURN CSV!!
		return "Hei! Dette er OrderCollection sin toString! =) Dette må egentlig være en samling av CSVdata";
	}
}
