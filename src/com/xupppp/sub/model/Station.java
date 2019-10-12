package com.xupppp.sub.model;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private String name;  //站点名
    private List<String> line=new ArrayList<String>();  //所在线路（换乘站有多条）
    private List<Station> linkStations = new ArrayList<Station>();  //与之相邻的站点

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getLine() {
		return line;
	}
	public void setLine(List<String> line) {
		this.line = line;
	}
	public List<Station> getLinkStations() {
        return linkStations;
    }
    public void setLinkStations(List<Station> linkStations) {
        this.linkStations = linkStations;
    }


    public Station(String name, String line) {
        this.name = name;
        this.line.add(line);
    }

    public Station(String name) {
        this.name = name;
    }

    public Station (){ 

    }

//    public boolean equals(Object obj) {
//        if(this == obj){
//            return true;
//        } else if(obj instanceof Station){
//            Station s = (Station) obj;
//            if(s.getName().equals(this.getName())){
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            return false;
//        }
//    }
//
//    public int hashCode() {
//        return this.getName().hashCode();
//    }
//
//    public String toString() {
//    	String str="Station{" +
//                "name='" + name + '\'' +
//                ", line='" + line + '\'' +
//                "linkStations='";
//    	for(Station s:linkStations)
//    		str=str+s.getName();
//    	str=str+'\''+'}';
//        return str;
//    }
    
}
