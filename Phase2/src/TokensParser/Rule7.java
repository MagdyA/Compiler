package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule7 implements Node
{
	int isRight;
	Rule10 rule10;
	Rule7 rule7;

	public void def() 
	{
		isRight = 0;
		rule10 = new Rule10();
		rule7 = new Rule7();
	}
	
	public void Print(String space) 
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule7 : NULL");
			return ;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule7 : Syntax Error");
			return;
		}
		
		System.out.println(space + "Rule7 :");
		
		space += "	";

		rule10.Print(space);
		rule7.Print(space);
	}

	public void Run(Queue<Token> q)
	{
		def();

		rule10.Run(q);
		
		if(rule10.isRight == 0)
		{
			rule7.Run(q);
			
			if(rule7.isRight == 2)
				isRight = 2;
		}
		else
			isRight = 1;
	}
}
