public class Users {
    private String age;
    private String student;
    private String credit_rating;
    private String income;
    private String buys_computer;

    public Users(String age, String student, String credit_rating, String income, String buys_computer) {
        this.age = age;
        this.student = student;
        this.credit_rating = credit_rating;
        this.income = income;
        this.buys_computer = buys_computer;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getCredit_rating() {
        return credit_rating;
    }

    public void setCredit_rating(String credit_rating) {
        this.credit_rating = credit_rating;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getBuys_computer() {
        return buys_computer;
    }

    public void setBuys_computer(String buys_computer) {
        this.buys_computer = buys_computer;
    }
}
