package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BestAlbum {  // ����Ʈ �ٹ�

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};

		System.out.println(solution(genres, plays));
	}

	private static int[] solution(String[] genres, int[] plays) {
		// 1. ���� �뷡�� ���� ���� �帣
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < genres.length; i++) {
			String genre = genres[i];
			map.put(genre, map.getOrDefault(genre, 0) + plays[i]);
		}

		// Ȯ��
		System.out.println("====================1=====================");
		for (String key : map.keySet()) {
			System.out.println(String.format("�帣�� : %s, ���Ƚ��: %d", key, map.get(key)));
		}System.out.println();

		List<String> listKeySet = new ArrayList<>(map.keySet());
		
		// �������� ����
		Collections.sort(listKeySet, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
		// Ȯ��
		System.out.println("====================2=====================");
		for(String key : listKeySet) {
			System.out.println("key : " + key + " , " + "value : " + map.get(key)); 
		}System.out.println();
		
		
		// 2. ���  Ƚ���� ���� ���� �뷡
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < listKeySet.size(); i++) {
			String genre = listKeySet.get(i);
			// ù��°
			int max = 0;
			int first = -1;
			for (int j = 0; j < genres.length; j++) {
				if(genre.equals(genres[j]) && max < plays[j] && j != first) {
					max = plays[j];
					first = j;
				}
			}
			// �ι�°
			max = 0;
			int second = -1;
			for (int j = 0; j < genres.length; j++) {
				if(genre.equals(genres[j]) && max < plays[j] && j != first) {
					max = plays[j];
					second = j;
				}
			}
			
			list.add(first);
			// �� �帣�� �Ѱ ���� ��쿡�� �ι�° �� �߰� x
			if(second != -1) {
				list.add(second);
			}			
		}
		
		int[] result = new int[list.size()];
		for (int j = 0; j < list.size(); j++) {
			result[j] = list.get(j);
		}
		
		System.out.println(Arrays.toString(result));
		return result;
	}

}
