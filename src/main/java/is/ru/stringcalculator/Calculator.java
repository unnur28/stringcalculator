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
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",|\\n");
	}
	
	private static String[] customSplit(String numbers)
	{
		String[] temp = new String[2];
		temp = numbers.split("\\n");
		String delimiter = temp[0].substring(2);
		return temp[1].split(delimiter);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }



}