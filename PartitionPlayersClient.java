public class PartitionPlayersClient implements PartitionPlayers{
	public static void main(String[] args){
		int[] team = {1,9,8,7,6,4,2,3,5};
		newTeam = PartitionPlayers.sort(team);
		for (int i = 0;i<team.length; i++)
			System.out.print(newTeam[i] + " ");	
		System.out.println(" ");
	}


}
