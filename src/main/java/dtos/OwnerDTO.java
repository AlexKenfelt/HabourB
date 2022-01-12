package dtos;

import entities.Owner;

public class OwnerDTO {

    //Varibels

    private Long id;
    private String name;
    private String address;
    private int phone;

    //Constructor
    public OwnerDTO(Long id, String name, String address, int phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public OwnerDTO(Owner entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.address= entity.getAddress();
        this.phone = entity.getPhone();

    }

    //Getter og Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "OwnerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }
}
