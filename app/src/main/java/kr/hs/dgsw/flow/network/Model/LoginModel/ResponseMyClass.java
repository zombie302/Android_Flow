package kr.hs.dgsw.flow.network.Model.LoginModel;

public class ResponseMyClass {
    private int grade;
    private int class_room;
    private int class_number;

    public ResponseMyClass(int grade, int class_room, int class_number) {
        this.grade = grade;
        this.class_room = class_room;
        this.class_number = class_number;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClass_room() {
        return class_room;
    }

    public void setClass_room(int class_room) {
        this.class_room = class_room;
    }

    public int getClass_number() {
        return class_number;
    }

    public void setClass_number(int class_number) {
        this.class_number = class_number;
    }
}
