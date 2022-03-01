package Hash;

import java.util.HashMap;

public class camouflage { // ����

	public static void main(String[] args) {
		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		System.out.println(solution(clothes));
	}

	private static int solution(String[][] clothes) {
		// int answer = 0;

		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < clothes.length; i++) {
			String t = clothes[i][1];
			map.put(t,  map.getOrDefault(t, 1) + 1);  // ������ ������������ ���ļ� 1���� ����
		}
		
		// Ȯ��
		for (String key : map.keySet()) {  
			System.out.println(String.format("Ÿ�� : %s, ��: %d", key, map.get(key)));
		}
		
		int answer = 1;
		// ������ �� ���ϱ�
		for (int cnt : map.values()) {
			answer *= cnt;
		}
		
		answer -= 1;  // ��� ����x
		
		return answer;
	}

}
