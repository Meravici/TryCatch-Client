package com.steps.utils;

public class Utils {
	public static int generatRandomPositiveNegitiveValue(int max , int min) {
	    //Random rand = new Random();
	    int ii = -min + (int) (Math.random() * ((max - (-min)) + 1));
	    return ii;
	}
	
	public static float pixelToMetes(float x){
		return x/30;
	}
	
	public static float metersToPixel(float x){
		return x*30;
	}
}
