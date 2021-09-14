package com.tests.java8.T07Streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AMain {

	private enum Status {
		OPEN, CLOSED
	};
	
	private static final class Task {
		
		private final Status status;
		private final Integer points;
		
		Task(final Status status, final Integer points) {
			this.status = status;
			this.points = points;
		}
		
		public Integer getPoints() {
			return points;
		}
		
		public Status getStatus() {
			return status;
		}
		
		@Override
		public String toString() {
			return String.format("[%s, %d]", status, points);
		}
	}
	
	public static void main(String[] args) {
		
		final Collection<Task> tasks = Arrays.asList(
				new Task(Status.OPEN, 5),
				new Task(Status.CLOSED, 8),
				new Task(Status.OPEN, 13)
		);
		
		// Calculate total points of all open tasks using sum().
		// Firstly, the tasks collection is converted to its stream representation.
		// Then, the filter operation on stream filters out all OPEN tasks.
		// On next step, the mapToInt operation converts the stream of Tasks to the stream of Integers using Task::getPoints method of the each task instance.
		// And lastly, all points are summed up using sum method, producing the final result.
		final long totalPointsOfOpenTasks = tasks
				.stream()
				.filter(task -> task.getStatus() == Status.OPEN)
				.mapToInt(Task::getPoints)
				.sum();
		
		System.out.println("Total points: " + totalPointsOfOpenTasks); // Total points: 18
		
		
		// Calculate total points of all tasks.
		// To process all the tasks in parallel and calculate the final result using reduce method.
		final double totalPoints = tasks
				.stream()
				.parallel()
				.map(task -> task.getPoints()) // or map(Task::getPoints)
				.reduce(0, Integer::sum);
		
		System.out.println("Total points (all tasks): " + totalPoints); // Total points (all tasks): 26.0
		
		
		// Often, there is a need to performing a grouping of the collection elements by some criteria.
		// Group tasks by their status.
		final Map<Status, List<Task>> map = tasks
				.stream()
				.collect(Collectors.groupingBy(Task::getStatus));
		
		System.out.println(map); // {OPEN=[[OPEN, 5], [OPEN, 13]], CLOSED=[[CLOSED, 8]]}
		
		
		// Calculate the weight of each tasks (as percent of total points).
		final Collection<String> result = tasks
				.stream() // Stream<String>
				.mapToInt(Task::getPoints) // IntStream
				.asLongStream() // LongStream
				.mapToDouble(points -> points / totalPoints) // DoubleStream
				.boxed() // Stream<Double>
				.mapToLong(weigth -> (long)(weigth * 100)) // LongStream
				.mapToObj(percentage -> percentage + "%") // Stream<String>
				.collect(Collectors.toList()); // List<String>
		
		System.out.println(result); // [19%, 30%, 50%]
	}
}