package TokensParser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import GenTokens.Run;
import GenTokens.Token;

public class Parser
{

	public static void main(String[] args)
	{
		ArrayList<Token> tmp = new Run().Tokenize();
		Queue<Token> arr = new Run().Print(tmp);
		Queue<Token> q = new LinkedList<Token>();
		Token eof = new Token();
		
		eof.Type = "<EOF>";
		eof.Value = "End OF File";

		for(Token i: arr)
		{
			if(!(i.Type.equals("<EOL>") || i.Type.equals("<S_COMMENTS>") || i.Type.equals("<M_COMMENTS>")))
				q.add(i);
		}
		
		q.add(eof);
		
		for(Token i: q)
		{
			System.out.println(i.Type);
		}
		
		Rule1 root = new Rule1();
		
		root.Run(q);
		root.Print("");
	}
}

