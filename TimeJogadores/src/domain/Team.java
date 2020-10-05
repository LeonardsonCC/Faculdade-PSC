package domain;

import java.util.ArrayList;

public class Team {
	
	private static int current_id = 1;
	private int id;
	private String name;
	private ArrayList<Player> playerList;

	public Team() {
		this.id = current_id;
		current_id++;
		this.playerList = new ArrayList<Player>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addPlayer(Player newPlayer) {
		this.playerList.add(newPlayer);
	}
	
	public void removePlayer(Player player) {
		this.playerList.remove(player);
	}
	
	public Player getPlayer(int index) {
		return this.playerList.get(index);
	}
	
	public int getPlayerListSize() {
		return this.playerList.size();
	}

	@Override
	public String toString() {
		return "ID: " + this.id + " | Name: " + this.name;
	}
	
}
