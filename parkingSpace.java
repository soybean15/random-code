import java.util.ArrayList;
import java.util.Scanner;

public class Bin {

    private String name;
    ArrayList<String> v= new ArrayList<>();
    int[] count = new int[Vehicle.typeArr.length];

     char[][] parkingSpace = new char[10][26];

     public Bin(String name){
         this.name = name;
     }

     String getName(){
         return this.name;
     }

    void printParked_bin(){
        for(int i = 0; i<Vehicle.typeArr.length;i++){
            System.out.println(count[i]+" "+Vehicle.typeArr[i]);
        }
    }

    void createParkingSpace(){//create parking space
        for(int i =0; i<10; i++){
            for(int j=0; j<25; j++){
                parkingSpace[i][j] = '=';
            }

        }

    }


    void printParkingSpace(){//print parking space
        for(int i =0; i<10; i++){
            for(int j=0; j<25; j++){
                System.out.print(parkingSpace[i][j]);
            }
            System.out.println();
        }

    }

    void parkVehicle(Vehicle v, int x, int y){
        int width=x+v.getWidth();
        int length = y+v.getLength();

        for(int i=y; i<length;i++){
            for(int j=x; j<width;j++){
                if(j==width-1){
                    parkingSpace[i][j]='|';

                }else{
                    parkingSpace[i][j] = v.getType().charAt(0);
                }


            }

        }


    }

    boolean checkVacant(Vehicle v, int _i, int _j){


        int count_j=0;
        int count_i=0;


        //check width
        for(int i =_j; i<_j+v.getWidth(); i++) {
            if(parkingSpace[_i][i]=='='){
                count_j++;
            }
        }

        //check length
        for(int j =_i; j<_i+ v.getLength(); j++) {
            if(parkingSpace[j][_j]=='='){
                count_i++;
            }
        }

        return v.getWidth()==count_j && v.getLength()==count_i;


    }


}



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



public class ParkingSpace {

    Scanner sc = new Scanner(System.in);


    Bin main = new Bin("Main Building");
    Bin audi= new Bin("Auditorium");
    Bin gym =  new Bin("Gym");
    Bin library = new Bin("Library");





    void addOnParkingSpace(Vehicle v,Bin bin){

        int _j= 0;
        int _i=0;


        outerloop:

        for(int i=0; i<10;i++){
            for (int j = 0; j<25; j++) {
                try{
                    if (bin.checkVacant(v,i,j)) {
                        _j= j;
                        _i = i;
                        break outerloop;
                    }
                }catch (ArrayIndexOutOfBoundsException e){

                }

            }
        }
        if (!bin.checkVacant(v,_i,_j)){
            System.out.println("Parking lot is FUll");
        }else{
            bin.parkVehicle(v, _j, _i);

        }

        bin.printParkingSpace();

    }

    void printVehicle(){
        int count = 1;
        for(String typestr:Vehicle.typeArr){
            System.out.println(count+". "+typestr);
            count++;
       
        }
System.out.println("Enter -1 to back to main menu");
    }



    void printParkedCar(String vehicle, Bin bin){
        int index = 0;
        int idx = 0;
        for(String str:Vehicle.typeArr){
            if(str.equals(vehicle)){
                index =idx;
            }
            idx++;
        }
        bin.count[index] +=1;

        for(int i = 0; i<Vehicle.typeArr.length;i++){
            System.out.println(bin.count[i]+" "+Vehicle.typeArr[i]);
        }

        System.out.println("Number of Vehicle parked: "+ bin.v.size());

    }



    void addVehicle(Bin bin){
        Vehicle[] vehicle = new Vehicle[50];//vehicle array

        int index = 0;


        int option;
        while (true) {

            printVehicle();//print vehicle list
            vehicle[index] =new Vehicle(); // create vehicle
            System.out.println("Select Car Type:");
            option = sc.nextInt();
            if(option<0){
                selectParkingSpace();
            }

            vehicle[index].setSize(option);//set size and type on vehicle

            bin.v.add(vehicle[index].getType());//added parked vehicle

            addOnParkingSpace(vehicle[index], bin);// add vehicle on parking space


            System.out.println("Car Parked:");
            printParkedCar(vehicle[index].getType(),bin);//print vehicle inside parking space
            index++;


        }



    }

    void showBins(){
        System.out.println(main.getName()+" Parking Space");
        main.printParked_bin();
        main.printParkingSpace();

        System.out.println(gym.getName()+" Parking Space");
        gym.printParked_bin();
        gym.printParkingSpace();

        System.out.println(library.getName()+" Parking Space");
        library.printParked_bin();
        library.printParkingSpace();

        System.out.println(audi.getName()+" Parking Space");
        audi.printParked_bin();
        audi.printParkingSpace();
    }


    void selectParkingSpace(){



        while (true){
            System.out.println("Select Parking Space");
            System.out.println("1. Main Building");
            System.out.println("2.Auditorium");
            System.out.println("3.Gym");
            System.out.println("4.Library");
            System.out.println("5.Show bins");

            int select = sc.nextInt();
            switch (select){
                case 1:addVehicle(main);
                case 2:addVehicle(audi);
                case 3:addVehicle(gym);
                case 4:addVehicle(library);
                case 5: showBins();
                default:
                    System.out.println("Invalid");
            }


        }


    }

    void parkCar(){
        main.createParkingSpace();
        audi.createParkingSpace();
        gym.createParkingSpace();
        library.createParkingSpace();
        selectParkingSpace();
        System.out.println();

    }


}
public class Main {

    public static void main(String[] args) {
        ParkingSpace p = new ParkingSpace();
        p.parkCar();
    }
}



