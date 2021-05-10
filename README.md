# ScalaCompProblem

## Problem Summary 
  The situation presented is that of a team of hikers crossing a series of bridges. Each hiker jhas a unique ID and speed while hiking and each bridge has a **length**  can only hold two hikers at a time,  and along their trek the group may encounter additional hikers. We want to return:
    - Per Bridge results (length, number of hikers, ID of hikers, total time taken)
    - Total time taken to cross all bridges
 

 ## Methodology
   Given the problem paremeters the approach for the bridge crsosing is the following premise: The Hiker with the fastest speed is the torchbearer and makes consecutive runs back and forth on the bridge until the whole party is across, minimizing the time of the walk back to the beginning of the bridge. Hence it would make the most sense to implement a Max-Heap representation giving priority to the hiker eith the greatest speed. 
   In the senario where there is an additional hiker at the end of the bridge,if the new hiker's speed is faster than the torchbearer, than they become the torch bearer and continues in the algorithm .
 ### Bridge Class
    A bridge will be classified by three parameters: an identifying name, its length, and the as additional hiker at the beginning of the bridge to be picked up by the group.
 -**getTravelTime()**:
    returns the total travel time taken across the bridge by the group, which in this scenario is the 
        **bridge length / (speed of slowest hiker)** 
        

  