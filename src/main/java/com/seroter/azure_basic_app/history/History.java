package com.seroter.azure_basic_app.history;

import java.time.LocalDateTime;
import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class History {

    @Id
    @SequenceGenerator(name = "history_sequence", allocationSize = 1, sequenceName = "history_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_sequence")
    private Long id;
    private Long member1;
    private Long member2;
    private String[] gameStatus;
    private String[] winner;
    private String[] winStatus;
    private LocalDateTime date;

    public History() {

    }

    public History(Long id, Long member1, Long member2, String[] gameStatus, String[] winner, String[] winStatus) {

        this.id = id;
        this.member1 = member1;
        this.member2 = member2;
        this.gameStatus = gameStatus;
        this.winner = winner;

    }

    public History(Long member1, Long member2, String[] gameStatus, String[] winner, String[] winStatus) {

        this.member1 = member1;
        this.member2 = member2;
        this.gameStatus = gameStatus;
        this.winner = winner;
        this.winStatus = winStatus;
    }

    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now();
    }

    public String[] getWinner() {
        return winner;
    }

    public void setWinner(String[] winner) {
        this.winner = winner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMember1() {
        return member1;
    }

    public void setMember1(Long member1) {
        this.member1 = member1;
    }

    public Long getMember2() {
        return member2;
    }

    public void setMember2(Long member2) {
        this.member2 = member2;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDateTime.now();
    }

    public String[] getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(String[] gameStatus) {
        this.gameStatus = gameStatus;
    }

    public String[] getWinStatus() {
        return winStatus;
    }

    public void setWinStatus(String[] winStatus) {
        this.winStatus = winStatus;
    }

    @Override
    public String toString() {
        return "History [id=" + id + ", member1=" + member1 + ", member2=" + member2 + ", gameStatus="
                + Arrays.toString(gameStatus) + ", winner=" + Arrays.toString(winner) + ", winStatus="
                + Arrays.toString(winStatus) + ", date=" + date + "]";
    }

}
