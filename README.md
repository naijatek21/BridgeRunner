# ScalaCompProblem

## Problem Summary 
  The situation presented is that of a team of hikers crossing a series of bridges. Each hiker jhas a unique ID and speed while hiking and each bridge has a **length**  can only hold two hikers at a time,  and along their trek the group may encounter additional hikers. We want to return:
    - Per Bridge results (length, number of hikers, ID of hikers, total time taken)
    - Total time taken to cross all bridges
 

 ## Methodology
   Given the problem paremeters, the approach for the bridge crsosing is the following premise: The Hiker with the fastest speed is the torchbearer and makes consecutive runs back and forth on the bridge until the whole party is across, minimizing the time of the walk back to the beginning of the bridge. Hence it would make the most sense to implement a Max-Heap representation giving priority to the hiker with the greatest speed. In terms of the bridges, because they follow some specific order relative to one another, we could use a singly linked list setup so that we could simulate each bridge crossing. 

   In the senario where there is an additional hiker at the end of the bridge,if the new hiker's speed is faster than the torchbearer, than they become the torch bearer and continues in the algorithm .



  ## Testing Strategy
    In terms of testing, there are key scenarios we have to check in order to adequately work out everycase of this problem:
      -When there is one hiker, one bridge, and no additional hikers
      -When there is one hiker, one bridge, and an additional hiker
      -When there is multiple hikers, and one bridge.
      -When it starts off with one Hiker and an additional hiker is added at every bridge
      -When there are multiple hikers and multiple bridges
      

  