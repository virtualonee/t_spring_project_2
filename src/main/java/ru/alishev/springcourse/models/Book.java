package ru.alishev.springcourse.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="book")
public class Book {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Название книги не должно быть пустым")
    @Size(min=2, max=100, message="Название книги должно быть длиной от 2 до 100 символов")
    @Column(name="name")
    private String name;
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min=2, max=100, message="Имя должно быть длиной от 2 до 100 символов")
    @Column(name="author")
    private String author;
    @Min(value = 1900, message = "Год должен быть больше, чем 1900")
    @Column(name="year")
    private String year;

    @ManyToOne
    @JoinColumn(name="person", referencedColumnName = "id")
    private Person person;

    public Book(){

    }

    public Book(String name, String author, String year, Person person) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
