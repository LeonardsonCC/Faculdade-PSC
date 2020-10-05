package domain;

import javax.swing.JOptionPane;

public class Player {

	private String name;
	private int number;
	private int teamId;
	

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void registerWith_JOpt() {
		String newName = JOptionPane.showInputDialog("Digite o nome: ");
		int newNumber = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do jogador: "));
		int teamId = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do time: "));
		
		this.setName(newName);
		this.setNumber(newNumber);
		this.setTeamId(teamId);
	}
	
	@Override
	public String toString() {
		return "Team Id: " + this.teamId + " | Name: " + this.name + " | Number: " + this.number;
	}
}
