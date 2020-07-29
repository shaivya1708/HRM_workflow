package com.example.android.hrm;

public class Employer_requirement_send {
    String ndays;
    String nlab;
    String job_desp;
    String job;
    String work_id;

    public void Employer_requirement_send(){

    }
    public String getNdays() {
        return ndays;
    }

    public String getNlab() {
        return nlab;
    }

    public String getJob_desp() {
        return job_desp;
    }

    public String getJob() {
        return job;
    }

    public String getWork_id() {
        return work_id;
    }

    public Employer_requirement_send(String work_id,String ndays, String nlab, String job_desp, String job) {
        this.ndays = ndays;
        this.nlab = nlab;
        this.job_desp = job_desp;
        this.job = job;
        this.work_id = work_id;
    }
}
