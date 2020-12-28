package io.javabrains;

public class MathUtils {

	public int add(int a,int b)
	{
		return a+b;
	}
	
	public int divide(int a,int b)
	{
		return a/b;
	}
	
	public double multiply(double a,double b)
	{
		return a*b;
	}
	
	public double computeCircleArea(double radius)
	{
		System.out.println("Math.PI :"+Math.PI);
		return Math.PI*radius*radius;
	}
}
