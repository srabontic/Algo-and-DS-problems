/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author srabo
 */
public class LRUCache {

    //store each data
    class record{
        int key;
        int value;
        record prev;
        record next;
        record(int x, int y){
            key = x;
            value = y;
        }        
        private record() {
            key =0;
            value =0;
        }
    }
    //data structure of LRU Cache
    Map<Integer, record> map;
    int cap;
    int size;
    record head, tail;
    public LRUCache(int capacity) {
        map = new HashMap<Integer, record>();
        cap = capacity; 
        size = 0;
        head = new record();
        tail = new record();
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        int value =0;
        if (!map.containsKey(key)){
            return -1;
        }else{
            value = map.get(key).value;
        }
        update(map.get(key));
        return value;
    }
    
    public void put(int key, int value) {
        //if capacity = size remove least used
        //the add the new one
        
        record node = map.get(key);
        if (node == null){ //no such record in cache
            node = new record(key, value);
            map.put(key, node);
            add(node);
            size++;
        } else{
            node.value = value;
            update(node);
        } 
        if (size == cap){
            remove (tail.prev);
            map.remove(tail.prev.key);
            size--;
        }
    }
    
    //remove the node from list which has been added to the beginning because of priority
    private void remove(record r) {
        record temp1 = r.next;
        record temp2 = r.prev;
        temp1.prev = temp2;
        temp2.next = temp1;
    }

    //add at the beginning of the list
    private void add(record r) {
        record temp = head.next;
        head.next = r;
        r.next = temp;
        temp.prev = r;
        r.prev = head;
    }

    private void update(record r) {
        remove(r);
        add(r);
       
    }
    public static void main(String[] args) {
        // TODO code application logic here
        LRUCache cache = new LRUCache( 2 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        //cache.get(4);       // returns 4
        System.out.println(cache.get(4));
    }
    
}
