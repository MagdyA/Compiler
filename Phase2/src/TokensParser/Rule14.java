package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule14 implements Node
{
	int isRight;
	Rule15 rule15;
	Rule30 rule30;
	Rule13 rule13;
	
	public Rule14()
	{
	}
	
	void def()
	{
		isRight = 0;
		rule15 = new Rule15();
		rule30 = new Rule30();
		rule13 = new Rule13();
	}

	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule14 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule14 : Syntax Error");
			return;
		}

		System.out.println(space + "Rule14 :");
		
		space += "	";
				
		rule15.Print(space);
		rule30.Print(space);
		rule13.Print(space);
	}

	public void Run(Queue<Token> q) 
	{
		def();
		rule15.Run(q);

		if(rule15.isRight == 0)
		{	
			rule30.Run(q);
			
			if(rule30.isRight > 0)
			{
				isRight = 2;
				return;
			}
			
			rule13.Run(q);
			
			if(rule13.isRight == 2)
				isRight = 2;
		}
		else
			isRight = 1;		
	}

}
