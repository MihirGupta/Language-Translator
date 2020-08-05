import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Translator extends CSVReader
{
    public String input(String s,String language)
    {
    	super.setFilePath(language);
        String output="";
        try
        {
            output=this.process(s);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return output;
    }

    public String process(String s)
    {
        s+=" ";
        String value="";
        String x="",y="";
        char ch;
        try
        {
            for(int i=0;i<s.length();i++)
            {
                ch=s.charAt(i);
                if(Character.isLetter(ch))
                {
                    x+=ch;
                }
                else 
                {
                	y+=" "+super.compute(x);
                    x="";
                }
                if((!Character.isLetter(ch))&&(ch!=' '))
                {
                    y+=ch;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return y;
    }
}