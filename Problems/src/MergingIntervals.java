import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class MergingIntervals {

	public class Interval {
		private int startTime;
		private int endTime;

		public Interval(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		public int startTime() {
			return startTime;
		}
		
		public int endTime() {
			return endTime;
		}
		
		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}
		
		public String toString() {
			return startTime+":"+endTime;
		}
	}

	private class IntervalComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval arg1, Interval arg2) {
			return arg1.startTime() - arg2.startTime();
		}
	}
	
	public void merge(Interval []all) {			
		Arrays.sort(all, new IntervalComparator());
		System.out.println(Arrays.toString(all));	
		Interval previous = all[0];
		for(int i=1; i < all.length; i++) {
			Interval current = all[i];
			if(current.startTime() < previous.endTime() && current.endTime() > previous.endTime()) {
				previous.setEndTime(current.endTime());
			}
			else if (current.startTime() < previous.endTime())	{
				//no need to merge with previous interval, as previous includes current completely
			}
			else {
				System.out.print(previous+", ");
				previous = current;
			}			
		}
		System.out.println(previous);
	}
	
	public static void main(String[] args) {
		MergingIntervals merger = new MergingIntervals();
		
		Interval []all = {merger.new Interval(2,4),  merger.new Interval(1,3), merger.new Interval(5, 7), merger.new Interval(6, 8)};
		merger.merge(all);
		
		Interval []other = {merger.new Interval(6, 8),  merger.new Interval(1, 9), merger.new Interval(2, 4), merger.new Interval(4, 7)};
		merger.merge(other);
	}

}
