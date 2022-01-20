import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


//bin class

public class Bin {
     char[][] parkingSpace = new char[6][12];
    int num;



    char[][] createBin(){//create parking space
        char[][] parkingSpace = new char[7][11];
        for(int i =0; i<5; i++){
            for(int j=0; j<10; j++){
                parkingSpace[i][j] = '=';
            }

        }
        return parkingSpace;
    }


    void parkVehicle(Vehicle v, int index ){
        int width=index+v.getWidth();

        for(int i = 0; i <v.getLength();i++)
            for(int j=index; j<width;j++){
                if(j==width-1){
                    parkingSpace[i][j]='|';

                }else{
                    parkingSpace[i][j] = v.getType().charAt(0);
                }




        }

    }




    void printBin(){//print parking space
        for(int i =0; i<6; i++){
            for(int j=0; j<10; j++){
                System.out.print(parkingSpace[i][j]);
            }
            System.out.println();
        }

    }
}


//vehicle class
class Vehicle {
    private String type;
    private int width;
    private int length;
    static String[] typeArr = {"Motorcycle","Tricycle","Sedan","SUV"};


    String getType(){
        return type;
    }

    int getWidth(){
        return width;
    }
    int getLength(){
        return length;
    }

    void setSize(int intType){

        if (intType == 1){
            this.width =3;
            this.length = 4;
            this.type = typeArr[intType-1];
        }else if(intType == 2){
            this.width = 4;
            this.length = 4;
            this.type = typeArr[intType-1];
        }else if(intType == 3) {
            this.width = 5;
            this.length = 5;
            this.type = typeArr[intType-1];
        }else if(intType == 4) {
            this.width = 5;
            this.length = 6;
            this.type = typeArr[intType-1];
        }

    }
}



//main  class
public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static ArrayList<String> carType = new ArrayList<>();
    int[] count = new int[Vehicle.typeArr.length];


    void showBins(ArrayList<Integer> weight, int capacity){
        ArrayList<Vehicle> vehicleCopy = new ArrayList<>(vehicles);
        System.out.println(vehicleCopy);
        Bin[] bin = new Bin[10];
        int size = weight.size();
        int idx=0;
        while(size>0){
            weight.removeAll(Collections.singleton(0));
            vehicleCopy.removeAll(Collections.singleton(null));
            size = weight.size();
            bin[idx] = new Bin();
            bin[idx].num =idx+1;

            int remaining = capacity;
            int index = 0;

            for (int i =0; i < size; i++){
                if(vehicleCopy.get(i).getWidth()<=remaining){

                    bin[idx].parkVehicle(vehicleCopy.get(i), index);
//                  bin[idx].printBin();
                    index = index+weight.get(i);
                    remaining = remaining-weight.get(i);

                    weight.set(i, 0);
                    vehicleCopy.set(i, null);

                }
                if(remaining<2){
                    break;
                }
            }
            idx++;
        }

        if(idx == 0){
            System.out.println("bin"+bin[0].num);
            bin[0].printBin();
        }else {
            for (int i = 0; i<idx-1; i ++){
                System.out.println("bin"+bin[i].num);
                bin[i].printBin();

            }
        }
    }

    static int nextFit(ArrayList<Integer> weight, int n, int c) {
        // Initialize result (Count of bins) and remaining
        // capacity in current bin.
        int res = 0, bin_rem = c;

        // Place items one by one
        for (int i = 0; i < n; i++) {
            // If this item can't fit in current bin
            if (weight.get(i) > bin_rem) {
                res++; // Use a new bin
                bin_rem = c - weight.get(i);
            } else
                bin_rem -= weight.get(i);
        }
        return res;
    }

    void printVehicle() {
        int count = 1;
        for (String typestr : Vehicle.typeArr) {
            System.out.println(count + ". " + typestr);
            count++;
        }
    }

    void printCarType(String vehicle){
        int index = 0;
        int idx = 0;
        for(String str:Vehicle.typeArr){
            if(str.equals(vehicle)){
                index =idx;
            }
            idx++;
        }
        count[index] +=1;

        for(int i = 0; i<Vehicle.typeArr.length;i++){
            System.out.println(count[i]+" "+Vehicle.typeArr[i]);
        }

        System.out.println("Number of Vehicle parked: "+ vehicles.size());

    }

    void showBin(){

    }

    public static void main(String[] args) {

        Main main = new Main();
        ArrayList<Integer> weight = new ArrayList<Integer>();


        int c = 10;

        int i = 0;
        while(true) {
            main.printVehicle();
            System.out.println("Select Vehicle(Enter -1 to Stop");
            int option = sc.nextInt();
            if(option<0){
                break;
            }
            Vehicle v = new Vehicle();
            vehicles.add(v);
            vehicles.get(i).setSize(option);
            String type = vehicles.get(i).getType();
            carType.add(type);

            weight.add(vehicles.get(i).getWidth());

            main.printCarType(type);

            i++;
        }

        int totalBin = nextFit(weight, weight.size(), c)+1;
        System.out.println("Number of bins : " + totalBin );

        main.showBins(weight,c);
     }

}
