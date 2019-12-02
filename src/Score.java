
public class Score {
	private String name;
    private int credit;
    private int score;
    
    public Score(){
        
    }
    public Score(String st, int crt, int sre){
        name = new String(st);
        credit = crt;
        score = sre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public int getScore() {
        return score;
    }
}
