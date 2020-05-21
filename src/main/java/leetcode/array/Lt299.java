class Lt299{
    public String getHint(String secret, String guess) {
		int A = 0;
		int[] mapS = new int[10];
		int[] mapG = new int[10];
		for(int i=0; i<secret.length(); i++) {
			if(secret.charAt(i) == guess.charAt(i)) {
				A++;
			} else {
				mapG[guess.charAt(i) - '0']++;
				mapS[secret.charAt(i) - '0']++;
			}
		}
		
		int B = 0;
		for(int i=0; i<mapG.length; i++) {
			B += Math.min(mapG[i], mapS[i]);
		}
		
		return A + "A" + B + "B";
    }	
}