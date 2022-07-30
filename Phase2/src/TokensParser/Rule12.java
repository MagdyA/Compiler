package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule12 implements Node
{
	int isRight;
	Token token;
	
	public Rule12()
	{
	}
	
	void def()
	{
		isRight = 0;
		token = new Token();
	}

	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule12 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule12 : Syntax Error");
			return;
		}

		System.out.println(space + "Rule12 :");
		
		space += "	";
		
		System.out.println(space + token.Type + " : " + token.Value);		
	}

	public void Run(Queue<Token> q)
	{
		def();
		
		if(q.peek().Type.equals("<PUBLIC>"))
		{
			token = q.peek();
			q.poll();
		}
		else if(q.peek().Type.equals("<PRIVATE>"))
		{
			token = q.peek();
			q.poll();
		}
		else if(q.peek().Type.equals("<PROTECTED>"))
		{
			token = q.peek();
			q.poll();
		}
		else
			isRight = 2;
	}
}
