class SnapshotArray {

    //recording: 27th june Hashing 5 time(2:30:00)
	//TC: O()  SC: O(N) 

	HashMap<Integer, Integer>[] HashMapArray;
	int snapID;
    
    public SnapshotArray(int length) {
        HashMapArray = new HashMap[length];
		snapID = 0;
    }
    
    
    public void set(int index, int val) {
        if(HashMapArray[index] == null)
			HashMapArray[index] = new HashMap<>();

		HashMapArray[index].put(snapID, val);
    }
    
    
    public int snap() {
        snapID++;
		return snapID-1;
    }
    
    
    public int get(int index, int snap_id) {
        if(HashMapArray[index] == null)
			return 0;

		while(snap_id >= 0 && HashMapArray[index].containsKey(snap_id) == false)
			snap_id--;

		//if HashMapArray has snap_id's starting from 3,
		//and if given snap_id=2, then we can never have the last 
		//updated val of the index. In such case snap_id will become -1
		if(snap_id == -1)
			return 0;
		
		return HashMapArray[index].get(snap_id);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */