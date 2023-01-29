package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Nikiforova Anna");
        student.setGroup("2015");
        student.setReceiptDate(new Date());
        System.out.println(student.getFio() + " Group " + student.getGroup() + " receipt date " + student.getReceiptDate());
    }
}
