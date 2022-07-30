package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule20 implements Node
{
	int isRight;
	Token token1, token2, token3, token4;
	Rule21 rule21_1, rule21_2;
	
	public Rule20()
	{
	}
	
	void def()
	{
		isRight = 0;
		token1 = new Token();
		token2 = new Token();
		token3 = new Token();
		token4 = new Token();
		rule21_1 = new Rule21();
		rule21_2 = new Rule21();
	}
	
	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule20 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule20 : Syntex Error");
			return ;
		}

		System.out.println(space + "Rule20 :");
		
		space += "	";

		switch(token1.Type)
		{
		case "<ASSIGNMENT>":
			Print1(space);
			break;
			
		default:
			Print2(space);
			break;
		}
	}

	void Print1(String space)
	{
		System.err.println(space + token1.Type + " : " + token1.Value);
		rule21_1.Print(space);
		System.err.println(space + token2.Type + " : " + token2.Value);
	}
	
	void Print2(String space)
	{
		System.err.println(space + token1.Type + " : " + token1.Value);
		rule21_1.Print(space);
		System.err.println(space + token2.Type + " : " + token2.Value);
		System.err.println(space + token3.Type + " : " + token3.Value);
		rule21_2.Print(space);
		System.err.println(space + token4.Type + " : " + token4.Value);
	}

	public void Run(Queue<Token> q)
	{
		def();

		switch (q.peek().Type) 
		{
		case "<ASSIGNMENT>":
			Run1(q);
			break;

		default:
			Run2(q);
			break;
		}
	}
	
	void Run1(Queue<Token> q)
	{
		token1 = q.peek();
		q.poll();
		
		rule21_1.Run(q);
		
		if(rule21_1.isRight > 0)
		{
			isRight = 2;
			return ;
		}
		
		if(q.peek().Type.equals("<SEMICOLON>"))
		{
			token2 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return ;
		}
	}
	
	void Run2(Queue<Token> q)
	{
		
		if(q.peek().Type.equals("<LEFT_SQUARE_B>"))
		{
			token1 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return ;
		}

		rule21_1.Run(q);
		
		if(rule21_1.isRight > 0)
		{
			isRight = 2;
			return ;
		}

		if(q.peek().Type.equals("<RIGHT_SQUARE_B>"))
		{
			token2 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return ;
		}

		if(q.peek().Type.equals("<ASSIGNMENT>"))
		{
			token3 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return ;
		}

		rule21_2.Run(q);
		
		if(rule21_2.isRight > 0)
		{
			isRight = 2;
			return ;
		}

		if(q.peek().Type.equals("<SEMICOLON>"))
		{
			token4 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return ;
		}
	}
}
