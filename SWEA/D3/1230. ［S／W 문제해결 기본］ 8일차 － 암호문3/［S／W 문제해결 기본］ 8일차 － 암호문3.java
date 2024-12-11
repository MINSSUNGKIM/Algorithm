import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			MyLinkedList<Integer> password = new MyLinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				password.addLast(Integer.parseInt(st.nextToken()));
			}

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {

				String command = st.nextToken();
				int x = 0;
				int y = 0;
				int s = 0;
				Node<Integer> current = null;
				Node<Integer> nextNode = null;
				switch (command) {
				case "I":
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());

					MyLinkedList<Integer> newNodes = new MyLinkedList<>();
					for (int j = 0; j < y; j++) {
						s = Integer.parseInt(st.nextToken());
						newNodes.addLast(s);
					}

					if (x == 0) {
						// 맨 앞에 삽입
						newNodes.last.next = password.first;
						password.first.prev = newNodes.last;
						password.first = newNodes.first;
					} else if (x == password.size()) {
						// 맨 뒤에 삽입
						password.last.next = newNodes.first;
						newNodes.first.prev = password.last;
						password.last = newNodes.last;
					} else {
						// 중간 삽입
						current = password.get(x - 1);
						nextNode = current.next;

						current.next = newNodes.first;
						newNodes.first.prev = current;

						newNodes.last.next = nextNode;
						if (nextNode != null) {
							nextNode.prev = newNodes.last;
						}
					}
					password.setSize(password.size + y);

					break;
					
				case "D":
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());

					current = password.get(x);

					for (int j = 0; j < y; j++) {
						current = current.next;
					}

					password.get(x - 1).next = current;
					current.prev = password.get(x - 1);
					
					password.setSize(password.size - y);
					break;
					
				case "A":

					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						s = Integer.parseInt(st.nextToken());
						password.addLast(s);
					}

					break;
				}

			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);

			for (int i = 0; i < 10; i++) {
				sb.append(" ").append(password.get(i).data);
			}

			System.out.println(sb.toString());

		}

		br.close();

	}

}

class Node<T> {
	Node<T> prev;
	T data;
	Node<T> next;

	public Node(Node<T> prev, T data, Node<T> next) {
		this.prev = prev;
		this.data = data;
		this.next = next;
	}

}

class MyLinkedList<T> {

	// 전역에서 사용될 변수
	int size = 0;
	Node<T> first;
	Node<T> last;

	// 1. 기본 생성자
	public MyLinkedList() {
	}
	// Get

	public Node<T> get(int index) {

		if (index < size / 2) {
			Node<T> x = first;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}
			return x;
		} else {
			Node<T> x = last;
			for (int i = size - 1; i > index; i--) {
				x = x.prev;
			}
			return x;
		}

	}

	// Add
	// 1. `addFirst(E element)` - 맨 앞에 추가
	// 2. `addLast(E element)` - 맨 뒤에 추가
	// 3. `add(int index, E element)` - 지정 위치에 추가

	public void addFirst(T data) {
		Node<T> f = first;
		Node<T> newNode = new Node<>(null, data, f);
		first = newNode;

		// first 나 last 가 null인 상태였다면
		if (f == null)
			last = newNode;
		else
			f.prev = newNode;

		size++;
	}

	public void addLast(T data) {
		Node<T> l = last;
		Node<T> newNode = new Node<>(l, data, null);
		last = newNode;

		// 기존에 null 상태였다면
		if (l == null)
			first = newNode;
		else
			l.next = newNode;

		size++;

	}

	public void add(int index, T data) {

		// index 유효성 검사
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException();

		if (index == size) {
			addLast(data);
		} else if (index == 0) {
			addFirst(data);
		} else {

			Node<T> target = get(index);
			Node<T> newNode = new Node<>(target.prev, data, target);
			target.prev.next = newNode;
			target.prev = newNode;
			size++;

		}

	}

	// Remove
	// 1. `removeFirst()` - 첫 노드 삭제
	// 2. `removeLast()` - 마지막 노드 삭제
	// 3. `remove(int index)` - 인덱스로 삭제
	// 4. `remove(Object o)` - 특정 값을 가진 첫 노드 삭제 ( 커스텀 해도 좋음)

	public void removeFirst() {
		// 유효성 검사
		if (size == 0)
			throw new NoSuchElementException();

		Node<T> f = first;
		first = f.next;
		f.data = null;
		f.next = null;

		// 요소가 한개 남았었다면
		if (first != null)
			first.prev = null;
		else
			last = null;

		size--;
	}

	public void removeLast() {
		// 유효성 검사
		if (size == 0)
			throw new NoSuchElementException();
		Node<T> l = last;

		last = l.prev;

		l.data = null;
		l.prev = null;

		if (last != null)
			last.next = null;
		else
			first = null;

		size--;
	}

	public void remove(int index) {

		// index 유효성 검사
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException();

		if (index == size - 1) {
			removeLast();
		} else if (index == 0) {
			removeFirst();
		} else {
			Node<T> target = get(index);

			target.prev.next = target.next;
			target.next.prev = target.prev;

			target.next = null;
			target.prev = null;
			target.data = null;
			size--;
		}

	}

	// 특정 오브젝트를 가진 모든 노드를 한번에 삭제 + 해당 노드 개수 반환
	public int remove(T data) {

		Node<T> current = first;
		int cnt = 0;

		while (current != null) {
			// 다음노드 미리 저장해두기. 저장 안해두면 nullpointerException 발생 가능성 있음
			Node<T> nextNode = current.next;

			// current의 데이터와, 삭제하려는 data 가 일치할 때
			if ((data == null && current.data == null) || (data != null && data.equals(current.data))) {

				if (current == first) {
					removeFirst();
				} else if (current == last) {
					removeLast();
				} else {
					current.prev.next = current.next;
					current.next.prev = current.prev;

					current.data = null;
					current.next = null;
					current.prev = null;

					size--;

				}

				cnt++;

			}

			current = nextNode;

		}

		return cnt;
	}

	// contains -> 가지고있는 data 의 개수만큼 return
	public int contains(T data) {
		Node<T> current = first;
		int cnt = 0;

		while (current != null) {
			if ((data == null && current.data == null) || (data != null && data.equals(current.data))) {
				cnt++;
			}
			current = current.next;
		}
		return cnt;
	}

	// size
	public int size() {
		return size;
	}

	// clear

	public void clear() {
		for (Node<T> x = first; x != null;) {
			Node<T> next = x.next;
			x.prev = null;
			x.next = null;
			x.data = null;
			x = next;
		}

		first = null;
		last = null;
		size = 0;
	}

	@Override
	public String toString() {
		if (size == 0) {
			return "[]";
		}

		StringBuilder sb = new StringBuilder();
		sb.append('[');

		Node<T> current = first;
		while (current != null) {
			sb.append(current.data);
			if (current.next != null) {
				sb.append(", ");
			}
			current = current.next;
		}

		sb.append(']');
		return sb.toString();
	}

	public void setSize(int size) {
		this.size = size;
	}
}