package Hash;

import java.util.Arrays;
import java.util.HashMap;

public class marathon {  // �������� ���� ����

	public static void main(String[] args) {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		System.out.println(solution(participant, completion));
	}

	private static String solution(String[] participant, String[] completion) {
		String answer = "";
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for (String p : participant) {
			map.put(p, map.getOrDefault(p, 0) + 1);  // getOrDefault(�����;� �ϴ� ����� Ű, ���ε� ���� ���� ��� ��ȯ�Ǿ�� �ϴ� �⺻��) 
		}
		for (String p : completion) {
			map.put(p,  map.get(p) - 1);
		}
		
		for (String key : map.keySet()) {  // map.keySet()
			// System.out.println(String.format("������ : %s, ��: %d", key, map.get(key)));
			if(map.get(key) != 0) {
				answer = key;
			}
		}
		return answer;
	}

}
