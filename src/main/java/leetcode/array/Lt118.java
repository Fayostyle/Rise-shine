class Lt118{
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList();
		if(numRows == 0) {
			return res;
		}
		res.add(new ArrayList());
		res.get(0).add(1);
		
		for(int i=1; i<numRows; i++) {
			List<Integer> inner = new ArrayList();
			List<Integer> pre = res.get(i-1);
			inner.add(1);
			for(int j=1; j<i; j++) {
				inner.add(pre.get(j-1) + pre.get(j));
			}
			inner.add(1);
			res.add(inner);
		}
		
		return res;
	}
}