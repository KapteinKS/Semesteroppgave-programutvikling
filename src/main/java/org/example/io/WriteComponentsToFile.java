package org.example.io;

import org.example.Deeper.ComponentCollection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WriteComponentsToFile extends Writer{
    String filePath = "";
    public static void saveComponents(ComponentCollection compCol, String filePath){
        try{
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(compCol.);

            //MATS JOBBER LIVET AV SEG HER
        }catch (Exception e){

        }
    }
}