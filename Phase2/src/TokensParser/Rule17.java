package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule17 implements Node
{
	int isRight;
	Token token1, token2, token3, token4;
	Rule17 rule17;
	Rule18 rule18;
	Rule19 rule19;
	Rule20 rule20;
	Rule21 rule21;
	Rule30 rule30;
		
	void def()
	{
		isRight = 0;
		token1 = new Token();
		token2 = new Token();
		token3 = new Token();
		token4 = new Token();
		rule17 = new Rule17();
		rule18 = new Rule18();
		rule19 = new Rule19();
		rule20 = new Rule20();
		rule21 = new Rule21();
		rule30 = new Rule30();		
		
		token1.Type = "";
	}

	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule17 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule17 : Syntex Error");
			return ;
		}

		System.out.println(space + "Rule17 :");
		
		space += "	";
		
		switch(token1.Type)
		{
		case "<LEFT_CURLY_B>":
			Print1(space);
			break;
			
		case "<IF>":
			Print2(space);
			break;

		case "<WHILE>":
			Print3(space);
			break;

		case "<SYSTEM.OUT.PRINTLN>":
			Print4(space);
			break;

		default :
			Print5(space);		
		}
	}
	
	void Print1(String space)
	{
		System.out.println(space + token1.Type + " : " + token1.Value);
		rule18.Print(space);
		System.out.println(space + token2.Type + " : " + token2.Value);
	}
	
	void Print2(String space)
	{
		System.out.println(space + token1.Type + " : " + token1.Value);
		System.out.println(space + token2.Type + " : " + token2.Value);
		rule21.Print(space);
		System.out.println(space + token3.Type + " : " + token3.Value);
		rule17.Print(space);
		rule19.Print(space);
	}

	void Print3(String space)
	{
		System.out.println(space + token1.Type + " : " + token1.Value);
		System.out.println(space + token2.Type + " : " + token2.Value);
		rule21.Print(space);
		System.out.println(space + token3.Type + " : " + token3.Value);
		rule17.Print(space);
	}

	void Print4(String space)
	{
		System.out.println(space + token1.Type + " : " + token1.Value);
		System.out.println(space + token2.Type + " : " + token2.Value);
		rule21.Print(space);
		System.out.println(space + token3.Type + " : " + token3.Value);
		System.out.println(space + token4.Type + " : " + token4.Value);
	}

	void Print5(String space)
	{
		rule30.Print(space);
		rule20.Print(space);
	}

	public void Run(Queue<Token> q)
	{
		def();

		switch (q.peek().Type) 
		{
		case "<LEFT_CURLY_B>":
			Run1(q);
			break;
			
		case "<IF>":
			Run2(q);
			break;

		case "<WHILE>":
			Run3(q);
			break;

		case "<SYSTEM.OUT.PRINTLN>":
			Run4(q);
			break;

		default :
			Run5(q);		
		}
	}
	
	void Run1(Queue<Token> q)
	{
		token1 = q.peek();
		q.poll();
		
		rule18.Run(q);
		
		if(rule18.isRight == 2)
		{
			isRight = 2;
			return ;
		}
		
		if(q.peek().Type.equals("<RIGHT_CURLY_B>"))
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

		if(q.peek().Type.equals("<LEFT_ROUND_B>"))
		{
			token2 = q.peek();
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
			token3 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return ;
		}

		rule17.Run(q);
		
		if(rule17.isRight > 0)
		{
			isRight = 2;
			return ;
		}

		rule19.Run(q);
		
		if(rule19.isRight == 2)
			isRight = 2;
	}

	void Run3(Queue<Token> q)
	{
		token1 = q.peek();
		q.poll();

		if(q.peek().Type.equals("<LEFT_ROUND_B>"))
		{
			token2 = q.peek();
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
			token3 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return ;
		}

		rule17.Run(q);
		
		if(rule17.isRight > 0)
			isRight = 2;
	}

	void Run4(Queue<Token> q)
	{
		token1 = q.peek();
		q.poll();

		if(q.peek().Type.equals("<LEFT_ROUND_B>"))
		{
			token2 = q.peek();
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
			token3 = q.peek();
			q.poll();
		}
		else
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
			isRight = 2;
	}

	void Run5(Queue<Token> q)
	{
		rule30.Run(q);
		
		if(rule30.isRight == 0)
		{			
			rule20.Run(q);
			
			if(rule20.isRight > 0)
				isRight = 2;
		}
		else
			isRight = 2;
	}
}
