package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if (text.contains("//"))
		{
			return sum(customSplit(text));
		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",|\\n");
	}
	
	private static String[] customSplit(String numbers)
	{
		String delimiter = "";
		String[] temp = new String[2];
		temp = numbers.split("\\n");
		String[] del = temp[0].split("]");
		
		if (temp[0].substring(2,3).equals("["))
		{
			for (int i = 0; i < del.length; i++)
			{
				delimiter += del[i].substring(del[i].lastIndexOf("[") + 1) + "|";
			}
			delimiter = delimiter.substring(0, delimiter.length() - 1);
		}
		else
		{
			delimiter = temp[0].substring(2);
		}
		delimiter = delimiter.replace("*", "\\*");
		return temp[1].split(delimiter);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0, num;
		boolean exception = false;
		String e = "Negatives not allowed: ";
        for(String number : numbers){
			num = toInt(number);
			if (num < 0)
			{
				exception = true;
				e += number + ",";
			}
			if (num <= 1000)
			{
				total += num;
			}    
		}
		if (exception)
		{
			throw new IllegalArgumentException(e.substring(0, e.length() -1));
		}
		return total;
    }
}
