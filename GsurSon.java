package com.json;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GsurArr{
	private String jsonCode = "{}";
	private String result;
	private String lastData;
	private int newData;
	private int size = 0;
	private int maxSize = 999999999;
	
	
	public GsurArr(){
	
	}
	
	
	
	
	public GsurArr(int max){
		maxSize = max;
	}
	
	
	
	
	
	public void add(String v){
		if (size<maxSize){
		if (this.size < 1){
		 this.jsonCode = this.jsonCode.replace("}", "").concat("\"".concat(String.valueOf(size).concat("\":\"".concat(v.concat("\"\n}")))));
         this.size++;
		} else {
		 this.jsonCode = this.jsonCode.replace("}", "").concat(",\"".concat(String.valueOf(size).concat("\":\"".concat(v.concat("\"\n}")))));
         this.size++;
		}
		} else {
			
		}
	}
	
	
	
	
	public String get(int pos){
		if (this.jsonCode.contains(String.valueOf(pos))){
		Pattern pattern = Pattern.compile("\"".concat(String.valueOf(pos)).concat("\":\"(.+?)\""));
	    Matcher matcher = pattern.matcher(jsonCode);
        while (matcher.find()) { 
        this.result = jsonCode.substring(matcher.start(), matcher.end());
        }

		
		this.result = this.result.replace("\"","");
		this.result = this.result.replaceFirst(String.valueOf(pos),"");
		this.result = this.result.replaceFirst(":","");
		this.result = this.result.replace("}","");
        this.result = this.result.replace("{","");
		
		} else {
			this.result = "Position: " + String.valueOf(pos) + " not exist";
		}
		
		return this.result;
	}
	
	
	
	private void replace(int pos,String newValue){
		this.jsonCode = this.jsonCode.replaceFirst(get(pos),newValue);
	}
	
	public void remove(int pos){
		lastData = "\""+String.valueOf(pos)+"\":\""+get(pos)+"\"";
		Pattern pattern = Pattern.compile("\"".concat(String.valueOf(pos)).concat("\":\"(.+?)\""));
	    Matcher matcher = pattern.matcher(jsonCode);
        while (matcher.find()) { 
        this.result = jsonCode.substring(matcher.start(), matcher.end());
        }
		if (pos < 1){
			this.jsonCode = this.jsonCode.replace(this.result,"");
			this.jsonCode = this.jsonCode.replaceFirst(",","");
		} else {
			if (pos == size){
			this.jsonCode = this.jsonCode.replace("}","");
			this.jsonCode = this.jsonCode.replace(this.result,"}");
			} else {
			this.jsonCode = this.jsonCode.replaceFirst(",","");
			this.jsonCode = this.jsonCode.replace(this.result,"");
			}
			this.jsonCode = this.jsonCode.replace("\n","");
			for (int i = 1;i<size;i++){
				newData = i-1;
				this.jsonCode = this.jsonCode.replace(String.valueOf(i),String.valueOf(newData));
			}
		}
		
        this.size--;
	}
	
	public int size(){
		return this.size;
	}
	
	
	
	public String getJson(){
		return this.jsonCode;
	}
	
}package com.json;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GsurArr{
	private String jsonCode = "{}";
	private String result;
	private String lastData;
	private int newData;
	private int size = 0;
	private int maxSize = 999999999;
	
	
	public GsurArr(){
	
	}
	
	
	
	
	public GsurArr(int max){
		maxSize = max;
	}
	
	
	
	
	
	public void add(String v){
		if (size<maxSize){
		if (this.size < 1){
		 this.jsonCode = this.jsonCode.replace("}", "").concat("\"".concat(String.valueOf(size).concat("\":\"".concat(v.concat("\"\n}")))));
         this.size++;
		} else {
		 this.jsonCode = this.jsonCode.replace("}", "").concat(",\"".concat(String.valueOf(size).concat("\":\"".concat(v.concat("\"\n}")))));
         this.size++;
		}
		} else {
			
		}
	}
	
	
	
	
	public String get(int pos){
		if (this.jsonCode.contains(String.valueOf(pos))){
		Pattern pattern = Pattern.compile("\"".concat(String.valueOf(pos)).concat("\":\"(.+?)\""));
	    Matcher matcher = pattern.matcher(jsonCode);
        while (matcher.find()) { 
        this.result = jsonCode.substring(matcher.start(), matcher.end());
        }

		
		this.result = this.result.replace("\"","");
		this.result = this.result.replaceFirst(String.valueOf(pos),"");
		this.result = this.result.replaceFirst(":","");
		this.result = this.result.replace("}","");
        this.result = this.result.replace("{","");
		
		} else {
			this.result = "Position: " + String.valueOf(pos) + " not exist";
		}
		
		return this.result;
	}
	
	
	
	private void replace(int pos,String newValue){
		this.jsonCode = this.jsonCode.replaceFirst(get(pos),newValue);
	}
	
	public void remove(int pos){
		lastData = "\""+String.valueOf(pos)+"\":\""+get(pos)+"\"";
		Pattern pattern = Pattern.compile("\"".concat(String.valueOf(pos)).concat("\":\"(.+?)\""));
	    Matcher matcher = pattern.matcher(jsonCode);
        while (matcher.find()) { 
        this.result = jsonCode.substring(matcher.start(), matcher.end());
        }
		if (pos < 1){
			this.jsonCode = this.jsonCode.replace(this.result,"");
			this.jsonCode = this.jsonCode.replaceFirst(",","");
		} else {
			if (pos == size){
			this.jsonCode = this.jsonCode.replace("}","");
			this.jsonCode = this.jsonCode.replace(this.result,"}");
			} else {
			this.jsonCode = this.jsonCode.replaceFirst(",","");
			this.jsonCode = this.jsonCode.replace(this.result,"");
			}
			this.jsonCode = this.jsonCode.replace("\n","");
			for (int i = 1;i<size;i++){
				newData = i-1;
				this.jsonCode = this.jsonCode.replace(String.valueOf(i),String.valueOf(newData));
			}
		}
		
        this.size--;
	}
	
	public int size(){
		return this.size;
	}
	
	
	
	public String getJson(){
		return this.jsonCode;
	}
	
}
