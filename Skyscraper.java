package Solution1;

import java.util.*;

public class Skyscraper {
	Stack<Integer> building = new Stack<>();
	Stack<Integer> tempStack = new Stack<>();
	static int count;

	public void AssembleFloor(List<Integer> floorsList) {
		List<Integer> sortedList = new ArrayList<Integer>();

		// sorting the list of floor
		for (int i = 0; i < floorsList.size(); i++) {
			sortedList.add(floorsList.get(i));
		}

		sortedList.sort(null);

		// storing the floor list in main Stack -- push elements (retrieving descending
		// order of floors)
		for (int i : sortedList) {
			building.push(i);
		}

		System.out.println("\nOrder of construction is as follows\n");

		// storing the floor elements in temporary stack till maximum floor size is
		// reached
		// popping the possible traversed floor elements
		for (int floor : floorsList) {
			System.out.println("Day: " + (++count));

			if (floor != building.peek()) {
				tempStack.push(floor); // push elements in temporary stack & sort
				tempStack.sort(null);
			} else {
				System.out.print(building.pop() + " ");

				while (!tempStack.isEmpty() && tempStack.peek().equals(building.peek())) {
					tempStack.pop();
					System.out.print(building.pop() + " "); // pop elements from both stacks if floor is present in
					// temporary stack
				}
			}

			System.out.println();
		}
	}

}
