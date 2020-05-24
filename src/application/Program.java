package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worke;
import entities.enuns.WorkeLevel;

@SuppressWarnings("unused")
public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
		System.out.print("Enter department's name: ");
		String departmentName = scan.next();
				
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = scan.next();
		System.out.print("LEVEL: ");
		String workerLevel = scan.next();
		System.out.print("Base salary: ");
		double baseSalary = scan.nextDouble();
		Worke worke = new Worke(workerName, WorkeLevel.valueOf(workerLevel) , baseSalary , new Department(departmentName));
		
		System.out.print("How many contracts to this worker?: ");
		int n = scan.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.print("Enter contract #" + i + " data: ");
			System.out.println("Date (DD/MM/YYYY): ");
			Date date = sdf.parse(scan.next());
			
			System.out.print("Value per hour: ");
			double valuePerHour = scan.nextDouble();
			
			System.out.print("Duration (hours): ");
			int hours = scan.nextInt();
			
			HourContract contract = new HourContract(date, valuePerHour, hours);
			worke.addContract(contract);
		}
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = scan.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " + worke.getName());
		System.out.println("Department: " + worke.getDepartment().getNome());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worke.income(year, month)));
			
	scan.close();
	}
}
