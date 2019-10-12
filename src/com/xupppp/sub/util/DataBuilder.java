package com.xupppp.sub.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import com.xupppp.sub.model.Station;

public class DataBuilder {
	public static LinkedHashSet<List<Station>> lineSet = new LinkedHashSet<List<Station>>();   //线路集合
	public DataBuilder(String pathname) throws IOException{
        File filename = new File(pathname); 
        InputStreamReader reader = new InputStreamReader( new FileInputStream(filename)); 
        BufferedReader br = new BufferedReader(reader); 
        String content="";
        content=br.readLine();  //读取第一行，获取共有几条线路
        int linenum=Integer.parseInt(content);
        for(int i=0;i<linenum;i++) {  //循环往lineSet中添加line
        	content=br.readLine();
        	List<Station> line=new ArrayList<Station>();
        	String[] linearr=content.split(" "); 
        	String linename=linearr[0];
        	for(int j=1;j<linearr.length;j++) {  //循环往line中添加station
        		int flag=0;
        		for(List<Station> l:lineSet) {  //处理换乘站
        			for(int k=0;k<l.size();k++) {
        				if(l.get(k).getName().equals(linearr[j])) {  
        					List<String> newline=l.get(k).getLine();
        					newline.add(linename);
        					l.get(k).setLine(newline);
        					line.add(l.get(k));
        					flag=1;
        					break;
        				}
        			}
        			if(flag==1)
        				break;
        		}
        		if(j==linearr.length-1&&linearr[j].equals(linearr[1])) {  //处理环线
        			line.get(0).getLinkStations().add(line.get(line.size()-1));
        			line.get(line.size()-1).getLinkStations().add(line.get(0));
        			flag=1;
        		}
        		if(flag==0)
        			line.add(new Station(linearr[j],linename));
        	}
        	for(int j=0;j<line.size();j++) {  //初始化每个车站相邻的车站
        		List<Station> newlinkStations=line.get(j).getLinkStations();
        		if(j==0) {
        			newlinkStations.add(line.get(j+1));
        			line.get(j).setLinkStations(newlinkStations);
        		}
        		else if(j==line.size()-1) {
        			newlinkStations.add(line.get(j-1));
        			line.get(j).setLinkStations(newlinkStations);
        		}
        		else {
        			newlinkStations.add(line.get(j+1));
        			newlinkStations.add(line.get(j-1));
        			line.get(j).setLinkStations(newlinkStations);
        		}
        	}
        	lineSet.add(line); 
        }
        br.close();
	}
	
}
