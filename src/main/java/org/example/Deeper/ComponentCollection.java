package org.example.Deeper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.example.components.Component;

public class ComponentCollection {

	private ObservableList<Component> componentList = FXCollections.observableArrayList();

	public void add (Component component){
		componentList.add(component);
	}

	public ObservableList<Component> getComponentList(){
		return componentList;
	}

	public void attachTableView(TableView tv){
		tv.setItems(componentList);
	}


}