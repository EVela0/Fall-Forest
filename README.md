# Fall-Forest

The mentality I had to build the program FallForest, was to break down how a real tree changes with the seasons. I thought about how each branch can lose leaves and then regrow them, and how wind might make multiple leaves fall at once. I wanted the logic to look like nature repeating itself, so recursion made sense. I planned the order of actions first so nothing would break and each step made sense. Recursion makes small changes travel through the whole structure. When one branch runs fallLeaves() that same method get called again for every smaller branch. Thats how a single command can make the whole forest lose its leaves. You can see recursion in nature like rivers how it repeats the same pattern at smaller scales. This code shows how nature works in seasons. In fall leaves fall one by one until nothing is left. Then in spring growLeaves() brings everything back. The program repeat the same action across every branch showing how natural patterns echo themselves in smaller parts. I learned that recursion is like showing natures rhythm small parts acting like the whole all connected simple but powerfull.

Import java.io.*
Import java.util.Random

Create class Branch

Variables:
int leaves
Branch[] subBranches
static int windStrength = 2
Random rand = new Random()

Constructor: Branch(int leaves, int subCount)
Creates subBranches array with the given size
For each subBranch → new Branch with random number of leaves (1–3) and subBranch count (0–1)

Method: fallLeaves(int level)

If branch has no leaves and no subBranches → stop (base case)

If branch has leaves →

Output: “🍂 leaf falls from level (level)”

Subtract one leaf for each leaf that falls
Use Thread.sleep(500) for animation delay
Recursively call fallLeaves(level) on the same branch if leaves remain

After finishing the current branch →
For each subBranch → call fallLeaves(level + 1)
This lets the process continue through the smaller branches

Method: growLeaves(int level)

If branch already has 3 leaves and no subBranches → stop (base case)

Generate random number of new leaves (1–3)
Output: “🌱 new leaves grow on level (level)”
Use Thread.sleep(500) for animation
For each subBranch → call growLeaves(level + 1)
This spreads the regrowth through the entire tree

Create public class FallForest

Main Method:

Try creating new PrintStream to write to “leaf_fall_log.txt” so both screen and file show same text

Output: “The forest prepares for autumn...”

Create new Branch tree = new Branch(3, 2)

Call tree.fallLeaves(0)

Output: “The forest sleeps for winter.”

Output: “--- spring time ---”

Call tree.growLeaves(0)

Output: “The forest is alive again!”

Output: “log saved to leaf_fall_log.txt”

Close PrintStream

Create class MultiOut extends OutputStream

Takes multiple OutputStreams (console + file)
Writes every output to both places at once
