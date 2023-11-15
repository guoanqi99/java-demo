package graph_array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class adjacency_matrix {
   List<Integer> vertices;//顶点元素
   List<List<Integer>> adjMat;//邻接矩阵，行列索引对应
   

   //构造函数
   public adjacency_matrix(int[] vertices,int[][] edges) {
      this.vertices=new ArrayList<>();
      this.adjMat=new ArrayList<>();
      //添加顶点
      for (int vertex : vertices) {
         addVertex(vertex);
      }
      //添加边  {[2,3],[3,4]}
      //edges 元素为顶点索引
      for (int[] edge : edges) {
         addEdge(edge[0],edge[1]);
      }


   }
   //添加边
   public void addEdge(int i, int j) {
      //索引越界处理
      if (i<0||j<0||i>=size()||j>=size()||i==j){
         throw new IndexOutOfBoundsException();
      }
      adjMat.get(i).set(j,1);
      adjMat.get(j).set(i,1);
   }

   //添加顶点
   public void addVertex(int vertex) {
      int n=size();
      //向顶点列表中添加顶点元素
      vertices.add(vertex);
      //向邻接矩阵中添加一行
      List<Integer> newrow=new ArrayList<>(n);
      //添加0
      for (int i = 0; i < n; i++) {
         newrow.add(0);
      }
      adjMat.add(newrow);
      //在邻接矩阵中添加一列
      for (List<Integer> integers : adjMat) {
         integers.add(0);
      }
   }

   //获取顶点元素数量
   public int size() {
      return vertices.size();
   }

   //删除顶点
   public void removeVertex(int index){
      if(index<0||index>=size()){
         throw new IndexOutOfBoundsException();
      }
      vertices.remove(index);//顶点列表中移除对应顶点
      adjMat.remove(index);//删除对应行
      for (List<Integer> integers : adjMat) {
         integers.remove(index);
      }
   }

   //删除边
   public void removeEdge(int i,int j){
      if(i<0||j<0||i>=size()||j>=size()||i==j){
         throw new IndexOutOfBoundsException();
      }
      adjMat.get(i).set(j,0);
      adjMat.get(j).set(i,0);
   }

   //打印邻接矩阵
   public void print(){
      System.out.println("顶点列表=");
      System.out.println(vertices);
      System.out.println("邻接矩阵=");
      for (List<Integer> integers : adjMat) {
         for (Integer integer : integers) {
            System.out.print(integer);
         }
         System.out.println("\t");
      }
   }

}
