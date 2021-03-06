package com.employeeWageUsingMethods;

import java.util.ArrayList;
import java.util.HashMap;
class CompanySpecifics
{
	public final String companyName;
	public final int maxMonthlyDays;
	public final int maxMonthlyHours;
	public final int wagePerHour;
	public int totalWage;
	ArrayList<Integer> dailyWage;
	public CompanySpecifics(String companyName,int maxMonthlyDays,int maxMonthlyHours,int wagePerHour)
	{
		this.companyName=companyName;
		this.maxMonthlyDays=maxMonthlyDays;
		this.maxMonthlyHours=maxMonthlyHours;
		this.wagePerHour=wagePerHour;
		totalWage=0;
		dailyWage=new ArrayList<Integer>();
	}
}

interface IEmployeeWageViaMethods
{
	public void addCompany(String company, int maxWorkingDays, int maxWorkingHours,int empWagePerHour);
	public int workingHoursComputation(int empCheck);
	public void monthlyWageComputation();
	public int getTotalWage(String companyName );
}
class EmployeeWageViaMethods implements IEmployeeWageViaMethods 
{
	static final int IS_FULL_TIME=1 ,IS_PART_TIME=2;
	private ArrayList<CompanySpecifics> companySpecificsArrayList;
	private HashMap<String,CompanySpecifics> companySpecificsHashMap;
	public EmployeeWageViaMethods()
	{
		companySpecificsArrayList=new ArrayList<CompanySpecifics>();
		companySpecificsHashMap=new HashMap<String,CompanySpecifics>();
	}
	
	public void addCompany(String company, int maxWorkingDays, int maxWorkingHours,int empWagePerHour)
	{	
		CompanySpecifics companySpecifics=new CompanySpecifics(company,maxWorkingDays,maxWorkingHours,empWagePerHour);
		companySpecificsArrayList.add(companySpecifics);
		companySpecificsHashMap.put(company,companySpecifics);
	}
	//Daily Working Hours Selection
	public int workingHoursComputation(int empCheck)
	{	
		int empDailyHours=0;
		switch (empCheck)
		{
			case IS_FULL_TIME :
				empDailyHours=8;
			break;
			case IS_PART_TIME :
				empDailyHours=4;
			break;
			default :
				empDailyHours=0;
				}
		return empDailyHours;
	}

	//computation of Monthly wage with maximum working days according to company	
	public void monthlyWageComputation()
	{	
		for (int i=0;i<companySpecificsArrayList.size();i++)
		{
			CompanySpecifics companySpecifics=companySpecificsArrayList.get(i);
			int empDailyWage, empWorkingDays=0,empWorkingHours=0; 
			while(empWorkingDays<=companySpecifics.maxMonthlyDays && empWorkingHours<companySpecifics.maxMonthlyHours)
			{	
				int empCheck=(int)(Math.floor(Math.random()*10)%3);
				int empDailyHours=this.workingHoursComputation(empCheck);	
				empDailyWage=empDailyHours*companySpecifics.wagePerHour;
				companySpecifics.dailyWage.add(empDailyWage);
				companySpecifics.totalWage+=empDailyWage;
				empWorkingDays++;
				empWorkingHours+=empDailyHours;
			}
			System.out.println("*****  "+companySpecifics.companyName+"  *****");
			System.out.println("Daily Wage :"+companySpecifics.dailyWage);
			System.out.println("Total Wage : " +this.getTotalWage(companySpecifics.companyName));
		}
	}
	//to get total wage when queried by specific company
	public int getTotalWage(String companyName )
	{
		return companySpecificsHashMap.get(companyName).totalWage;
	}
	public static void main(String args[])
	{	//welcome message
		System.out.println("Welcome to Employee Wage Computation Program");		
		EmployeeWageViaMethods employeeWage=new EmployeeWageViaMethods();
		employeeWage.addCompany("D-mart", 10, 80, 50);
		employeeWage.addCompany("Reliance", 20, 120, 40);
		employeeWage.addCompany("BigBasket", 22, 130, 100);
		employeeWage.monthlyWageComputation();
	}
}