import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> tree;
    static boolean[] isDeleted;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        tree = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        isDeleted = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            int parent = sc.nextInt();
            if(parent != -1) {
                tree.get(parent).add(i);
            }
        }
        
       
        int deleteNode = sc.nextInt();
        
   
        deleteNode(deleteNode);
        
    
        int result = countLeafNodes();
        
        System.out.println(result);
    }
    
  
    static void deleteNode(int node) {
        isDeleted[node] = true;
        for(int child : tree.get(node)) {
            deleteNode(child);
        }
    }
    
    // 리프 노드의 개수를 세는 메소드
    static int countLeafNodes() {
        int count = 0;
        for(int i = 0; i < tree.size(); i++) {
            // 삭제되지 않은 노드 중에서
            if(!isDeleted[i]) {
                boolean isLeaf = true;
                // 자식 노드들 확인
                for(int child : tree.get(i)) {
                    if(!isDeleted[child]) {
                        isLeaf = false;
                        break;
                    }
                }
                if(isLeaf) count++;
            }
        }
        return count;
    }
}