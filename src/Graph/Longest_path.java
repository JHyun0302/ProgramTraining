package Graph;

import Tree.BinarySearchTree;

import java.util.ArrayList;

public class Longest_path {
    static int INF = Integer.MAX_VALUE;
    static int MAX_VERTICES = 7;
    static int[] parent = new int[MAX_VERTICES]; // 사이클 생성 여부 확인
    static int[] num =  new int[MAX_VERTICES];

    class element {
        int v; // 정점1
        int u; // 정점2
        int key; // 간선의 가중치
        public class HeapType {
            element heap[] = new element[MAX_VERTICES];
            int heap_size;
        };
    };




    static void set_init(int n){
        int i;
        for(i=0;i<n;i++){
            parent[i] = -1;
            num[i] = 1;
        }
    }
    static  int set_find(int vertex){ // 정점vertex가 속한 집합 반환
        int p,temp, i=-1;
        for(i=vertex;(p=parent[i]) >=0;i=p); // 정점vertex의 루트를 찾는다
        temp=i; // 집합의 대표 원소
        for(i=vertex;(p=parent[i])>=0;i=p)
            parent[i]=temp; // 집합의 모든 원소들의 부모를 temp로 설정
        return temp;
    }
    void Set_union(int v1,int v2){ // 집합 합치기
        if(num[v1] < num[v2]) // 자식의 갯수로 비교
        {
            parent[v1]=v2;
            num[v1]+=num[v2];
        }
        else
        {
            parent[v2]=v1;
            num[v2]+=num[v1];
        }
    }

    // 여기까지 union!!
    void InsertHeapEdge(HeapType *h,int v,int u,int weight)
    {
        Element node;
        node.v=v;
        node.u=u;
        node.key=weight;

        InsertHeap(h,node);
    }




    static void kruskal(int n){
        Element e;
        HeapType h;
        int uSet,vSet,edgeCount=0,sum=0;

        InitHeap(&h);
        InitUF();

        InsertHeapEdge(&h,0,1,29);
        InsertHeapEdge(&h,1,2,15);
        InsertHeapEdge(&h,2,3,12);
        InsertHeapEdge(&h,3,4,22);
        InsertHeapEdge(&h,4,5,27);
        InsertHeapEdge(&h,5,0,10);
        InsertHeapEdge(&h,6,1,16);
        InsertHeapEdge(&h,6,3,18);
        InsertHeapEdge(&h,6,4,25);

        while(edgeCount < n-1) // 간선의 갯수가 n-1이 될 때 까지
        {
            e=DeleteHeap(&h); // 최소 힙

            // 가장 가중치가 가장 낮은 간선을 선택
            uSet=SetFind(e.u);
            vSet=SetFind(e.v);

            if(uSet != vSet) // 서로의 대표 원소가 같지 않은 경우에만
            {
                printf("(%d,%d) %d\n",e.u,e.v,e.key);
                sum+=e.key;
                edgeCount++; // 간선을 하나 늘린다
                SetUnion(uSet,vSet); // 두 집합을 합친다
            }
        }

        printf("최소 비용의 간선 길이 %d \n\n",sum);

        for(int m=0;m<n;m++)
            printf("자식 [%d] : 부모 %d\n",m,parent[m]);

        return 0;
    }
}
    public static void main(String[] args) {
        kruskal(7);
    }
}