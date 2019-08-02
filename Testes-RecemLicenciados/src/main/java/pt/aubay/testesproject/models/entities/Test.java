package pt.aubay.testesproject.models.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import java.util.ArrayList;
import pt.aubay.testesproject.models.entities.Questions;

@Entity
@NamedQueries({
	 @NamedQuery(name="Test.getAll",query="SELECT t FROM Test t"),
	 @NamedQuery(name="Test.count", query = "SELECT COUNT(t.id) FROM Test t"),
	 @NamedQuery(name="Test.checkIfExists", query = "SELECT COUNT(t.id) FROM Test t WHERE t.id =:id"),
	 @NamedQuery(name="Test.getTest", query="SELECT t FROM Test t WHERE t.id=:id"),
})

public class Test extends Models{
	private ArrayList <Questions> questions;
	private String author;
	private Date date;
	private int timer;
	private int averageScore;
	private String testName;
	
	public Test() {
	}
	
	public ArrayList<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Questions> questions) {
		this.questions = questions;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public int getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(int averageScore) {
		this.averageScore = averageScore;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}
	
}
