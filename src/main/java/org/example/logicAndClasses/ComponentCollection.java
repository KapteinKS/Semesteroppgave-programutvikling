package org.example.logicAndClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.example.componentClasses.Component;

import java.util.List;
import java.util.stream.Collectors;

public class ComponentCollection {

	private static ObservableList<Component> componentList = FXCollections.observableArrayList();

	public void add (Component component){
		componentList.add(component);
	}

	public ObservableList<Component> getComponentList(){
		return componentList;
	}

	public void attachTableView(TableView tv){
		tv.setItems(componentList);
	}

	public static ObservableList<Component> filter(String choiceBoxValue, String filterInput){
		List<Component> filteredList;
		switch (choiceBoxValue){
			case "Produsent": {
				filteredList = componentList.parallelStream().filter(p -> (p.getManufacturer().startsWith(filterInput)))
						.collect(Collectors.toCollection(FXCollections::observableArrayList));
				return (ObservableList<Component>) filteredList;
			}
			case "Navn": {
				filteredList = componentList.parallelStream().filter(p -> (p.getName().startsWith(filterInput)))
						.collect(Collectors.toCollection(FXCollections::observableArrayList));
				return (ObservableList<Component>) filteredList;
			}
			case "Høyeste Pris": {
				filteredList = componentList.parallelStream()
						.filter(p -> ((p.getPrice() <= Double.parseDouble(filterInput))))
						.collect(Collectors.toCollection(FXCollections::observableArrayList));
				return (ObservableList<Component>) filteredList;
			}
			case "Type": {
				filteredList = componentList.parallelStream().filter(p -> (p.getType().toLowerCase().startsWith(filterInput.toLowerCase())))
						.collect(Collectors.toCollection(FXCollections::observableArrayList));
				return (ObservableList<Component>) filteredList;
			}
			default:
				return componentList;
		}

	}
}
