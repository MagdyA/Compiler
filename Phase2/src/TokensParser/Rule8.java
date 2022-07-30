package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule8 implements Node
{
	int isRight;
	Rule11 rule11;
	Rule8 rule8;

	public void def() 
	{
		isRight = 0;
		rule11 = new Rule11();
		rule8 = new Rule8();
	}
	
	public void Print(String space) 
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule8 : NULL");
			return ;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule8 : Syntax Error");
			return;
		}
	
		System.out.println(space + "Rule8 :");
		
		space += "	";

		rule11.Print(space);
		rule8.Print(space);
	}

	public void Run(Queue<Token> q)
	{
		def();

		rule11.Run(q);
		
		if(rule11.isRight == 0)
		{
			rule8.Run(q);
			
			if(rule8.isRight == 2)
				isRight = 2;
		}
		else
			isRight = 1;
	}
}
