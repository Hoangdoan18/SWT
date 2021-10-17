/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Subject {

    private int subjectID, cateID;
    private String subjectTitle, username, date;
    private int numOfTerm;
    private float rating;

    public Subject() {
    }

    public Subject(int subjectID, String subjectTitle, int cateID, String username, String date) {
        this.subjectID = subjectID;
        this.cateID = cateID;
        this.subjectTitle = subjectTitle;
        this.username = username;
        this.date = date;
    }

    public Subject(int numOfTerm) {
        this.numOfTerm = numOfTerm;
    }

    public Subject(float rating) {
        this.rating = rating;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumOfTerm() {
        return numOfTerm;
    }

    public void setNumOfTerm(int numOfTerm) {
        this.numOfTerm = numOfTerm;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Subject{" + "subjectID=" + subjectID + ", cateID=" + cateID + ", subjectTitle=" + subjectTitle + ", username=" + username + ", date=" + date + ", numOfTerm=" + numOfTerm + ", rating=" + rating + '}';
    }
}
