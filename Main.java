package org.example;

public class Main {
    public static void main(String[] args) {
        /*

Nje klase abstrakte duhet te kete gjithmone nje metode abstrakte? a mund te ekzistoje nje metode
abstrakte jashte nje klase jo-abstrakte? Një klasë mund të jetë abstrakte edhe pa pasur metoda abstrakte —
thjesht nuk mund të krijosh objekt direkt prej saj. Nuk mund te krijojme nje
metode abstrakte jashte nje klase abstract. Mund te implementohet nje metode ne nje interface?
Mund te implementojme nje metode abstrakte deri para Java 8,por pas asaj u shtuan dy metoda te reja Default dhe Static te cilat lejojne e
krijojme nje trup brenda atyre metodave.  Super klasa eshte klasa prind e cila trashegohet nga nen klasat e saj.
Subclass eshte nenklas e nje super klase e cila trashegon nga klasa prind dhe perdoret metoda extend.
Super eshte fjale kyce e cila perdoret per te thirrur metoda ose konstruktore nga klasa prind(Super class). 
Overload eshte te perdorim te njejten metoda por me parametra te ndryshme. Override eshte kur subclass perdor te njejten metode te trasheguar nga super klasa.

———————————————————————————————————————
package org.example;

class Lule {
    //Variablat
    private String ngjyra;
    private String lloji;

    //Konstuktori

    public Lule () {}

    public Lule(String ngjyra,String lloji){
        this.ngjyra = ngjyra;
        this.lloji = lloji;
    }

    //Get dhe set

    public String getNgjyra() {
        return ngjyra;
    }

    public void setNgjyra(String ngjyra) {
        this.ngjyra = ngjyra;
    }

    public String getlloji (){
        return lloji;
    }

    public void setlloji (String lloji) {
        this.lloji = lloji;
    }
}

class Makina {
    private String kompania;
    private String modeli;
    private int vitiProdhimit;
    private double engineSize;

    public Makina () {}

    public Makina (String Kompania,String Modeli,int VitiProdhimit,int engineSize){
        this.kompania = Kompania;
        this.modeli = Modeli;
        this.vitiProdhimit = VitiProdhimit;
        this.engineSize = engineSize;
    }

    public String getKompania(){
        return kompania;
    }

    public String setKompania(String kompania){
        this.kompania = kompania;
        return  kompania;
    }

    public String getModeli(){
        return modeli;
    }

    public String setModeli(String modeli){
        this.modeli = modeli;
        return modeli;
    }

    public int getVitiProdhimit(){
        return vitiProdhimit;
    }

    public int setVitiProdhimit(int vitiProdhimit){
        this.vitiProdhimit = vitiProdhimit;
        return vitiProdhimit;
    }

    public double getEngineSize(){
        return engineSize;
    }

    public double setEngineSize(double engineSize){
        this.engineSize = engineSize;
        return engineSize;
    }

}

class Dhoma {
    private int Siperfaqia;
    private int nrDritareve;
    private String ngjyraMureve;

    public Dhoma () {}

    public Dhoma (int Siperfaqia,int NrDritareve,String NgjyraMureve){
        this.Siperfaqia = Siperfaqia;
        this.nrDritareve = NrDritareve;
        this.ngjyraMureve = NgjyraMureve;
    }

    public int getSiperfaqia(){
        return Siperfaqia;
    }

    public int setSiperfaqia(int Siperfaqia){
        this.Siperfaqia = Siperfaqia;
        return Siperfaqia;
    }

    public int getNrDritareve(){
        return nrDritareve;
    }

    public int setNrDritareve(int nrDritareve){
        this.nrDritareve = nrDritareve;
        return nrDritareve;
    }

    public String getNgjyraMureve(){
        return ngjyraMureve;
    }

    public String setNgjyraMureve(String ngjyraMureve){
        this.ngjyraMureve = ngjyraMureve;
        return ngjyraMureve;
    }
}

public class Main {
    public static void main(String[] args) {
        Lule lule = new Lule();
        Makina makine = new Makina();
        Dhoma home = new Dhoma();

        lule.setlloji("Trendafila");
        lule.setNgjyra("te kuqe");

        makine.setKompania("Audi");
        makine.setModeli("A3");
        makine.setVitiProdhimit(2015);
        makine.setEngineSize(2.0);

        home.setNgjyraMureve("Blue");
        home.setSiperfaqia(20);
        home.setNrDritareve(3);

        System.out.println(lule.getlloji());
        System.out.println(lule.getNgjyra());
        System.out.println();
        System.out.println(makine.getKompania());
        System.out.println(makine.getModeli());
        System.out.println(makine.getVitiProdhimit());
        System.out.println(makine.getEngineSize() +"T");
        System.out.println();
        System.out.println(home.getNgjyraMureve());
        System.out.println(home.getSiperfaqia()+"^2");
        System.out.println(home.getNrDritareve()+" dritare.");
    }
}
———————————————————————————————————————
package org.example;

abstract class Makina {
    abstract void benZhurme();
}

class Audi  extends Makina {
    void benZhurme() {
        System.out.println("VRUM VRUM");
    }
}

class Benz extends Makina {
    void benZhurme() {
        System.out.println("KLE KLE KLE");
    }
}

public class Main {
    public static void main(String[] args) {
        Audi a = new Audi();
        Benz b = new Benz();

        a.benZhurme();
        b.benZhurme();
    }
}
————————————————————————————————————
package org.example;

public interface Shpejtesi{
    void ecenMeShpejtesi();
}

public class Makina implements Shpejtesi {
    @Override
    public void ecenMeShpejtesi() {
        System.out.println("Makina ecen me 200 km/h.");
    }
}

public class Avioni implements Shpejtesi {
    @Override
    public void ecenMeShpejtesi() {
        System.out.println("Avioni ecen me 400 km/h.");
    }
}

public class Person implements Shpejtesi{
    @Override
    public void ecenMeShpejtesi() {
        System.out.println("Person ecen me 10 km/h.");
    }
}

public class Main {
    public static void main(String[] args) {
        Shpejtesi makine = new Makina();
        makine.ecenMeShpejtesi();
        System.out.println();
        Shpejtesi avioni = new Avioni();
        avioni.ecenMeShpejtesi();
        System.out.println();
        Shpejtesi person = new Person();
        person.ecenMeShpejtesi();
    }
}

————————————————————————————————————————
package org.example;

class Automjetet {
    String Modeli;
    int VitiProdhimit;

    public Automjetet (String modeli,int vitiProdhimit){
        this.Modeli = modeli;
        this.VitiProdhimit = vitiProdhimit;
    }

    public String getModeli(){
        return  Modeli;
    }

    public void setModeli(String modeli){
        this.Modeli = modeli;
    }
    public int getVitiProdhimit(){
        return VitiProdhimit;
    }

    public void  setVitiProdhimit(int vitiProdhimit){
        this.VitiProdhimit = vitiProdhimit;
    }
}

public class Main {
    public static void main(String[] args) {
        Automjetet makina = new Automjetet("Audi",2015);
        makina.setModeli("Audi A3 ");
        makina.setVitiProdhimit(2015);

        System.out.println(makina.getModeli() + makina.getVitiProdhimit());
    }
}
——————————————————————————————————————
package org.example;
//funksion qe merr ne input nje numer dhe gjen nese eshte pozitiv apo negativ
import java.util.Scanner;
public class Main {

    public static double Inputi(double a){
        if (a < 0 ){
            System.out.println("Numri eshte negativ.");
        } else if ( a > 0 ){
            System.out.println("Numri eshte pozitiv.");
        } else if ( a == 0){
            System.out.println("Numri juaj eshte 0.");
        } else {
            System.out.println("Ju nuk keni futur numer!");
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ju lutem fusni nje numer cfaredo : ");
        double a = scanner.nextDouble();
        double rezultati = Inputi(a);
        System.out.println(rezultati);
    }
}

———————————————————————————————————————
package org.example;
//funksion qe merr ne input 3 numra dhe gjen me te madhin
import java.util.Scanner;
public class Main {

    public static double Numrat (double a,double b,double c) {
        double max = Math.max(a,Math.max(b,c));
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ju lutem fusni tre numra : ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c= scanner.nextDouble();

        double rezultati =  Numrat(a,b,c);
        System.out.println("Numri juaj me i madh eshte : " + rezultati);
    }
}
————————————————————————————————————————
package org.example;
//funksion qe merr ne input nje liste me numra dhe kur gjen numrin 5 printon "U gjet"
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void GjejNumrin (ArrayList<Integer> Lista){
        for (int i = 0; i < Lista.size(); i++) {
            int a = Lista.get(i);
            if (a == 5) {
                System.out.println("U gjet " + Lista.get(i) + " ne pozicionin " + i + ".");
                return;
            }
        }
        System.out.println("Nuk u gjet.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Fusni nje shifer per sa numra do vendosni ne liste : ");
        int nrElementeve =  scanner.nextInt();

        ArrayList<Integer> Lista = new ArrayList<>();
        System.out.println("Fusni numrat : ");

        for(int i = 0; i < nrElementeve; i++){
            int numri = scanner.nextInt();
            Lista.add(numri);
        }
        GjejNumrin(Lista);
    }
}
——————————————————————————————————————
package org.example;
//nje Map<Integer, String> muajt dhe mbusheni me muajt e vitit.
//Printoni listen e muajve. pastaj modifikoni vleren e key = 3 dhe vendosni
//"Shtator", printoni serisht vlerat.

import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> Muajte = new HashMap<>();
        Muajte.put(1, "Janar");
        Muajte.put(2, "Shkurt");
        Muajte.put(3, "Mars");
        Muajte.put(4, "Prill");
        Muajte.put(5, "Maj");
        Muajte.put(6, "Qershor");
        Muajte.put(7, "Korrik");
        Muajte.put(8, "Gusht");
        Muajte.put(9, "Shtator");
        Muajte.put(10, "Tetor");
        Muajte.put(11, "Nentor");
        Muajte.put(12, "Dhjetor");

        System.out.println("Muajte para modifikimit.");
        for(int key : Muajte.keySet()){
            System.out.println(Muajte.get(key));
        }

        Muajte.put(3, "Shtator");
        Muajte.put(9, "Mars");

        System.out.println("Muajte pas modifikimit.");
        for(int key : Muajte.keySet()){
            System.out.println(Muajte.get(key));
        }
    }
}
         */
    }
}

