package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule2 implements Node
{
	int isRight;
	Rule4 rule4;
	Rule2 rule2;

	public Rule2() 
	{
	}

	void def()
	{
		isRight = 0;
		rule2 = new Rule2();
		rule4 = new Rule4();
	}
	
	public void Print(String space) 
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule2 : NULL");
			return ;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule2 : syntax Error");
			return;
		}

		System.out.println(space + "Rule2 : ");
		
		space += "	";
		
		rule4.Print(space);
		rule2.Print(space);
	}

	public void Run(Queue<Token> q) 
	{
		def();

		rule4.Run(q);
		
		if(rule4.isRight == 0)
		{
			rule2.Run(q);
			
			if(rule2.isRight == 2)
				isRight = 2;
		}
		else
			isRight = 1;
	}
	
}
