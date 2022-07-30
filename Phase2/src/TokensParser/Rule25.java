package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule25 implements Node
{
	int isRight;
	Token token1, token2, token3;
	Rule27 rule27;
	
	public Rule25()
	{
	}
	
	void def()
	{
		isRight = 0;
		token1 = new Token();
		token2 = new Token();
		token3 = new Token();
		rule27 = new Rule27();
	}

	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule25 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule25 : Syntex Error");
			return;
		}

		System.out.println(space + "Rule25 :");
		
		space += "	";
		
		if(token1.Type.equals("<LENGTH>"))
			System.out.println(space + token1.Type + " : " + token1.Value);
		else
		{
			System.out.println(space + token1.Type + " : " + token1.Value);
			System.out.println(space + token2.Type + " : " + token2.Value);
			rule27.Print(space);
			System.out.println(space + token3.Type + " : " + token3.Value);
		}
	}

	public void Run(Queue<Token> q)
	{
		def();

		if(q.peek().Type.equals("<LENGTH>"))
		{
			token1 = q.peek();
			q.poll();
			return ;
		}
		
		if(q.peek().Type.equals("<ID>"))
		{
			token1 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return ;
		}
		
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

		rule27.Run(q);
		
		if(rule27.isRight == 2)
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
			isRight = 2;
	}

}
