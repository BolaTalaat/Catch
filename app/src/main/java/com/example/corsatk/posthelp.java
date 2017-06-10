package com.example.corsatk;

/**
 * Created by bola on 6/8/2017.
 */

public class posthelp {
    private String image,name,email,problem ;

    public posthelp(){

    }
    public posthelp(String image, String name, String email, String problem) {
        this.image = image;
        this.name = name;
        this.email = email;
        this.problem = problem;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String phone) {
        this.email = email;
    }

    public String getProblem() {
        return problem;
    }

    public void setproblem(String problem) {
        this.problem = problem;
    }
}
