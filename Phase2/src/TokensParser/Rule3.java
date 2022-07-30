package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule3 implements Node
{
	int isRight;
	Token token1, token2, token3, token4, token5, token6, token7, token8, token9, token10,
			token11, token12, token13, token14;
	Rule30 rule30_1, rule30_2;
	Rule17 rule17;

	public void def()
	{
		isRight = 0;
		token1 = new Token();
		token2 = new Token();
		token3 = new Token();
		token4 = new Token();
		token5 = new Token();
		token6 = new Token();
		token7 = new Token();
		token8 = new Token();
		token9 = new Token();
		token10 = new Token();
		token11 = new Token();
		token12 = new Token();
		token13 = new Token();
		token14 = new Token();
		rule30_1 = new Rule30();
		rule30_2 = new Rule30();
		rule17 = new Rule17();
	}
	
	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule3 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule3 : Syntax Error");
			return;
		}
		
		System.out.println(space + "Rule3 : ");
		
		space += "	";
		
		System.out.println(space + token1.Type + " : " + token1.Value);
		
		rule30_1.Print(space);
		
		System.out.println(space + token2.Type + " : " + token2.Value);
		System.out.println(space + token3.Type + " : " + token3.Value);
		System.out.println(space + token4.Type + " : " + token4.Value);
		System.out.println(space + token5.Type + " : " + token5.Value);
		System.out.println(space + token6.Type + " : " + token6.Value);
		System.out.println(space + token7.Type + " : " + token7.Value);
		System.out.println(space + token8.Type + " : " + token8.Value);
		System.out.println(space + token9.Type + " : " + token9.Value);
		System.out.println(space + token10.Type + " : " + token10.Value);

		rule30_2.Print(space);
		
		System.out.println(space + token11.Type + " : " + token11.Value);
		System.out.println(space + token12.Type + " : " + token12.Value);
		
		rule17.Print(space);
		
		System.out.println(space + token13.Type + " : " + token13.Value);
		System.out.println(space + token14.Type + " : " + token14.Value);
	}

	public void Run(Queue<Token> q)
	{
		def();

		if(q.peek().Type.equals("<CLASS>"))
		{
			token1 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}
		
		rule30_1.Run(q);
		
		if(rule30_1.isRight > 0)
		{
			isRight = 2;
			return;
		}
		
		if(q.peek().Type.equals("<LEFT_CURLY_B>"))
		{
			token2 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}

		if(q.peek().Type.equals("<PUBLIC>"))
		{
			token3 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}

		if(q.peek().Type.equals("<STATIC>"))
		{
			token4 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}

		if(q.peek().Type.equals("<VOID>"))
		{
			token5 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}
		
		if(q.peek().Type.equals("<MAIN>"))
		{
			token6 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}

		if(q.peek().Type.equals("<LEFT_ROUND_B>"))
		{
			token7 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}
		
		if(q.peek().Type.equals("<STRING>"))
		{
			token8 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}

		if(q.peek().Type.equals("<LEFT_SQUARE_B>"))
		{
			token9 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}

		if(q.peek().Type.equals("<RIGHT_SQUARE_B>"))
		{
			token10 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}

		rule30_2.Run(q);
		
		if(rule30_2.isRight > 0)
		{
			isRight = 2;
			return;
		}
		
		if(q.peek().Type.equals("<RIGHT_ROUND_B>"))
		{
			token11 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}

		if(q.peek().Type.equals("<LEFT_CURLY_B>"))
		{
			token12 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}

		rule17.Run(q);

		if(rule17.isRight > 0)
		{
			isRight = 2;
			return;
		}

		if(q.peek().Type.equals("<RIGHT_CURLY_B>"))
		{
			token13 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}

		if(q.peek().Type.equals("<RIGHT_CURLY_B>"))
		{
			token14 = q.peek();
			q.poll();
		}
		else
			isRight = 2;
	}
}
