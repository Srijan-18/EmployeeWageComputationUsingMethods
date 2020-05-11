package com.employeeWageUsingMethods;

class EmployeeWageViaMethods 
{
	public static void main(String args[])
	{	//welcome message
		System.out.println("Welcome to Employee Wage Computation Program");
		//constants
		final int isFullTime=1 ,isPartTime=2;
		//variables
		int empDailyWage=0, empDailyHours=0, empWagePerHour=20;
		int empMonthlyWage=0;
		
		//computation of Monthly wage with maximum working days in a month as 20
		for (int i=1;i<=20;i++)
		{	
			int empCheck=(int)(Math.floor(Math.random()*10)%3);
			switch (empCheck)
			{
				case isFullTime :
					empDailyHours=8;
				break;
				case isPartTime :
					empDailyHours=4;
				break;
				default :		
					}	
		empDailyWage=empDailyHours*empWagePerHour;
		empMonthlyWage+=empDailyWage;
		}
		System.out.println("Monthly Wage of Employee is :"+empMonthlyWage);
	}
}
