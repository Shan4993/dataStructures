import java.util.*;


public class MineSweeperClick {
	
	
	public static void print(MineSweeperNode[] node){
		for(int i=1;i<node.length;i++){
			MineSweeperNode currNode = node[i];
			if(!currNode.isSelected){
				System.out.print(currNode.val+" ");
			}else{
				System.out.print("  ");
			}
			
			if(i%5 == 0){
				System.out.println();
			}
		}
	}
	

	public static void click(MineSweeperNode selectedNode){
		
		Queue<MineSweeperNode> q = new LinkedList<MineSweeperNode>();
		q.add(selectedNode);
		selectedNode.isSelected = true;
		
		while(!q.isEmpty()){
			MineSweeperNode currNode = q.remove();
			ArrayList<MineSweeperNode> neighbors = currNode.neighbors;
			for(MineSweeperNode neighbor : neighbors){
				if(!neighbor.isSelected && neighbor.val != 3){
					neighbor.isSelected = true;
					q.add(neighbor);
				}
			}
		}
	}
	
	public static void main(String[] args){
		MineSweeperNode[] node = new MineSweeperNode[26];
		
		for(int i=1;i<node.length;i++){
			MineSweeperNode currNode = new MineSweeperNode(1);
			node[i] = currNode;
		}
		
		node[1].val = 1;
		node[2].val = 0;
		node[3].val = 3;
		node[4].val = 1;
		node[5].val = 3;
		
		node[6].val = 0;
		node[7].val = 2;
		node[8].val = 3;
		node[9].val = 3;
		node[10].val = 3;

		node[11].val = 0;
		node[12].val = 1;
		node[13].val = 0;
		node[14].val = 0;
		node[15].val = 1;

		node[16].val = 2;
		node[17].val = 1;
		node[18].val = 2;
		node[19].val = 0;
		node[20].val = 0;

		node[21].val = 0;
		node[22].val = 1;
		node[23].val = 3;
		node[24].val = 3;
		node[25].val = 1;

		node[1].neighbors.add(node[2]); node[1].neighbors.add(node[6]); node[1].neighbors.add(node[7]);
		node[2].neighbors.add(node[1]); node[2].neighbors.add(node[3]); node[2].neighbors.add(node[6]); node[2].neighbors.add(node[7]); node[2].neighbors.add(node[8]);
		node[3].neighbors.add(node[2]); node[3].neighbors.add(node[4]); node[3].neighbors.add(node[7]); node[3].neighbors.add(node[8]); node[3].neighbors.add(node[9]);
		node[4].neighbors.add(node[3]); node[4].neighbors.add(node[5]); node[4].neighbors.add(node[8]); node[4].neighbors.add(node[9]); node[4].neighbors.add(node[10]); 
		node[5].neighbors.add(node[4]); node[5].neighbors.add(node[9]); node[5].neighbors.add(node[10]); 

		node[6].neighbors.add(node[1]); node[6].neighbors.add(node[2]); node[6].neighbors.add(node[7]); node[6].neighbors.add(node[11]); node[6].neighbors.add(node[12]);
		node[7].neighbors.add(node[1]); node[7].neighbors.add(node[2]); node[7].neighbors.add(node[3]); node[7].neighbors.add(node[6]); node[7].neighbors.add(node[8]); node[7].neighbors.add(node[11]); node[7].neighbors.add(node[12]); node[7].neighbors.add(node[13]); 
		node[8].neighbors.add(node[2]); node[8].neighbors.add(node[3]); node[8].neighbors.add(node[4]); node[8].neighbors.add(node[7]); node[8].neighbors.add(node[9]); node[8].neighbors.add(node[12]); node[8].neighbors.add(node[13]); node[8].neighbors.add(node[14]); 
		node[9].neighbors.add(node[3]); node[9].neighbors.add(node[4]); node[9].neighbors.add(node[5]); node[9].neighbors.add(node[8]); node[9].neighbors.add(node[10]); node[9].neighbors.add(node[13]); node[9].neighbors.add(node[14]); node[9].neighbors.add(node[15]); 
		node[10].neighbors.add(node[4]); node[10].neighbors.add(node[5]); node[10].neighbors.add(node[9]); node[10].neighbors.add(node[14]); node[10].neighbors.add(node[15]); 
		
		node[11].neighbors.add(node[6]); node[11].neighbors.add(node[7]); node[11].neighbors.add(node[12]); node[11].neighbors.add(node[16]); node[11].neighbors.add(node[17]); 
		node[12].neighbors.add(node[6]); node[12].neighbors.add(node[7]); node[12].neighbors.add(node[8]); node[12].neighbors.add(node[11]); node[12].neighbors.add(node[13]); node[12].neighbors.add(node[16]); node[12].neighbors.add(node[17]); node[12].neighbors.add(node[18]); 
		node[13].neighbors.add(node[7]); node[13].neighbors.add(node[8]); node[13].neighbors.add(node[9]); node[13].neighbors.add(node[12]); node[13].neighbors.add(node[14]); node[13].neighbors.add(node[17]); node[13].neighbors.add(node[18]); node[13].neighbors.add(node[19]); 
		node[14].neighbors.add(node[8]); node[14].neighbors.add(node[9]); node[14].neighbors.add(node[10]); node[14].neighbors.add(node[13]); node[14].neighbors.add(node[15]); node[14].neighbors.add(node[18]); node[14].neighbors.add(node[19]); node[14].neighbors.add(node[20]); 
		node[15].neighbors.add(node[9]); node[15].neighbors.add(node[10]); node[15].neighbors.add(node[14]); node[15].neighbors.add(node[19]); node[15].neighbors.add(node[20]); 
 
 		node[16].neighbors.add(node[11]); node[16].neighbors.add(node[12]); node[16].neighbors.add(node[17]); node[16].neighbors.add(node[21]); node[16].neighbors.add(node[22]); 
		node[17].neighbors.add(node[11]); node[17].neighbors.add(node[12]); node[17].neighbors.add(node[13]); node[17].neighbors.add(node[16]); node[17].neighbors.add(node[18]); node[17].neighbors.add(node[21]); node[17].neighbors.add(node[22]); node[17].neighbors.add(node[23]); 
		node[18].neighbors.add(node[12]); node[18].neighbors.add(node[13]); node[18].neighbors.add(node[14]); node[18].neighbors.add(node[17]); node[18].neighbors.add(node[19]); node[18].neighbors.add(node[22]); node[18].neighbors.add(node[23]); node[18].neighbors.add(node[24]); 
		node[19].neighbors.add(node[13]); node[19].neighbors.add(node[14]); node[19].neighbors.add(node[15]); node[19].neighbors.add(node[18]); node[19].neighbors.add(node[20]); node[19].neighbors.add(node[23]); node[19].neighbors.add(node[24]); node[19].neighbors.add(node[25]);  
		node[20].neighbors.add(node[14]); node[20].neighbors.add(node[15]); node[20].neighbors.add(node[19]); node[20].neighbors.add(node[24]); node[20].neighbors.add(node[25]);  

		node[21].neighbors.add(node[16]); node[21].neighbors.add(node[17]); node[21].neighbors.add(node[22]); 
		node[22].neighbors.add(node[16]); node[22].neighbors.add(node[17]); node[22].neighbors.add(node[18]); node[22].neighbors.add(node[21]); node[22].neighbors.add(node[23]); 
		node[23].neighbors.add(node[17]); node[23].neighbors.add(node[18]); node[23].neighbors.add(node[19]); node[23].neighbors.add(node[22]); node[23].neighbors.add(node[24]); 
		node[24].neighbors.add(node[18]); node[24].neighbors.add(node[19]); node[24].neighbors.add(node[20]); node[24].neighbors.add(node[23]); node[24].neighbors.add(node[25]); 
		node[25].neighbors.add(node[19]); node[25].neighbors.add(node[20]); node[25].neighbors.add(node[24]); 

		print(node);
		
		click(node[13]);
		
		System.out.println("\n\n");
		
		print(node);
		
		
		click(node[3]);
		
		System.out.println("\n\n");
		
		print(node);
		
		
		
	}
}


class MineSweeperNode{
	private static int counter = 1;
    final int objectId;	
    int val;
	boolean isSelected;
	ArrayList<MineSweeperNode> neighbors;
	
	public MineSweeperNode(int val){
		this.objectId = counter++;
		this.isSelected = false;
		this.val = val;
		this.neighbors = new ArrayList<MineSweeperNode>();
	}
}