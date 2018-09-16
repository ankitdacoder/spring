package main;

import java.util.List;
import java.util.Map;

public class Sports {

	private List<String> gamesList;

	public List<String> getGamesList() {
		return gamesList;
	}

	public void setGamesList(List<String> gamesList) {
		this.gamesList = gamesList;
	}

	private Map<String, String> gamesMap;

	public Map<String, String> getGamesMap() {
		return gamesMap;
	}

	public void setGamesMap(Map<String, String> gamesMap) {
		this.gamesMap = gamesMap;
	}

	public String printSports() {
		String sports = "";
		if (gamesList != null && gamesList.size() > 0) {
			sports += "\nList";

			for (int i = 0; i < gamesList.size(); i++) {
				sports += ". name :" + gamesList.get(i);
			}

		}

		if (gamesMap != null && gamesMap.size() > 0) {
			sports += "\nMap";

			for (Map.Entry<String, String> game : gamesMap.entrySet()) {
				sports += game.getKey() + " ==> " + game.getValue()+" ";
			}

		}

		return sports;

	}

}
