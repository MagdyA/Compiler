package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule21 implements Node
{
	int isRight;
	Token token1, token2;
	Rule22 rule22;
	Rule28 rule28;
	Rule21 rule21;
	
	public Rule21()
	{
	}
	
	void def()
	{
		isRight = 0;
		token1 = new Token();
		token2 = new Token();
		rule21 = new Rule21();
		rule22 = new Rule22();
		rule28 = new Rule28();
	}

	public void Print(String space) 
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule21 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule21 : Syntex Error");
			return ;
		}

		System.out.println(space + "Rule21 :");
		
		space += "	";
		
		switch (token1.Type) {
		case "<NEW>":
			Print2(space);
			break;
			
		case "<NOT>":
			Print3(space);
			break;

		case "<LEFT_ROUND_B>":
			Print4(space);
			break;

		default:
			Print1(space);
			break;
		}
		
	}

	void Print1(String space)
	{
		System.out.println(space + token1.Type  + " : " + token1.Value);
		rule22.Print(space);
	}
	
	void Print2(String space)
	{
		System.out.println(space + token1.Type  + " : " + token1.Value);
		rule28.Print(space);
		rule22.Print(space);
	}

	void Print3(String space)
	{
		System.out.println(space + token1.Type  + " : " + token1.Value);
		rule21.Print(space);
		rule22.Print(space);
	}

	void Print4(String space)
	{
		System.out.println(space + token1.Type  + " : " + token1.Value);
		rule21.Print(space);
		System.out.println(space + token2.Type  + " : " + token2.Value);
		rule22.Print(space);
	}

	public void Run(Queue<Token> q)
	{
		def();

		switch (q.peek().Type) {
		case "<INTEGRAL_LITERAL>":
		case "<FLOAT_LITERAL>":
		case "<ID>":
		case "<THIS>":
		case "<TRUE>":
		case "<FALSE>":
		case "<STRING_LITERAL>":
			Run1(q);
			break;

		case "<NEW>":
			Run2(q);
			break;
			
		case "<NOT>":
			Run3(q);
			break;

		default:
			Run4(q);
			break;
		}
	}
	
	void Run1(Queue<Token> q)
	{
		token1 = q.peek();
		q.poll();
		
		rule22.Run(q);
		
		if(rule22.isRight == 2)
			isRight = 2;
	}
	
	void Run2(Queue<Token> q)
	{
		token1 = q.peek();
		q.poll();
		
		rule28.Run(q);
		
		if(rule28.isRight > 0)
			isRight = 2;

		rule22.Run(q);
		
		if(rule22.isRight == 2)
			isRight = 2;
	}

	void Run3(Queue<Token> q)
	{
		token1 = q.peek();
		q.poll();
		
		rule21.Run(q);
		
		if(rule21.isRight > 0)
			isRight = 2;
		
		rule22.Run(q);
		
		if(rule22.isRight == 2)
			isRight = 2;		
	}

	void Run4(Queue<Token> q)
	{
		if(q.peek().Type.equals("<LEFT_ROUND_B>"))
		{
			token1 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return ;
		}
		
		rule21.Run(q);
		
		if(rule21.isRight > 0)
		{
			isRight = 2;
			return ;
		}
		
		if(q.peek().Type.equals("<RIGHT_ROUND_B>"))
		{
			token2 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return ;
		}

		rule22.Run(q);
		
		if(rule22.isRight == 2)
			isRight = 2;
	}
}
