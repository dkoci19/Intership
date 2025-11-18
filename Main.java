package org.example;

class Building {
    private long Id;
    public String Addres;

    public Building(long Id, String Addres) {
        this.Id = Id;
        this.Addres = Addres;
    }

    public long getId() {
        return Id;
    }
    public void setId(long Id) {
        this.Id = Id;
    }

    public String getAddres() {
        return Addres;
    }
    public void setAddres(String Addres) {
        this.Addres = Addres;
    }

    public void printAddress() {
        System.out.println("Address: " + Addres);
        System.out.println("ID: " + Id);
    }
}
public class Main {
    public static void main(String[] args) {
        Building building = new Building(221, "Tirane");
        building.printAddress();
    }
}