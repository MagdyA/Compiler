package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule6 implements Node
{
	int isRight;
	Rule9 rule9;
	Rule6 rule6;

	public void def() 
	{
		isRight = 0;
		rule9 = new Rule9();
		rule6 = new Rule6();
	}
	
	public void Print(String space) 
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule6 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule6 : Syntax Error");
			return;
		}

		System.out.println(space + "Rule6 :");
		
		space += "	";

		rule9.Print(space);
		rule6.Print(space);
	}

	public void Run(Queue<Token> q)
	{
		def();

		rule9.Run(q);
		
		if(rule9.isRight == 0)
		{
			rule6.Run(q);
			
			if(rule6.isRight == 2)
				isRight = 2;				
		}
		else
			isRight = 1;
	}
}
