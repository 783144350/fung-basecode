package fung.util.test.excelparser;

import fung.util.excelhelper.ExcelHead;

import java.util.Date;

public class Model2 {
    @ExcelHead(value = "PartName")
    private String partName;

    @ExcelHead(value = "PO")
    private String orderNumber;

    @ExcelHead(value = "QTY")
    private Integer quantity;

    @ExcelHead(value = "ETA")
    private Date date;

    public String getPartName() {
        return partName;
    }

    public Model2 setPartName(String partName) {
        this.partName = partName;
        return this;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Model2 setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Model2 setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Model2 setDate(Date date) {
        this.date = date;
        return this;
    }
}
