import java.util.ArrayList;
import java.util.Scanner;


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
    static char[][] parkingSpace = new char[10][26];
    Scanner sc = new Scanner(System.in);
    ArrayList<String> v= new ArrayList<>();
    int[] count = new int[Vehicle.typeArr.length];


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




    void addOnParkingSpace(Vehicle v){

        int _j= 0;
        int _i=0;


            outerloop:

            for(int i=0; i<10;i++){
                for (int j = 0; j<25; j++) {
                    try{
                        if (checkVacant(v,i,j)) {
                            _j= j;
                            _i = i;
                            break outerloop;
                        }
                    }catch (ArrayIndexOutOfBoundsException e){

                    }

                }
            }
        if (!checkVacant(v,_i,_j)){
            System.out.println("Parking lot is FUll");
        }else{
            parkVehicle(v, _j, _i);

        }

        printParkingSpace();

    }

    void printVehicle(){
        int count = 1;
        for(String typestr:Vehicle.typeArr){
            System.out.println(count+". "+typestr);
            count++;
        }
    }

    void printParkedCar(String vehicle){
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

        System.out.println("Number of Vehicle parked: "+ v.size());

    }

    void addVehicle(){
        Vehicle[] vehicle = new Vehicle[50];//vehicle array

        int index = 0;



        while (true) {
            
            printVehicle();//print vehicle list
            vehicle[index] =new Vehicle(); // create vehicle
            System.out.println("Select Car Type:");
            int option = sc.nextInt();

            vehicle[index].setSize(option);//set size and type on vehicle 

            v.add(vehicle[index].getType());//added parked vehicle

            addOnParkingSpace(vehicle[index]);// add vehicle on parking space


            System.out.println("Car Parked:");
            printParkedCar(vehicle[index].getType());//print vehicle inside parking space
            index++;


        }



    }

    void parkCar(){
        createParkingSpace();
        System.out.println();
        addVehicle();
    }


    public static void main(String[] args) {
        ParkingSpace p = new ParkingSpace();
        p.parkCar();
    }
}
