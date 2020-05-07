package com.model.dataModel;

public class PlayerRecord implements Comparable<PlayerRecord>{
    private String playerName;
    private String playDate;
    private int totalScore;

    public PlayerRecord(String playerName, String playDate, int totalScore) {
        this.playerName = playerName;
        this.playDate = playDate;
        this.totalScore = totalScore;
    }

    public PlayerRecord() {

    }

    @Override
    public int compareTo(PlayerRecord that) {
        if (this.totalScore<that.totalScore){
            return 1;
        }else if(this.totalScore==that.totalScore){
            return 0;
        }else
            return -1;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayDate() {
        return playDate;
    }

    public void setPlayDate(String playDate) {
        this.playDate = playDate;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }


}
