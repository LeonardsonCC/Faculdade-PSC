package view;

import java.util.ArrayList;

import domain.Player;
import domain.Team;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TeamsController {

	ArrayList<Team> teamList = new ArrayList<Team>();
    @FXML
    private TextField txtTeamName;

    @FXML
    private TextArea lstTeamList;

    @FXML
    private TextArea lstPlayerList;

    @FXML
    void btnNewPlayer() {
    	Player newPlayer = new Player();
    	newPlayer.registerWith_JOpt();
    	
    	if (newPlayer.getTeamId() != 0) {
    		int teamIndex = newPlayer.getTeamId() - 1;
    		teamList.get(teamIndex).addPlayer(newPlayer);
    		this.refreshLists();
    	}
    }

    @FXML
    void btnRegisterTeam() {
    	String name = txtTeamName.getText();
    	
    	if (!name.isEmpty()) {
    		Team newTeam = new Team();
    		newTeam.setName(name);
    		teamList.add(newTeam);
    		this.refreshLists();
    	}
    }
    
    void refreshLists() {
    	String teamText = "";
    	String playerText = "";
    	for (Team team: this.teamList) {
    		teamText += team.toString() + "\n";
			for (int i=0; i<team.getPlayerListSize(); i++) {
				playerText += "Team Name: " + team.getName() + " | Player: {" + team.getPlayer(i) + "}";
			}
    	}
    	
    	lstTeamList.setText(teamText);
    	lstPlayerList.setText(playerText);
    }

}
