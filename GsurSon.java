package com.gsur;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;

public class GsurSon{
	
	private String jsonCode;
	private String result;
	private String helpMess;
	private boolean cont;
	private boolean cont2;
	
	
	public GsurSon(String jsonC){
		this.jsonCode = jsonC;
	}
	
	


	public void addData(String Key,String Value){
		this.jsonCode = this.jsonCode.replace("}", "").concat(",\"".concat(Key.concat("\":\"".concat(Value.concat("\"\n}")))));
	}
	
	public void renameKey(String key,String newKey){
		if (this.jsonCode.contains(key)){
		this.jsonCode = this.jsonCode.replaceFirst(key,newKey);
		} else {
		
		}
	}
	
	public void setDataKey(String key,String newValue){
		this.jsonCode = this.jsonCode.replaceFirst(getValueByKey(key),newValue);
	}
	
	public String getValueByKey(String key){
		if (this.jsonCode.contains(key)){
		Pattern pattern = Pattern.compile("\"".concat(key).concat("\":\"(.+?)\""));
	    Matcher matcher = pattern.matcher(jsonCode);
        while (matcher.find()) { 
        this.result = jsonCode.substring(matcher.start(), matcher.end());
        }

		
		this.result = this.result.replace("\"","");
		this.result = this.result.replaceFirst(key,"");
		this.result = this.result.replaceFirst(":","");
		this.result = this.result.replace("}","");
        this.result = this.result.replace("{","");
		
		} else {
			this.result = "Key: " + key + " not exist";
		}
		return this.result.toString();
	}
	
	public double getDoubleByKey(String key){
		result = getValueByKey(key);
		if(result.contains("0")||result.contains("1")||result.contains("2")||result.contains("3")||result.contains("4")||result.contains("5")||result.contains("6")||result.contains("7")||result.contains("8")||result.contains("9")){
			
		} else {
			this.result = "0";
		}
		return Double.parseDouble(this.result);
	}
	
	public long getLongByKey(String key){
		result = getValueByKey(key);
		if(result.contains("0")||result.contains("1")||result.contains("2")||result.contains("3")||result.contains("4")||result.contains("5")||result.contains("6")||result.contains("7")||result.contains("8")||result.contains("9")){
			
		} else {
			this.result = "0";
		}
		return Long.parseLong(this.result);
	}
	
	public String getJsonCode(){
		return this.jsonCode;
	}
	
	
	public void setJsonCode(String jCode) {
		this.jsonCode = jCode;
	}
	
}
