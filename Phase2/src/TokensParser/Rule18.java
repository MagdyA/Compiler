package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule18 implements Node
{
	int isRight;
	Rule17 rule17;
	Rule18 rule18;
		
	void def()
	{
		isRight = 0;
		rule17 = new Rule17();
		rule18 = new Rule18();
	}

	public void Print(String space) 
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule18 : NULL");
			return ;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule18 : Syntex Error");
			return;
		}

		System.out.println(space + "Rule18 :");
		
		space += "	";
		
		rule17.Print(space);
		rule18.Print(space);
	}

	public void Run(Queue<Token> q)
	{
		def();

		rule17.Run(q);
		
		if(rule17.isRight == 0)
		{
			rule18.Run(q);
			
			if(rule18.isRight == 2)
				isRight = 2;
		}
		else
			isRight = 1;
	}

}
