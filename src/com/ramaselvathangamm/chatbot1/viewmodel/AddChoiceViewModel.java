package com.ramaselvathangamm.chatbot1.viewmodel;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ramaselvathangamm.chatbot1.repository.ChatBotRepository;

public class AddChoiceViewModel {
	@SuppressWarnings("unused")
	private SelectChoice selectchoice;
	private ChatBotRepository dat;
	ArrayList<String> choiceList = new ArrayList<>();

	public AddChoiceViewModel(SelectChoice selectChoice) {
		this.selectchoice = selectChoice;
		getData();
	}

	JSONObject data;
	
	public  void getData(){
		dat = ChatBotRepository.getInstance();
		data = dat.jsonAction();
	}

	public void print(int step, int choice) {
		for (String choiceString : getChoices(step, choice)) {
			System.out.println(choiceString);
		}
		System.out.println();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<String> getChoices(int step, int choice) {
		choiceList.clear();
		String steps=String.valueOf(step);
		String choices=String.valueOf(choice);
		
		if (data.containsKey(steps)) {
			JSONObject levelObject = (JSONObject) data.get(steps);

			if (levelObject.containsKey(choices)) {
				Object optionsObject = levelObject.get(choices);

				if (optionsObject instanceof JSONArray) {
					choiceList.addAll((JSONArray) optionsObject);
				} else if (optionsObject instanceof JSONObject) {
					choiceList.addAll(((JSONObject) optionsObject).values());
				}
			}
		}
		return choiceList;
	}

}
