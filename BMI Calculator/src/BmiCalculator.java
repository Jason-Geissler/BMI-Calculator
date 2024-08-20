import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

interface Patient {
	
	public String displayBMI(double bmi);
	
	public String displayInsuranceCategory(double bmi);

}
public abstract class BmiCalculator implements Patient{

public static void main(String[] args) {

String name, date, bmiStatus, insuranceStatus;

double weight, height, BMI;

Scanner sc=new Scanner(System.in);

File fout = new File("out.txt");

FileOutputStream fos = null;
try {

fos = new FileOutputStream(fout);
} catch (FileNotFoundException e) {

System.out.print("File not found!!");
}

BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

try {

while(true){

System.out.print("Please enter your name (or q to stop):");
name=sc.nextLine();

if(name.equalsIgnoreCase("q"))
break;

System.out.print("Please enter your birthdate (mm/dd/yyyy):");
date=sc.nextLine();

System.out.print("Please enter your weight (in pounds): ");

weight=Double.parseDouble(sc.nextLine());

System.out.print("Please enter your height (in inches): ");

height=Double.parseDouble(sc.nextLine());

BMI=weight*730 /(height*height);

if(BMI<18.5){
bmiStatus="underweight";
insuranceStatus="low";
}
else if(BMI>18.5 && BMI<=24.9 ){
bmiStatus="Normal";
insuranceStatus="low";
}

else if(BMI>=25 && BMI<=29.9 ){
bmiStatus="Overweight";
insuranceStatus="high";
}
else{
bmiStatus="Obese";
insuranceStatus="highest";
}

String strDouble = String.format("%.2f", BMI);

String outputString="Name: "+name+"\r\n"+"Birth Date: "+date+"\r\nBMI Index: "+strDouble+"\r\nBMI Category: "+bmiStatus+"\r\nInsurance payment category is:" +insuranceStatus;

bw.write(outputString);

bw.newLine();

bw.newLine();

System.out.println("BMI index calculated and write to file successful.");


System.out.println("");


System.out.println(outputString);


System.out.println("");

}


bw.close();
sc.close();
}

catch (IOException e) {

System.out.print("Error while reading and writing!!");
}
}
}