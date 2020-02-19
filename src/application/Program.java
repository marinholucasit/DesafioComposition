package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner scRead = new Scanner(System.in);		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.print("Report department's name: ");
		String departmentName = scRead.nextLine();
		
		System.out.println("------- Enter work data -------");		
		System.out.print("Worker name: ");
		String workerName = scRead.nextLine();
		
		System.out.print("Worker level: ");
		String workerlevel = scRead.nextLine();
		
		System.out.print("Base salary: ");
		Double baseSalary = scRead.nextDouble();
		
		Worker worker = new Worker(workerName, 
				                   WorkerLevel.valueOf(workerlevel), 
				                   baseSalary, 
				                   new Department(departmentName));
		
		System.out.print("How many contracts to this worker?");
		int n = scRead.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.print("Enter contract #"+i+" data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(scRead.next());
			System.out.print("Value per hour: ");
			double valuePerHour = scRead.nextDouble();
			System.out.print("Duration (hour): ");
			int hours = scRead.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.println("Enter month and year to calcule income (MM/YYYY): ");
		String monthAndYear = scRead.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: "+worker.getName());
		System.out.println("Department: "+worker.getDepartment().getName());
		System.out.println("Income for "+monthAndYear+": "+String.format("%.2f", worker.income(year, month)));
		
		
		
		scRead.close();

	}

}
