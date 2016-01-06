package model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

public class LottoWindowIfYouWonHelper
{
	public static Map<Integer, Integer> checkIfYouWon(List<Integer> list)
	{
		Map<Integer, Integer> wygrane = new HashMap<>();
		wygrane.put(1,0);
		wygrane.put(2,0);
		wygrane.put(3,0);
		wygrane.put(4,0);
		wygrane.put(5,0);
		wygrane.put(6,0);
		
		int wynikLosowania = 0;
		
		Map<LocalDate, SortedSet<Integer>> losowania = LottoHelper.getLottoResultsMap();
		
		//losowania.forEach((key1, value1) ->
		for(Map.Entry<LocalDate, SortedSet<Integer>> entry : losowania.entrySet())
		{
			wynikLosowania = 0;
			for (int number : entry.getValue())
			{
				if(list.contains(number))
				{
					wynikLosowania++; 
				}
			}
			if (wynikLosowania > 0)
			{
				int wygraneDanegoStopnia = wygrane.get(wynikLosowania);
				wygrane.put(wynikLosowania, wygraneDanegoStopnia + 1);
			}
		}
		return wygrane;
	}
}
