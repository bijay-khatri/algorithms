/*
Implement a document scanning engine that receives a text document doc and 
returns a list of all unique words in it and their number of occurrences,
sorted by the number of occurrences in descending order.

Example:
for doc: "practice makes perfect. get perfect by practice. just practice!"
the engine returns the list: { practice: 3, perfect: 2,  makes: 1, get: 1, by: 1, just: 1 }.

The engine should ignore punctuation and white-spaces.
Find the minimal runtime complexity and analyze it.

  @author Bijay Khatri
  @since August, 11, 2016
  @version 1.0
 */
import java.util.*;
import java.util.Map.Entry;

public class WordCounter{
   class Wrapper{
   		String key;
   		Integer value;

   		public Wrapper(String key, Integer value){
   			this.key = key;
   			this.value = value;
   		}

   		public String getKey(){
   			return key;
   		}

   		public Integer getValue(){
   			return value;
   		}

   		@Override
   		public String toString(){
   			return "[ " + key + " : " + value + " ]";
   		}
   }

   public static void main(String [] args){
   		WordCounter obj = new WordCounter();
   		String doc ="practice makes perfect. get perfect by practice. just practice and get it done!";
   		
   		List<Wrapper> wrappers = obj.countAll(doc);
   		
   		wrappers.forEach(System.out::println);
   }

   private List<Wrapper> countAll(String doc){
   		if(doc == null) throw new IllegalArgumentException("Invalid String as an Input");

   		if(doc.length() == 0) return null;

   		ArrayList<String> words  = new ArrayList<>(
   			Arrays.asList(doc.replaceAll("[^a-zA-Z]"," ").trim().split("\\s+")));

   		HashMap<String, Integer> map = new HashMap<>();
   		for(String word: words){
   			if(map.get(word) == null){
   				map.put(word, 1);
   			}
   			else{
   				map.put(word, map.get(word) + 1);
   			}
   		}

   		return mapToList(map);
   }

   private List<Wrapper> mapToList(Map<String,Integer> map){
   		List<Wrapper> list = new ArrayList<>();

   		for(Entry<String,Integer> entry : map.entrySet()){
   			list.add(new Wrapper(entry.getKey(), entry.getValue()));
   		}

   	return sort(list);
   }

   private List<Wrapper> sort(List<Wrapper> list){
   		final Comparator<Wrapper> BY_VALUE_DESC = (w1, w2) -> w2.getValue() - w1.getValue();
   		Collections.sort(list, BY_VALUE_DESC);
   		return list;
   }
}