package graph_array;

public class text {
    public static void main(String[] args) {
       /* 邻接矩阵
        int[] v={3,5,1,2};
        int[][] edges={{2,0},{1,2},{2,3}};
        adjacency_matrix adj=new adjacency_matrix(v,edges);
        adj.print();*/

        //邻接表
        Vertex a=new Vertex(3);
        Vertex b=new Vertex(5);
        Vertex c=new Vertex(4);
        Vertex d=new Vertex(1);
        Vertex[][] vertices= {{a, b},
                              {c, b},
                              {c,d}};
        GraphAdjList adjList=new GraphAdjList(vertices);
        adjList.print();
        System.out.println("-------");
        adjList.graphBFS(adjList, a);
        System.out.println("-------");
        adjList.graphDFS1(a);
    }
}