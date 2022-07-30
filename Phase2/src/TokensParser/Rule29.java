package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule29 implements Node
{
	int isRight;
	Token token;
	
	public void def() 
	{
		isRight = 0;
		token = new Token();
	}
	
	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule29 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule29 : Syntex Error");
			return;
		}

		System.out.println(space + "Rule29 :");
		
		space += "	";

		System.out.println(space + token.Type + " : " + token.Value);
	}

	public void Run(Queue<Token> q)
	{
		def();

		if(Check(q.peek().Type))
		{
			token = q.peek();
			q.poll();
		}
		else
			isRight = 2;
	}
	
	boolean Check (String s)
	{
		return s.equals("<INT>") || s.equals("<FLOAT>") || s.equals("<STRING>") || s.equals("<CHARACTER>")
				|| s.equals("<BOOLEAN>");
	}

}
