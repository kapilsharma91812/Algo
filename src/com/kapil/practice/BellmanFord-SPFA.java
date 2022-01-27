//Improved Bellman-Ford Algorithm with Queue — SPFA Algorithm
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        boolean[] visited = new boolean[n];
        int[] price = new int[n];
        Queue<Integer> queue = new LinkedList();
        Map<Integer, Map<Integer, Integer>> map =new HashMap();
        for(int[]flight:flights){
            map.putIfAbsent(flight[0],new HashMap());
            map.get(flight[0]).put(flight[1],flight[2]);
        }
        
        /*Set initial price*/
        for(int i=0;i<n; i++){
            price[i]=Integer.MAX_VALUE;
            visited[i]=false;
        }
        
        /*Set the source node*/
        price[src]=0;
        queue.add(src);
        visited[src]=true;
        int count=0;
        while(!queue.isEmpty()&& count<k+1) {
            int currentNode = queue.remove();
            visited[currentNode]=false;
            if(map.containsKey(currentNode)) {
                for(int next:map.get(currentNode).keySet()) {
                    int newPrice = price[currentNode]+map.get(currentNode).get(next);
                    if(price[next]>newPrice) {
                        price[next]=newPrice;
                        if(!visited[next]) {//If this node is not present in queue
                            visited[next]=true;
                            queue.add(next);    
                        }
                        
                    }
                }    
            }
            
          count++;  
        }
        
        return price[dst]==Integer.MAX_VALUE?-1:price[dst];
       // return price[dst];
        
    }
}
