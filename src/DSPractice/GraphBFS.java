package DSPractice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
	private static HashMap<Person, Person[]> adjList = new HashMap<Person, Person[]>();

	GraphBFS(HashMap<Person, Person[]> adjList) {
		this.adjList = adjList;
	}

	public static void bfs(Person source) {
		Queue<Person> q = new LinkedList<Person>();
		q.add(source);
		source.setVisited(true);
		while (!q.isEmpty()) {
			Person currentPerson = q.remove();
			Person[] friends = adjList.get(currentPerson);
			for (Person p : friends) {
				if (!p.isVisited()) {
					p.setDistance(currentPerson.getDistance() + 1);
					p.setLastFriend(currentPerson.getName());
					currentPerson.setVisited(true);
					q.add(p);
				}
			}

		}

	}

	public static void main(String[] args) {
		HashMap<Person, Person[]> map = new HashMap<Person, Person[]>();

		Person kami = new Person("Kami", 0, null);
		Person mim = new Person("Mim", 0, null);
		Person junaid = new Person("Junaid", 0, null);
		Person shan = new Person("Shan", 0, null);
		Person mo = new Person("Mo", 0, null);
		Person luis = new Person("Luis", 0, null);
		Person sohail = new Person("Sohail", 0, null);
		Person jerry = new Person("Jerry", 0, null);

		map.put(kami, new Person[] { mim });
		map.put(mim, new Person[] { kami, mo, luis });
		map.put(junaid, new Person[] { shan, mo });
		map.put(shan, new Person[] { junaid, sohail });
		map.put(mo, new Person[] { mim, junaid });
		map.put(luis, new Person[] { mim, sohail });
		map.put(sohail, new Person[] { shan, luis });
		map.put(jerry, new Person[] {});

		GraphBFS.bfs(shan);
		
		System.out.println(kami.getDistance() + " " + kami.getLastFriend());
		System.out.println(mim.getDistance() + " " + mim.getLastFriend());
		System.out.println(junaid.getDistance() + " " + junaid.getLastFriend());
		System.out.println(shan.getDistance() + " " + shan.getLastFriend());
		System.out.println(mo.getDistance() + " " + mo.getLastFriend());
		System.out.println(luis.getDistance() + " " + luis.getLastFriend());
		System.out.println(sohail.getDistance() + " " + sohail.getLastFriend());
		System.out.println(jerry.getDistance() + " " + jerry.getLastFriend());		

	}

}

class Person {
	String name;
	int distance = 0;
	String lastFriend;
	boolean visited;

	Person(String s, int d, String l) {
		this.name = s;
		this.distance = d;
		this.lastFriend = l;
		this.visited = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getLastFriend() {
		return lastFriend;
	}

	public void setLastFriend(String lastFriend) {
		this.lastFriend = lastFriend;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}
