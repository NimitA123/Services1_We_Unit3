package com.example.evalution_1;

import java.util.List;
import java.io.Serializable;

public class ResponseModel implements Serializable {
	private List<ComingSoonModel> comingSoon;
	private List<NowShowingModel> nowShowing;

	public void setComingSoon(List<ComingSoonModel> comingSoon){
		this.comingSoon = comingSoon;
	}

	public List<ComingSoonModel> getComingSoon(){
		return comingSoon;
	}

	public void setNowShowing(List<NowShowingModel> nowShowing){
		this.nowShowing = nowShowing;
	}

	public List<NowShowingModel> getNowShowing(){
		return nowShowing;
	}

	@Override
 	public String toString(){
		return 
			"ResponseModel{" + 
			"coming_soon = '" + comingSoon + '\'' + 
			",now_showing = '" + nowShowing + '\'' + 
			"}";
		}
}