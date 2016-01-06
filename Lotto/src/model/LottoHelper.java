package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class LottoHelper
{
	private static Map<LocalDate, SortedSet<Integer>> lottoResultsMap;
	
	public static Map<LocalDate, SortedSet<Integer>> getLottoResultsMap()
	{
		return lottoResultsMap;
	}

	public static void setLottoResultsMap(Map<LocalDate, SortedSet<Integer>> map)
	{
		lottoResultsMap = map;
	}

	/**
	 * The method outputs the map in form key - draw date, value - draw numbers
	 * @return
	 */
	public static void saveIntoCollection()
	{
		InputStream fileInputStream = getFileInputStream();
		InputStreamReader isr = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr);

		Map<LocalDate, SortedSet<Integer>> lottoMap = new HashMap<LocalDate, SortedSet<Integer>>();
		
		try
		{
			String line;
			while ((line = br.readLine()) != null)
			{
				lottoMap.put(getDateFromLine(line), getNumbersFromLine(line));
			}
		} catch (IOException e1)
		{
			System.out.print("Blad odczytu pliku");
		}
		setLottoResultsMap(lottoMap);
	}

	/**
	 * Metoda zwraca InputStream - strumien bajtow z pliku.
	 * 
	 * @return FileInputStream
	 */
	private static FileInputStream getFileInputStream()
	{
		FileInputStream inputStream = null;
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			File file = fileChooser.getSelectedFile();
			try
			{
				inputStream = new FileInputStream(file);
			} catch (FileNotFoundException e1)
			{
				// wyswietla przyczyne bledu w konsoli
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Nie mozna odnalezc okreslonego pliku!");
				getFileInputStream(); // dzieki THIS odwolujemy sie do
				// kazdego elementu obecnej klasy.
			}
		}
		return inputStream;
	}

	/**
	 * Metoda zwraca date z danej linii pliku
	 * 
	 * @param line
	 * @return
	 */
	private static LocalDate getDateFromLine(String line)
	{
		String stringDate = line.substring(line.indexOf(" ") + 1, line.lastIndexOf(" "));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate date = LocalDate.parse(stringDate, formatter);
		return date;
	}

	/**
	 * Metoda zwraca SortedSet wynikow Lotto (posortowany rosnaco zbior wynikow
	 * losowan)
	 * 
	 * @param line
	 * @return
	 */
	private static SortedSet<Integer> getNumbersFromLine(String line)
	{
		String result = line.substring(line.indexOf(" ") + 1, line.length());
		result = result.substring(result.indexOf(" ") + 1, result.length());
		String[] scores = result.split(",");
		
		SortedSet<Integer> set = new TreeSet<Integer>();
		
		for(int i = 0; i < scores.length; i++)
		{
			set.add(Integer.parseInt(scores[i]));
		}
		
		return set;
	}
}
