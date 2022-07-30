package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule13 implements Node
{
	int isRight;
	Token token;
	Rule15 rule15;
	Rule30 rule30;
	Rule13 rule13;
	
	public Rule13()
	{
	}
	
	void def()
	{
		isRight = 0;
		token = new Token();
		rule15 = new Rule15();
		rule30 = new Rule30();
		rule13 = new Rule13();
	}

		
	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule13 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule13 : Syntax Error");
			return;
		}

		System.out.println(space + "Rule13 :");
		
		space += "	";
		
		System.out.println(space + token.Type + " : " + token.Value);
		
		rule15.Print(space);
		rule30.Print(space);
		rule13.Print(space);
	}

	public void Run(Queue<Token> q) 
	{
		def();

		if(q.peek().Type.equals("<COMMA>"))
		{
			token = q.peek();
			q.poll();
			
			rule15.Run(q);
			
			if(rule15.isRight > 0)
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
			
			rule13.Run(q);
			
			if(rule13.isRight == 2)
				isRight = 2;
		}
		else
			isRight = 1;		
	}

}

