package com.example.evalution_1;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class ResponseModel implements Serializable {

	@SerializedName("coming_soon")
	private List<ComingSoonModel> comingSoon;

	@SerializedName("now_showing")
	private List<NowShowingModel> nowShowing;

	public List<ComingSoonModel> getComingSoon(){
		return comingSoon;
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