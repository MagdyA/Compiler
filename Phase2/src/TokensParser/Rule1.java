package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule1 implements Node
{
	int isRight;
	Rule3 rule3;
	Rule2 rule2;
	Token token1;
	
	public Rule1()
	{
		isRight = 0;
		token1 = new Token();
		rule3 = new Rule3();
		rule2 = new Rule2();
	}
	
	public void Print(String space) 
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule1 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule1 : Syntex Error");
			return ;
		}

		System.out.println(space + "Rule1 :");
		
		space += "	";
		
		rule3.Print(space);
		rule2.Print(space);
		
		System.out.println(space + token1.Type + " : " + token1.Value);
	}

	public void Run(Queue<Token> q) 
	{
		rule3.Run(q);
		
		if(rule3.isRight > 0)
		{
			isRight = 2;
			return;
		}
			
		rule2.Run(q);
		
		if(rule2.isRight == 2)
		{
			isRight = 2;
			return;
		}

		if(q.peek().Type.equals("<EOF>"))
		{
			token1 = q.peek();
			q.poll();
		}
		else
			isRight = 2;
	}
}
