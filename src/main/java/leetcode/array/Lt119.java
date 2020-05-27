class Lt119 {
	public List<Integer> getRow(int rowIndex) {
		if(rowIndex == 0) {
			return Collections.singletonList(1);
		}
		List<Integer> res = new ArrayList();
		res.add(1);
		List<Integer> pre = getRow(rowIndex - 1);
		for(int i=1; i<pre.length; i++) {
			res.add(pre.get(i) + pre.get(i-1));
		}
		res.add(1);
		return res;
    }
}