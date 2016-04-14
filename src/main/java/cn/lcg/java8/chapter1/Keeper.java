package cn.lcg.java8.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
/**
 * @Description 饲养员/团队
 * @author leon
 * @date 2016年4月13日 下午1:58:01
 */
public class Keeper {
    
    private String name;
    private List<Keeper> members;
    private List<String> jobs;
    
    public Keeper(String name, List<Keeper> members, List<String> jobs) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(members);
        Objects.requireNonNull(jobs);
        
        this.name = name;
        this.members = new ArrayList<>(members);
        this.jobs = new ArrayList<>(jobs);
    }
    
    public String getName() {
        return name;
    }
    
    public Stream<Keeper> getMembers() {
        return members.stream();
    }
    
    public Stream<String> getJobs() {
        return jobs.stream();
    }
    
    public String getMainJob() {
        return jobs.get(0);
    }
    public String setMainJob(String job) {
        return jobs.set(0, job);
    }
    
    public boolean isSolo() {
        return members.isEmpty();
    }
    
    public boolean isResponsible(String job) {
        return jobs.contains(job);
    }
    
    public Keeper copy() {
        List<Keeper> members = getMembers().map(Keeper::copy).collect(toList());
        /*
         * to 'String' it's same, because String as a heap
         * List<String> jobs = getJobs().map(str -> new String(str)).collect(toList());
         */
        List<String> jobs = getJobs().collect(toList());
        return new Keeper(name, members, jobs);
    }
}
