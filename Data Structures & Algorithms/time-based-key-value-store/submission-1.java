class TimeMap {
    Map<String,List<Integer>> key_ts;
    Map<String,String> key_val;

    public TimeMap() {
        key_ts=new HashMap<>();
        key_val=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!key_ts.containsKey(key)){
            key_ts.put(key,new ArrayList<>());
        }
        key_ts.get(key).add(timestamp);
        key_val.put(key+"#"+timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        int ts=calculateTs(key,timestamp);
        if(ts==-1){
            return "";
        }
        return key_val.get(key+"#"+ts);
    }

    private int calculateTs(String key,int ts){
      List<Integer> list=key_ts.get(key);
      if(list==null) return -1;
      int start=0,end=list.size()-1;
      int ans=-1;
      while(start<=end){
        int mid=start+(end-start)/2;
        if(list.get(mid)>ts){
            end=mid-1;
        }else{
            ans=list.get(mid);
            start=mid+1;
        }
      }
      return ans;
    }
}
