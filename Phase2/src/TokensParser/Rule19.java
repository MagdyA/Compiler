package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule19 implements Node
{
	int isRight;
	Token token;
	Rule17 rule17;
	
	public Rule19() 
	{
	}
	
	void def()
	{
		isRight = 0;
		token = new Token();
		rule17 = new Rule17();
	}

	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule19 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule19 : Syntex Error");
			return;
		}

		System.out.println(space + "Rule19 :");
		
		space += "	";
		
		System.out.println(space + token.Type + " : " + token.Value);
		rule17.Print(space);
	}

	public void Run(Queue<Token> q)
	{
		def();

		if(q.peek().Type.equals("<ELSE>"))
		{
			token = q.peek();
			q.poll();
			
			rule17.Run(q);
			
			if(rule17.isRight > 0)
				isRight = 2;
		}
		else
			isRight = 1;
	}
}