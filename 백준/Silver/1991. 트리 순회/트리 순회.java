import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
  public static void main(String args[]) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    int[][] tree = new int[27][3];

    for(int i=0; i<N; i++){

      st = new StringTokenizer(br.readLine());

      int idx = st.nextToken().charAt(0) - 'A';
      tree[idx][0] = 1;
      char tmp = st.nextToken().charAt(0);        
      int leftChild = (tmp == '.') ? -1 : tmp - 'A';
      tmp = st.nextToken().charAt(0);
      int rightChild = (tmp == '.') ? -1 : tmp - 'A';

      tree[idx][1] = leftChild;
      tree[idx][2] = rightChild;
    }

    // for(int i =0; i<27; i++){
    //   for(int j=0; j<3; j++){
    //     System.out.print(tree[i][j] + " ");
    //   }
    //   System.out.println();
    // }

    preorder(tree,0);
    System.out.println();
    inorder(tree,0);
    System.out.println();
    reverse(tree,0);

    
  }

  public static void preorder(int[][] tree, int now){

    if(now == -1 || tree[now][0] == 0)
      return;

    System.out.print((char)(now + 'A'));
    preorder(tree,tree[now][1]);
    preorder(tree,tree[now][2]);
    
    
  }

  public static void inorder(int[][] tree, int now){

    if(now == -1 || tree[now][0] == 0)
      return;

    inorder(tree,tree[now][1]);
    System.out.print((char)(now + 'A'));
    inorder(tree,tree[now][2]);


  }

  public static void reverse(int[][] tree, int now){

    if(now == -1 || tree[now][0] == 0)
      return;

    reverse(tree,tree[now][1]);
    reverse(tree,tree[now][2]);
    System.out.print((char)(now + 'A'));



  }
}

