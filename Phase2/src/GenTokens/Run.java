package GenTokens;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Run
{
	public static String code;
	
	public static void main(String[] args)
	{
		ArrayList<Token> tokens = new Run().Tokenize();
		new Run().Print(tokens);
	}
	
	public ArrayList<Token> Tokenize()
	{
		code = ReadInput("TESTCASE8_CLASS_3.txt") + "\n";
		ArrayList<RegEx> REs = ReadRE("RegEx.txt");
		ArrayList<Token> tokens = Solve(REs);
		Sort(tokens);
		tokens.remove(0);
				
		return tokens;
	}

	String ReadInput(String FileName)
	{
		String s="";
		
		try 
		{
			Scanner fin = new Scanner(new File(FileName));
			
			while(fin.hasNextLine())
				s += "\n"+fin.nextLine();
			
			fin.close();
			
		}catch(Exception ex){}
		
		return s;
	}
	
	ArrayList<RegEx> ReadRE(String FileName)
	{
		ArrayList<RegEx> REs = new ArrayList<>();
		RegEx RE;
		
		try 
		{
			Scanner fin = new Scanner(new File(FileName));
			
			while(fin.hasNextLine())
			{
				RE = new RegEx();
				
				RE.TName = fin.nextLine();
				RE.RE = fin.nextLine();
				RE.Flag = fin.nextInt();
				
				if(fin.hasNextLine())
					fin.nextLine();
				
				REs.add(RE);
			}
			
			fin.close();
			
		}catch(Exception ex){}

		return REs;
	}
	
	ArrayList<Token> Solve(ArrayList<RegEx> REs)
	{
		ArrayList<Token> tokens = new ArrayList<>();
		boolean arr[] = new boolean[code.length()];
		Token token;
		
		for(RegEx RE : REs)
		{
			Pattern pat = Pattern.compile(RE.RE);
			Matcher mat = pat.matcher(code);
			
			while(mat.find())
			{
				token = new Token();
				
				if(!arr[mat.start()] && (RE.Flag==0 || (Check(code.charAt(mat.start()-1)) && Check(code.charAt(mat.end())))))
				{
					token.ind = mat.start();
					token.Type = RE.TName;
					token.Value = mat.group();
					
					tokens.add(token);
					
					arr[mat.start()]=true; 
				}
			}
		}
		
		return tokens;
	}
	
	public boolean Check(char ch)
	{
		return (ch>'z' || ch<'a') && (ch>'Z' || ch<'A') && (ch>'9' || ch<'0') && ch!='_';
	}
	
	public void Sort(ArrayList<Token> tokens)
	{
		Collections.sort(tokens,new Comparator<Token>()
		{
			@Override
			public int compare(Token p1, Token p2) 
			{
				return p1.ind>p2.ind || (p1.ind==p2.ind && p1.Value.length()<p2.Value.length())? 1 : (p1.ind<p2.ind ? -1 : 0);
			}
		});
	}
	
	public Queue<Token> Print(ArrayList<Token> tokens) 
	{
		int ind=0, sz;
		Queue<Token> q = new LinkedList<Token>();
		
		for(Token t : tokens)
		{
			sz = t.Value.length();
			
			if(t.Value.equals("\n"))
				t.Value = "End of line";
			
			if(t.ind == ind)
			{
				Token tmp = new Token();
				
				tmp.Type = "<" + t.Type + ">";
				tmp.Value = "-" + t.Value + "-";
				
				q.add(tmp);
			}
			
			else if(t.ind > ind)
			{
				String s = code.substring(ind,t.ind);
				String arr[] = s.split("\\s");
				
				for(String i : arr)
					if(!i.equals(""))
					{
						Token tmp = new Token();
						
						tmp.Type = "<Error unknown token>";
						tmp.Value = "-" + i + "-";
						q.add(tmp);
					}
				
				Token tmp = new Token();
				
				tmp.Type = "<" + t.Type + ">";
				tmp.Value = "-" + t.Value + "-";
				q.add(tmp);
			}
			
			if(t.ind>=ind)
				ind = t.ind + sz;
		}
		
		return q;
	}		
}
