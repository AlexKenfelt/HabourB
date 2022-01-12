package entities;

import javax.persistence.*;

@Table(name = "boat")
@Entity
public class Boat {

    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "make")
    private String make;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    //Constructors

    public Boat() {
    }

    public Boat(String brand, String make, String name, String image) {
        this.brand = brand;
        this.make = make;
        this.name = name;
        this.image = image;
    }

    public Boat(Boat boat) {
        this.brand = boat.getBrand();
        this.make = boat.getMake();
        this.name = boat.getName();
        this.image = boat.getImage();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //toString
    @Override
    public String toString() {
        return "Boat{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", make='" + make + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}