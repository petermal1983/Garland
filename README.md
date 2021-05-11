# Garland
Solution of the algorithmic task "Garland" in Java

Garland

Input file name: input.txt Output file name: output.txt Time limit: 2 seconds Memory limit: 256 megabytes A garland consists of n bulbs on a common wire. One end of it is fixed at a given height A mm (h(1)=A). Due to gravity the garland sags: the height of each non-end lamp is 1 mm less than the average height of the nearest neighbors (h(i)=(h(i-1)+h(i+1))/2-1 for 1<i<N). Find the minimum height of the second end B (B=h(n)) provided that only one bulb can touch the ground, and for the others the condition h(i)>0 is satisfied.

Hint: you can use binary search to solve this task (dichotomy method).

Garland Input file format The first line of the input file contains two numbers n and A (3≤n≤1000, n is an integer, 10≤A≤1000, A is real and given with no more than three decimal places).
