package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule30 implements Node
{
	int isRight;
	Token token;
	
	public void def()
	{
		isRight = 0;
		token = new Token();
	}
	
	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule30 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule30 : Syntex Error");
			return;
		}

		System.out.println(space + "Rule30 :");
		
		space += "	";
		
		System.out.println(space + token.Type + " : " + token.Value);
	}

	public void Run(Queue<Token> q)
	{
		def();

		if(q.peek().Type.equals("<ID>"))
		{
			token = q.peek();
			q.poll();
		}
		else
			isRight = 2;
	}
}
