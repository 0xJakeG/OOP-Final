public class Question {
    private String questionText;
    private String answer;

    // Constructor
    public Question(String questionText, String answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    // Getters
    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer() {
        return answer;
    }

    // Setters
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    // Methods
    public void askQuestion() {
        //  ask the question
        System.out.println(questionText);
    }

    public void storeAnswer() {
        // store the answer
        System.out.println(answer);
    }

    public boolean isAnswerCorrect(String userAnswer) {
        return this.answer.equalsIgnoreCase(userAnswer);
    }
}


