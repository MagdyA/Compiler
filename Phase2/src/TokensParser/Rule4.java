package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule4 implements Node
{
	int isRight;
	Token token1, token2, token3;
	Rule30 rule30;
	Rule5 rule5;
	Rule6 rule6;
	Rule7 rule7;
	Rule8 rule8;

	public void def() 
	{
		isRight = 0;
		token1 = new Token();
		token2 = new Token();
		token3 = new Token();
		rule30 = new Rule30();
		rule5 = new Rule5();
		rule6 = new Rule6();
		rule7 = new Rule7();
		rule8 = new Rule8();
	}
	
	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule4 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule4 : Syntax Error");
			return ;
		}
		
		System.out.println(space + "Rule4 :");
		
		space += "	";
		
		System.out.println(space + token1.Type + " : " + token1.Value);
		
		rule30.Print(space);
		rule5.Print(space);
		
		System.out.println(space + token2.Type + " : " + token2.Value);
		
		rule6.Print(space);
		rule7.Print(space);
		rule8.Print(space);
		
		System.out.println(space + token3.Type + " : " + token3.Value);
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
		
		rule30.Run(q);
		
		if(rule30.isRight > 0)
		{
			isRight = 2;
			return;
		}
		
		rule5.Run(q);
				
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
		
		rule6.Run(q);
		
		if(rule6.isRight == 2)
		{
			isRight = 2;
			return;
		}
		
		rule7.Run(q);	
		
		if(rule6.isRight == 2)
		{
			isRight = 2;
			return;
		}

		rule8.Run(q);
		
		if(rule6.isRight == 2)
		{
			isRight = 2;
			return;
		}

		if(q.peek().Type.equals("<RIGHT_CURLY_B>"))
		{
			token3 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}
	}

}
