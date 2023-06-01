package com.sonic.process;

import java.util.*;

public class DrawBox<Item> {
	List<Item> items;
	Random random;
	
	public DrawBox() {
		items = new ArrayList<Item>();
		random = new Random();
	}
	
	public boolean isEmpty() {
		return items.isEmpty();
	}
	
	public int getSize() {
		return items.size();
	}
	
	public void add(Item item) {
		items.add(item);
	}
	
	public void add(List<Item> item) {
		items.addAll(item);
	}
	
	public void suffle() {
		if (!isEmpty()) {
			int size = getSize();
			int iRandom = 0;
			for (int i = 0; i < size; i++) {
				iRandom = random.nextInt(size);
				swap(i, iRandom);
			}
		}
	}
	
	public Item get() {
		if (!isEmpty()) {
			int size = getSize();
			int iRandom = random.nextInt(size);
			return items.get(iRandom);
		}
		else return null;
	}
	
	public Item peek() {
		if (!isEmpty()) {
			int size = getSize();
			int iRandom = random.nextInt(size);
			Item item = items.get(iRandom);
			items.remove(iRandom);
			return item;
		}
		else return null;
	}
	
	public void clear() {
		items.clear();
	}
	
	private void swap(int index1, int index2) {
		Item temp = items.get(index1);
		items.set(index1, items.get(index2)); 
		items.set(index2, temp);
	}
}
