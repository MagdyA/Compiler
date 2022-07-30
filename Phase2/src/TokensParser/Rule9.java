package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule9 implements Node
{
	int isRight;
	Rule15 rule15;
	Rule30 rule30;
	Token token;
	
	public void def()
	{
		isRight = 0;
		token = new Token();
		rule15 = new Rule15();
		rule30 = new Rule30();
	}
	
	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule9 : NULL");
			return;
		}
		
		System.out.println(space + "Rule9 :");
		
		space += "	";
		
		rule15.Print(space);
		rule30.Print(space);
		
		System.out.println(space + token.Type + " : " + token.Value);
	}

	public void Run(Queue<Token> q) 
	{
		def();

		rule15.Run(q);
		
		if(rule15.isRight > 0)
		{
			isRight = 2;
			return;
		}
		
		rule30.Run(q);
		
		if(rule30.isRight > 0)
		{
			isRight = 2;
			return;
		}
		
		if(q.peek().Type.equals("<SEMICOLON>"))
		{
			token = q.peek();
			q.poll();
		}
		else
			isRight = 2;
	}

}
