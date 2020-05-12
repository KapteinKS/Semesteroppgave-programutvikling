package org.example.logicAndClasses;

import javafx.concurrent.Task;
import org.example.App;
//  Simple class to handle a second window
public class SecondaryWindowThread extends Task<String> {
    @Override
    protected String call() throws Exception {
        while (App.isWindowShowing()){
        }
        return "";
    }
}
