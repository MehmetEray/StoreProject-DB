/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

/**
 *
 * @author mehmet eray
 */
public class comp {
    String model;
    Integer SSD;
    Integer HDD;
    String processor;
    Integer price;

    public comp(String model, Integer SSD, Integer HDD, String processor, Integer price) {
        this.model = model;
        this.SSD = SSD;
        this.HDD = HDD;
        this.processor = processor;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSSD() {
        return SSD;
    }

    public void setSSD(Integer SSD) {
        this.SSD = SSD;
    }

    public Integer getHDD() {
        return HDD;
    }

    public void setHDD(Integer HDD) {
        this.HDD = HDD;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
