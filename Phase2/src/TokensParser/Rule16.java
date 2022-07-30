package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule16 implements Node
{
	int isRight;
	Token token1, token2;
	
	public Rule16()
	{
	}
	
	void def()
	{
		isRight = 0;
		token1 = new Token();
		token2 = new Token();
	}

	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule16 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule16 : Syntex Error");
			return;
		}

		System.out.println(space + "Rule16 :");
		
		space += "	";
		
		System.out.println(space + token1.Type + " : " + token1.Value);
		System.out.println(space + token2.Type + " : " + token2.Value);
	}

	public void Run(Queue<Token> q)
	{
		def();

		if(q.peek().Type.equals("<LEFT_SQUARE_B>"))
		{
			token1 = q.peek();
			q.poll();
			
			if(q.peek().Type.equals("<RIGHT_SQUARE_B>"))
			{
				token2 = q.peek();
				q.poll();
			}
			else
				isRight = 2;
		}
		else
			isRight = 1;
	}
}
