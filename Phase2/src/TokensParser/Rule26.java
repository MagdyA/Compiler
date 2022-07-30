package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule26 implements Node
{
	int isRight;
	Token token;
	Rule21 rule21;
	Rule26 rule26;
	
	public Rule26() 
	{
	}
	
	void def()
	{
		isRight = 0;
		token = new Token();
		rule21 = new Rule21();
		rule26 = new Rule26();
	}

	public void Print(String space) 
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule26 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule26 : Syntex Error");
			return;
		}

		System.out.println(space + "Rule26 :");
		
		space += "	";

		System.out.println(space + token.Type + " : " + token.Value);
		rule21.Print(space);
		rule26.Print(space);
	}

	public void Run(Queue<Token> q)
	{
		def();

		if(q.peek().Type.equals("<COMMA>"))
		{
			token = q.peek();
			q.poll();
			
			rule21.Run(q);
			
			if(rule21.isRight > 0)
			{
				isRight = 2;
				return ;
			}
			
			rule26.Run(q);
			
			if(rule26.isRight == 2)
				isRight = 2;
		}
		else
			isRight = 1;
	}
}
