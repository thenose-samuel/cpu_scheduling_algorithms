import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class FCFS {
    public static void printProcesses(Process[] processes){
        System.out.println("ProcessId\tArrival Time\tBurstTime");
        for (int i = 0; i < processes.length; i++){
            System.out.println(i+"\t\t\t"+processes[i].arrivalTime+"\t\t\t\t"+processes[i].burstTime);
        }
        System.out.println("***************************************");
    }

    public static void fcfs(Process[] processes){
        System.out.println("Received Processes :");
        printProcesses(processes);
        PriorityQueue<Process> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.arrivalTime > o2.arrivalTime) {
                return 1;
            } else if (o1.arrivalTime < o2.arrivalTime) {
                return -1;
            }
            return 0;
        });
        queue.addAll(Arrays.asList(processes));
        int time = queue.peek().arrivalTime;
        int currIndex = 0;
        //       int[] waitingTimes = new int[queue.size()];
//        Iterator<Process> iter = queue.iterator();
        System.out.println("According to FCFS scheduling algorithm the processes will run as follows:");
        System.out.println("ProcessId\tArrival Time\tBurstTime\tWaiting Time");
        while (queue.peek() != null){
            Process currentProcess = queue.poll();
            time = time + currentProcess.burstTime;
            int turnaround = time - currentProcess.arrivalTime;
            int waitingTime = turnaround - currentProcess.burstTime;
            System.out.println(currIndex+"\t\t\t"+currentProcess.arrivalTime+"\t\t\t\t"+currentProcess.burstTime+"\t\t\t\t"+waitingTime);
            currIndex++;
        }
    }
    public static void main(String args[]){
        //Creating an array of the Processes with random arrival and Burst time
        Process[] processes = new Process[3];
        for (int i = 0;  i < 3; i++){
            //Assigning a random arrival and burst time to the processes
            int arrivalTime = (int) ( Math.random() * ( 10 - 1 + 1 ) )+ 1;
            int burstTime = (int) ( Math.random() * ( 10 - 1 + 1 ) )+ 1;
            processes[i] = new Process(arrivalTime, burstTime);
        }
        fcfs(processes);
    }
}

class Process {
    public int processId;
    public int arrivalTime;
    public int burstTime;
    Process(int arrivalTime, int burstTime){
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }

}
