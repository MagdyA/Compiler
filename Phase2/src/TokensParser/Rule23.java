package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule23 implements Node
{
	int isRight;
	Token token1, token2;
	Rule24 rule24;
	Rule21 rule21;
	Rule25 rule25;
		
	void def()
	{
		isRight = 0;
		token1 = new Token();
		token2 = new Token();
		rule21 = new Rule21();
		rule24 = new Rule24();
		rule25 = new Rule25();
		token1.Type="";
	}

	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule23 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule23 : Syntex Error");
			return;
		}

		System.out.println(space + "Rule23 :");
		
		space += "	";

		switch (token1.Type) {
		case "<LEFT_SQUARE_B>":
			Print1(space);
			break;

		case "<DOT>":
			Print2(space);
			break;

		default:
			Print3(space);
			break;
		}
	}

	void Print1(String space)
	{
		System.out.println(space + token1.Type + " : " + token1.Value);
		rule21.Print(space);
		System.out.println(space + token1.Type + " : " + token1.Value);
	}
	
	void Print2(String space)
	{
		System.out.println(space + token1.Type + " : " + token1.Value);
		rule25.Print(space);
	}

	void Print3(String space)
	{
		rule24.Print(space);
		rule21.Print(space);
	}

	
	public void Run(Queue<Token> q)
	{
		def();

		switch (q.peek().Type) {
		case "<LEFT_SQUARE_B>":
			Run1(q);
			break;

		case "<DOT>":
			Run2(q);
			break;

		default:
			Run3(q);
			break;
		}		
	}
	
	void Run1(Queue<Token> q)
	{
		token1 = q.peek();
		q.poll();
		
		rule21.Run(q);
		
		if(rule21.isRight > 0)
			isRight = 2;

		if(q.peek().Type.equals("<RIGHT_SQUARE_B>"))
		{
			token2 = q.peek();
			q.poll();
		}
		else
			isRight = 2;
	}
	
	void Run2(Queue<Token> q)
	{
		token1 = q.peek();
		q.poll();
		
		rule25.Run(q);
		
		if(rule25.isRight > 0)
			isRight = 2;
	}
	
	void Run3(Queue<Token> q)
	{
		rule24.Run(q);
		
		if(rule24.isRight > 0)
			isRight = 2;
		
		rule21.Run(q);
		
		if(rule21.isRight > 0)
			isRight = 2;
	}
}
