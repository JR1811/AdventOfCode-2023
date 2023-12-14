
# Advent of Code 2023

My attempts at solving AoC-2023 problems with Java. For more information check out the official website at: https://adventofcode.com/2023

## Notice

This project has been put on hold due to other projects which have a bigger priority right now. I plan to come back to those exercises eventually.

## Goals

- Commit to the whole thing. Don't stop doing them halfway through.
- Use OOP Design Patterns more consciously, if needed.
- Make use of "Unit-Tests" and potentially realize, why they are useful.
- Have fun!

![ramlethal-valentine](https://media.tenor.com/5OasumneRNIAAAAM/smile-ramlethal.gif)

## Thoughts

### Day 01

Part one was done easily. It was only some simple string handling. The second part took me a bit longer since some hidden edge cases, like intersecting numbers, were made using the `replace` method of String unviable. Ultimately, I went for a simple map of the alphabetical number and a list of only the digits in the string and let them compare their indexes to get the first and last viable number.

If the difficulty of those exercises keeps being on that level, it might be a bit harder this year compared to the last ones...

![heavy-scared](https://i.redd.it/s55qwl1xgn3c1.jpg)

### Day 02

Today wasn't as difficult as yesterday. The only problem here was the repeated nesting of elements. I could've done a way better job cleaning up the code but I wanted to finish this day in less than 24 hours. Maybe I will clean up this mess at a later day. 

I also felt like I had a proper use for the unit testing. I set up the test from the start but with the smaller example data where the expected value was already given. After using that I could easily test if my code did, what it was supposed to do, 
even if I used the actual data, where I had no expected result yet.

![nesting-joker](https://github.com/JR1811/AdventOfCode-2023/assets/36027822/bc820a94-06c3-4c6e-9d32-97358d353f28)
