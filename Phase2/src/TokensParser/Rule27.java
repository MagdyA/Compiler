package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule27 implements Node
{
	int isRight;
	Rule21 rule21;
	Rule26 rule26;
	
	public Rule27()
	{
	}
	
	void def()
	{
		isRight = 0;
		rule21 = new Rule21();
		rule26 = new Rule26();
	}

	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule27 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule27 : Syntex Error");
			return;
		}

		System.out.println(space + "Rule27 :");
		
		space += "	";

		rule21.Print(space);
		rule26.Print(space);
	}

	public void Run(Queue<Token> q)
	{
		def();

		rule21.Run(q);
		
		if(rule21.isRight == 0)
		{
			rule26.Run(q);
			
			if(rule26.isRight == 2)
				isRight = 2;
		}
		else
			isRight = 1;
	}
}
