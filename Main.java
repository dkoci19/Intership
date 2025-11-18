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

class Residental extends Building {
    int Apaertaments;

    public Residental(long Id, String Addres, int Apaertaments) {
        super(Id, Addres);
        this.Apaertaments = Apaertaments;
    }

    public int getApaertaments() {
        return Apaertaments;
    }
    public void setApaertaments(int Apaertaments) {
        this.Apaertaments = Apaertaments;
    }

    public void printAddres() {
        System.out.println("Address: " + Addres);
    }
}

class Commercial extends Building {
    private int officeNumber;
    public Commercial(long Id, String Addres, int officeNumber) {
        super(Id, Addres);
        this.officeNumber = officeNumber;
    }

    public int getOfficeNumber() {
        return  officeNumber;
    }
    public void setOfficeNumber(int officeNumber) {
        this.officeNumber = officeNumber;
    }

    public void printAddress() {
        System.out.println("Office number : " + officeNumber);
    }
}

public class Main {
    public static void main(String[] args) {
        Building building = new Building(221, "Tirane");
        building.printAddress();

        Residental res = new Residental(222,"Durres",20);
        res.printAddress();

        Commercial commercial = new Commercial(223,"Tirane",20);
        commercial.printAddress();
    }
}

