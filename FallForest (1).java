import java.io.*;
import java.util.Random;

class Branch {
    private int leaves;
    private Branch[] subBranches;
    private static int windStrength = 2; 
    private static Random rand = new Random();

    public Branch(int leaves, int subCount){
        this.leaves = leaves;
        subBranches = new Branch[subCount];
        for(int i = 0; i < subCount; i++){
            // make branch
            subBranches[i] = new Branch(rand.nextInt(3)+1, rand.nextInt(2));
        }
    }

    public void fallLeaves(int level){
        if (leaves <= 0 && subBranches.length == 0) return; // if no leaves and no sub branches stop

        if (leaves > 0){
            // if this branch has leaves
            int fallCount = rand.nextInt(windStrength) + 1;
            for(int i = 0; i < fallCount; i++){
                if (leaves > 0){
                    // if leaf can fall print it
                    System.out.println(" ".repeat(level*2) + "🍂 leaf falls from level " + level);
                    leaves--;
                    try {
                        Thread.sleep(500); // wait
                    } catch (Exception e) {
                        // dont know
                    }
                }
            }
            // if maybe more leaves left call same branch
            fallLeaves(level);
        }

        // do sub branches
        for (Branch b : subBranches){
            b.fallLeaves(level+1);
        }
    }

    public void growLeaves(int level){
        if (leaves >= 3 && subBranches.length == 0){
            return; // if full leaf and no sub branches stop
        }

        int newLeaves = rand.nextInt(3)+1;
        // if growing show new leaves
        System.out.println(" ".repeat(level*2) + " new leaves grow on level " + level + " (" + newLeaves + ")");
        leaves = newLeaves;

        try {
            Thread.sleep(500); // wait
        } catch (InterruptedException e){
            // just ignore it
        }

        // do sub branches
        for (Branch b : subBranches){
            b.growLeaves(level+1);
        }
    }
}

public class FallForest {
    public static void main(String[] args){
        try {
            PrintStream original = System.out;
            PrintStream fileOut = new PrintStream(new FileOutputStream("leaf_fall_log.txt"));
            System.setOut(new PrintStream(new MultiOut(original, fileOut)));

            // start
            System.out.println("The forest prepares for autumn...");
            Branch tree = new Branch(3, 2);
            tree.fallLeaves(0); // if leaves fall
            System.out.println("The forest sleeps for the winter.");

            System.out.println("\n--- spring time ---");
            tree.growLeaves(0); // if leaves grow
            System.out.println("The forest is alive again....");

            System.setOut(original);
            System.out.println("saved to leaf_fall_log.txt");
        } catch (Exception e){
            System.out.println("something went wrong: " + e.getMessage());
        }
    }
}

class MultiOut extends OutputStream {
    private OutputStream[] outs;

    public MultiOut(OutputStream... outs){
        this.outs = outs;
    }

    public void write(int b) throws IOException {
        for(OutputStream o : outs){
            o.write(b);
        }
    }
}

