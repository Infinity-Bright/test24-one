package com.ash.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
public class Book {
    private Integer id;
    private String name;
    private Double price;
}
