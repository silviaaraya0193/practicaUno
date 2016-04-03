/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Archivos;

import Modelo.MyException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import flexjson.JSONSerializer;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Silvia Araya J
 */
public class Escritor {
    private FileWriter writer;
    
    private void writeThrows(String fileP, String text) throws MyException, IOException{
        File file = new File(fileP);
        if(!file.exists()){
            file.createNewFile();
        } 
        writer = new FileWriter(file);
        writer.write(text);
        writer.flush();
    }
    
    public void writeFile(String fileP, String text) throws IOException{
        try {
            writeThrows(fileP, text);
        } catch (MyException ex) {
            Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try{
                writer.close();
            }
        catch (IOException ex) {
            Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
//    public void withObjFileJson(String fileP, Object obj){
//       //http://flexjson.sourceforge.net/#Serialization
//        JSONSerializer serializer = new JSONSerializer();
//        writeFile(fileP, serializer.serialize(obj));
//    }
     public void with_obj_in_file_xml(String filepath, Object obj){
        // https://docs.oracle.com/javase/7/docs/api/java/beans/XMLEncoder.html
        XMLEncoder e;
        try {
            e = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream(filepath)));
            e.writeObject(obj);
            e.close();
        } catch (FileNotFoundException ex) {
           Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
