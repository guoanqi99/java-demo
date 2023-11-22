package graph_array;

import java.util.*;

public class GraphAdjList {
    /*1. 如果我们选择通过顶点值来区分不同顶点，那么值重复的顶点将无法被区分。
      2. 如果类似邻接矩阵那样，使用顶点列表索引来区分不同顶点。那么，假设我们想要删除索引为 𝑖 的顶
    点，则需要遍历整个邻接表，将其中 > 𝑖 的索引全部减 1 ，这样操作效率较低。
      3. 因此我们考虑引入顶点类 Vertex ，使得每个顶点都是唯一的对象，此时删除顶点时就无须改动其余顶
    点了。*/
    //键为顶点值，值为相关邻接顶点
    Map<Vertex, List<Vertex>> adjList;

    //初始化构造器
    public GraphAdjList(Vertex[][] vertices) {
       this.adjList=new HashMap<>();
        for (Vertex[] vertex : vertices) {
            //添加顶点和边
            addVertex(vertex[0]);
            addVertex(vertex[1]);
            addEdge(vertex[0],vertex[1]);
        }
    }
    //添加边
    public void addEdge(Vertex i, Vertex j) {
        if(i==j||!adjList.containsKey(i)||!adjList.containsKey(j)){
            throw new IllegalArgumentException();
        }
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }
    //添加顶点
    public void addVertex(Vertex vertex) {
        if (adjList.containsKey(vertex)){
            return;
        }
        //对应顶点下添加一个新链表
        adjList.put(vertex,new ArrayList<>());
    }
    //删除顶点
    public void removeVertex(Vertex vertex){
        if(!adjList.containsKey(vertex)){
            throw new IllegalArgumentException();
        }
        //删除对应顶点的健值
        adjList.remove(vertex);
        //删除其他顶点中包含改顶点的值
        for (List<Vertex> value : adjList.values()) {
            value.remove(vertex);
        }
    }
    //删除边
    public void removeEdge(Vertex i,Vertex j){
        if(i==j||!adjList.containsKey(i)||!adjList.containsKey(j)){
            throw new IllegalArgumentException();
        }
        adjList.get(i).remove(j);
        adjList.get(j).remove(i);
    }
    //获取顶点数量
    public int size(){
        return adjList.size();
    }
    //遍历邻接表
    public void  print(){
        for (Map.Entry<Vertex, List<Vertex>>  pair: adjList.entrySet()) {
            for (Vertex vertex : pair.getValue()) {
                System.out.println(pair.getKey().val + ":" + vertex.val + ";");

            }
        }
        for (Vertex vertex : adjList.keySet()) {
            System.out.println(vertex.val);
        }
    }

    //广度优先遍历 邻接表
     void graphBFS(GraphAdjList graph,Vertex startVet){
        //顶点遍历
        List<Vertex> res=new ArrayList<>();
        //记录被访问过得节点
        Set<Vertex> visited=new HashSet<>();
        visited.add(startVet);
        //定义队列按照队列顺序遍历
        Queue<Vertex> queue=new LinkedList<>();
        queue.offer(startVet);
        while (!queue.isEmpty()) {
            Vertex vet= queue.poll();//队首顶点出队
            res.add(vet);
            //遍历该顶点的所有邻接顶点
            for (Vertex vertex :graph.adjList.get(vet)) {
                if (visited.contains(vertex)) {
                    continue;
                }
                queue.add(vertex);//向队列中加入下一个遍历顶点
                visited.add(vertex);//标记已遍历节点
            }
        }
        res.forEach(s->System.out.println(s.val));//直接用hash遍历  顺序会变

    }
    //走到尽头再回来，深度优先遍历
    /*void graphDFS(Vertex startVet){
        //记录已走过的节点
        Set<Vertex> visited=new HashSet<>();
        visited.add(startVet);//将顶点加入set中

        for (Vertex vertex : adjList.get(startVet)) {
            if (visited.contains(vertex)){
                continue;//如果以记录过该节点，则跳过
            }
            visited.add(vertex);//将邻接顶点加入set中记录
            //以邻接顶点为顶点递归查找
            DFS(vertex,visited);
        }
        visited.forEach(s->System.out.println(s.val));

    }

    private Set<Vertex> DFS(Vertex vertex,Set<Vertex> visited) {
        for (Vertex vertex1 : adjList.get(vertex)) {
            if(visited.contains((vertex1))){
                continue;
            }
            visited.add(vertex1);//将邻接顶点加入set
            DFS(vertex1,visited);
        }
        return visited;
    }*/
    //优化深度优先遍历
    void graphDFS1(Vertex vertex){
        //用于记录已走过的节点
        Set<Vertex> visited=new HashSet<>();
        //递归遍历 邻接顶点
        DFS(vertex,visited);
        visited.forEach(s->System.out.println(s.val));
    }

    private void DFS(Vertex vertex,Set<Vertex> visited) {
        visited.add(vertex);
        for (Vertex vertex1 : adjList.get(vertex)) {
            if(visited.contains((vertex1))){
                continue;
            }
            DFS(vertex1,visited);
        }
    }



}
