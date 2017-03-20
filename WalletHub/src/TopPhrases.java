import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TopPhrases {
	private HashMap<String, Integer> phraseCountingMap = new HashMap<>();
	private TreeMap<Integer, ArrayList<String>> reversedCountingMap = new TreeMap<>(Collections.reverseOrder());
	private File file;

	public TopPhrases(String pathToFile) {
		file = new File(pathToFile);
		readFile();
		reverseCounterMap();
	}

	public void readFile() {
		FileReader fReader = null;
		BufferedReader reader = null;
		try {
			fReader = new FileReader(file);
			reader = new BufferedReader(fReader);
			while (true) {
				String line = reader.readLine();
				if (line != null) {
					countPhrases(line);
				} else {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (fReader != null) {
					fReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected void reverseCounterMap() {
		Set<String> phrasesSet = phraseCountingMap.keySet();

		for (String phrase : phrasesSet) {
			if (reversedCountingMap.get(phraseCountingMap.get(phrase)) != null) {
				reversedCountingMap.get(phraseCountingMap.get(phrase)).add(phrase);
			} else {
				ArrayList<String> phrases = new ArrayList<>();
				phrases.add(phrase);
				reversedCountingMap.put(phraseCountingMap.get(phrase), phrases);
			}
		}
	}

	protected void countPhrases(String line) {
		String[] phrases = line.split("\\|");
		for (String phrase : phrases) {
			if (phraseCountingMap.get(phrase) == null) {
				phraseCountingMap.put(phrase, 0);
			} else {
				phraseCountingMap.put(phrase, phraseCountingMap.get(phrase) + 1);
			}
		}
	}

	public ArrayList<String> getTopPhrases(int count) {
		ArrayList<String> results = new ArrayList<>();
		Set<Entry<Integer, ArrayList<String>>> set = reversedCountingMap.entrySet();

		Iterator<Entry<Integer, ArrayList<String>>> it = set.iterator();
		outer: while (it.hasNext()) {
			for (String phrase : it.next().getValue()) {
				if (results.size() < count) {
					results.add(phrase);
				} else {
					break outer;
				}
			}

		}

		return results;
	}

}
