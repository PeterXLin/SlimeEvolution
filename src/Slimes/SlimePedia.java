package Slimes;

public  class SlimePedia {
	static private boolean[] pedia = new boolean[16];
	
	public static boolean getIndex(int a) {
		return pedia[a];
	}
	public static void setIndex(int a, boolean set) {
		pedia[a] = set;
	}
	
	public static int ownAmount() {
		int amount = 0;
		for(int i=0;i<16;i++) {
			if(pedia[i]) {
				amount++;
			}
		}
		return amount;
	}
}
