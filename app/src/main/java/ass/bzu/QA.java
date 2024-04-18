package ass.bzu;

public class QA {
    private String question;
    private String Ans;

    public QA(String question, String ans) {
        this.question = question;
        this.Ans = ans;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns() {
        return Ans;
    }

    public void setAns(String ans) {
        Ans = ans;
    }
}
