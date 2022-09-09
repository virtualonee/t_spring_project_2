package ru.alishev.springcourse.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min=2, max=100, message="Имя должно быть длиной от 2 до 100 символов")
    @Column(name="fio")
    private String fio;

    @Min(value = 1900, message = "Год рождения должен быть больше, чем 1900")
    @Column(name="date")
    private String date;

    @OneToMany(mappedBy = "person")
    private List<Book> books;

    public Person(){

    }

    public Person(String fio, String date, List<Book> books) {
        this.fio = fio;
        this.date = date;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
