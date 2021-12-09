import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here

        Scanner sc=new Scanner(System.in);
        int members=Integer.parseInt(sc.nextLine());
        Map<Integer,Map<Integer,Integer>> map=new HashMap<>();
        for(int i=0;i<members;i++) map.put(Integer.parseInt(sc.nextLine()),new HashMap<>());

        int edges=Integer.parseInt(sc.nextLine());
        for(int i=0;i<edges;i++){
            String in=sc.nextLine();
            String[] splitted=in.split(" ");
            int u=Integer.parseInt(splitted[0]);
            int v=Integer.parseInt(splitted[1]);
            int t=Integer.parseInt(splitted[2]);
            Map<Integer,Integer> ls=map.get(u);
            ls.put(v,t);
            map.put(u,ls);
        }
        int source=Integer.parseInt(sc.nextLine());
        int dest=Integer.parseInt(sc.nextLine());
        Queue<int[]> pq=new PriorityQueue<>((a,b)-> a[0]-b[0]);
        Map<Integer,Integer> dist=new HashMap<>();

        for(Integer key:map.keySet()) dist.put(key,Integer.MAX_VALUE);
        dist.put(source,0);
        pq.offer(new int[]{0,source});
        Set<Integer> visited=new HashSet<>();

        while(!pq.isEmpty()){
            int[] peek=pq.remove();
            int curr=peek[1];
            if (visited.contains(curr)) continue;
            visited.add(curr);
            Map<Integer,Integer> childs=map.get(curr);
            for(Integer key: map.keySet()){
                int new_curr=key;
                int distance=childs.get(key);
                if(!visited.contains(new_curr)){
                    if(dist.containsKey(new_curr) && dist.get(new_curr) < dist.get(curr) + distance)
                        continue;

                    dist.put(new_curr,dist.get(curr) + distance);
                    pq.add(new int[]{new_curr,dist.get(new_curr)});
                }
            }
        }

        System.out.println(dist.get(dest));

    }


}
