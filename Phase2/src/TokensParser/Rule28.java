	package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule28 implements Node
{
	int isRight;
	Token token1, token2, token3;
	Rule29 rule29;
	Rule21 rule21;
	Rule27 rule27;
	
	public void def()
	{
		isRight = 0;
		token1 = new Token();
		token2 = new Token();
		token3 = new Token();
		rule21 = new Rule21();
		rule27 = new Rule27();
		rule29 = new Rule29();
	}
	
	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule28 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule28 : Syntex Error");
			return ;
		}

		System.out.println(space + "Rule28 :");
		
		space += "	";
		
		if(token1.Type.equals("<ID>"))
		{
			System.out.println(space + token1.Type + " : " + token1.Value);
			System.out.println(space + token2.Type + " : " + token2.Value);
			rule27.Print(space);
			System.out.println(space + token3.Type + " : " + token3.Value);
		}
		else
		{
			rule29.Print(space);
			System.out.println(space + token1.Type + " : " + token1.Value);
			rule21.Print(space);
			System.out.println(space + token2.Type + " : " + token2.Value);
		}
	}

	public void Run(Queue<Token> q)
	{
		def();

		if(q.peek().Type.equals("<ID>"))
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
			
			rule27.Run(q);
			
			if(rule27.isRight == 2)
			{
				isRight = 2;
				return;
			}
			
			if(q.peek().Type.equals("<RIGHT_ROUND_B>"))
			{
				token3 = q.peek();
				q.poll();
			}
			else
				isRight = 2;
		}
		else
		{
			rule29.Run(q);
			
			if(rule29.isRight > 0)
			{
				isRight = 2;
				return;
			}

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
			
			rule21.Run(q);
			
			if(rule21.isRight > 0)
			{
				isRight = 2;
				return;
			}
			
			if(q.peek().Type.equals("<RIGHT_SQUARE_B>"))
			{
				token2 = q.peek();
				q.poll();
			}
			else
				isRight = 2;
		}
		
	}

}
