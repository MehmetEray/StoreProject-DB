/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class phone {
     String model;
     Integer ram;
     String processor;
     Integer camera;
     Integer price;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Integer getCamera() {
        return camera;
    }

    public void setCamera(Integer camera) {
        this.camera = camera;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
     

    public phone(String model, Integer ram, String processor, Integer camera, Integer price) {
        this.model = model;
        this.ram = ram;
        this.processor = processor;
        this.camera = camera;
        this.price = price;
    }

    

   
}
