package com.mridul.birla.codinginterview;


public class CustomHashMap {
	
	static int size=100;
	Entry hashtable[]= new Entry[100];
	
	private class Entry{
		String key;
		String value;
		Entry next;
		
		Entry(String k, String v){
			key=k;
			value=v;		
		}
		public String getValue(){
			return value;
		}
		public String getKey(){
			return key;
		}
		
	}
	
	public void put(String key,String val){
		
		int hashcd= key.hashCode()%size;
		Entry e= hashtable[hashcd];
		Entry lastEntry=null;
		if(e!=null){
			while(e!=null){
				lastEntry=e;
				e=e.next;
			}
			Entry newEntry= new Entry(key,val);
			lastEntry.next=newEntry;
		}else{
			Entry newEntry= new Entry(key,val);
			hashtable[hashcd]=newEntry;
		}
		
		
	}
	
	public String get(String key){
		
		int hashcd= key.hashCode()%size;
		Entry e= hashtable[hashcd];
		if(e!=null){
			while(e!=null){
				if (e.getKey()==key)
					return e.getValue();
			}
			return null;
		}else
			return null;
		
	}
	public static void main(String args[]){
		
		CustomHashMap tHashMap= new CustomHashMap();
		
		tHashMap.put("123","Mridul");
		tHashMap.put("246","Birla");
		System.out.println(tHashMap.get("24w6"));
		
		
	}
}
