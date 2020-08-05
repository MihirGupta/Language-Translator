import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class CSVReader
{
    String language;
    public String setFilePath(String language)
    {
        this.language = language.concat(".csv");
        return null;
    }

    public String compute(String a)  
    {
        BufferedReader br = null;
        
        String ans="";
        String line = "";
        int first=0;
        int last=0;
        int middle=0;
        String check="";
        try 
        {
            br = new BufferedReader(new FileReader(language));
            while ((line = br.readLine()) != null) 
            {
                String[] dutch = line.split(",");// use comma as separator
                first=0;
                last=dutch.length-1;
                middle=(first+last)/2;
                while(first<=last)
                {
                    if(dutch[middle].compareTo(a)<0)
                    {
                        first=middle+1;
                    }
                    else if(dutch[middle].equalsIgnoreCase(a))
                    {
                        ans=dutch[middle+1];
                        check="found";
                        break;
                    }
                    else
                    {
                        last=middle-1;
                    }
                    middle=(first+last)/2;
                }
            }
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println(e);
        } 
        catch (IOException e) 
        {
            System.out.println(e);
        } 
        finally 
        {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
        if(check.equalsIgnoreCase("found")!=true)
        {
            String b=a;
            ans+=b;
        }
        return ans;
    }
}