package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule5 implements Node
{
	int isRight;
	Token token;
	Rule30 rule30;

	public void def() 
	{
		isRight = 0;
		token = new Token();
		rule30 = new Rule30();
	}
	
	public void Print(String space) 
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule5 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule5 : Syntax Error");
			return;
		}

		
		System.out.println(space + "Rule5 :");
		
		space += "	";

		System.out.println(space + token.Type + " : " + token.Value);
		
		rule30.Print(space);		
	}

	public void Run(Queue<Token> q)
	{
		def();

		if(q.peek().Type.equals("<EXTENDS>"))
		{
			token = q.peek();
			q.poll();
			
			rule30.Run(q);
			
			if(rule30.isRight > 0)
				isRight = 2;
		}
		else
			isRight = 1;
	}
}
