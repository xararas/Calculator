//package com.bham.pij.assignments.calculator;

// Charalampos 2165173

import java.util.Scanner;

public class Calculator 
{
	public static float result;
	public boolean isNotValid = false;
	public static float memoryVal;

	public static void main(String[] args) 
	{
		String exp;
		String exp2;
		Scanner in = new Scanner(System.in);
		Calculator calc = new Calculator();
		System.out.println("Enter the expression");
		exp = in.nextLine();		
		result = calc.evaluate(exp);
		System.out.println(result);

		while (exp != "")
		{
			System.out.println("Enter the expression");
			exp = in.nextLine();
			if (exp.equals("m"))
			{
				calc.setMemoryValue(result);
			} 

			else
			{
				result = calc.evaluate(exp);
				System.out.println(result);
			}

			System.out.println("Enter the expression");
			exp = in.nextLine();
			float memVal;
			if (exp.equals("mr"))
			{
				memVal = calc.getMemoryValue();
				System.out.println(memVal);
			}

			else
			{
				result = calc.evaluate(exp);
				System.out.println(result);
			}

			System.out.println("Enter the expression");
			exp = in.nextLine();
			if (exp.equals("c"))
			{	calc.clearMemory();
			System.out.println(calc.getMemoryValue());
			}

			else
			{
				result = calc.evaluate(exp);
				System.out.println(result);
			}
		}
	}

	public Calculator()
	{

	}

	public float evaluate(String expression)
	{	

		String[] tokens = expression.split(" ");	

		if(tokens.length != 3)
		{
			System.out.println("Invalid input");
			return Float.MIN_VALUE;
		}

		if(tokens[0].equals("") && tokens[1] != "" && tokens[2] != "")
		{
			System.out.println("Invalid input");
			return Float.MIN_VALUE;
		}

		if(tokens[0] != "" && tokens[1] != "" && tokens[2].equals(""))
		{
			System.out.println("Invalid input");
			return Float.MIN_VALUE;
		}

		float operand1 = Float.parseFloat(tokens[0]);
		float operand2 = Float.parseFloat(tokens[2]);


		String op = tokens[1];

		float i = 0;

		switch (op)
		{
		case "+":
			i = operand1 + operand2;
			break;

		case "-":
			i = operand1 - operand2;
			break;

		case "*":
			i = operand1 * operand2;
			break;

		case "/":

			if(operand2 != 0)
				i = operand1 / operand2;
			else
			{
				System.out.println("Invalid input");
				return Float.MIN_VALUE;
			}
			break;

		default:
			System.out.println("Invalid input");
		}

		return result = i;
	}

	public float getCurrentValue()
	{
		return result;
	}

	public void setMemoryValue(float memval)
	{
		memoryVal = memval;
	}

	public float getMemoryValue()
	{
		return memoryVal;
	}


	public void clearMemory()
	{
		setMemoryValue(0);
	}

	public float getHistoryValue(int index)
	{
		return index;
	}
}


