package com.example.washwash1;

public class Report {
    private String description;
    private String name;
    private String machine_id;
    private String hp;



    public Report() {
        new Report("", "", "", "");
    }

    public Report(String id, String description, String name, String hp){
        this.description = description;
        this.name = name;
        this.machine_id = id;
        this.hp = hp;
    }

    public boolean isEmpty(){
        return this.machine_id.isEmpty() || this.name.isEmpty() || this.description.isEmpty() || this.hp.isEmpty();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setMachine_id(String id){
        this.machine_id = id;
    }

    public String getMachine_id(){
        return this.machine_id;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getHp() {
        return hp;
    }
}
