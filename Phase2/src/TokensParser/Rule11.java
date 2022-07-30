package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule11 implements Node
{
	int isRight;
	Token token1, token2, token3, token4, token5, token6;
	Rule12 rule12;
	Rule15 rule15;
	Rule30 rule30;
	Rule14 rule14;
	Rule6 rule6;
	Rule18 rule18;
	Rule21 rule21;
	
	public Rule11() 
	{
	}
	
	void def()
	{
		isRight = 0;
		token1 = new Token();
		token2 = new Token();
		token3 = new Token();
		token4 = new Token();
		token5 = new Token();
		token6 = new Token();
		rule12 = new Rule12();
		rule15 = new Rule15();
		rule18 = new Rule18();
		rule14 = new Rule14();
		rule21 = new Rule21();
		rule30 = new Rule30();
		rule6 = new Rule6();
	}


	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule11 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule11 : Syntax Error");
			return ;
		}
		
		System.out.println(space + "Rule11 :");
		
		space += "	";
		
		rule12.Print(space);
		rule15.Print(space);
		rule30.Print(space);
		
		System.out.println(space + token1.Type + " : " + token1.Value);

		rule14.Print(space);
		
		System.out.println(space + token2.Type + " : " + token2.Value);
		System.out.println(space + token3.Type + " : " + token3.Value);

		rule6.Print(space);
		rule18.Print(space);
		
		System.out.println(space + token4.Type + " : " + token4.Value);

		rule21.Print(space);
		
		System.out.println(space + token5.Type + " : " + token5.Value);
		System.out.println(space + token6.Type + " : " + token6.Value);
	}

	public void Run(Queue<Token> q) 
	{
		def();
		rule12.Run(q);
		
		if(rule12.isRight > 0)
		{
			isRight = 2;
			return;
		}
		
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

		if(q.peek().Type.equals("<LEFT_ROUND_B>"))
		{
			token1 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}
		
		rule14.Run(q);
		
		if(rule14.isRight == 2)
			isRight = 2;
				
		if(q.peek().Type.equals("<RIGHT_ROUND_B>"))
		{
			token2 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}
		
		if(q.peek().Type.equals("<LEFT_CURLY_B>"))
		{
			token3 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}
		
		rule6.Run(q);
		
		if(rule6.isRight == 2)
			isRight = 2;

		rule18.Run(q);
				
		if(rule18.isRight == 2)
			isRight = 2;

		if(q.peek().Type.equals("<RETURN>"))
		{
			token4 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}

		rule21.Run(q);

		if(rule21.isRight > 0)
		{
			isRight = 2;
			return;
		}

		if(q.peek().Type.equals("<SEMICOLON>"))
		{
			token5 = q.peek();
			q.poll();
		}
		else
		{
			isRight = 2;
			return;
		}

		if(q.peek().Type.equals("<RIGHT_CURLY_B>"))
		{
			token6 = q.peek();
			q.poll();
		}
		else
			isRight = 2;
	}

}

