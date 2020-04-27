package org.example.logicAndClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.example.componentClasses.Component;

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