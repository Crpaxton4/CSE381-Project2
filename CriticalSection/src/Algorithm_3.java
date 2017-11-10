
public class Algorithm_3 extends MutualExclusion {
private volatile int turn;
private volatile boolean[] flag = new boolean[2];

public Algorithm_3() {
	flag[0] = false;
	flag[1] = false;
	turn = TURN_0;
}
public void enteringCriticalSection(int t) {
	int other;
	other = 1 - t;
	flag[t] = true;
	turn = other;
	while (flag[other] == true && (turn == other))
		Thread.yield();
}
public void leavingCriticalSection(int t) {
	flag[t] = false;
}
}
