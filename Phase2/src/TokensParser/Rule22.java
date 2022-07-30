package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule22 implements Node
{
	int isRight;
	Rule23 rule23;
	Rule22 rule22;
	
	public Rule22()
	{
	}
	
	void def()
	{
		isRight = 0;
		rule22 = new Rule22();
		rule23 = new Rule23();
	}

	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule22 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule22 : Syntex Error");
			return;
		}

		System.out.println(space + "Rule22 :");
		
		space += "	";

		rule23.Print(space);
		rule22.Print(space);
	}

	public void Run(Queue<Token> q)
	{
		def();

		rule23.Run(q);
		
		if(rule23.isRight == 0)
		{
			rule22.Run(q);
			
			if(rule22.isRight == 2)
				isRight = 2;
		}
		else
			isRight = 1;
	}
}
