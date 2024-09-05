import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class RoboSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {

        HashMap<Integer, PriorityQueue<Integer>> x_map = new HashMap<>();
        HashMap<Integer, PriorityQueue<Integer>> y_map = new HashMap<>();

        for (int[] obstacle : obstacles) {
            int x = obstacle[0];
            int y = obstacle[1];

            // Add to x_map
            x_map.putIfAbsent(y, new PriorityQueue<>());
            x_map.get(y).add(x);

            // Add to y_map
            y_map.putIfAbsent(x, new PriorityQueue<>());
            y_map.get(x).add(y);
        }

        int[] posi = {0, 0};
        int dir = 0;
        boolean gotObs = false;
        int maxDis = Integer.MIN_VALUE;

        for (int command : commands) {
            if (command == -1) {
                dir++;
                if (dir > 3) dir = 0;
            } else if (command == -2) {
                dir--;
                if (dir < 0) dir = 3;
            } else {

                switch (dir) {
                    case 0:
                        gotObs = false;
                        if (y_map.containsKey(posi[0]))
                            for (int t : y_map.get(posi[0])) {
                                if (t < posi[1] + command && posi[1] < t) {
                                    posi[1] = t - 1;
                                    gotObs = true;
                                    break;
                                }
                            }
                        if (!gotObs)
                            posi[1] += command;
                        break;

                    case 1:
                        gotObs = false;
                        if (x_map.containsKey(posi[1]))
                            for (int t : x_map.get(posi[1])) {
                                if (t < posi[0] + command && posi[0] < t) {
                                    posi[0] = t - 1;
                                    gotObs = true;
                                    break;
                                }
                            }
                        if (!gotObs)
                            posi[0] += command;
                        break;
                    case 2:
                        gotObs = false;
                        if (y_map.containsKey(posi[0]))
                            for (int t : y_map.get(posi[0])) {
                                if (t > posi[1] - command && posi[1] > t) {
                                    posi[1] = t + 1;
                                    gotObs = true;
                                    break;
                                }
                            }
                        if (!gotObs)
                            posi[1] -= command;
                        break;
                    case 3:
                        gotObs = false;
                        if (x_map.containsKey(posi[1]))
                            for (int t : x_map.get(posi[1])) {
                                if (t > posi[0] - command && posi[0] > t) {
                                    posi[0] = t + 1;
                                    gotObs = true;
                                    break;
                                }
                            }
                        if (!gotObs)
                            posi[0] -= command;
                        break;
                }
                maxDis = Math.max(maxDis,getDis(posi));
            }
        }
        return maxDis;
    }

    private int getDis(int[] posi){
        return posi[0] * posi[0] + posi[1] * posi[1];
    }


    public static void main(String[] args) {
        int[] cmd = {6,-1,-1,6};
        int[][] obs = {};

        RoboSimulation obj = new RoboSimulation();

        System.out.println(obj.robotSim(cmd, obs));

    }
}
