package com.yoidukigembu.apisample.db.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by hilo on 2017/07/18.
 */
@Entity(name = "Person")
@Table(name = "person")
@Data
public class PersonEntity implements Serializable {


    private static final long serialVersionUID = 4554084689009576911L;

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;


}
