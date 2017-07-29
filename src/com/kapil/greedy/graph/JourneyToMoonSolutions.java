package com.kapil.greedy.graph;

/**
 * Created by kapilsharma on 28/07/17.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JourneyToMoonSolutions {

    static Map<Integer,ArrayList<Integer>> planets=new HashMap<Integer,ArrayList<Integer>>();
    static Map<Integer,ArrayList<Integer>> components=new HashMap<Integer,ArrayList<Integer>>();
    public static void main(String args[]) throws IOException {
        File file = new File("src/com/kapil/input1.txt");
        Scanner scanner = new Scanner(file);

        int n=scanner.nextInt(), k=scanner.nextInt();
        int a1,a2,temp;
        for(int i=1;i<=n;i++) planets.put(i, new ArrayList<Integer>());
        StringTokenizer st;
        for(int i=0;i<k;i++) {
            a1=scanner.nextInt(); a2=scanner.nextInt();
            planets.get(a1+1).add(a2+1);
            planets.get(a2+1).add(a1+1);
        }
        int offset=1,el,neighbour,component=1;
        boolean isVisited[]=new boolean[n+1];
        Arrays.fill(isVisited, false);
        Queue<Integer> q=new LinkedList<Integer>();
        Iterator<Integer> itr;
        while(offset<n) {
            q.clear();
            //Search for first element which is not visited
            while(offset<n && isVisited[offset]) offset++;
            if(offset==n && isVisited[offset]) break;

            components.put(component, new ArrayList<Integer>());
            q.add(offset);
            components.get(component).add(offset);

            isVisited[offset]=true;
            while(q.size()>0) {
                el=q.remove();
                itr=planets.get(el).iterator();
                while(itr.hasNext()) {
                    neighbour=itr.next();
                    if(!isVisited[neighbour]) {
                        isVisited[neighbour]=true;
                        q.add(neighbour);
                        components.get(component).add(neighbour);
                    }
                }
            }
            component++;
        }
        int []a=new int[components.size()];
        itr=components.keySet().iterator();
        int i=0,sum=0;
        while(itr.hasNext()) {
            a[i]=components.get(itr.next()).size();
            sum+=a[i];
            i++;
        }
        long ways=0;
        for(i=0;i<a.length-1;i++) {
            sum-=a[i];
            ways+=a[i]*sum;
        }
        System.out.println(ways);
    }
}
