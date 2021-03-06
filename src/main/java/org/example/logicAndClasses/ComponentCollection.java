package org.example.logicAndClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.example.componentClasses.Cabinet;
import org.example.componentClasses.Component;
import org.example.componentClasses.GraphicCard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//  Collection class for components
public class ComponentCollection {
	private static ObservableList<Component> componentList = FXCollections.observableArrayList();

	public void add(Component component){
		componentList.add(component);
	}
	//  Using this method, we can use a components 'display-string' to fetch a component.
	public <T extends Component> T getComponentByDisplayString(String componentDisplayString) {
		//  Create a dummy GraphicCard (never actually returned)
		T e = (T) new GraphicCard("ERROR","Error",00,00,0,"error",0);
		for (Component c : componentList) {
			if (componentDisplayString.equals(c.displayComponent())) {
				e = (T) c;
				break;
			}
		}
		return e;
	}

	public ObservableList<Component> getArrayList(){
		return componentList;
	}

	public ObservableList<Component> getComponentList(){
		return componentList;
	}

	public void attachTableView(TableView tv){
		tv.setItems(componentList);
	}

	public void remove(Component c){
		componentList.remove(c);
	}

	public void removeAll(){
		componentList.clear();
	}
	//  Filter methods
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
	//  Method to get a list of components of a certain given type
	public ObservableList<Component> getComponentByType(String type){
		try {
			return componentList.stream().
					filter(cmp -> cmp.getClass().getSimpleName().equals(type)).
					collect(Collectors.toCollection(FXCollections::observableArrayList));
		} catch (Exception e){
			e.getMessage();
			return componentList;
		}
	}
}