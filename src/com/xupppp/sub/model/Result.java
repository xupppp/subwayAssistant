package com.xupppp.sub.model;

public class Result {
	private Station star;  //起始站
    private Station end;   //终点站
    private int distance;  //距离
    private Station passStations;  //到达该站的最短路径中的上一站
    private String line;   //到达该站在几号线上
    private int linechange;  //标记从上一站到该站是否有换乘，0为无换乘，1为需换乘
    public Station getStar() {
        return star;
    }
    public void setStar(Station star) {
        this.star = star;
    }
    public Station getEnd() {
        return end;
    }
    public void setEnd(Station end) {
        this.end = end;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    } 
    public Station getPassStations() {
		return passStations;
	}
	public void setPassStations(Station passStations) {
		this.passStations = passStations;
	}
	public Result(Station star, Station end, int distance) {
        this.star = star;
        this.end = end;
        this.distance = distance;
    }
    public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public int getLinechange() {
		return linechange;
	}
	public void setLinechange(int linechange) {
		this.linechange = linechange;
	}
	public Result() {

    }

//    public String toString() {
//        return "Result{" +
//                "star=" + star +
//                ", end=" + end +
//                ", distance=" + distance +
//                ", passStations=" + passStations +
//                '}';
//    }
    
}
