package com.root.Array;

import com.root.common.Interval;
import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.

 Example 1:

 Input: [[0, 30],[5, 10],[15, 20]]
 Output: 2
 Example 2:

 Input: [[7,10],[2,4]]
 Output: 1
 */

public class MeetingRoom {

  /** meetingRoom II
   * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
   * find the minimum number of conference rooms required.

   Example 1:

   Input: [[0, 30],[5, 10],[15, 20]]
   Output: 2
   Example 2:

   Input: [[7,10],[2,4]]
   Output: 1
   */

  /*
    Just add the meeting room to the queue, if no overlap, poll it and add the next meeting. Whenever there's an overlap,
    add the next meeting to create an additional room. Finally, just return the size of the priority queue for the total
    # of meeting rooms.
  */
  public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }

    Arrays.sort(intervals, (a, b) -> a.start - b.start );
    PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
    pq.offer(intervals[0]);

    for (int i=1; i<intervals.length; i++) {
      if (intervals[i].start >= pq.peek().end) {
        pq.poll();
      }
      pq.offer(intervals[i]);
    }

    return pq.size();
  }

}

